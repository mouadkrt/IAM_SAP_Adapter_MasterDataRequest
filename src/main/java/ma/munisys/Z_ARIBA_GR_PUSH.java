package ma.munisys;

// PurchaseOrderHeaderStatusImport_V1

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.underscore.U; // https://javadev.github.io/underscore-java/
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

public class Z_ARIBA_GR_PUSH {

	public JCoFunction currentSapFunction;
	public String PARTITION;
	public String VARIANT;
	public GR_HEADER GR_HEADER;
	public ERROR_MSG_TABLE ERROR_MSG_TABLE;
	public GR_ITEMS GR_ITEMS;
	
	public Z_ARIBA_GR_PUSH() {
		this.PARTITION = "";
		this.VARIANT  ="";
	
		this.GR_HEADER = new GR_HEADER();

		this.ERROR_MSG_TABLE = new ERROR_MSG_TABLE();
		this.ERROR_MSG_TABLE.items =  new ArrayList<>();

		this.GR_ITEMS = new GR_ITEMS();
		this.GR_ITEMS.items =  new ArrayList<>();
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class GR_HEADER {
		public String MBLNR;

		// https://answers.sap.com/questions/12757653/how-do-i-set-date-in-custom-rfc-jco-call-.html :
			// If the data type of the function module parameter is of type DATS you can easily pass a java.util.date object and the SAP JCo implementation will convert it correctly.
			// You could also pass a YYYYMMDD formated String, which will also work

			//@JsonFormat(pattern="yyyy/MM/dd")
			public String BLDAT;

			//@JsonFormat(pattern="yyyy/MM/dd")
			public String BUDAT;
			
		public String FRBNR;
		public String LFSNR;
		public String BWARTWE;
		public String BKTXT;
		public String EBELN;
		public String ARIBA_GRNO;
	}

	class ERROR_MSG_TABLE {public ArrayList<ERROR_MSG_TABLE_Item> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ERROR_MSG_TABLE_Item {
		public String MBLNR;
		public String NUMINSET;
		public String TYPE;
		public String MSGID;
		public String MSGNR;
		public String DYNAME;
		public String DYNUMB;
		public String FLDNAME;
		public String MESSAGE;
		public String DATETIME2;
		public String SYSID;
		public String MANDT;
	}

	class GR_ITEMS {public ArrayList<GR_ITEMS_Item> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class GR_ITEMS_Item {
		public String ZEILE;
		public String ARIBA_ITNO;
		public String ERFMG;
		public String ERFME;
		public String ELIKZ;
		public String EBELN;
		public String EBELP;
		public String ARIBA_GRNO;
		public String MBLNR;
		public String AEDAT;
		public String SGTXT;
	}


    public String toString() {
        // You may print the Z_ARIBA_GR_PUSH Java object back as a JSON format, to inspect it :
		try { 
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting Z_ARIBA_GR_PUSH object to String"; }
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
        public Z_ARIBA_GR_PUSH Z_ARIBA_GR_PUSH;
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
		public String disposition;
		public String language;
    }

    // The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object (Designed to mimic the http soap xml received)
	// The resulting instance will be then handed over to the SAP function for processing
	public static Z_ARIBA_GR_PUSH create_Z_ARIBA_GR_PUSH_ObjectFromXML(String httpBody)  {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
            Z_ARIBA_GR_PUSH	z_ariba_gr_push = new Z_ARIBA_GR_PUSH();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		MuisApp.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		MuisApp.muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_GR_PUSHH = (Map<String, Object>) soap_body.get("Z_ARIBA_GR_PUSH");
		MuisApp.muis_debug("Z_ARIBA_GR_PUSHH", Z_ARIBA_GR_PUSHH);
		
		// SAP Scalars :
		Map<String, Object> Z_ARIBA_GR_PUSHH2 = (Map<String, Object>) Z_ARIBA_GR_PUSHH.get("Z_ARIBA_GR_PUSH");
			MuisApp.muis_debug("Z_ARIBA_GR_PUSHH2", Z_ARIBA_GR_PUSHH2);
			z_ariba_gr_push.PARTITION =  !(Z_ARIBA_GR_PUSHH2.get("PARTITION") instanceof String) ? "" : (String) Z_ARIBA_GR_PUSHH2.get("PARTITION");
			z_ariba_gr_push.VARIANT = !(Z_ARIBA_GR_PUSHH2.get("VARIANT") instanceof String) ? "" : (String) Z_ARIBA_GR_PUSHH2.get("VARIANT");
		
		ObjectMapper mapper = new ObjectMapper();

		// SAP Structures :
		Map<String, Object> grheader = (Map<String, Object>) Z_ARIBA_GR_PUSHH2.get("GR_HEADER");
			MuisApp.muis_debug("grheader", grheader);
			z_ariba_gr_push.GR_HEADER = (GR_HEADER) mapper.convertValue(grheader,GR_HEADER.class);
				
		// SAP Tables :
		Map<String, Object> ERROR_MSG_TABLE2 = (Map<String, Object>) Z_ARIBA_GR_PUSHH2.get("ERROR_MSG_TABLE");
			MuisApp.muis_debug("ERROR_MSG_TABLE2", ERROR_MSG_TABLE2);
			z_ariba_gr_push.ERROR_MSG_TABLE.items = MuisApp.getItemsAsArrayList((LinkedHashMap<String, Object>) ERROR_MSG_TABLE2, ERROR_MSG_TABLE_Item.class);
		
		Map<String, Object> GR_ITEMS2 = (Map<String, Object>) Z_ARIBA_GR_PUSHH2.get("GR_ITEMS");
			MuisApp.muis_debug("GR_ITEMS2", GR_ITEMS2);
			z_ariba_gr_push.GR_ITEMS.items = MuisApp.getItemsAsArrayList((LinkedHashMap<String, Object>) GR_ITEMS2, GR_ITEMS_Item.class);
			
	
		return z_ariba_gr_push;
	}

    public void execute_SapFunc_Z_ARIBA_GR_PUSH(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_GR_PUSH() : " + body);

		Z_ARIBA_GR_PUSH z_ariba_gr_push = create_Z_ARIBA_GR_PUSH_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_gr_push = \n" + z_ariba_gr_push);

        try
        {
				MuisApp.muis_debug("MUIS : Repository name dest.getRepository().getName() ", MuisApp.dest.getRepository().getName());
					
				String sapFunctionStr = "Z_ARIBA_GR_PUSH"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				this.currentSapFunction = MuisApp.dest.getRepository().getFunction(sapFunctionStr);
				if (this.currentSapFunction==null) throw new RuntimeException(this.currentSapFunction + " not found in SAP.");
				
				if(!MuisApp.MUIS_DEBUG.equals("0")) MuisApp.describeFunction(this.currentSapFunction);
				
				// SAP Scalar fields
				this.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_gr_push.PARTITION);
				this.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_gr_push.VARIANT);
				
				// SAP Structures :
				MuisApp.feed_SAP_Structure("GR_HEADER", z_ariba_gr_push.GR_HEADER, GR_HEADER.class, this.currentSapFunction);
				
				// SAP Tables :
				MuisApp.feed_SAP_Table("ERROR_MSG_TABLE", z_ariba_gr_push.ERROR_MSG_TABLE.items, ERROR_MSG_TABLE_Item.class, this.currentSapFunction);
				MuisApp.feed_SAP_Table("GR_ITEMS", z_ariba_gr_push.GR_ITEMS.items, GR_ITEMS_Item.class, this.currentSapFunction);
		
				
				try {
                    this.currentSapFunction.execute(MuisApp.dest);
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

	public void read_SapFunc_Z_ARIBA_GR_PUSH_Response(Exchange exchange) {

		String sapFunctionStr = this.currentSapFunction.getName();
		MuisApp.muis_debug("read_SapFunc_Z_ARIBA_GR_PUSH_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		// Let's build our soap response step by step -Each time seeking some values from the SAP response values/tables/..etc :
		String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
		newBody += "<Z_ARIBA_GR_PUSHResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_PUSH:response\"><Z_ARIBA_GR_PUSH.Response>";
		
		String xml_E_PARTITION = "<E_PARTITION>"+ this.currentSapFunction.getExportParameterList().getString("E_PARTITION") + "</E_PARTITION>";
		String xml_E_VARIANT = "<E_VARIANT>"+ this.currentSapFunction.getExportParameterList().getString("E_VARIANT") + "</E_VARIANT>";
		newBody +=  xml_E_PARTITION + xml_E_VARIANT ; // Scalar values

		JCoTable sapTbl;
		Map<String, String> sapTables = Map.ofEntries(
			Map.entry("ZXTGRERR","ERROR_MSG_TABLE"),
			Map.entry("ZXTGRITEMS","GR_ITEMS")
		);
		
			
		for (Map.Entry<String, String> entry : sapTables.entrySet()) {
			String tblCode = entry.getKey();
			String tblName = entry.getValue();
			sapTbl = this.currentSapFunction.getTableParameterList().getTable(tblName);
			String xml_TblOut_Str = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll(tblCode, tblName) : "<"+tblName+"/>";
			newBody +=  xml_TblOut_Str; // Tables
		}
		
		newBody += "</Z_ARIBA_GR_PUSH.Response></Z_ARIBA_GR_PUSHResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
				
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_Z_ARIBA_GR_PUSH_Response() to : " + newBody);
	}

}
