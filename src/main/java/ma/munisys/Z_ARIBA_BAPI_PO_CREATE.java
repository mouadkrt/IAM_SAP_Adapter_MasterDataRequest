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

public class Z_ARIBA_BAPI_PO_CREATE {
	public String PARTITION;
	public String VARIANT;
	public String HEADER_ADD_DATA_RELEVANT;
	public String ITEM_ADD_DATA_RELEVANT;
	public String SKIP_ITEMS_WITH_ERROR;
	public PO_ADDRESS PO_ADDRESS;
	public PO_HEADER PO_HEADER;
	public PO_HEADER_ADD_DATA PO_HEADER_ADD_DATA;
	public ERROR_MSG_TABLE ERROR_MSG_TABLE;
	public PO_COND PO_COND;
	public PO_CONTRACT_LIMITS PO_CONTRACT_LIMITS;
	public PO_ITEMS PO_ITEMS;
	public PO_ITEM_ACCOUNT_ASSIGNMENT PO_ITEM_ACCOUNT_ASSIGNMENT;
	public PO_ITEM_ADD_DATA PO_ITEM_ADD_DATA;
	public PO_ITEM_SCHEDULES PO_ITEM_SCHEDULES;
	public PO_ITEM_TEXT PO_ITEM_TEXT;
	public PO_LIMITS PO_LIMITS;
	public PO_SERVICES PO_SERVICES;
	public PO_SERVICES_TEXT PO_SERVICES_TEXT;
	public PO_SRV_ACCASS_VALUES PO_SRV_ACCASS_VALUES;
	public PO_ZZIMMOS PO_ZZIMMOS;
	public PUR_ORDER_DELIVERY PUR_ORDER_DELIVERY;
	public PUR_ORDER_DETAILS PUR_ORDER_DETAILS;
	public RETURN RETURN;

	class PO_ADDRESS {
		public String ADDRNUMBER;
		public String ADDRHANDLE;
		public String NATION;
		public String DATE;
		public String DATE_FROM;
		public String DATE_TO;
		public String TITLE;
		public String NAME1;
		public String NAME2;
		public String NAME3;
		public String NAME4;
		public String NAME_TXT;
		public String NAME_CO;
		public String CITY1;
		public String CITY2;
		public String CITY_CODE;
		public String CITYP_CODE;
		public String CHCKSTATUS;
		public String POST_CODE1;
		public String POST_CODE2;
		public String POST_CODE3;
		public String PO_BOX;
		public String PO_BOX_NUM;
		public String PO_BOX_LOC;
		public String CITY_CODE2;
		public String PO_BOX_REG;
		public String PO_BOX_CTY;
		public String POSTALAREA;
		public String TRANSPZONE;
		public String STREET;
		public String STREETCODE;
		public String STREETABBR;
		public String HOUSE_NUM1;
		public String HOUSE_NUM2;
		public String HOUSE_NUM3;
		public String STR_SUPPL1;
		public String STR_SUPPL2;
		public String LOCATION;
		public String BUILDING;
		public String FLOOR;
		public String ROOMNUMBER;
		public String COUNTRY;
		public String LANGU;
		public String REGION;
		public String SORT1;
		public String SORT2;
		public String SORT_PHN;
		public String ADDRORIGIN;
		public String EXTENSION1;
		public String EXTENSION2;
		public String TIME_ZONE;
		public String TAXJURCODE;
		public String ADDRESS_ID;
		public String REMARK;
		public String DEFLT_COMM;
		public String TEL_NUMBER;
		public String TEL_EXTENS;
		public String FAX_NUMBER;
		public String FAX_EXTENS;
		public String BUILD_LONG;
	}

	class PO_HEADER {
		public String DOC_DATE;
		public String DOC_TYPE;
		public String DOC_CAT;
		public String CO_CODE;
		public String PURCH_ORG;
		public String PUR_GROUP;
		public String AGREEMENT;
		public String VENDOR;
		public String PO_NUMBER;
		public String SUPPL_PLNT;
		public String CREATED_BY;
		public String LANGU;
		public String LANGU_ISO;
		public String ARIBA_DOC_TYPE;
		public String ERPORDERID;
	}

