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
	<urn:Z_ARIBA_GR_QUALITY xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:urn="urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_QUALITY">
  <urn:Z_ARIBA_GR_QUALITY>
    <urn:PARTITION>par1iam</urn:PARTITION>
    <urn:STARTDATE/>
    <urn:VARIANT>var1iam</urn:VARIANT>
  </urn:Z_ARIBA_GR_QUALITY>
</urn:Z_ARIBA_GR_QUALITY>
    </soap:Body>
</soapenv:Envelope>'
