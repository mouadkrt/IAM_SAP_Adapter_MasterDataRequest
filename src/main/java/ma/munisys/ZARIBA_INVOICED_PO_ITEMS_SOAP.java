package ma.munisys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.underscore.U;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoTable;
import java.lang.reflect.Field;

public class ZARIBA_INVOICED_PO_ITEMS_SOAP {
	public String ENDDATE;
	public String PARTITION;
	public String STARTDATE;
	public String VARIANT;
	public ZINVPOITEMS ZINVPOITEMS;

    public String toString() {
        // You may print the ZARIBA_INVOICED_PO_ITEMS_SOAP Java object back as a JSON format, to inspect it :
		try { return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting ZARIBA_INVOICED_PO_ITEMS_SOAP object to String"; }
    }

    class Envelope { 
        public Header Header;
        public Body Body;
        public String soapenv;
        public String urn;
        public String urn1;
        public String text;
    }
    class Body { 
        public ZARIBA_INVOICED_PO_ITEMS_SOAP ZARIBA_INVOICED_PO_ITEMS_SOAP;
    }
    class Header { 
        public ibsinfo ibsinfo;
    }
    class ibsinfo { 
        public String service;
        public String method;
        public String license;
        public String Username;
        public String Password;
    }
    class ZINVPOITEMS {
        public ArrayList<ZINVPOITEMS_item> items;
        public ZINVPOITEMS() {
           this.items = new ArrayList<ZINVPOITEMS_item>();
          }
    }
    class ZINVPOITEMS_item {
        public String EBELN;
        public String EBELP;
        public String QTEFACT;
        public String QTECHU;
        public String QTEFACTPRE;
        public String QTECHUPRE;
        public String QTECIA;
        public String QTECIAPRE;
        public String BSTME;
    }
    
    // The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object as defined in the Z_ARIBA_GR_TRANSFER public class (Designed to mimic the http soap xml received)
	// The resulting instance of the Z_ARIBA_GR_TRANSFER will be then handed over to the SAP function for processing
	public static Z_ARIBA_GR_TRANSFER create_Z_ARIBA_GR_TRANSFER_ObjectFromXML(String httpBody) {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
		Z_ARIBA_GR_TRANSFER	z_ariba_gr_transfer = new Z_ARIBA_GR_TRANSFER();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Application.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		Application.muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_GR_TRANSFER = (Map<String, Object>) soap_body.get("Z_ARIBA_GR_TRANSFER");
		Application.muis_debug("Z_ARIBA_GR_TRANSFER", Z_ARIBA_GR_TRANSFER);
		
		Map<String, Object> Z_ARIBA_GR_TRANSFER2 = (Map<String, Object>) Z_ARIBA_GR_TRANSFER.get("Z_ARIBA_GR_TRANSFER");
		Application.muis_debug("Z_ARIBA_GR_TRANSFER2", Z_ARIBA_GR_TRANSFER2);
		
		z_ariba_gr_transfer.PARTITION = (String) Z_ARIBA_GR_TRANSFER2.get("PARTITION");
		z_ariba_gr_transfer.VARIANT = (String) Z_ARIBA_GR_TRANSFER2.get("VARIANT");
		
		Map<String, Object> GR_ITEMs2 = (Map<String, Object>) Z_ARIBA_GR_TRANSFER2.get("GR_ITEM");
		Application.muis_debug("GR_ITEMs2", GR_ITEMs2);
		
		Application.muis_debug("GR_ITEMs2.get('item')", GR_ITEMs2.get("item"));
		Application.muis_debug("... class : ", GR_ITEMs2.get("item").getClass().getName());
		
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
				Application.muis_debug("item", itemm);
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

    public static void execute_SapFunc_Z_ARIBA_GR_TRANSFER(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_GR_TRANSFER() : " + body);

		Z_ARIBA_GR_TRANSFER  z_ariba_gr_transfer = create_Z_ARIBA_GR_TRANSFER_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_gr_transfer = \n" + z_ariba_gr_transfer);

        try
        {
				String repoName  = Application.dest.getRepository().getName();
				System.out.println("MUIS : Reposiroty name dest.getRepository().getName() =  " + repoName);
					
				String sapFunctionStr = "Z_ARIBA_GR_TRANSFER"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				Application.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (Application.currentSapFunction==null) throw new RuntimeException(Application.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(Application.currentSapFunction);
				
				// The following will be used sftp adapter side :
					//sapFunction.getImportParameterList().setValue("ENCODING", "UTF-8");
					//sapFunction.getImportParameterList().setValue("FILE_NAME", "/exportQ11/DATAARIBA/Asset.csv");

					Application.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_gr_transfer.PARTITION);
					Application.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_gr_transfer.VARIANT);
				
				JCoTable GR_ITEM = Application.currentSapFunction.getTableParameterList().getTable("GR_ITEM");
				
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
                    Application.currentSapFunction.execute(Application.dest);
						
						//JCoStructure exportStructure = currentSapFunction.getTableParameterList().getStructure("GR_ITEM");
						//for (int i = 0; i < exportStructure.getMetaData().getFieldCount(); i++)
						//	System.out.println( "\n- MUIS2 :" + exportStructure.getMetaData().getName(i) + ":\t" + exportStructure.getString(i));
						
						System.out.println("\nMUIS : STATUS = " + Application.currentSapFunction.getExportParameterList().getString("STATUS"));
						Application.getTableValues(Application.currentSapFunction, "GR_ITEM");
						Application.getTableValues(Application.currentSapFunction, "GR_SERIAL");
						Application.getTableValues(Application.currentSapFunction, "ERROR_MSG_TABLE");
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

	public static void read_SapFunc_Z_ARIBA_GR_TRANSFER_Response(Exchange exchange) {

		String sapFunctionStr = Application.currentSapFunction.getName();
		Application.muis_debug("read_SapFunc_Z_ARIBA_GR_TRANSFER_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		String xmlStatusStr = "<STATUS>"+ Application.currentSapFunction.getExportParameterList().getString("STATUS") + "</STATUS>";

		JCoTable sapTbl;

		sapTbl = Application.currentSapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE");
		String xmlErrorStr = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTGRERR", "ERROR_MSG_TABLE") : "<ERROR_MSG_TABLE/>";
		
		sapTbl = Application.currentSapFunction.getTableParameterList().getTable("GR_ITEM");
		String xmlGrItemStr = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTEMTRANS", "GR_ITEM") : "<GR_ITEM/>";

		sapTbl = Application.currentSapFunction.getTableParameterList().getTable("GR_SERIAL");
		String xmlGrSerialStr = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTSERIAL", "GR_SERIAL") : "<GR_SERIAL/>";

		String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
			newBody += "<Z_ARIBA_GR_TRANSFERResponse xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_TRANSFER:response\"><Z_ARIBA_GR_TRANSFER.Response>";
				newBody += xmlStatusStr + xmlErrorStr + xmlGrItemStr + xmlGrSerialStr;
			newBody += "</Z_ARIBA_GR_TRANSFER.Response></Z_ARIBA_GR_TRANSFERResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
		
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_Z_ARIBA_GR_TRANSFER_Response() to : " + newBody);
	}
}
