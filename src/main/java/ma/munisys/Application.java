package ma.munisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.camel.Exchange;
import org.apache.camel.Message;								
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoField;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Properties;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

import org.apache.camel.builder.xml.Namespaces;

import com.github.underscore.U;

@SpringBootApplication
//@ImportResource({"classpath:spring/camel-context.xml"})
public class Application extends RouteBuilder {
 
 	public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
		Map<String, Object> map = U.fromXmlMap(
			"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><ns1:Z_ARIBA_GR_TRANSFER xmlns:ns1=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_TRANSFER\"><ns1:Z_ARIBA_GR_TRANSFER><ns1:PARTITION>par1iam</ns1:PARTITION><ns1:VARIANT>var1iam</ns1:VARIANT><ns1:GR_ITEM><ns1:item><ns1:MBLNR>5001744605</ns1:MBLNR><ns1:MJAHR>2021</ns1:MJAHR><ns1:ZEILE>0001</ns1:ZEILE><ns1:ZQACCEPT>2.00000</ns1:ZQACCEPT><ns1:ZUACCEPT>ES</ns1:ZUACCEPT><ns1:ZQREFUS>0.00000</ns1:ZQREFUS><ns1:ZUREFUS>ES</ns1:ZUREFUS><ns1:BWTAR/><ns1:GRUND/><ns1:ARIBA_GRNO>TR-RC329434</ns1:ARIBA_GRNO><ns1:ARIBA_ITNO>1</ns1:ARIBA_ITNO><ns1:NO_MORE_GR>X</ns1:NO_MORE_GR></ns1:item><ns1:item><ns1:MBLNR>5001744605</ns1:MBLNR><ns1:MJAHR>2021</ns1:MJAHR><ns1:ZEILE>0002</ns1:ZEILE><ns1:ZQACCEPT>24.00000</ns1:ZQACCEPT><ns1:ZUACCEPT>ES</ns1:ZUACCEPT><ns1:ZQREFUS>0.00000</ns1:ZQREFUS><ns1:ZUREFUS>ES</ns1:ZUREFUS><ns1:BWTAR/><ns1:GRUND/><ns1:ARIBA_GRNO>TR-RC329434</ns1:ARIBA_GRNO><ns1:ARIBA_ITNO>2</ns1:ARIBA_ITNO><ns1:NO_MORE_GR>X</ns1:NO_MORE_GR></ns1:item></ns1:GR_ITEM></ns1:Z_ARIBA_GR_TRANSFER></ns1:Z_ARIBA_GR_TRANSFER></soapenv:Body></soapenv:Envelope>");
			
