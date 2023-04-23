package ma.munisys;

// PurchaseOrderChangeExport_V1

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

    public String toString() {
        // You may print the Z_ARIBA_BAPI_PO_CHANGE Java object back as a JSON format, to inspect it :
		try { return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this); }
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

	class ERROR_MSG_TABLE { 
        public ArrayList<ERROR_MSG_TABLE_item> items;
    }

	class ERROR_MSG_TABLE_item {
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
		String EBELN;
        String ERPORDERID;
        String VERSION;
        String LIFNR;
        String ORDERTYPE;
        String EKGRP;
        String AEDAT;
        String EKORG;
        String UNSEZ;
        String WAERS;
        String CHGSTATE;
        String PMNTTRMS;
	}
	
	class DELPO_ACCNTS { ArrayList<ZXTCPODELACCNT> items;}
	class ZXTCPODELACCNT {
		String EBELP;
		String SERIAL_NO;
	}

	class DELPO_ITEMS { ArrayList<ZXTCPODELITEMS> items; }
	class ZXTCPODELITEMS {
		String EBELP;
	}

	class PO_ACCOUNTS { ArrayList<ZXTCPOACCNT> items;}
	class ZXTCPOACCNT {
		String EBELP;
		String SERIAL_NO;
		String MKNTM;
		String SAKTO;
		String KOSTL;
		String AUFNR;
		String ANLN1;
		String ANLN2;
		String PS_PSP_PNR;
		String MKNTMLIMIT;
		String CHGSTATE;
	}

	class PO_COND { ArrayList<ZXTPOCOND> items; }
	class ZXTPOCOND {
		String KSCHL;
        String KBETR;
        String KONWA;
	}

	class PO_ITEMS { ArrayList<ZXTCPOITEMS> items;}
	class ZXTCPOITEMS {
		String EBELP;
        String TXZ01;
        String MATKL;
        String KNTTP;
        String WERKS;
        String NETPR;
        String PEINH;
        String MENGE;
        String MEINS;
        String EEIND;
        String EMATN;
        String SAKTO;
        String KOSTL;
        String AUFNR;
        String PS_PSP_PNR;
        String ANLN1;
        String ANLN2;
        String MWSKZ;
        String EPSTP;
        String SUMLIMIT;
        String COMMITMENT;
        String REQ_ID;
        String ITEMONREQ;
        String VRTKZ;
        String TWRKZ;
        String UNTTO;
        String UEBTO;
        String CHGSTATE;
        String LGORT;
	}

	class PO_TEXT { ArrayList<ZARSTRING> items;}
	class ZARSTRING {
		String EBELP;
        String TDOBJECT;
        String TDID;
        String STRINGNUM;
        String STRING;
	}

	class PUR_ORDER_DELIVERY { ArrayList<ZXTPODELIV> items;}
	class ZXTPODELIV {
		String EBELN;
		String EBELP;
		String EINDT;
	}

	class PUR_ORDER_DETAILS { ArrayList<ZXTPODET> items;}
	class ZXTPODET {
		String EBELN;
		String EBELP;
		String AEDAT;
		String MENGE;
		String MEINS;
		String NETPR;
		String REQ_ID;
		String ITEMONREQ;
	}
    
    // The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object as defined in the Z_ARIBA_GR_TRANSFER public class (Designed to mimic the http soap xml received)
	// The resulting instance of the Z_ARIBA_BAPI_PO_CHANGE will be then handed over to the SAP function for processing
	public static Z_ARIBA_BAPI_PO_CHANGE create_Z_ARIBA_BAPI_PO_CHANGE_ObjectFromXML(String httpBody) {
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
			Application.muis_debug("Z_ARIBA_BAPI_PO_CHANGEL2", Z_ARIBA_BAPI_PO_CHANGEE2);
			z_ariba_bapi_po_change.PARTITION =  !(Z_ARIBA_BAPI_PO_CHANGEE2.get("PARTITION") instanceof String) ? "" : (String) Z_ARIBA_BAPI_PO_CHANGEE2.get("PARTITION");
			z_ariba_bapi_po_change.VARIANT = !(Z_ARIBA_BAPI_PO_CHANGEE2.get("VARIANT") instanceof String) ? "" : (String) Z_ARIBA_BAPI_PO_CHANGEE2.get("VARIANT");
		
		Map<String, Object> poheader = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_HEADER");
			Application.muis_debug("poheader", poheader);
			z_ariba_bapi_po_change.PO_HEADER = z_ariba_bapi_po_change.new PO_HEADER();
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
				z_ariba_bapi_po_change.DELPO_ACCNTS.items = new ArrayList<ZXTCPODELACCNT>();
				z_ariba_bapi_po_change.DELPO_ACCNTS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) delpo_accnts, ZXTCPODELACCNT.class);
			
			Map<String, Object> delpo_items = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("DELPO_ITEMS");
				Application.muis_debug("delpo_items", delpo_items);
				z_ariba_bapi_po_change.DELPO_ITEMS.items = new ArrayList<ZXTCPODELITEMS>();
				z_ariba_bapi_po_change.DELPO_ITEMS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) delpo_items, ZXTCPODELITEMS.class);
			
			Map<String, Object> po_accounts = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_ACCOUNTS");
				Application.muis_debug("po_accounts", po_accounts);
				z_ariba_bapi_po_change.PO_ACCOUNTS.items = new ArrayList<ZXTCPOACCNT>();
				z_ariba_bapi_po_change.PO_ACCOUNTS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_accounts, ZXTCPOACCNT.class);
			
			Map<String, Object> po_cond = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_COND");
				Application.muis_debug("po_cond", po_cond);
				z_ariba_bapi_po_change.PO_COND.items = new ArrayList<ZXTPOCOND>();
				z_ariba_bapi_po_change.PO_COND.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_cond, ZXTPOCOND.class);
			
			Map<String, Object> po_items = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_ITEMS");
				Application.muis_debug("po_items", po_items);
				z_ariba_bapi_po_change.PO_ITEMS.items = new ArrayList<ZXTCPOITEMS>();
				z_ariba_bapi_po_change.PO_ITEMS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_items, ZXTCPOITEMS.class);
			
			Map<String, Object> po_text = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PO_TEXT");
				Application.muis_debug("po_text", po_text);
				z_ariba_bapi_po_change.PO_TEXT.items = new ArrayList<ZARSTRING>();
				z_ariba_bapi_po_change.PO_TEXT.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) po_text, ZARSTRING.class);
			
			Map<String, Object> pur_order_delivery = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PUR_ORDER_DELIVERY");
				Application.muis_debug("pur_order_delivery", pur_order_delivery);
				z_ariba_bapi_po_change.PUR_ORDER_DELIVERY.items = new ArrayList<ZXTPODELIV>();
				z_ariba_bapi_po_change.PUR_ORDER_DELIVERY.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) pur_order_delivery, ZXTPODELIV.class);
			
			Map<String, Object> pur_order_details = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("PUR_ORDER_DETAILS");
				Application.muis_debug("pur_order_details", pur_order_details);
				z_ariba_bapi_po_change.PUR_ORDER_DETAILS.items = new ArrayList<ZXTPODET>();
				z_ariba_bapi_po_change.PUR_ORDER_DETAILS.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) pur_order_details, ZXTPODET.class);
			
			Map<String, Object> error_msg_table = (Map<String, Object>) Z_ARIBA_BAPI_PO_CHANGEE2.get("ERROR_MSG_TABLE");
				Application.muis_debug("error_msg_table", error_msg_table);
				z_ariba_bapi_po_change.ERROR_MSG_TABLE.items = new ArrayList<ERROR_MSG_TABLE_item>();
				z_ariba_bapi_po_change.ERROR_MSG_TABLE.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) error_msg_table, ERROR_MSG_TABLE_item.class);
			

			ERROR_MSG_TABLE err = (ERROR_MSG_TABLE) Z_ARIBA_BAPI_PO_CHANGEE2.get("ERROR_MSG_TABLE");
			Application.muis_debug("ERROR_MSG_TABLE", err);

		return z_ariba_bapi_po_change;
	}

    public static void execute_SapFunc_Z_ARIBA_BAPI_PO_CHANGE(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_BAPI_PO_CHANGE() : " + body);

		Z_ARIBA_BAPI_PO_CHANGE z_ariba_bapi_po_change = create_Z_ARIBA_BAPI_PO_CHANGE_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_bapi_po_change = \n" + z_ariba_bapi_po_change);

        try
        {
				String repoName  = Application.dest.getRepository().getName();
				System.out.println("MUIS : Reposiroty name dest.getRepository().getName() =  " + repoName);
					
				String sapFunctionStr = "Z_ARIBA_BAPI_PO_CHANGE"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				Application.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (Application.currentSapFunction==null) throw new RuntimeException(Application.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(Application.currentSapFunction);
				
				Application.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_bapi_po_change.PARTITION);
				Application.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_bapi_po_change.VARIANT);
								
				JCoTable t_ZXTPOERR = Application.currentSapFunction.getTableParameterList().getTable("ZXTPOERR");
				
				for (ERROR_MSG_TABLE_item zItem : z_ariba_bapi_po_change.ERROR_MSG_TABLE.items) {
					t_ZXTPOERR.appendRow();
					JCoFieldIterator it = t_ZXTPOERR.getFieldIterator();
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
