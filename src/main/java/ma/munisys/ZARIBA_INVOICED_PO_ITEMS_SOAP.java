package ma.munisys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.underscore.U; // https://javadev.github.io/underscore-java/
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
	// The resulting instance of the ZARIBA_INVOICED_PO_ITEMS_SOAP will be then handed over to the SAP function for processing
	public static ZARIBA_INVOICED_PO_ITEMS_SOAP create_ZARIBA_INVOICED_PO_ITEMS_SOAP_ObjectFromXML(String httpBody) {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
            ZARIBA_INVOICED_PO_ITEMS_SOAP	z_ariba_invoiced_po_items_soap = new ZARIBA_INVOICED_PO_ITEMS_SOAP();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Application.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		Application.muis_debug("soap_body", soap_body);
		
		Map<String, Object> ZARIBA_INVOICED_PO_ITEMS_SOAPP = (Map<String, Object>) soap_body.get("ZARIBA_INVOICED_PO_ITEMS_SOAP");
		Application.muis_debug("ZARIBA_INVOICED_PO_ITEMS_SOAPP", ZARIBA_INVOICED_PO_ITEMS_SOAPP);
		
		Map<String, Object> ZARIBA_INVOICED_PO_ITEMS_SOAPP2 = (Map<String, Object>) ZARIBA_INVOICED_PO_ITEMS_SOAPP.get("ZARIBA_INVOICED_PO_ITEMS_SOAP");
		Application.muis_debug("Z_ARIBA_GR_TRANSFERR2", ZARIBA_INVOICED_PO_ITEMS_SOAPP2);
		

		z_ariba_invoiced_po_items_soap.PARTITION =  !(ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("PARTITION") instanceof String) ? "" : (String) ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("PARTITION");
		z_ariba_invoiced_po_items_soap.VARIANT = !(ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("VARIANT") instanceof String) ? "" : (String) ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("VARIANT");
		z_ariba_invoiced_po_items_soap.STARTDATE = !(ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("STARTDATE") instanceof String) ? "" : (String) ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("STARTDATE");
		z_ariba_invoiced_po_items_soap.ENDDATE = !(ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("ENDDATE") instanceof String) ? "" : (String) ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("ENDDATE");
		
		z_ariba_invoiced_po_items_soap.ZINVPOITEMS = z_ariba_invoiced_po_items_soap.new ZINVPOITEMS();

		Map<String, Object> ZINVPOITEMS2 = (Map<String, Object>) ZARIBA_INVOICED_PO_ITEMS_SOAPP2.get("ZINVPOITEMS");
		Application.muis_debug("ZINVPOITEMS2", ZINVPOITEMS2);
		if(!(ZINVPOITEMS2 == null)) {
			Application.muis_debug("ZINVPOITEMS2.get('item')", ZINVPOITEMS2.get("item"));
			Application.muis_debug("... class : ", ZINVPOITEMS2.get("item").getClass().getName());
			
			ObjectMapper mapper = new ObjectMapper();
			
			if(!ZINVPOITEMS2.get("item").getClass().getName().equals("java.util.ArrayList")) {
				LinkedHashMap itemm = (LinkedHashMap) ZINVPOITEMS2.get("item");
				//Set xml self-closed tags as empty strings  :
						for (Object key : itemm.keySet()) if(  !(itemm.get(key) instanceof java.lang.String) ) itemm.put(key, "");
				ZINVPOITEMS_item gr_item_item = mapper.convertValue(itemm,ZINVPOITEMS_item.class);
				z_ariba_invoiced_po_items_soap.ZINVPOITEMS.items.add(gr_item_item);
			}
			else {
				ArrayList<Map<String,String>> GR_ITEMs = (ArrayList<Map<String,String>>) ZINVPOITEMS2.get("item");
				Iterator iter = GR_ITEMs.iterator();
				while (iter.hasNext()) {
					Map<String, String> itemm = (Map<String, String>) iter.next();
					Application.muis_debug("item", itemm);
					//LinkedHashMap itemm = (LinkedHashMap) item.get("item").get(0);
									
					//Set xml self-closed tags as empty strings  :
						for (String key : itemm.keySet()) if(  !(itemm.get(key) instanceof java.lang.String) ) itemm.put(key, "");
					
					//System.out.print(iter.next() + "\n");
					ZINVPOITEMS_item gr_item_item = mapper.convertValue(itemm,ZINVPOITEMS_item.class);
					z_ariba_invoiced_po_items_soap.ZINVPOITEMS.items.add(gr_item_item);
				}
			}
		}
		else {

		}
		return z_ariba_invoiced_po_items_soap;
	}

    public static void execute_SapFunc_ZARIBA_INVOICED_PO_ITEMS_SOAP(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_ZARIBA_INVOICED_PO_ITEMS_SOAP() : " + body);

		ZARIBA_INVOICED_PO_ITEMS_SOAP z_ariba_invoiced_po_items_soap = create_ZARIBA_INVOICED_PO_ITEMS_SOAP_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_invoiced_po_items_soap = \n" + z_ariba_invoiced_po_items_soap);

        try
        {
				String repoName  = Application.dest.getRepository().getName();
				System.out.println("MUIS : Reposiroty name dest.getRepository().getName() =  " + repoName);
					
				String sapFunctionStr = "ZARIBA_INVOICED_PO_ITEMS_SOAP"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				Application.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (Application.currentSapFunction==null) throw new RuntimeException(Application.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(Application.currentSapFunction);
				
				Application.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_invoiced_po_items_soap.PARTITION);
				Application.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_invoiced_po_items_soap.VARIANT);
				Application.currentSapFunction.getImportParameterList().setValue("STARTDATE", z_ariba_invoiced_po_items_soap.STARTDATE);
				Application.currentSapFunction.getImportParameterList().setValue("ENDDATE", z_ariba_invoiced_po_items_soap.ENDDATE);
				
				JCoTable t_ZINVPOITEMS = Application.currentSapFunction.getTableParameterList().getTable("ZINVPOITEMS");
				
				for (ZINVPOITEMS_item zItem : z_ariba_invoiced_po_items_soap.ZINVPOITEMS.items) {
					//for( Field f : grItem.getClass().getDeclaredFields() ) {}
					t_ZINVPOITEMS.appendRow();
					JCoFieldIterator it = t_ZINVPOITEMS.getFieldIterator();
					while(it.hasNextField()) {
						JCoField field = it.nextField();
						try {
							Field f = zItem.getClass().getDeclaredField(field.getName());
							f.setAccessible(true);
							field.setValue(f.get(zItem));
						}
						catch(NoSuchFieldException|IllegalAccessException e) { System.out.println(e.getMessage());}
					}
				}
				
				try {
                    Application.currentSapFunction.execute(Application.dest);
						
						//JCoStructure exportStructure = currentSapFunction.getTableParameterList().getStructure("GR_ITEM");
						//for (int i = 0; i < exportStructure.getMetaData().getFieldCount(); i++)
						//	System.out.println( "\n- MUIS2 :" + exportStructure.getMetaData().getName(i) + ":\t" + exportStructure.getString(i));
						
						System.out.println("\nMUIS : SENDDATE = " + Application.currentSapFunction.getExportParameterList().getString("SENDDATE"));
						Application.getTableValues(Application.currentSapFunction, "ZINVPOITEMS");
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

	public static void read_SapFunc_ZARIBA_INVOICED_PO_ITEMS_SOAP_Response(Exchange exchange) {

		String sapFunctionStr = Application.currentSapFunction.getName();
		Application.muis_debug("read_SapFunc_ZARIBA_INVOICED_PO_ITEMS_SOAP_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		String xmlSendDateStr = "<SENDDATE>"+ Application.currentSapFunction.getExportParameterList().getString("SENDDATE") + "</SENDDATE>";

		JCoTable sapTbl;

		sapTbl = Application.currentSapFunction.getTableParameterList().getTable("ZINVPOITEMS");
		String xml_ZINVPOITEMS_Str = sapTbl.getNumRows() > 0 ? sapTbl.toXML() : "<ZINVPOITEMS/>";
		
			String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
			newBody += "<ZARIBA_INVOICED_PO_ITEMS_SOAPResponse xmlns=\"urn:iwaysoftware:ibse:jul2003:ZARIBA_INVOICED_PO_ITEMS_SOAP:response\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><ZARIBA_INVOICED_PO_ITEMS_SOAP.Response>";
				newBody +=  xmlSendDateStr + xml_ZINVPOITEMS_Str;
			newBody += "</ZARIBA_INVOICED_PO_ITEMS_SOAP.Response></ZARIBA_INVOICED_PO_ITEMS_SOAPResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
		
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_ZARIBA_INVOICED_PO_ITEMS_SOAP_Response() to : " + newBody);
	}

}