		System.out.println(map);
		//System.out.println((Map<String, Object>map.get("Details")).get("detail-a"));
    }
						  
	@Override
	public void configure() {
		Namespaces ns = new Namespaces("ns1", "urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_TRANSFER");
		 from("netty4-http:http://0.0.0.0:8088/")
			.convertBodyTo(String.class)
			.setHeader("partition", ns.xpath("//ns1:Z_ARIBA_GR_TRANSFER/ns1:Z_ARIBA_GR_TRANSFER/ns1:PARTITION/text()", String.class))
			.setHeader("variant", ns.xpath("//ns1:Z_ARIBA_GR_TRANSFER/ns1:Z_ARIBA_GR_TRANSFER/ns1:VARIANT/text()", String.class))
			.process(Application::sapRFC)
        .end();
	}
													   
	private static void sapRFC(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("MUIS : Received HTTP body : " + body);
		String partition = message.getHeader("partition", String.class);
		String variant = message.getHeader("variant", String.class);
		message.getHeader("partition");
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are  : ");
		System.out.println("partition = " + partition);
		System.out.println("variant = " + variant);

   		InMemoryDestinationDataProvider memoryProvider=new Application.InMemoryDestinationDataProvider();

        // register the provider with the JCo environment;
        // catch IllegalStateException if an instance is already registered
        try { Environment.registerDestinationDataProvider(memoryProvider); }
        catch (IllegalStateException providerAlreadyRegisteredException) {
            // somebody else registered its implementation stop the execution, alternatively you // could write it to your logs
            throw new Error(providerAlreadyRegisteredException);
        }

        // set properties for the destination ABAP_AS1 and ...
        memoryProvider.changeProperties(DestinationConcept.SAPqualif.ABAP_AS1,  getDestinationPropertiesFromUI());

        // ... work with it
			executeCalls(DestinationConcept.SAPqualif.ABAP_AS1);
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

    private static Properties getDestinationPropertiesFromUI()
    {
        // adapt parameters in order to configure a valid destination
		
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
		System.out.println("**********************************************************************************");
		System.out.println("SAP Function name = " + sapFunctionStr );
		System.out.println(sapFunctionStr + " as XML : " + sapFunction.toXML() );
		System.out.println("\n\n- MUIS : " + sapFunctionStr+ ".getChangingParameterList() = \n" + sapFunction.getChangingParameterList());
		System.out.println("\n\n- MUIS : " + sapFunctionStr+ ".getExportParameterList() = \n" + sapFunction.getExportParameterList());
		System.out.println("\n\n- MUIS : " + sapFunctionStr+ ".getTableParameterList() = \n" + sapFunction.getTableParameterList());
		System.out.println("\n\n- MUIS : " + sapFunctionStr+ ".getFunctionTemplate() = \n" + sapFunction.getFunctionTemplate());
		System.out.println("***********************************************************************************");
	}
	
	private static void getTableValues(JCoFunction sapFunction, String tblName) {
		JCoTable sapTbl = sapFunction.getTableParameterList().getTable(tblName);
		if( sapTbl.getNumRows() > 0 ) {
			JCoFieldIterator it = sapTbl.getFieldIterator();
			System.out.println("\n- MUIS : Displaying Table " + tblName + " :");
			while(it.hasNextField()) {
				JCoField field = it.nextField();
				System.out.println(field.getName() + " = " + field.getString() + ", ");
			}
		}
	}
	
    private static void executeCalls(String destName)
    {
        try
        {
            JCoDestination dest=JCoDestinationManager.getDestination(destName);
            // Ping SAP :
				dest.ping();
				System.out.println("\n-MUIS : PING destination "+destName+" OK");
			// or execute any other remote sap function :
				
				String repoName  =dest.getRepository().getName();
				System.out.println("MUIS : Reposiroty name dest.getRepository().getName() =  " + repoName);
					
				//String[] sapFunctionsStr_Master 	= 	{"ZARIBA_PLANT", "ZARIBA_PURCHASE_ORG", "ZARIBA_PURCHASE_GROUP", "ZARIBA_PLANT_PORG", "ZARIBA_ASSET", "ZARIBA_GENERAL_LEDGER", "ZARIBA_INTERNAL_ORDER", "ZARIBA_WBS", "ZARIBA_ACCOUNT_CATEGORY", "ZARIBA_ACC_FIELD_STATUS", "ZARIBA_INTERNAL_ORDER", "ZARIBA_WBS", "ZARIBA_MATERIAL_GROUP", "ZARIBA_CURRENCY_CONVERSION", "ZARIBA_VENDOR", "ZARIBA_MINORITY_VENDOR", "ZARIBA_TAX_CODE", "ZARIBA_COMPANY", "ZARIBA_VENDOR", "ZARIBA_COST_CENTER", "ZARIBA_ACCOUNT_CAT_NAMES", "ZARIBA_MATERIAL_GROUP_NAMES", "ZARIBA_COST_CENTER_NAMES", "ZARIBA_GENERAL_LEDGER_NAMES", "ZARIBA_TAX_CODE_NAMES", "ZARIBA_VENDOR_INC", "ZARIBA_ASSET_INC", "ZARIBA_MATERIAL_ACC ", "ZARIBA_MATERIAL_ALT", "ZARIBA_MATERIAL_MRP", "ZARIBA_MATERIAL_CCR", "ZARIBA_MATERIAL_GEN", "ZARIBA_MATERIAL_STO", "ZARIBA_MATERIAL_PUR", "ZARIBA_MATERIAL_DSU", "ZARIBA_WAREHOUSE"};
				//String sapFunctionsStr_Trans		=	{"Z_ARIBA_GR_PUSH", "Z_ARIBA_BAPI_PO_CHANGE","Z_ARIBA_BAPI_PO_CANCEL","Z_ARIBA_PO_HEADER_STATUS","Z_ARIBA_GR_TRANSFER","Z_ARIBA_GR_QUALITY","ZARIBA_INVOICED_PO_ITEMS_SOAP", "Z_ARIBA_BAPI_PO_CREATE"};
				/*for(String sapFunctionStr: sapFunctionsStr) {
					JCoFunction sapFunction=dest.getRepository().getFunction(sapFunctionStr);
					System.out.println(sapFunctionStr + " as XML : " + sapFunction.toXML() );
				}*/
				
				String sapFunctionStr = "Z_ARIBA_GR_TRANSFER"; // "RFC_PING", "STFC_CONNECTION"
				JCoFunction sapFunction = dest.getRepository().getFunction(sapFunctionStr);
				if (sapFunction==null)
						throw new RuntimeException(sapFunction + " not found in SAP.");
				
				describeFunction(sapFunction);
				
				//sapFunction.getImportParameterList().setValue("ENCODING", "UTF-8");
				//sapFunction.getImportParameterList().setValue("FILE_NAME", "/exportQ11/DATAARIBA/Asset.csv");
				sapFunction.getImportParameterList().setValue("PARTITION", "par1iam");
				sapFunction.getImportParameterList().setValue("VARIANT", "var1iam");
				
				Map<String, String> a_gr_item = new HashMap<String, String>();
					a_gr_item.put("MBLNR","5001744605");
					a_gr_item.put("MJAHR","2021");
					a_gr_item.put("ZEILE","0001");
					a_gr_item.put("ZQACCEPT","2.00000");
					a_gr_item.put("ZUACCEPT","ES");
					a_gr_item.put("ZQREFUS","0.00000");
					a_gr_item.put("ZUREFUS","ES");
					//a_gr_item.put("BWTAR","");
					//a_gr_item.put("GRUND","");
					a_gr_item.put("ARIBA_GRNO","TR-RC329434");
					a_gr_item.put("ARIBA_ITNO","1");
					a_gr_item.put("NO_MORE_GR","X");

				JCoTable GR_ITEM = sapFunction.getTableParameterList().getTable("GR_ITEM");
				GR_ITEM.appendRow();
				JCoFieldIterator it = GR_ITEM.getFieldIterator();
				while(it.hasNextField()) {
					JCoField field = it.nextField();
					//System.out.println("-MUIS gr_item field = " + field.getName());
					
					for(Map.Entry<String, String> me : a_gr_item.entrySet()) {
						//System.out.println("key : " + me.getKey());
						if( field.getName().equals((String)me.getKey()) ) {
							System.out.println("-MUIS setting " + field.getName() + " to " + me.getValue());
							field.setValue(me.getValue());
						}
					}
				}
				
				try {
						sapFunction.execute(dest);
						
						//JCoStructure exportStructure = sapFunction.getTableParameterList().getStructure("GR_ITEM");
						//for (int i = 0; i < exportStructure.getMetaData().getFieldCount(); i++)
						//	System.out.println( "\n- MUIS2 :" + exportStructure.getMetaData().getName(i) + ":\t" + exportStructure.getString(i));
						
						System.out.println("\nMUIS : STATUS = " + sapFunction.getExportParameterList().getString("STATUS"));
						System.out.println("MUIS : GR_ITEM num rows = " + sapFunction.getTableParameterList().getTable("GR_ITEM").getNumRows());
						System.out.println("MUIS : GR_SERIAL num rows = " + sapFunction.getTableParameterList().getTable("GR_SERIAL").getNumRows());
						System.out.println("MUIS : ERROR_MSG_TABLE num rows = " + sapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE").getNumRows());
						getTableValues(sapFunction, "GR_ITEM");
						getTableValues(sapFunction, "GR_SERIAL");
						getTableValues(sapFunction, "ERROR_MSG_TABLE");
						//System.out.println("MUIS : ERROR_MSG_TABLE isTable = " + sapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE").isTable());
						//System.out.println("MUIS : ERROR_MSG_TABLE isStructure = " + sapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE").isStructure());
						
						//System.out.println("\n- MUIS : ECHOTEXT = " + sapFunction.getExportParameterList().getString("ECHOTEXT"));
						//System.out.println("\n- MUIS : RESPTEXT = " + sapFunction.getExportParameterList().getString("RESPTEXT"));
						
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
            System.out.println("Execution on destination "+destName+" failed");
        }
    }

}
																					 
