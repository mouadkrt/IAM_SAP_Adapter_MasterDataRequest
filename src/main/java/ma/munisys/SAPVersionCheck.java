import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import com.sap.conn.jco.ext.SimpleDestinationDataProvider;
import com.sap.conn.jco.ext.DestinationDataProviderException;
import com.sap.conn.jco.util.JCoSessionContext;

import java.util.Properties;

public class SAPVersionCheck {

    // Define your SAP connection parameters
    private static final String DESTINATION_NAME = "ABAP_AS_WITH_POOL";
    private static final String ASHOST = "sapqual6.iamdg.net.ma";
    private static final String SYSNR = "00"; // System number
    private static final String CLIENT = "200"; // Client
    private static final String USER = "WS_USER";
    private static final String PASSWD = "M@roc2023";
    private static final String LANG = "fr"; // Language

    public static void main(String[] args) {
        try {
            // Setup SAP destination properties
            Properties properties = new Properties();
            properties.setProperty(DestinationDataProvider.JCO_ASHOST, ASHOST);
            properties.setProperty(DestinationDataProvider.JCO_SYSNR, SYSNR);
            properties.setProperty(DestinationDataProvider.JCO_CLIENT, CLIENT);
            properties.setProperty(DestinationDataProvider.JCO_USER, USER);
            properties.setProperty(DestinationDataProvider.JCO_PASSWD, PASSWD);
            properties.setProperty(DestinationDataProvider.JCO_LANG, LANG);


            // Set up destination data provider
            DestinationDataProvider destinationDataProvider = new SimpleDestinationDataProvider(properties);
            Environment.registerDestinationDataProvider(destinationDataProvider);

            // Get destination
            JCoDestination destination = JCoDestinationManager.getDestination(DESTINATION_NAME);

            // Check SAP version
            String sapVersion = destination.getRepository().getFunction("SYSTEM_STATUS").getImportParameterList().getString("SAP_RELEASE");
            System.out.println("SAP Version: " + sapVersion);

            // Check if bgRFC is supported
            boolean isBgRFCSupported = destination.getRepository().getFunction("BGRFC_CHECK").isCallable();
            System.out.println("bgRFC Supported: " + isBgRFCSupported);

        } catch (JCoException e) {
            e.printStackTrace();
        } catch (DestinationDataProviderException e) {
            e.printStackTrace();
        }
    }
}