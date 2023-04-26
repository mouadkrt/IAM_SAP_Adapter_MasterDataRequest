package ma.munisys;

// Service PurchaseOrderCancelExport_V1

import java.util.ArrayList;
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

public class Z_ARIBA_BAPI_PO_CANCEL {
	public String PARTITION;
	public String VARIANT;
	public PO_HEADER PO_HEADER;
	public ERROR_MSG_TABLE ERROR_MSG_TABLE;

    public String toString() {
        // You may print the Z_ARIBA_BAPI_PO_CANCEL Java object back as a JSON format, to inspect it :
		try { return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting Z_ARIBA_BAPI_PO_CANCEL object to String"; }
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
        public Z_ARIBA_BAPI_PO_CANCEL Z_ARIBA_BAPI_PO_CANCEL;
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
	class ERROR_MSG_TABLE { 
		public ArrayList<ERROR_MSG_TABLE_item> items;
    }

	static class PO_HEADER {
		public String EBELN;
        public String ERPORDERID;
        public String VERSION;
        public String LIFNR;
        public String ORDERTYPE;
        public String EKGRP;
        public String EKORG;
        public String AEDAT;
        public String UNSEZ;
        public String WAERS;
        public String CHGSTATE;
	}
	static class ERROR_MSG_TABLE_item {
        public String EBELN;
        public String ERPORDERID;
		public String NUMINSET;
		public String TYPE;
		public String MSGID;
		public String MSGNR;
		public String DYNAME;
		public String DYNUMB;
		public String FLDNAME;
		public String MESSAGE;
		//@JsonFormat(pattern="yyyy/MM/dd")
		public String DATETIME2;
		public String SYSID;
		public String MANDT;
    }
    
    // The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object (Designed to mimic the http soap xml received)
	// The resulting instance will be then handed over to the SAP function for processing
	public static Z_ARIBA_BAPI_PO_CANCEL create_Z_ARIBA_BAPI_PO_CANCEL_ObjectFromXML(String httpBody) {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
            Z_ARIBA_BAPI_PO_CANCEL	z_ariba_bapi_po_cancel = new Z_ARIBA_BAPI_PO_CANCEL();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Application.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		Application.muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_BAPI_PO_CANCELL = (Map<String, Object>) soap_body.get("Z_ARIBA_BAPI_PO_CANCEL");
		Application.muis_debug("Z_ARIBA_BAPI_PO_CANCEL", Z_ARIBA_BAPI_PO_CANCELL);
		
		Map<String, Object> Z_ARIBA_BAPI_PO_CANCELL2 = (Map<String, Object>) Z_ARIBA_BAPI_PO_CANCELL.get("Z_ARIBA_BAPI_PO_CANCEL");
			Application.muis_debug("Z_ARIBA_BAPI_PO_CANCELL2", Z_ARIBA_BAPI_PO_CANCELL2);
			z_ariba_bapi_po_cancel.PARTITION =  !(Z_ARIBA_BAPI_PO_CANCELL2.get("PARTITION") instanceof String) ? "" : (String) Z_ARIBA_BAPI_PO_CANCELL2.get("PARTITION");
			z_ariba_bapi_po_cancel.VARIANT = !(Z_ARIBA_BAPI_PO_CANCELL2.get("VARIANT") instanceof String) ? "" : (String) Z_ARIBA_BAPI_PO_CANCELL2.get("VARIANT");
		
		Map<String, Object> poheader = (Map<String, Object>) Z_ARIBA_BAPI_PO_CANCELL2.get("PO_HEADER");
			Application.muis_debug("poheader", poheader);
			z_ariba_bapi_po_cancel.PO_HEADER.AEDAT 		= Application.forceString(poheader, "AEDAT");
			z_ariba_bapi_po_cancel.PO_HEADER.CHGSTATE 	= Application.forceString(poheader, "CHGSTATE");
			z_ariba_bapi_po_cancel.PO_HEADER.EBELN 		= Application.forceString(poheader, "EBELN");
			z_ariba_bapi_po_cancel.PO_HEADER.EKGRP 		= Application.forceString(poheader, "EKGRP");
			z_ariba_bapi_po_cancel.PO_HEADER.EKORG 		= Application.forceString(poheader, "EKORG");
			z_ariba_bapi_po_cancel.PO_HEADER.ERPORDERID = Application.forceString(poheader, "ERPORDERID");
			z_ariba_bapi_po_cancel.PO_HEADER.LIFNR 		= Application.forceString(poheader, "LIFNR");
			z_ariba_bapi_po_cancel.PO_HEADER.ORDERTYPE	= Application.forceString(poheader, "ORDERTYPE");
			z_ariba_bapi_po_cancel.PO_HEADER.UNSEZ 		= Application.forceString(poheader, "UNSEZ");
			z_ariba_bapi_po_cancel.PO_HEADER.VERSION 	= Application.forceString(poheader, "VERSION");
			z_ariba_bapi_po_cancel.PO_HEADER.WAERS 		= Application.forceString(poheader, "WAERS");

			ERROR_MSG_TABLE err = (ERROR_MSG_TABLE) Z_ARIBA_BAPI_PO_CANCELL2.get("ERROR_MSG_TABLE");
			Application.muis_debug("ERROR_MSG_TABLE", err);

		return z_ariba_bapi_po_cancel;
	}

    public static void execute_SapFunc_Z_ARIBA_BAPI_PO_CANCEL(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_BAPI_PO_CANCEL() : " + body);

		Z_ARIBA_BAPI_PO_CANCEL z_ariba_bapi_po_cancel = create_Z_ARIBA_BAPI_PO_CANCEL_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_bapi_po_cancel = \n" + z_ariba_bapi_po_cancel);

        try
        {
				Application.muis_debug("MUIS : Reposiroty name dest.getRepository().getName() ", Application.dest.getRepository().getName());

				String sapFunctionStr = "Z_ARIBA_BAPI_PO_CANCEL"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				Application.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (Application.currentSapFunction==null) throw new RuntimeException(Application.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(Application.currentSapFunction);
				
				// SAP Scalar fields
				Application.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_bapi_po_cancel.PARTITION);
				Application.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_bapi_po_cancel.VARIANT);
							
				// SAP Structures :
				Application.feed_SAP_Structure("PO_HEADER", z_ariba_bapi_po_cancel.PO_HEADER, PO_HEADER.class);
				
				// SAP Tables :
				Application.feed_SAP_Table("ERROR_MSG_TABLE", z_ariba_bapi_po_cancel.ERROR_MSG_TABLE.items, ERROR_MSG_TABLE_item.class);

				
				
				try {
                    Application.currentSapFunction.execute(Application.dest);
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

	public static void read_SapFunc_Z_ARIBA_BAPI_PO_CANCEL_Response(Exchange exchange) {

		String sapFunctionStr = Application.currentSapFunction.getName();
		Application.muis_debug("read_SapFunc_Z_ARIBA_BAPI_PO_CANCEL_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		String xml_ERPORDERID = "<ERPORDERID>"+ Application.currentSapFunction.getExportParameterList().getString("ERPORDERID") + "</ERPORDERID>";
		String xml_E_PARTITION = "<E_PARTITION>"+ Application.currentSapFunction.getExportParameterList().getString("E_PARTITION") + "</E_PARTITION>";
		String xml_E_VARIANT = "<E_VARIANT>"+ Application.currentSapFunction.getExportParameterList().getString("E_VARIANT") + "</E_VARIANT>";
		String xml_RETURNMSG = "<RETURNMSG>"+ Application.currentSapFunction.getExportParameterList().getString("RETURNMSG") + "</RETURNMSG>";

		JCoTable sapTbl;

		sapTbl = Application.currentSapFunction.getTableParameterList().getTable("ERROR_MSG_TABLE");
		String xml_ERROR_MSG_TABLE = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll("ZXTPOERR", "ERROR_MSG_TABLE") : "<ERROR_MSG_TABLE/>";
		
			String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
			newBody += "<Z_ARIBA_BAPI_PO_CANCELResponse xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_BAPI_PO_CANCEL:response\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><Z_ARIBA_BAPI_PO_CANCEL.Response>";
				newBody +=  xml_ERPORDERID + xml_E_PARTITION + xml_E_VARIANT + xml_RETURNMSG + xml_ERROR_MSG_TABLE;
			newBody += "</Z_ARIBA_BAPI_PO_CANCEL.Response></Z_ARIBA_BAPI_PO_CANCELResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
		
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_Z_ARIBA_BAPI_PO_CANCEL_Response() to : " + newBody);
	}

}
