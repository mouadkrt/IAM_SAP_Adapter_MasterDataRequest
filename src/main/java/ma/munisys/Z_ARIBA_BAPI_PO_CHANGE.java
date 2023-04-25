package ma.munisys;

import java.lang.reflect.Field;

// PurchaseOrderChangeExport_V1

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.underscore.U; // https://javadev.github.io/underscore-java/
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoTable;

public class Z_ARIBA_BAPI_PO_CHANGE {

public String PARTITION;
	public String VARIANT;
	public PO_HEADER PO_HEADER;
	public ERROR_MSG_TABLE ERROR_MSG_TABLE;
	public DELPO_ACCNTS DELPO_ACCNTS;
	public DELPO_ITEMS DELPO_ITEMS;
	public PO_ACCOUNTS PO_ACCOUNTS;
	public PO_COND PO_COND;
	public PO_ITEMS PO_ITEMS;
	public PO_TEXT PO_TEXT;
	public PUR_ORDER_DELIVERY PUR_ORDER_DELIVERY;
	public PUR_ORDER_DETAILS PUR_ORDER_DETAILS;

	public Z_ARIBA_BAPI_PO_CHANGE() {

		this.PARTITION = "";
		this.VARIANT = "";

		this.PO_HEADER = new PO_HEADER();

		this.ERROR_MSG_TABLE = new ERROR_MSG_TABLE();
		this.ERROR_MSG_TABLE.items = new ArrayList<>();

		this.DELPO_ACCNTS = new DELPO_ACCNTS();
		this.DELPO_ACCNTS.items = new ArrayList<>();

		this.DELPO_ITEMS = new DELPO_ITEMS();
		this.DELPO_ITEMS.items = new ArrayList<>();

		this.PO_ACCOUNTS = new PO_ACCOUNTS();
		this.PO_ACCOUNTS.items = new ArrayList<>();

		this.PO_COND = new PO_COND();
		this.PO_COND.items = new ArrayList<>();

		this.PO_ITEMS = new PO_ITEMS();
		this.PO_ITEMS.items = new ArrayList<>();

		this.PO_TEXT = new PO_TEXT();
		this.PO_TEXT.items = new ArrayList<>();

		this.PUR_ORDER_DELIVERY = new PUR_ORDER_DELIVERY();
		this.PUR_ORDER_DELIVERY.items = new ArrayList<>();

		this.PUR_ORDER_DETAILS = new PUR_ORDER_DETAILS();
		this.PUR_ORDER_DETAILS.items = new ArrayList<>();

	}