	class PO_HEADER_ADD_DATA {
		public String PMNTTRMS;
		public String DSCNT1_TO;
		public String DSCNT2_TO;
		public String DSCNT3_TO;
		public String CASH_DISC1;
		public String CASH_DISC2;
		public String CREATED_BY;
		public String CURRENCY;
		public String EXCH_RATE;
		public String EX_RATE_FX;
		public String INCOTERMS1;
		public String INCOTERMS2;
		public String REF_1;
		public String SALES_PERS;
		public String TELEPHONE;
		public String TRNSP_MODE;
		public String CUSTOMS;
		public String EXCH_RATE_CM;
		public String VPER_START;
		public String VPER_END;
		public String OUR_REF;
	}

	class ERROR_MSG_TABLE {ArrayList<ERROR_MSG_TABLE_Item> items;}
	class ERROR_MSG_TABLE_Item {
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

	class PO_COND { ArrayList<PO_COND_Item> items;}
	class PO_COND_Item{
		public String KSCHL;
		public String KBETR;
		public String KONWA;
	}

	class PO_CONTRACT_LIMITS {ArrayList<PO_CONTRACT_LIMITS_Item> items;}
	class PO_CONTRACT_LIMITS_Item{
		public String PCKG_NO;
		public String LINE_NO;
		public String CON_NUMBER;
		public String CON_ITEM;
		public String LIMIT;
		public String NO_LIMIT;
		public String PRICE_CHG;
		public String SHORT_TEXT;
		public String DELETE_IND;
	}

	class PO_ITEMS  {ArrayList<PO_ITEMS_Item> items;}
	class PO_ITEMS_Item {
		public String PO_NUMBER;
		public String PO_ITEM;
		public String ADDRESS;
		public String MATERIAL;
		public String PUR_MAT;
		public String INFO_REC;
		public String ITEM_CAT;
		public String ACCTASSCAT;
		public String AGREEMENT;
		public String AGMT_ITEM;
		public String STORE_LOC;
		public String MAT_GRP;
		public String SHORT_TEXT;
		public String DISTRIB;
		public String PART_INV;
		public String KANBAN_IND;
		public String PLANT;
		public String ALLOC_TBL;
		public String AT_ITEM;
		public String UNIT;
		public String NET_PRICE;
		public String PRICE_UNIT;
		public String CONV_NUM1;
		public String CONV_DEN1;
		public String ORDERPR_UN;
		public String PCKG_NO;
		public String PROMOTION;
		public String ACKN_REQD;
		public String TRACKINGNO;
		public String PLAN_DEL;
		public String RET_ITEM;
		public String AT_RELEV;
		public String REQ_ID;
		public String ITEMONREQ;
		public String VEND_MAT;
		public String MANUF_PROF;
		public String MANU_MAT;
		public String MFR_NO;
		public String MFR_NO_EXT;
		public String PO_PRICE;
		public String SHIPPING;
		public String ITEM_CAT_EXT;
		public String PO_UNIT_ISO;
		public String ORDERPR_UN_ISO;
		public String PREQ_NAME;
		public String DISP_QUAN;
		public String QUAL_INSP;
		public String NO_MORE_GR;
		public String DELETE_IND;
		public String NO_ROUNDING;
		public String TAX_CODE;
	}

