package ma.munisys;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.server.JCoServerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerContextInfo;
import com.sap.conn.bgrfc.client.BGTask;
import com.sap.conn.bgrfc.client.BGTaskHandler;
import com.sap.conn.bgrfc.client.BGTaskOwner;
import com.sap.conn.bgrfc.client.BGTaskHandlerFactory;
import com.sap.conn.bgrfc.client.BGRFCCallbackHandler;
import com.sap.conn.bgrfc.client.BGTaskState;
import com.sap.conn.bgrfc.client.impl.BGTaskQueue;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import com.github.underscore.U;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MuisApp  extends RouteBuilder {

    private static InMemoryDestinationDataProvider memoryProvider = new MuisApp.InMemoryDestinationDataProvider();
    public static JCoDestination dest;
    static String MUIS_DEBUG = System.getenv().getOrDefault("MUIS_DEBUG", "0");

    public void configure() throws Exception {

        from("netty4-http:http://0.0.0.0:8089?ssl=true&keyStoreFile=/certs/keystore_iam.jks&passphrase=changeit&trustStoreFile=/certs/keystore_iam.jks")
        //from("netty4-http:http://0.0.0.0:8089")
            .routeId("muisRouteMasterDataRequest")
            .log(LoggingLevel.INFO, "Initial received message :\nHEADER :\n${in.headers}\nBODY :\n${body}\n")
            .convertBodyTo(String.class)
            .process(MuisApp::execute_SapFunc_MasterDataImport)
        .end();
    }

    public static void muis_debug(String label, Object txt) {
        if (!MUIS_DEBUG.equals("0")) System.out.println("\nMUIS_DEBUG : " + label + " : " + txt);
    }

    public static void dumpObject(Object obj) throws IllegalArgumentException, IllegalAccessException {
        muis_debug("Dumpping object ", obj);
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            muis_debug(f.getName(), f.get(obj));
        }
    }

    public static String forceString(Map<String, Object> o, String key) {
        return !(o.get(key) instanceof String) ? "" : (String) o.get(key);
    }

    public static HashMap<String, String> forceSelfClosedXmlToEmptyString(HashMap<String, String> itemm) {
        // Set xml self-closed tags as empty strings :
        for (String key : itemm.keySet()) if (!(itemm.get(key) instanceof java.lang.String)) itemm.put(key, "");
        return itemm;
    }

    public static <itemType> ArrayList<itemType> getItemsAsArrayList(LinkedHashMap<String, Object> rootItems, Class<?> itemType) {

        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // mapper.setSerializationInclusion(Include.NON_NULL);
        ArrayList<itemType> returnn = new ArrayList<itemType>();
        muis_debug("rootItems", rootItems);
        muis_debug("itemType", itemType);

        if (rootItems == null) return returnn;
        if (!rootItems.containsKey("item")) return returnn;

        if (!rootItems.get("item").getClass().getName().equals("java.util.ArrayList")) {
            muis_debug("", "rootItems.get('item') class not an ArrayList");
            HashMap<String, String> xmlItemm = (HashMap<String, String>) rootItems.get("item");
            xmlItemm = MuisApp.forceSelfClosedXmlToEmptyString(xmlItemm);
            itemType itemm = (itemType) mapper.convertValue(xmlItemm, itemType);
            try { dumpObject(itemm); } catch (IllegalArgumentException | IllegalAccessException e) { e.printStackTrace(); }

            returnn.add(itemm);
        } else {
            ArrayList<Map<String, String>> itemms = (ArrayList<Map<String, String>>) rootItems.get("item");
            Iterator iter = itemms.iterator();
            while (iter.hasNext()) {
                HashMap<String, String> itemm = (HashMap<String, String>) iter.next();
                itemm = MuisApp.forceSelfClosedXmlToEmptyString(itemm);
                itemType itemm2 = (itemType) mapper.convertValue(itemm, itemType);
                returnn.add(itemm2);
            }
        }

        return returnn;
    }

    public static <itemType> void feed_SAP_Table(String sapTableName, ArrayList<itemType> items, Class<?> itemType, JCoFunction sapFunction) {
        JCoTable sapTable = sapFunction.getTableParameterList().getTable(sapTableName);
        for (itemType zItem : items) {
            sapTable.appendRow();
            JCoFieldIterator it = sapTable.getFieldIterator();
            while (it.hasNextField()) {
                JCoField field = it.nextField();
                try {
                    Field f = zItem.getClass().getDeclaredField(field.getName());
                    f.setAccessible(true);
                    field.setValue(f.get(zItem));
                    // muis_debug("feed_SAP_Table : field.getClass().getName() : " + field.getName(), field.getClass().getName());
                    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    //-ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-05-05 10:15:30 Europe/Paris", formatter);
                } catch (NoSuchFieldException | IllegalAccessException e) { System.out.println(e.getMessage()); }
            }
        }
    }

    public static <itemType> void feed_SAP_Structure(String sapStructName, itemType obj, Class<?> itemType, JCoFunction sapFunction) {

        if (obj == null) return;

        JCoStructure sapStruct = sapFunction.getImportParameterList().getStructure(sapStructName);

        JCoFieldIterator it = sapStruct.getFieldIterator();
        while (it.hasNextField()) {
            JCoField field = it.nextField();
            try {
                Field f = obj.getClass().getDeclaredField(field.getName());
                muis_debug("feed_SAP_Structure  :setting field " + field.getName() + " to " + f.get(obj), "");
                f.setAccessible(true);
                field.setValue(f.get(obj));
            } catch (NoSuchFieldException | IllegalAccessException e) { System.out.println(e.getMessage()); }
        }
    }

    static void registerDestinationDataProvider() {

        System.out.println("- Muis : Registering SAP Destination Data Provider ...");

        try { Environment.registerDestinationDataProvider(memoryProvider); }
        catch (IllegalStateException providerAlreadyRegisteredException) { throw new Error(providerAlreadyRegisteredException); }

        memoryProvider.changeProperties(DestinationConcept.SAPqualif.ABAP_AS1, getDestinationProperties());

        try {
            dest = JCoDestinationManager.getDestination(DestinationConcept.SAPqualif.ABAP_AS1);
            dest.ping();
            System.out.println("\n- MUIS : SAP PING OK \n");

            // Max time in ms for the allocation of a connection to a destination in case that the peak limit is already reached; Returns max wait time in ms :
            System.out.println("\n- MUIS : dest.getMaxGetClientTime :" + dest.getMaxGetClientTime());

            // the maximum number of idle connections, that will be kept open in a pool.
            // A value of 0 means that the connections will be closed immediately after being released
            System.out.println("\n- MUIS : dest.getMaxGetClientTime : " + dest.getMaxIdleTime());

            // Returns the minimum number of connections always kept open and in use, to a destination. Value 0 means no connections will be kept open.
            System.out.println("\n- MUIS : dest.getMaxGetClientTime : " + dest.getPoolCapacity());

            // Max time in ms to wait for a connection from a pool if the peak limit has been reached :
            System.out.println("\n- MUIS : dest.getMaxGetClientTime : " + dest.getPeakLimit());

            // Returns maximum number of concurrently open connections to a destination :
            System.out.println("\n- MUIS : dest.getWSHeartbeatInterval : " + dest.getWSHeartbeatInterval());

            // Returns maximum idle time for pooled connections :
            System.out.println("\n- MUIS : dest.getPoolCapacity : " + dest.getPoolCapacity());
        } catch (JCoException e) {
            e.printStackTrace();
        }
    }

    static Properties getDestinationProperties() {
        Properties connectProperties = new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, System.getenv("JCO_ASHOST")); // The SAP JCo server hostname
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  System.getenv("JCO_SYSNR"));  // The SAP system number
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, System.getenv("JCO_CLIENT")); // The SAP client number
        connectProperties.setProperty(DestinationDataProvider.JCO_USER, System.getenv("JCO_USER"));     // The SAP username
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, System.getenv("JCO_PASSWD")); // The SAP password
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, System.getenv("JCO_LANG"));     // The SAP logon language
        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "3");   // Max number of connections
        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "10");     // Max number of connections at peak time

        return connectProperties;
    }

    static void execute_SapFunc_MasterDataImport(Exchange exchange) {

        Message msg = exchange.getIn();
        String xml = (String) msg.getBody();

        registerDestinationDataProvider();

        try {

            // Use JCoDestinationManager to get the destination
            JCoDestination destination = JCoDestinationManager.getDestination(DestinationConcept.SAPqualif.ABAP_AS1);

            // Create and execute bgRFC unit
            executeSapFunctionAsBgRFC(destination, xml);

        } catch (JCoException e) {
            e.printStackTrace();
        }
    }

    static void executeSapFunctionAsBgRFC(JCoDestination destination, String xml) throws JCoException {

        try {
            JCoFunction function = destination.getRepository().getFunction("YOUR_FUNCTION_NAME");
            if (function == null) {
                throw new RuntimeException("SAP function not found in repository");
            }

            // Set function parameters based on XML (similar to your existing logic)

            // Create a bgRFC Unit
            BGTask bgTask = new BGTask(destination, function);

            // Set up the bgRFC Task Handler
            BGTaskHandler bgTaskHandler = BGTaskHandlerFactory.getHandler(bgTask.getQueueName());

            // Register callback handler
            bgTaskHandler.setCallbackHandler(new BGRFCCallbackHandler() {
                @Override
                public void handleBGRFCException(BGTask bgTask, Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void handleBGTaskResult(BGTask bgTask, BGTaskState bgTaskState) {
                    System.out.println("bgRFC Task State: " + bgTaskState.name());
                }
            });

            // Submit the bgRFC Task
            bgTaskHandler.submit(bgTask);

        } catch (AbapException e) {
            System.out.println(e.toString());
        }
    }

    public static void describeFunction(JCoFunction function) {

        System.out.println("\n[describeFunction] function.getName() : " + function.getName());
        System.out.println("[describeFunction] function.getImportParameterList() : " + function.getImportParameterList());
        System.out.println("[describeFunction] function.getTableParameterList() : " + function.getTableParameterList());
        System.out.println("[describeFunction] function.getExportParameterList() : " + function.getExportParameterList());

        if (function.getImportParameterList() != null) System.out.println("\nimportParameters :\n" + Arrays.toString(function.getImportParameterList().getParameterFieldNames()));
        if (function.getExportParameterList() != null) System.out.println("\nexportParameters :\n" + Arrays.toString(function.getExportParameterList().getParameterFieldNames()));
        if (function.getTableParameterList() != null) System.out.println("\ntableParameters :\n" + Arrays.toString(function.getTableParameterList().getParameterFieldNames()));

        if (function.getImportParameterList() != null) describeList(function.getImportParameterList());
        if (function.getExportParameterList() != null) describeList(function.getExportParameterList());
        if (function.getTableParameterList() != null) describeList(function.getTableParameterList());
    }

    public static void describeList(JCoParameterList list) {

        for (JCoFieldIterator it = list.getFieldIterator(); it.hasNextField(); ) {
            JCoField field = it.nextField();
            System.out.println("[describeList] field.getName() : " + field.getName() + " (" + field.getDescription() + ") [" + field.getTypeAsString() + "]");
        }
    }

    public static void describeAllAribaFunctions() throws JCoException {

        JCoFunction function;
        String[] aribaFunctions = {"ZARIBA_PLANT", "ZARIBA_PURCHASE_ORG", "ZARIBA_PURCHASE_GROUP", "ZARIBA_PLANT_PORG", "ZARIBA_ASSET", "ZARIBA_GENERAL_LEDGER", "ZARIBA_INTERNAL_ORDER", "ZARIBA_WBS", "ZARIBA_ACCOUNT_CATEGORY", "ZARIBA_ACC_FIELD_STATUS", "ZARIBA_INTERNAL_ORDER", "ZARIBA_WBS", "ZARIBA_MATERIAL_GROUP", "ZARIBA_CURRENCY_CONVERSION", "ZARIBA_VENDOR", "ZARIBA_MINORITY_VENDOR", "ZARIBA_TAX_CODE", "ZARIBA_COMPANY", "ZARIBA_VENDOR", "ZARIBA_COST_CENTER", "ZARIBA_ACCOUNT_CAT_NAMES", "ZARIBA_MATERIAL_GROUP_NAMES", "ZARIBA_COST_CENTER_NAMES", "ZARIBA_GENERAL_LEDGER_NAMES", "ZARIBA_TAX_CODE_NAMES", "ZARIBA_VENDOR_INC", "ZARIBA_ASSET_INC", "ZARIBA_MATERIAL_ACC", "ZARIBA_MATERIAL_ACC_INC", "ZARIBA_MATERIAL_ALT", "ZARIBA_MATERIAL_MRP", "ZARIBA_MATERIAL_CCR", "ZARIBA_MATERIAL_GEN", "ZARIBA_MATERIAL_STO", "ZARIBA_MATERIAL_PUR", "ZARIBA_MATERIAL_DSU", "ZARIBA_WAREHOUSE"};
		

        registerDestinationDataProvider();

        for (String zFunction : aribaFunctions) {
            function = dest.getRepository().getFunction(zFunction);
            describeFunction(function);
        }
    }

    static class InMemoryDestinationDataProvider implements DestinationDataProvider {

        private DestinationDataEventListener eL;
        private HashMap<String, Properties> secureDBStorage = new HashMap<String, Properties>();

        public Properties getDestinationProperties(String destinationName) {
            if (secureDBStorage.containsKey(destinationName)) {
                return secureDBStorage.get(destinationName);
            } else {
                throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION, "Destination " + destinationName + " is not available", null);
            }
        }

        public void setDestinationDataEventListener(DestinationDataEventListener eventListener) {
            this.eL = eventListener;
        }

        public boolean supportsEvents() {
            return true;
        }

        void changeProperties(String destName, Properties properties) {
            synchronized (secureDBStorage) {
                if (properties == null) {
                    if (secureDBStorage.remove(destName) != null) eL.deleted(destName);
                } else {
                    secureDBStorage.put(destName, properties);
                    eL.updated(destName);
                }
            }
        }
    }
}