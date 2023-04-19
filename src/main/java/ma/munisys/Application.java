package ma.munisys;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;								
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import com.github.underscore.U;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Application  {
  	
	private static JCoFunction currentSapFunction;
	private static InMemoryDestinationDataProvider memoryProvider=new Application.InMemoryDestinationDataProvider();
	private static JCoDestination dest;
	private static String MUIS_DEBUG = System.getenv().getOrDefault("MUIS_DEBUG", "0");
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		//String httpBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><ns1:Z_ARIBA_GR_TRANSFER xmlns:ns1=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_TRANSFER\"><ns1:Z_ARIBA_GR_TRANSFER><ns1:PARTITION>par1iam</ns1:PARTITION><ns1:VARIANT>var1iam</ns1:VARIANT><ns1:GR_ITEM><ns1:item><ns1:MBLNR>5001744605</ns1:MBLNR><ns1:MJAHR>2021</ns1:MJAHR><ns1:ZEILE>0001</ns1:ZEILE><ns1:ZQACCEPT>2.00000</ns1:ZQACCEPT><ns1:ZUACCEPT>ES</ns1:ZUACCEPT><ns1:ZQREFUS>0.00000</ns1:ZQREFUS><ns1:ZUREFUS>ES</ns1:ZUREFUS><ns1:BWTAR/><ns1:GRUND/><ns1:ARIBA_GRNO>TR-RC329434</ns1:ARIBA_GRNO><ns1:ARIBA_ITNO>1</ns1:ARIBA_ITNO><ns1:NO_MORE_GR>X</ns1:NO_MORE_GR></ns1:item><ns1:item><ns1:MBLNR>5001744605</ns1:MBLNR><ns1:MJAHR>2021</ns1:MJAHR><ns1:ZEILE>0002</ns1:ZEILE><ns1:ZQACCEPT>24.00000</ns1:ZQACCEPT><ns1:ZUACCEPT>ES</ns1:ZUACCEPT><ns1:ZQREFUS>0.00000</ns1:ZQREFUS><ns1:ZUREFUS>ES</ns1:ZUREFUS><ns1:BWTAR/><ns1:GRUND/><ns1:ARIBA_GRNO>TR-RC329434</ns1:ARIBA_GRNO><ns1:ARIBA_ITNO>2</ns1:ARIBA_ITNO><ns1:NO_MORE_GR>X</ns1:NO_MORE_GR></ns1:item></ns1:GR_ITEM><ns1:GR_ITEM><ns1:item><ns1:MBLNR>5001744605</ns1:MBLNR><ns1:MJAHR>2021</ns1:MJAHR><ns1:ZEILE>0001</ns1:ZEILE><ns1:ZQACCEPT>2.00000</ns1:ZQACCEPT><ns1:ZUACCEPT>ES</ns1:ZUACCEPT><ns1:ZQREFUS>0.00000</ns1:ZQREFUS><ns1:ZUREFUS>ES</ns1:ZUREFUS><ns1:BWTAR/><ns1:GRUND/><ns1:ARIBA_GRNO>TR-RC329434</ns1:ARIBA_GRNO><ns1:ARIBA_ITNO>1</ns1:ARIBA_ITNO><ns1:NO_MORE_GR>X</ns1:NO_MORE_GR></ns1:item><ns1:item><ns1:MBLNR>5001744605</ns1:MBLNR><ns1:MJAHR>2021</ns1:MJAHR><ns1:ZEILE>0002</ns1:ZEILE><ns1:ZQACCEPT>24.00000</ns1:ZQACCEPT><ns1:ZUACCEPT>ES</ns1:ZUACCEPT><ns1:ZQREFUS>0.00000</ns1:ZQREFUS><ns1:ZUREFUS>ES</ns1:ZUREFUS><ns1:BWTAR/><ns1:GRUND/><ns1:ARIBA_GRNO>TR-RC329434</ns1:ARIBA_GRNO><ns1:ARIBA_ITNO>2</ns1:ARIBA_ITNO><ns1:NO_MORE_GR>X</ns1:NO_MORE_GR></ns1:item></ns1:GR_ITEM></ns1:Z_ARIBA_GR_TRANSFER></ns1:Z_ARIBA_GR_TRANSFER></soapenv:Body></soapenv:Envelope>";
		// Z_ARIBA_GR_TRANSFER  z_ariba_gr_transfer = create_Z_ARIBA_GR_TRANSFER_ObjectFromXML(httpBody);
		// System.out.println(z_ariba_gr_transfer);
				
		registerDestinationDataProvider();
		describeAllAribaFunctions();
		CamelContext context = new DefaultCamelContext();
		try {
			context.addRoutes(new RouteBuilder() {
				public void configure() {
					from("netty4-http:http://0.0.0.0:8088/")
						.choice()
							.when(simple("${header.MasterDataImport_Request} == '1'"))
								.process(Application::execute_SapFunc_MasterDataImport)
							.otherwise()
								.process(Application::execute_SapFunc_Z_ARIBA_GR_TRANSFER)
								.process(Application::Z_ARIBA_GR_TRANSFER_Response)
					.end();
				}
			});
			context.start();
		}
		catch(Exception e) { System.out.println(e.getMessage()); }
    }
	
	private static void muis_debug(String label, Object txt) {
		if(!MUIS_DEBUG.equals("0")) System.out.println("\nMUIS_DEBUG : "+ label +" : " + txt);
	}
	
	private static void registerDestinationDataProvider() {

		System.out.println("- Muis : Registering SAP Destination Data Provider ...");

	 	try { Environment.registerDestinationDataProvider(memoryProvider); }
		 catch (IllegalStateException providerAlreadyRegisteredException) { throw new Error(providerAlreadyRegisteredException); }

        memoryProvider.changeProperties(DestinationConcept.SAPqualif.ABAP_AS1,  getDestinationProperties());
		
		try {
			dest = JCoDestinationManager.getDestination(DestinationConcept.SAPqualif.ABAP_AS1);
			dest.ping();
			System.out.println("\n- MUIS : SAP PING OK \n");
		}
		catch (JCoException e)
        {
            System.out.println("Execution on destination failed");
            e.printStackTrace();
        }
	}
						  
	// The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object as defined in the Z_ARIBA_GR_TRANSFER public class (Designed to mimic the http soap xml received)
	// The resulting instance of the Z_ARIBA_GR_TRANSFER will be then handed over to the SAP function for processing
	private static Z_ARIBA_GR_TRANSFER create_Z_ARIBA_GR_TRANSFER_ObjectFromXML(String httpBody) { 
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			//System.out.println(map);
		
		Z_ARIBA_GR_TRANSFER	z_ariba_gr_transfer = new Z_ARIBA_GR_TRANSFER();
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_GR_TRANSFER = (Map<String, Object>) soap_body.get("Z_ARIBA_GR_TRANSFER");
		muis_debug("Z_ARIBA_GR_TRANSFER", Z_ARIBA_GR_TRANSFER);
		
		Map<String, Object> Z_ARIBA_GR_TRANSFER2 = (Map<String, Object>) Z_ARIBA_GR_TRANSFER.get("Z_ARIBA_GR_TRANSFER");
		muis_debug("Z_ARIBA_GR_TRANSFER2", Z_ARIBA_GR_TRANSFER2);
		
		z_ariba_gr_transfer.PARTITION = (String) Z_ARIBA_GR_TRANSFER2.get("PARTITION");
		z_ariba_gr_transfer.VARIANT = (String) Z_ARIBA_GR_TRANSFER2.get("VARIANT");
		
		Map<String, Object> GR_ITEMs2 = (Map<String, Object>) Z_ARIBA_GR_TRANSFER2.get("GR_ITEM");
		muis_debug("GR_ITEMs2", GR_ITEMs2);
		
		muis_debug("GR_ITEMs2.get('item')", GR_ITEMs2.get("item"));
		muis_debug("... class : ", GR_ITEMs2.get("item").getClass().getName());
		
		z_ariba_gr_transfer.GR_ITEM = new GR_ITEM();
		ObjectMapper mapper = new ObjectMapper();
		
		if(!GR_ITEMs2.get("item").getClass().getName().equals("java.util.ArrayList")) {
			LinkedHashMap itemm = (LinkedHashMap) GR_ITEMs2.get("item");
			//Set xml self-closed tags as empty strings  :
					for (Object key : itemm.keySet()) if(  !(itemm.get(key) instanceof java.lang.String) ) itemm.put(key, "");
			GR_ITEM_item gr_item_item = mapper.convertValue(itemm,GR_ITEM_item.class);
			z_ariba_gr_transfer.GR_ITEM.items.add(gr_item_item);
		}
		else {
			ArrayList<Map<String,String>> GR_ITEMs = (ArrayList<Map<String,String>>) GR_ITEMs2.get("item");
			Iterator iter = GR_ITEMs.iterator();
			while (iter.hasNext()) {
				Map<String, String> itemm = (Map<String, String>) iter.next();
				muis_debug("item", itemm);
				//LinkedHashMap itemm = (LinkedHashMap) item.get("item").get(0);
								
				//Set xml self-closed tags as empty strings  :
					for (String key : itemm.keySet()) if(  !(itemm.get(key) instanceof java.lang.String) ) itemm.put(key, "");
				
				//System.out.print(iter.next() + "\n");
				GR_ITEM_item gr_item_item = mapper.convertValue(itemm,GR_ITEM_item.class);
				z_ariba_gr_transfer.GR_ITEM.items.add(gr_item_item);
			}
		}

		return z_ariba_gr_transfer;
	}
		private static class InMemoryDestinationDataProvider implements DestinationDataProvider
    {
        private DestinationDataEventListener eL;
        private HashMap<String, Properties> secureDBStorage=new HashMap<String, Properties>();

        @Override
        public Properties getDestinationProperties(String destinationName)
        {
            try
            {
                // read the destination from DB
                Properties p=secureDBStorage.get(destinationName);

                // check if all is correct
                if (p!=null&&p.isEmpty())
                    throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION,
                            "destination configuration is incorrect", null);

                return p;
            }
            catch (RuntimeException re)
            {
                throw new DataProviderException(DataProviderException.Reason.INTERNAL_ERROR, re);
            }
        }

        // An implementation supporting events has to retain the eventListener instance
        // provided by the JCo runtime. This listener instance shall be used to notify
        // the JCo runtime about all changes in destination configurations.
        @Override
        public void setDestinationDataEventListener(DestinationDataEventListener eventListener)
        {
            this.eL=eventListener;
        }

        @Override
        public boolean supportsEvents()
        {
            return true;
        }

        /** implementation that saves the properties in memory */
        void changeProperties(String destName, Properties properties)
        {
            synchronized (secureDBStorage)
            {
                if (properties==null)
                {
                    if (secureDBStorage.remove(destName)!=null)
                        eL.deleted(destName);
                }
                else
                {
                    secureDBStorage.put(destName, properties);
                    eL.updated(destName); // create or updated
                }
            }
        }
    }

    private static Properties getDestinationProperties()
    {
		// Get required value from OS environment :
			String JCO_ASHOST	=	System.getenv("JCO_ASHOST");
			String JCO_SYSNR	=	System.getenv("JCO_SYSNR");
			String JCO_CLIENT	=	System.getenv("JCO_CLIENT");
			String JCO_USER		=	System.getenv("JCO_USER");
			String JCO_PASSWD	=	System.getenv("JCO_PASSWD");
			String JCO_LANG		=	System.getenv("JCO_LANG");
			
			System.out.println("\n\n- MUIS : SAP connection Info :");
			System.out.println("JCO_ASHOST="+JCO_ASHOST);
			System.out.println("JCO_SYSNR="+JCO_SYSNR);
			System.out.println("JCO_CLIENT="+JCO_CLIENT);
			System.out.println("JCO_USER="+JCO_USER);
			System.out.println("JCO_PASSWD=********");
			System.out.println("JCO_LANG="+JCO_LANG);
			
        Properties connectProperties=new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, JCO_ASHOST);
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, JCO_SYSNR);
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, JCO_CLIENT);
        connectProperties.setProperty(DestinationDataProvider.JCO_USER, JCO_USER);
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, JCO_PASSWD);
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, JCO_LANG);
        return connectProperties;
    }

	private static void describeFunction(JCoFunction sapFunction)
	{
		String sapFunctionStr = sapFunction.getName();
		System.out.println("\n\n********************************* " + sapFunctionStr + "  *************************************************");
		System.out.println("SAP Function name = " + sapFunctionStr );
		System.out.println(sapFunctionStr + " as XML : " + sapFunction.toXML() );
		System.out.println("\n\n- MUIS : " + sapFunctionStr + ".getChangingParameterList() = \n" + sapFunction.getChangingParameterList());
		System.out.println("\n\n- MUIS : " + sapFunctionStr + ".getExportParameterList() = \n" + sapFunction.getExportParameterList());
		System.out.println("\n\n- MUIS : " + sapFunctionStr + ".getTableParameterList() = \n" + sapFunction.getTableParameterList());
		System.out.println("\n\n- MUIS : " + sapFunctionStr + ".getFunctionTemplate() = \n" + sapFunction.getFunctionTemplate());
		System.out.println("*********************************************************************************************************");
	}
	
	private static void describeAllAribaFunctions() {
		String[] sapFunctionsStr_Master 	= 	{"ZARIBA_PLANT", "ZARIBA_PURCHASE_ORG", "ZARIBA_PURCHASE_GROUP", "ZARIBA_PLANT_PORG", "ZARIBA_ASSET", "ZARIBA_GENERAL_LEDGER", "ZARIBA_INTERNAL_ORDER", "ZARIBA_WBS", "ZARIBA_ACCOUNT_CATEGORY", "ZARIBA_ACC_FIELD_STATUS", "ZARIBA_INTERNAL_ORDER", "ZARIBA_WBS", "ZARIBA_MATERIAL_GROUP", "ZARIBA_CURRENCY_CONVERSION", "ZARIBA_VENDOR", "ZARIBA_MINORITY_VENDOR", "ZARIBA_TAX_CODE", "ZARIBA_COMPANY", "ZARIBA_VENDOR", "ZARIBA_COST_CENTER", "ZARIBA_ACCOUNT_CAT_NAMES", "ZARIBA_MATERIAL_GROUP_NAMES", "ZARIBA_COST_CENTER_NAMES", "ZARIBA_GENERAL_LEDGER_NAMES", "ZARIBA_TAX_CODE_NAMES", "ZARIBA_VENDOR_INC", "ZARIBA_ASSET_INC", "ZARIBA_MATERIAL_ACC ", "ZARIBA_MATERIAL_ALT", "ZARIBA_MATERIAL_MRP", "ZARIBA_MATERIAL_CCR", "ZARIBA_MATERIAL_GEN", "ZARIBA_MATERIAL_STO", "ZARIBA_MATERIAL_PUR", "ZARIBA_MATERIAL_DSU", "ZARIBA_WAREHOUSE"};
		
		String[] sapFunctionsStr_Trans		=	{"Z_ARIBA_GR_PUSH", "Z_ARIBA_BAPI_PO_CHANGE","Z_ARIBA_BAPI_PO_CANCEL","Z_ARIBA_PO_HEADER_STATUS","Z_ARIBA_GR_TRANSFER","Z_ARIBA_GR_QUALITY","ZARIBA_INVOICED_PO_ITEMS_SOAP", "Z_ARIBA_BAPI_PO_CREATE"};

		String[] sapFunctionsStr_All		=	new String[sapFunctionsStr_Master.length + sapFunctionsStr_Trans.length];
		System.arraycopy(sapFunctionsStr_Master, 0, sapFunctionsStr_All, 0, sapFunctionsStr_Master.length);
        System.arraycopy(sapFunctionsStr_Trans, 0, sapFunctionsStr_All, sapFunctionsStr_Master.length, sapFunctionsStr_Trans.length);
				
		try {
			for(String sapFunctionStr: sapFunctionsStr_All) {
				JCoFunction sapFunction=dest.getRepository().getFunction(sapFunctionStr);
				if (sapFunction != null)
					describeFunction(sapFunction);
			}
		}
		catch(Exception  e) { System.out.println(e.getMessage());}
	}
	
	private static void getTableValues(JCoFunction sapFunction, String tblName) {
		JCoTable sapTbl = sapFunction.getTableParameterList().getTable(tblName);
		
		if( sapTbl.getNumRows() > 0 ) {
			System.out.println("MUIS : Table " + tblName + ", num rows = " + sapTbl.getNumRows());
			System.out.println("\n- MUIS : Displaying content of table " + tblName + " :");
			sapTbl.firstRow();
			do {
				//System.out.println(sapTbl.getString());
				JCoFieldIterator it = sapTbl.getFieldIterator();
				String rowString =	"Row : ";
				while(it.hasNextField()) {
					JCoField field = it.nextField();
					rowString += field.getName() + " = " + field.getString() + ", ";
				}
				System.out.println(rowString);
			} while (sapTbl.nextRow());
		}
		else {
			System.out.println("\n- MUIS : Table "+tblName+" has no rows");
		}
	}
	
    private static void execute_SapFunc_Z_ARIBA_GR_TRANSFER(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_GR_TRANSFER() : " + body);

		Z_ARIBA_GR_TRANSFER  z_ariba_gr_transfer = create_Z_ARIBA_GR_TRANSFER_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_gr_transfer = \n" + z_ariba_gr_transfer);

        try
        {
				String repoName  = dest.getRepository().getName();
				System.out.println("MUIS : Reposiroty name dest.getRepository().getName() =  " + repoName);
					
				String sapFunctionStr = "Z_ARIBA_GR_TRANSFER"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				currentSapFunction = dest.getRepository().getFunction(sapFunctionStr);
				if (currentSapFunction==null) throw new RuntimeException(currentSapFunction + " not found in SAP.");
				
				describeFunction(currentSapFunction);
				
				// The following will be used sftp adapter side :
					//sapFunction.getImportParameterList().setValue("ENCODING", "UTF-8");
					//sapFunction.getImportParameterList().setValue("FILE_NAME", "/exportQ11/DATAARIBA/Asset.csv");

					currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_gr_transfer.PARTITION);
					currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_gr_transfer.VARIANT);
				
				JCoTable GR_ITEM = currentSapFunction.getTableParameterList().getTable("GR_ITEM");
				
				for (GR_ITEM_item grItem : z_ariba_gr_transfer.GR_ITEM.items) {
					//for( Field f : grItem.getClass().getDeclaredFields() ) {}
					GR_ITEM.appendRow();
					JCoFieldIterator it = GR_ITEM.getFieldIterator();
					while(it.hasNextField()) {
						JCoField field = it.nextField();
						try {
							Field f = grItem.getClass().getDeclaredField(field.getName());
							f.setAccessible(true);
							field.setValue(f.get(grItem));
						}
						catch(NoSuchFieldException|IllegalAccessException e) { System.out.println(e.getMessage());}
					}
				}
				
				try {
						currentSapFunction.execute(dest);
						
						//JCoStructure exportStructure = currentSapFunction.getTableParameterList().getStructure("GR_ITEM");
						//for (int i = 0; i < exportStructure.getMetaData().getFieldCount(); i++)
						//	System.out.println( "\n- MUIS2 :" + exportStructure.getMetaData().getName(i) + ":\t" + exportStructure.getString(i));
						
						System.out.println("\nMUIS : STATUS = " + currentSapFunction.getExportParameterList().getString("STATUS"));
						getTableValues(currentSapFunction, "GR_ITEM");
						getTableValues(currentSapFunction, "GR_SERIAL");
						getTableValues(currentSapFunction, "ERROR_MSG_TABLE");
						//System.out.println("MUIS : ERROR_MSG_TABLE isTable = " + currentSapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE").isTable());
						//System.out.println("MUIS : ERROR_MSG_TABLE isStructure = " + currentSapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE").isStructure());
						
						//System.out.println("\n- MUIS : ECHOTEXT = " + sapFunction.getExportParameterList().getString("ECHOTEXT"));
						//System.out.println("\n- MUIS : RESPTEXT = " + currentSapFunction.getExportParameterList().getString("RESPTEXT"));
						
					}
					catch (AbapException e)
					{
						System.out.println(e);
						return;
					}
        }
        catch (JCoException e)
        {
            e.printStackTrace();
            System.out.println("Execution on destination  failed");
        }
    }

	private static void execute_SapFunc_MasterDataImport(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_MasterDataImport() : " + body);
		
		Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(body);
			
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Map<String, Object> soap_header = (Map<String, Object>) soap_envelope.get("Header");
		System.out.println("soap_header : " + soap_header);
		Map<String, Object> ibsinfo = (Map<String, Object>) soap_header.get("ibsinfo");
		System.out.println("ibsinfo : " + ibsinfo);
		String method =  (String) ibsinfo.get("method");
		System.out.println("method : " + method);

		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		System.out.println("soap_body" + soap_body);
		Map<String, Object> method2 = (Map<String, Object>) soap_body.get(method);
		System.out.println("method2 " + method2);
		String sapFunctionStr = (String) method2.keySet().toArray()[0];
		System.out.println("sapFunction extracted from XML payload : " + sapFunctionStr);

		Map<String, Object> sapFunctionInputs = (Map<String, Object>) method2.get(sapFunctionStr);
		String encoding = (String) sapFunctionInputs.get("ENCODING");
		String fileName = (String) sapFunctionInputs.get("FILE_NAME");
		String partition = (String) sapFunctionInputs.get("PARTITION");
		String variant = (String) sapFunctionInputs.get("VARIANT");


        try
        {
				String repoName  = dest.getRepository().getName();
				System.out.println("MUIS : Reposiroty name dest.getRepository().getName() =  " + repoName);
					
				JCoFunction sapFunction = dest.getRepository().getFunction(sapFunctionStr);
				if (sapFunction==null) throw new RuntimeException(sapFunction + " not found in SAP.");
				
				describeFunction(sapFunction);
			
				try {
					
					System.out.println("\nMUIS : Execution SAP function " + sapFunctionStr + " with params :");
					System.out.println("ENCODING="+ encoding + ", FILE_NAME=" + fileName + ", PARTITION=" + partition + ", VARIANT=" + variant);
					sapFunction.getImportParameterList().setValue("ENCODING", encoding);
					sapFunction.getImportParameterList().setValue("FILE_NAME", fileName);
					sapFunction.getImportParameterList().setValue("PARTITION", partition);
					sapFunction.getImportParameterList().setValue("VARIANT", variant);

					sapFunction.execute(dest);
				}
				catch (AbapException e)
				{
					System.out.println(e);
					return;
				}
        }
        catch (JCoException e)
        {
            e.printStackTrace();
            System.out.println("Execution on destination  failed");
        }
    }

	private static void Z_ARIBA_GR_TRANSFER_Response(Exchange exchange) {

		String sapFunctionStr = currentSapFunction.getName();
		muis_debug("Z_ARIBA_GR_TRANSFER_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		String xmlStatusStr = "<STATUS>"+ currentSapFunction.getExportParameterList().getString("STATUS") + "</STATUS>";

		JCoTable sapTbl;

		sapTbl = currentSapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE");
		String xmlErrorStr = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTGRERR", "ERROR_MSG_TABLE") : "<ERROR_MSG_TABLE/>";
		
		sapTbl = currentSapFunction.getTableParameterList().getTable("GR_ITEM");
		String xmlGrItemStr = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTEMTRANS", "GR_ITEM") : "<GR_ITEM/>";

		sapTbl = currentSapFunction.getTableParameterList().getTable("GR_SERIAL");
		String xmlGrSerialStr = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTSERIAL", "GR_SERIAL") : "<GR_ITEM/>";

		String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
			newBody += "<Z_ARIBA_GR_TRANSFERResponse xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_TRANSFER:response\"><Z_ARIBA_GR_TRANSFER.Response>";
				newBody += xmlStatusStr + xmlErrorStr + xmlGrItemStr + xmlGrSerialStr;
			newBody += "</Z_ARIBA_GR_TRANSFER.Response></Z_ARIBA_GR_TRANSFERResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
		
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in Z_ARIBA_GR_TRANSFER_Response() to : " + newBody);
	}
}