	class PO_ITEM_ACCOUNT_ASSIGNMENT  {ArrayList<PO_ITEM_ACCOUNT_ASSIGNMENT_Item> items;}
	class PO_ITEM_ACCOUNT_ASSIGNMENT_Item {
		public String PO_ITEM;
		public String SERIAL_NO;
		public String QUANTITY;
		public String DISTR_PERC;
		public String G_L_ACCT;
		public String BUS_AREA;
		public String COST_CTR;
		public String PROJ_EXT;
		public String SD_DOC;
		public String SDOC_ITEM;
		public String SCHED_LINE;
		public String ASSET_NO;
		public String SUB_NUMBER;
		public String ORDER_NO;
		public String GR_RCPT;
		public String UNLOAD_PT;
		public String CO_AREA;
		public String TO_COSTCTR;
		public String TO_ORDER;
		public String TO_PROJECT;
		public String COST_OBJ;
		public String PROF_SEGM;
		public String PROFIT_CTR;
		public String WBS_ELEM_E;
		public String NETWORK;
		public String ROUTING_NO;
		public String RL_EST_KEY;
		public String COUNTER;
		public String PART_ACCT;
		public String CMMT_ITEM;
		public String REC_IND;
		public String FUNDS_CTR;
		public String FUND;
		public String FUNC_AREA;
		public String REF_DATE;
		public String ACTIVITY;
		public String GRANT_NBR;
		public String CMMT_ITEM_LONG;
		public String FUNC_AREA_LONG;
	}
	
	class PO_ITEM_ADD_DATA  { ArrayList<PO_ITEM_ADD_DATA_Item> items;}
	class PO_ITEM_ADD_DATA_Item {
		public String INFO_UPD;
		public String REMINDER1;
		public String REMINDER2;
		public String REMINDER3;
		public String OVERDELTOL;
		public String UNLIMITED;
		public String UNDER_TOL;
		public String GR_IND;
		public String GR_NON_VAL;
		public String IR_IND;
		public String DEL_COMPL;
		public String FINAL_INV;
		public String BUS_TRANST;
		public String EXPIMPPROC;
		public String COMM_CODE;
		public String REG_ORIGIN;
		public String COUNT_ORIG;
		public String PO_ITEM;
	}
	
	class PO_ITEM_SCHEDULES  {ArrayList<PO_ITEM_SCHEDULES_Item> items;}
	class PO_ITEM_SCHEDULES_Item {
		public String PO_ITEM;
		public String SERIAL_NO;
		public String DEL_DATCAT;
		public String DELIV_DATE;
		public String DELIV_TIME;
		public String QUANTITY;
		public String PREQ_NO;
		public String PREQ_ITEM;
		public String CREATE_IND;
		public String QUOTA_NO;
		public String QUOTA_ITEM;
		public String BOMEXPL_NO;
		public String RESERV_NO;
		public String BATCH;
		public String VEND_BATCH;
		public String VERSION;
		public String DEL_DATCAT_EXT;
	}
	
	class PO_ITEM_TEXT  { ArrayList<PO_ITEM_TEXT_Item> items;}
	class PO_ITEM_TEXT_Item {
		public String PO_NUMBER;
		public String PO_ITEM;
		public String TEXT_ID;
		public String TEXT_FORM;
		public String TEXT_LINE;
	}
	
	class PO_LIMITS  {ArrayList<PO_LIMITS_Item> items;}
	class PO_LIMITS_Item {
		public String PCKG_NO;
		public String LIMIT;
		public String NO_LIMIT;
		public String EXP_VALUE;
		public String SSC_EXIST;
		public String CON_EXIST;
		public String TMP_EXIST;
		public String PRICE_CHG;
		public String FREE_LIMIT;
		public String NO_FRLIMIT;
		public String SERV_TYPE;
		public String EDITION;
		public String SSC_LIMIT;
		public String SSC_NOLIM;
		public String SSC_PRSCHG;
		public String SSC_PERC;
		public String TMP_NUMBER;
		public String TMP_LIMIT;
		public String TMP_NOLIM;
		public String TMP_PRSCHG;
		public String TMP_PERC;
		public String CONT_PERC;
	}
	