    public String toString() {
        // You may print the Z_ARIBA_BAPI_PO_CHANGE Java object back as a JSON format, to inspect it :
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		try { return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting Z_ARIBA_BAPI_PO_CHANGE object to String"; }
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
        public Z_ARIBA_BAPI_PO_CHANGE Z_ARIBA_BAPI_PO_CHANGE;
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

	class ERROR_MSG_TABLE { public ArrayList<ERROR_MSG_TABLE_item> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
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
		public String DATETIME2;
		public String SYSID;
		public String MANDT;
    }

	class PO_HEADER {
		public String EBELN = "";
        public String ERPORDERID = "";
        public String VERSION = "";
        public String LIFNR = "";
        public String ORDERTYPE = "";
        public String EKGRP = "";
        public String AEDAT = "";
        public String EKORG = "";
        public String UNSEZ = "";
        public String WAERS = "";
        public String CHGSTATE = "";
        public String PMNTTRMS = "";
	}
	
	class DELPO_ACCNTS { ArrayList<ZXTCPODELACCNT> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZXTCPODELACCNT {
		public String EBELP = "";
		public String SERIAL_NO = "";
	}

	class DELPO_ITEMS { ArrayList<ZXTCPODELITEMS> items; }
	class ZXTCPODELITEMS {
		public String EBELP = "";
	}

	class PO_ACCOUNTS { ArrayList<ZXTCPOACCNT> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZXTCPOACCNT {
		public String EBELP;
		public String SERIAL_NO = "";
		public String MKNTM = "";
		public String SAKTO = "";
		public String KOSTL = "";
		public String AUFNR = "";
		public String ANLN1 = "";
		public String ANLN2 = "";
		public String PS_PSP_PNR = "";
		public String MKNTMLIMIT = "";
		public String CHGSTATE = "";
	}

	class PO_COND { ArrayList<ZXTPOCOND> items; }
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZXTPOCOND {
		public String KSCHL = "";
        public String KBETR = "";
        public String KONWA = "";
	}

	class PO_ITEMS { ArrayList<ZXTCPOITEMS> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZXTCPOITEMS {
		public String EBELP = "";
        public String TXZ01 = "";
        public String MATKL = "";
        public String KNTTP = "";
        public String WERKS = "";
        public String NETPR = "";
        public String PEINH = "";
        public String MENGE = "";
        public String MEINS = "";

		@JsonFormat(pattern="yyyy/MM/dd")
        public Date EEIND;

        public String EMATN = "";
        public String SAKTO = "";
        public String KOSTL = "";
        public String AUFNR = "";
        public String PS_PSP_PNR = "";
        public String ANLN1 = "";
        public String ANLN2 = "";
        public String MWSKZ = "";
        public String EPSTP = "";
        public String SUMLIMIT = "";
        public String COMMITMENT = "";
        public String REQ_ID = "";
        public String ITEMONREQ = "";
        public String VRTKZ = "";
        public String TWRKZ = "";
        public String UNTTO = "";
        public String UEBTO = "";
        public String CHGSTATE = "";
        public String LGORT = "";
	}

	class PO_TEXT { ArrayList<ZARSTRING> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZARSTRING {
		public String EBELP = "";
        public String TDOBJECT = "";
        public String TDID = "";
        public String STRINGNUM = "";
        public String STRING = "";
	}

	class PUR_ORDER_DELIVERY { ArrayList<ZXTPODELIV> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZXTPODELIV {
		public String EBELN = "";
		public String EBELPv = "";
		public String EINDT = "";
	}

	class PUR_ORDER_DETAILS { ArrayList<ZXTPODET> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class ZXTPODET {
		public String EBELN = "";
		public String EBELP = "";
		public String AEDAT = "";
		public String MENGE = "";
		public String MEINS = "";
		public String NETPR = "";
		public String REQ_ID = "";
		public String ITEMONREQ = "";
	}
    
    // The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object (Designed to mimic the http soap xml received)
	// The resulting instance will be then handed over to the SAP function for processing
	public static Z_ARIBA_BAPI_PO_CHANGE create_Z_ARIBA_BAPI_PO_CHANGE_ObjectFromXML(String httpBody) throws IllegalArgumentException, IllegalAccessException {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
            Z_ARIBA_BAPI_PO_CHANGE	z_ariba_bapi_po_change = new Z_ARIBA_BAPI_PO_CHANGE();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Application.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		Application.muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_BAPI_PO_CHANGEE = (Map<String, Object>) soap_body.get("Z_ARIBA_BAPI_PO_CHANGE");
		Application.muis_debug("Z_ARIBA_BAPI_PO_CHANGE", Z_ARIBA_BAPI_PO_CHANGEE);
		
		Map<String, Object> Z_ARIBA_BAPI_PO_CHANGEE2 = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE.get("Z_ARIBA_BAPI_PO_CHANGE");
			Application.muis_debug("Z_ARIBA_BAPI_PO_CHANGEE2", Z_ARIBA_BAPI_PO_CHANGEE2);
			z_ariba_bapi_po_change.PARTITION =  !(Z_ARIBA_BAPI_PO_CHANGEE2.get("PARTITION") instanceof String) ? "" : (String) Z_ARIBA_BAPI_PO_CHANGEE2.get("PARTITION");
			z_ariba_bapi_po_change.VARIANT = !(Z_ARIBA_BAPI_PO_CHANGEE2.get("VARIANT") instanceof String) ? "" : (String) Z_ARIBA_BAPI_PO_CHANGEE2.get("VARIANT");
		
		Map<String, Object> poheader = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_HEADER");
			Application.muis_debug("poheader", poheader);
			z_ariba_bapi_po_change.PO_HEADER = z_ariba_bapi_po_change.new PO_HEADER();
			Field[] PO_HEADER_fields =  z_ariba_bapi_po_change.PO_HEADER.getClass().getDeclaredFields();
			/*for(Field f : PO_HEADER_fields){
				f.setAccessible(true);
				f.set(z_ariba_bapi_po_change.PO_HEADER, Application.forceString(poheader, f.getName()));
			}*/
			z_ariba_bapi_po_change.PO_HEADER.AEDAT 		= Application.forceString(poheader, "AEDAT");
			z_ariba_bapi_po_change.PO_HEADER.PMNTTRMS 	= Application.forceString(poheader, "PMNTTRMS");
			z_ariba_bapi_po_change.PO_HEADER.CHGSTATE 	= Application.forceString(poheader, "CHGSTATE");
			z_ariba_bapi_po_change.PO_HEADER.EBELN 		= Application.forceString(poheader, "EBELN");
			z_ariba_bapi_po_change.PO_HEADER.EKGRP 		= Application.forceString(poheader, "EKGRP");
			z_ariba_bapi_po_change.PO_HEADER.EKORG 		= Application.forceString(poheader, "EKORG");
			z_ariba_bapi_po_change.PO_HEADER.ERPORDERID = Application.forceString(poheader, "ERPORDERID");
			z_ariba_bapi_po_change.PO_HEADER.LIFNR 		= Application.forceString(poheader, "LIFNR");
			z_ariba_bapi_po_change.PO_HEADER.ORDERTYPE	= Application.forceString(poheader, "ORDERTYPE");
			z_ariba_bapi_po_change.PO_HEADER.UNSEZ 		= Application.forceString(poheader, "UNSEZ");
			z_ariba_bapi_po_change.PO_HEADER.VERSION 	= Application.forceString(poheader, "VERSION");
			z_ariba_bapi_po_change.PO_HEADER.WAERS 		= Application.forceString(poheader, "WAERS");
			

		Map<String, Object> delpo_accnts = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("DELPO_ACCNTS");
			Application.muis_debug("delpo_accnts", delpo_accnts);
			if(!(delpo_accnts == null)) {
				z_ariba_bapi_po_change.DELPO_ACCNTS.items = new ArrayList<ZXTCPODELACCNT>();
				z_ariba_bapi_po_change.DELPO_ACCNTS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) delpo_accnts, ZXTCPODELACCNT.class);
			}
		
		Map<String, Object> delpo_items = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("DELPO_ITEMS");
			Application.muis_debug("delpo_items", delpo_items);
			if(!(delpo_items == null)) {
				z_ariba_bapi_po_change.DELPO_ITEMS.items = new ArrayList<ZXTCPODELITEMS>();
				z_ariba_bapi_po_change.DELPO_ITEMS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) delpo_items, ZXTCPODELITEMS.class);
			}
		
		Map<String, Object> po_accounts = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_ACCOUNTS");
			Application.muis_debug("po_accounts", po_accounts);
			if(!(po_accounts == null)) {
				Application.muis_debug("Feeding z_ariba_bapi_po_change.PO_ACCOUNTS.items from getItemsAsArrayList()", po_accounts);
				z_ariba_bapi_po_change.PO_ACCOUNTS.items = new ArrayList<ZXTCPOACCNT>();
				z_ariba_bapi_po_change.PO_ACCOUNTS.items.addAll(Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_accounts, ZXTCPOACCNT.class));
				Application.muis_debug("z_ariba_bapi_po_change.PO_ACCOUNTS.items.size()", z_ariba_bapi_po_change.PO_ACCOUNTS.items.size());
			}
		
		Map<String, Object> po_cond = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_COND");
			Application.muis_debug("po_cond", po_cond);
			if(!(po_cond == null)) {
				z_ariba_bapi_po_change.PO_COND.items = new ArrayList<ZXTPOCOND>();
				z_ariba_bapi_po_change.PO_COND.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_cond, ZXTPOCOND.class);
			}
		
		Map<String, Object> po_items = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_ITEMS");
			Application.muis_debug("po_items", po_items);
			if(!(po_items == null)) {
				z_ariba_bapi_po_change.PO_ITEMS.items = new ArrayList<ZXTCPOITEMS>();
				z_ariba_bapi_po_change.PO_ITEMS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_items, ZXTCPOITEMS.class);
			}
		
		Map<String, Object> po_text = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_TEXT");
			Application.muis_debug("po_text", po_text);
			if(!(po_text == null)) {
				z_ariba_bapi_po_change.PO_TEXT.items = new ArrayList<ZARSTRING>();
				z_ariba_bapi_po_change.PO_TEXT.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_text, ZARSTRING.class);
			}
		
		Map<String, Object> pur_order_delivery = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PUR_ORDER_DELIVERY");
			Application.muis_debug("pur_order_delivery", pur_order_delivery);
			if(!(pur_order_delivery == null)) {
				z_ariba_bapi_po_change.PUR_ORDER_DELIVERY.items = new ArrayList<ZXTPODELIV>();
				z_ariba_bapi_po_change.PUR_ORDER_DELIVERY.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) pur_order_delivery, ZXTPODELIV.class);
			}
		
		Map<String, Object> pur_order_details = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PUR_ORDER_DETAILS");
			Application.muis_debug("pur_order_details", pur_order_details);
			if(!(pur_order_details == null)) {
				z_ariba_bapi_po_change.PUR_ORDER_DETAILS.items = new ArrayList<ZXTPODET>();
				z_ariba_bapi_po_change.PUR_ORDER_DETAILS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) pur_order_details, ZXTPODET.class);
			}
		
		Map<String, Object> error_msg_table = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("ERROR_MSG_TABLE");
			Application.muis_debug("error_msg_table", error_msg_table);
			if(!(error_msg_table == null)) {
				z_ariba_bapi_po_change.ERROR_MSG_TABLE.items = new ArrayList<ERROR_MSG_TABLE_item>();
				z_ariba_bapi_po_change.ERROR_MSG_TABLE.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) error_msg_table, ERROR_MSG_TABLE_item.class);
			}

		return z_ariba_bapi_po_change;
	}

    public static void execute_SapFunc_Z_ARIBA_BAPI_PO_CHANGE(final Exchange exchange) throws IllegalArgumentException, IllegalAccessException
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_BAPI_PO_CHANGE() : " + body);

		Z_ARIBA_BAPI_PO_CHANGE z_ariba_bapi_po_change = create_Z_ARIBA_BAPI_PO_CHANGE_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_bapi_po_change = \n" + z_ariba_bapi_po_change);
		Application.dumpObject(z_ariba_bapi_po_change.PO_ACCOUNTS.items.get(0));

        try
        {
				Application.muis_debug("MUIS : Reposiroty name dest.getRepository().getName() ", Application.dest.getRepository().getName());

				String sapFunctionStr = "Z_ARIBA_BAPI_PO_CHANGE"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				Application.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (Application.currentSapFunction==null) throw new RuntimeException(Application.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(Application.currentSapFunction);
				
				// SAP Scalar fields
				Application.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_bapi_po_change.PARTITION);
				Application.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_bapi_po_change.VARIANT);

				// SAP Structures :
				//Application.currentSapFunction.getImportParameterList().setValue("PO_HEADER", z_ariba_bapi_po_change.PO_HEADER);
				Application.feed_SAP_Structure("PO_HEADER", z_ariba_bapi_po_change.PO_HEADER, PO_HEADER.class);
				
				// SAP Tables :
				Application.feed_SAP_Table("DELPO_ACCNTS", z_ariba_bapi_po_change.DELPO_ACCNTS.items, ZXTCPODELACCNT.class);
				Application.feed_SAP_Table("DELPO_ITEMS", z_ariba_bapi_po_change.DELPO_ITEMS.items, ZXTCPODELITEMS.class);
				Application.feed_SAP_Table("ERROR_MSG_TABLE", z_ariba_bapi_po_change.ERROR_MSG_TABLE.items, ERROR_MSG_TABLE_item.class);
				Application.feed_SAP_Table("PO_ACCOUNTS", z_ariba_bapi_po_change.PO_ACCOUNTS.items, ZXTCPOACCNT.class);
				Application.feed_SAP_Table("PO_COND", z_ariba_bapi_po_change.PO_COND.items, ZXTPOCOND.class);
				Application.feed_SAP_Table("PO_ITEMS", z_ariba_bapi_po_change.PO_ITEMS.items, ZXTCPOITEMS.class);
				Application.feed_SAP_Table("PO_TEXT", z_ariba_bapi_po_change.PO_TEXT.items, ZARSTRING.class);
				Application.feed_SAP_Table("PUR_ORDER_DELIVERY", z_ariba_bapi_po_change.PUR_ORDER_DELIVERY.items, ZXTPODELIV.class);
				Application.feed_SAP_Table("PUR_ORDER_DETAILS", z_ariba_bapi_po_change.PUR_ORDER_DETAILS.items, ZXTPODET.class);
				
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

	public static void read_SapFunc_Z_ARIBA_BAPI_PO_CHANGE_Response(Exchange exchange) {

		String sapFunctionStr = Application.currentSapFunction.getName();
		Application.muis_debug("read_SapFunc_Z_ARIBA_BAPI_PO_CHANGE_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		// Let's build our soap response step by step -Each time seeking some values from the SAP response values/tables/..etc :
		String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
		newBody += "<Z_ARIBA_BAPI_PO_CHANGEResponse xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_BAPI_PO_CHANGE:response\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><Z_ARIBA_BAPI_PO_CHANGE.Response>";
		
		String xml_ERPORDERID = "<ERPORDERID>"+ Application.currentSapFunction.getExportParameterList().getString("ERPORDERID") + "</ERPORDERID>";
		String xml_E_PARTITION = "<E_PARTITION>"+ Application.currentSapFunction.getExportParameterList().getString("E_PARTITION") + "</E_PARTITION>";
		String xml_E_VARIANT = "<E_VARIANT>"+ Application.currentSapFunction.getExportParameterList().getString("E_VARIANT") + "</E_VARIANT>";
		String xml_RETURNMSG = "<RETURNMSG>"+ Application.currentSapFunction.getExportParameterList().getString("RETURNMSG") + "</RETURNMSG>";
		newBody +=  xml_ERPORDERID + xml_E_PARTITION + xml_E_VARIANT + xml_RETURNMSG; // Scalar values

		JCoTable sapTbl;
		Map<String, String> sapTables = Map.of("ZXTCPODELACCNT","DELPO_ACCNTS", "ZXTCPODELITEMS", "DELPO_ITEMS", "ZXTPOERR", "ERROR_MSG_TABLE", "ZXTCPOACCNT", "PO_ACCOUNTS", "ZXTPOCOND", "PO_COND", "ZXTCPOITEMS", "PO_ITEMS", "ZARSTRING", "PO_TEXT", "ZXTPODELIV", "PUR_ORDER_DELIVERY", "ZXTPODET", "PUR_ORDER_DETAILS");
		for (Map.Entry<String, String> entry : sapTables.entrySet()) {
			String tblCode = entry.getKey();
			String tblName = entry.getValue();
			sapTbl = Application.currentSapFunction.getTableParameterList().getTable(tblCode);
			String xml_TblOut_Str = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll(tblCode, tblName) : "<"+tblName+"/>";
			newBody +=  xml_TblOut_Str; // Tables
		}
		
		newBody += "</Z_ARIBA_BAPI_PO_CHANGE.Response></Z_ARIBA_BAPI_PO_CHANGEResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
				
		
		
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_Z_ARIBA_BAPI_PO_CHANGE_Response() to : " + newBody);
	}

}
