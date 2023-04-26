 curl --location --request GET 'http://10.100.3.137:8088/' \
--header 'Content-Type: application/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header>
        <ns1:ibsinfo xmlns:ns1="urn:schemas-iwaysoftware-com:iwse">
            <ns1:service>InvoiceImport_V1</ns1:service>
            <ns1:method>Z_ARIBA_GR_PUSH</ns1:method>
            <ns1:license>test</ns1:license>
            <ns1:Username>ARIBA_CPIC</ns1:Username>
            <ns1:Password>ENCR(312531493234280318631613211321732473227321431973252)</ns1:Password>
        </ns1:ibsinfo>
    </soapenv:Header>
    <soap:Body xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<ns1:Z_ARIBA_GR_PUSH xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_PUSH">[[
  <ns1:Z_ARIBA_GR_PUSH>
    <ns1:GR_HEADER>
      <ns1:BLDAT>2023/04/14</ns1:BLDAT>
      <ns1:BUDAT>2023/04/14</ns1:BUDAT>
      <ns1:LFSNR>1</ns1:LFSNR>
      <ns1:BWARTWE>101</ns1:BWARTWE>
      <ns1:BKTXT>1005035490</ns1:BKTXT>
      <ns1:EBELN>1005035490</ns1:EBELN>
      <ns1:ARIBA_GRNO>AR-RC206269</ns1:ARIBA_GRNO>
    </ns1:GR_HEADER>
    <ns1:PARTITION>par1iam</ns1:PARTITION>
    <ns1:VARIANT>var1iam</ns1:VARIANT>
    <ns1:GR_ITEMS>
      <ns1:item>
        <ns1:ARIBA_ITNO>1</ns1:ARIBA_ITNO>
        <ns1:ERFMG>10.00000</ns1:ERFMG>
        <ns1:ERFME>L</ns1:ERFME>
        <ns1:ELIKZ/>
        <ns1:EBELN>1005035490</ns1:EBELN>
        <ns1:EBELP>00001</ns1:EBELP>
        <ns1:ARIBA_GRNO>AR-RC206269</ns1:ARIBA_GRNO>
        <ns1:MBLNR/>
        <ns1:SGTXT>0</ns1:SGTXT>
      </ns1:item>
    </ns1:GR_ITEMS>
  </ns1:Z_ARIBA_GR_PUSH>
</ns1:Z_ARIBA_GR_PUSH>
    </soap:Body>
</soapenv:Envelope>'
