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

public class Z_ARIBA_PO_HEADER_STATUS {

	public JCoFunction currentSapFunction;
	public String PARTITION;
	public String VARIANT;
	public HEADERSTATUSINFO HEADERSTATUSINFO;
	
	public Z_ARIBA_PO_HEADER_STATUS() {
		this.PARTITION = "";
		this.VARIANT  ="";
	
		this.HEADERSTATUSINFO = new HEADERSTATUSINFO();
		this.HEADERSTATUSINFO.items =  new ArrayList<>();
		
	}
	
	class HEADERSTATUSINFO {public ArrayList<HEADERSTATUSINFO_Item> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class HEADERSTATUSINFO_Item {
		public String ERPORDERID;
		public String PONUMBER;
		public String SAPALLOWCANCEL;
	}

    public String toString() {
        // You may print the Z_ARIBA_PO_HEADER_STATUS Java object back as a JSON format, to inspect it :
		try { 
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting Z_ARIBA_PO_HEADER_STATUS object to String"; }
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
        public Z_ARIBA_PO_HEADER_STATUS Z_ARIBA_PO_HEADER_STATUS;
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
	public static Z_ARIBA_PO_HEADER_STATUS create_Z_ARIBA_PO_HEADER_STATUS_ObjectFromXML(String httpBody)  {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
            Z_ARIBA_PO_HEADER_STATUS	z_ariba_po_header_status = new Z_ARIBA_PO_HEADER_STATUS();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Application.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		Application.muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_PO_HEADER_STATUSS = (Map<String, Object>) soap_body.get("Z_ARIBA_PO_HEADER_STATUS");
		Application.muis_debug("Z_ARIBA_PO_HEADER_STATUS", Z_ARIBA_PO_HEADER_STATUSS);
		
		// SAP Scalars :
		Map<String, Object> Z_ARIBA_PO_HEADER_STATUSS2 = (Map<String, Object>) Z_ARIBA_PO_HEADER_STATUSS.get("Z_ARIBA_PO_HEADER_STATUS");
			Application.muis_debug("Z_ARIBA_PO_HEADER_STATUSS2", Z_ARIBA_PO_HEADER_STATUSS2);
			z_ariba_po_header_status.PARTITION =  !(Z_ARIBA_PO_HEADER_STATUSS2.get("PARTITION") instanceof String) ? "" : (String) Z_ARIBA_PO_HEADER_STATUSS2.get("PARTITION");
			z_ariba_po_header_status.VARIANT = !(Z_ARIBA_PO_HEADER_STATUSS2.get("VARIANT") instanceof String) ? "" : (String) Z_ARIBA_PO_HEADER_STATUSS2.get("VARIANT");

		// SAP Tables :
		Map<String, Object> ERROR_MSG_TABLE2 = (Map<String, Object>) Z_ARIBA_PO_HEADER_STATUSS2.get("ERROR_MSG_TABLE");
			Application.muis_debug("ERROR_MSG_TABLE2", ERROR_MSG_TABLE2);
			z_ariba_po_header_status.HEADERSTATUSINFO.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) ERROR_MSG_TABLE2, HEADERSTATUSINFO_Item.class);
			
	
		return z_ariba_po_header_status;
	}

    public void execute_SapFunc_Z_ARIBA_PO_HEADER_STATUS(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_PO_HEADER_STATUS() : " + body);

		Z_ARIBA_PO_HEADER_STATUS z_ariba_po_header_status = create_Z_ARIBA_PO_HEADER_STATUS_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_po_header_status = \n" + z_ariba_po_header_status);

        try
        {
				Application.muis_debug("MUIS : Reposiroty name dest.getRepository().getName() ", Application.dest.getRepository().getName());
					
				String sapFunctionStr = "Z_ARIBA_PO_HEADER_STATUS"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				this.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (this.currentSapFunction==null) throw new RuntimeException(this.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(this.currentSapFunction);
				
				// SAP Scalar fields
				this.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_po_header_status.PARTITION);
				this.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_po_header_status.VARIANT);
				
				// SAP Tables :
				Application.feed_SAP_Table("HEADERSTATUSINFO", z_ariba_po_header_status.HEADERSTATUSINFO.items, HEADERSTATUSINFO_Item.class, this.currentSapFunction);
		
				
				try {
                    this.currentSapFunction.execute(Application.dest);
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

	public void read_SapFunc_Z_ARIBA_PO_HEADER_STATUS_Response(Exchange exchange) {

		String sapFunctionStr = this.currentSapFunction.getName();
		Application.muis_debug("read_SapFunc_Z_ARIBA_BAPI_PO_CREATE_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		// Let's build our soap response step by step -Each time seeking some values from the SAP response values/tables/..etc :
		String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
		newBody += "<Z_ARIBA_PO_HEADER_STATUSResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_PO_HEADER_STATUS:response\"><Z_ARIBA_PO_HEADER_STATUS.Response>";
		
		String xml_E_PARTITION = "<E_PARTITION>"+ this.currentSapFunction.getExportParameterList().getString("E_PARTITION") + "</E_PARTITION>";
		String xml_E_VARIANT = "<E_VARIANT>"+ this.currentSapFunction.getExportParameterList().getString("E_VARIANT") + "</E_VARIANT>";
		newBody +=  xml_E_PARTITION + xml_E_VARIANT ; // Scalar values

		JCoTable sapTbl;
		Map<String, String> sapTables = Map.ofEntries(
			Map.entry("ZXTCPOHEADERSTATUS","HEADERSTATUSINFO")
		);
		
			
		for (Map.Entry<String, String> entry : sapTables.entrySet()) {
			String tblCode = entry.getKey();
			String tblName = entry.getValue();
			sapTbl = this.currentSapFunction.getTableParameterList().getTable(tblName);
			String xml_TblOut_Str = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll(tblCode, tblName) : "<"+tblName+"/>";
			newBody +=  xml_TblOut_Str; // Tables
		}
		
		newBody += "</Z_ARIBA_PO_HEADER_STATUS.Response></Z_ARIBA_PO_HEADER_STATUSResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
				
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_Z_ARIBA_BAPI_PO_CREATE_Response() to : " + newBody);
	}

}