	class PO_SERVICES  {ArrayList<PO_SERVICES_Item> items;}
	class PO_SERVICES_Item {
		public String PCKG_NO;
		public String LINE_NO;
		public String EXT_LINE;
		public String OUTL_LEVEL;
		public String OUTL_NO;
		public String OUTL_IND;
		public String SUBPCKG_NO;
		public String SERVICE;
		public String SERV_TYPE;
		public String EDITION;
		public String SSC_ITEM;
		public String EXT_SERV;
		public String QUANTITY;
		public String BASE_UOM;
		public String UOM_ISO;
		public String OVF_TOL;
		public String OVF_UNLIM;
		public String PRICE_UNIT;
		public String GR_PRICE;
		public String FROM_LINE;
		public String TO_LINE;
		public String SHORT_TEXT;
		public String DISTRIB;
		public String PERS_NO;
		public String WAGETYPE;
		public String PLN_PCKG;
		public String PLN_LINE;
		public String CON_PCKG;
		public String CON_LINE;
		public String TMP_PCKG;
		public String TMP_LINE;
		public String SSC_LIM;
		public String LIMIT_LINE;
		public String TARGET_VAL;
		public String BASLINE_NO;
		public String BASIC_LINE;
		public String ALTERNAT;
		public String BIDDER;
		public String SUPP_LINE;
		public String OPEN_QTY;
		public String INFORM;
		public String BLANKET;
		public String EVENTUAL;
		public String TAX_CODE;
		public String TAXJURCODE;
		public String PRICE_CHG;
		public String MATL_GROUP;
		public String DATE;
		public String BEGINTIME;
		public String ENDTIME;
		public String EXTPERS_NO;
		public String FORMULA;
		public String FORM_VAL1;
		public String FORM_VAL2;
		public String FORM_VAL3;
		public String FORM_VAL4;
		public String FORM_VAL5;
		public String USERF1_NUM;
		public String USERF2_NUM;
		public String USERF1_TXT;
		public String USERF2_TXT;
		public String HI_LINE_NO;
		public String EXTREFKEY;
		public String DELETE_IND;
	}
	
	class PO_SERVICES_TEXT  {ArrayList<PO_SERVICES_TEXT_Item> items;}
	class PO_SERVICES_TEXT_Item {
		public String PCKG_NO;
		public String LINE_NO;
		public String TEXT_ID;
		public String FORMAT_COL;
		public String TEXT_LINE;
	}

	class PO_SRV_ACCASS_VALUES  {ArrayList<PO_SRV_ACCASS_VALUES_Item> items;}
	class PO_SRV_ACCASS_VALUES_Item {
		public String PCKG_NO;
		public String LINE_NO;
		public String SERNO_LINE;
		public String PERCENTAGE;
		public String SERIAL_NO;
		public String QUANTITY;
		public String NET_VALUE;
	}
	
	class PO_ZZIMMOS  {ArrayList<PO_ZZIMMOS_Item> items;}
	class PO_ZZIMMOS_Item {
		public String EBELP;
		public String UMSON;
		public String PRIXNUL;
		public String LGORT;
		public String ZZIMMOS;
	}
	
	class PUR_ORDER_DELIVERY  {ArrayList<PUR_ORDER_DELIVERY_Item> items;}
	class PUR_ORDER_DELIVERY_Item {
		public String EBELN;
		public String EBELP;
		public String EINDT;
	}
	
	class PUR_ORDER_DETAILS  {ArrayList<PUR_ORDER_DETAILS_Item> items;}
	class PUR_ORDER_DETAILS_Item {
		public String EBELN;
		public String EBELP;
		public String AEDAT;
		public String MENGE;
		public String MEINS;
		public String NETPR;
		public String REQ_ID;
		public String ITEMONREQ;
	}
	
	class RETURN  {ArrayList<RETURN_Item> items;}
	class RETURN_Item {
		public String TYPE;
		public String CODE;
		public String MESSAGE;
		public String LOG_NO;
		public String LOG_MSG_NO;
		public String MESSAGE_V1;
		public String MESSAGE_V2;
		public String MESSAGE_V3;
		public String MESSAGE_V4;
	}

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
		public String disposition;
		public String language;
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
