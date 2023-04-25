for Flux in AccCategoryFieldStatusComboImport AccountCategoryImport AccountCategoryLanguageImport AssetImport AssetIncImport CompanyCodeImport CostCenterImport CostCenterLanguageImport CurrencyConversionRateImport GeneralLedgerImport GeneralLedgerLanguageImport InternalOrderImport MaterialAccountingImport	 MaterialAltUoMImport		 MaterialControllerImport	 MaterialCostImport			 MaterialGeneralImport		 MaterialPlaceImport			 MaterialPurchasingImport MaterialTextImport			 MinorityVendorImport PartitionedCommodityCodeImport PartitionedCommodityCodeLanguageImport PlantImport PlantPurchaseOrgComboImport PurchaseGroupImport PurchaseOrgImport SupplierImport SupplierIncImport TaxCodeImport TaxCodeLanguageImport WarehouseImport WBSElementImport
do

echo -e "\n\n---------------------------------------------------------------------"
echo $Flux
echo

export filename=`printf '%s\n' "${Flux//Import/}"`
curl -k --location 'https://masterdataimport-request-v1-3scale-rec-apicast-staging.apps.okd.iamdg.net.ma:443' \
--header 'Content-Type: text/xml' \
--header "SOAPAction: ${Flux}_V1.${Flux}Request@test@@" \
--header 'Authorization: Basic aWFtdXNlcjppYW11c2VyJDE5' \
--data "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">
    <soap:Body>
        <WebServiceEventLauncherRequest variant=\"var1iam\" partition=\"par1iam\" xmlns=\"urn:Ariba:Buyer:vsap\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">
            <WebServiceEventInfo_WebServiceEventInfo_Item>
                <item>
                    <Password>ENCR(312531493234280318631613211321732473227321431973252)</Password>
                    <NbDaysAssetInc>0</NbDaysAssetInc>
                    <NbDaysVendorInc>0</NbDaysVendorInc>
                    <Variant>VAR1IAM</Variant>
                    <Encoding>UTF-8</Encoding>
                    <Flux>${Flux}</Flux>
                    <Partition>PAR1IAM</Partition>
                    <Login>ARIBA_CPIC</Login>
                    <FileName1>/home/osbsap/output/${Flux}/${filename}.csv</FileName1>
                </item>
            </WebServiceEventInfo_WebServiceEventInfo_Item>
        </WebServiceEventLauncherRequest>
    </soap:Body>
</soap:Envelope>"

done > call.log
