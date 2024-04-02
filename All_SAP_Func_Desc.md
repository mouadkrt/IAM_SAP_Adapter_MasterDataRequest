- Muis : Registering SAP Destination Data Provider ...


- MUIS : SAP connection Info :
JCO_ASHOST=****
JCO_SYSNR=00
JCO_CLIENT=200
JCO_USER=WS_USER
JCO_PASSWD=********
JCO_LANG=fr

- MUIS : SAP PING OK 

####################### START describeAllAribaFunctions() ######################

********************************* Describing SAP function : ZARIBA_MATERIAL_ACC  *************************************************
SAP Function name = ZARIBA_MATERIAL_ACC
ZARIBA_MATERIAL_ACC as XML : <ZARIBA_MATERIAL_ACC><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_ACC_INFO></MATERIAL_ACC_INFO></TABLES></ZARIBA_MATERIAL_ACC>


- MUIS : ZARIBA_MATERIAL_ACC.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_ACC.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_ACC.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_ACC_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_ACC_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_ACC.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_ACC
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_ACC_INFO             ,ZXTMATACC                     ,h  ,u,0,0,48,82,0
Exceptions:


********************************* End of describing SAP function : ZARIBA_MATERIAL_ACC  ************


********************************* ZARIBA_PLANT  *************************************************
SAP Function name = ZARIBA_PLANT
ZARIBA_PLANT as XML : <ZARIBA_PLANT><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><SHIP_TO_INFO></SHIP_TO_INFO></TABLES></ZARIBA_PLANT>


- MUIS : ZARIBA_PLANT.getChangingParameterList() = 
null


- MUIS : ZARIBA_PLANT.getExportParameterList() = 
null


- MUIS : ZARIBA_PLANT.getTableParameterList() = 
|------------|
| PARAMETERS 'TABLES'
|------------|
|SHIP_TO_INFO|
|------------|
|            |
|------------|
|SHIP_TO_INFO|
|------------|



- MUIS : ZARIBA_PLANT.getFunctionTemplate() = 
Function: ZARIBA_PLANT
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
SHIP_TO_INFO                  ,ZXTPLANT                      ,h   ,u,0,0,149,298,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_PURCHASE_ORG  *************************************************
SAP Function name = ZARIBA_PURCHASE_ORG
ZARIBA_PURCHASE_ORG as XML : <ZARIBA_PURCHASE_ORG><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><PORG_INFO></PORG_INFO></TABLES></ZARIBA_PURCHASE_ORG>


- MUIS : ZARIBA_PURCHASE_ORG.getChangingParameterList() = 
null


- MUIS : ZARIBA_PURCHASE_ORG.getExportParameterList() = 
null


- MUIS : ZARIBA_PURCHASE_ORG.getTableParameterList() = 
|---------|
| PARAMETERS 'TABLES'
|---------|
|PORG_INFO|
|---------|
|         |
|---------|
|PORG_INFO|
|---------|



- MUIS : ZARIBA_PURCHASE_ORG.getFunctionTemplate() = 
Function: ZARIBA_PURCHASE_ORG
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
PORG_INFO                     ,ZXTPOORG                      ,h   ,u,0,0,28,56,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_PURCHASE_GROUP  *************************************************
SAP Function name = ZARIBA_PURCHASE_GROUP
ZARIBA_PURCHASE_GROUP as XML : <ZARIBA_PURCHASE_GROUP><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><PGROUP_INFO></PGROUP_INFO></TABLES></ZARIBA_PURCHASE_GROUP>


- MUIS : ZARIBA_PURCHASE_GROUP.getChangingParameterList() = 
null


- MUIS : ZARIBA_PURCHASE_GROUP.getExportParameterList() = 
null


- MUIS : ZARIBA_PURCHASE_GROUP.getTableParameterList() = 
|-----------|
| PARAMETERS 'TABLES'
|-----------|
|PGROUP_INFO|
|-----------|
|           |
|-----------|
|PGROUP_INFO|
|-----------|



- MUIS : ZARIBA_PURCHASE_GROUP.getFunctionTemplate() = 
Function: ZARIBA_PURCHASE_GROUP
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
PGROUP_INFO                   ,ZXTPGRP                       ,h    ,u,0,0,21,42,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_PLANT_PORG  *************************************************
SAP Function name = ZARIBA_PLANT_PORG
ZARIBA_PLANT_PORG as XML : <ZARIBA_PLANT_PORG><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><PLANT_PORG_INFO></PLANT_PORG_INFO></TABLES></ZARIBA_PLANT_PORG>


- MUIS : ZARIBA_PLANT_PORG.getChangingParameterList() = 
null


- MUIS : ZARIBA_PLANT_PORG.getExportParameterList() = 
null


- MUIS : ZARIBA_PLANT_PORG.getTableParameterList() = 
|---------------|
| PARAMETERS 'TABLES'
|---------------|
|PLANT_PORG_INFO|
|---------------|
|               |
|---------------|
|PLANT_PORG_INFO|
|---------------|



- MUIS : ZARIBA_PLANT_PORG.getFunctionTemplate() = 
Function: ZARIBA_PLANT_PORG
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
PLANT_PORG_INFO               ,ZXTPLPO                       ,h    ,u,0,0,8,16,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_ASSET  *************************************************
SAP Function name = ZARIBA_ASSET
ZARIBA_ASSET as XML : <ZARIBA_ASSET><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ASSET_INFO></ASSET_INFO></TABLES></ZARIBA_ASSET>


- MUIS : ZARIBA_ASSET.getChangingParameterList() = 
null


- MUIS : ZARIBA_ASSET.getExportParameterList() = 
null


- MUIS : ZARIBA_ASSET.getTableParameterList() = 
|----------|
| PARAMETERS 'TABLES'
|----------|
|ASSET_INFO|
|----------|
|          |
|----------|
|ASSET_INFO|
|----------|



- MUIS : ZARIBA_ASSET.getFunctionTemplate() = 
Function: ZARIBA_ASSET
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ASSET_INFO                    ,ZXTASSET                      ,h   ,u,0,0,128,256,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_GENERAL_LEDGER  *************************************************
SAP Function name = ZARIBA_GENERAL_LEDGER
ZARIBA_GENERAL_LEDGER as XML : <ZARIBA_GENERAL_LEDGER><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><GENERAL_LEDGER_INFO></GENERAL_LEDGER_INFO></TABLES></ZARIBA_GENERAL_LEDGER>


- MUIS : ZARIBA_GENERAL_LEDGER.getChangingParameterList() = 
null


- MUIS : ZARIBA_GENERAL_LEDGER.getExportParameterList() = 
null


- MUIS : ZARIBA_GENERAL_LEDGER.getTableParameterList() = 
|-------------------|
| PARAMETERS 'TABLES'
|-------------------|
|GENERAL_LEDGER_INFO|
|-------------------|
|                   |
|-------------------|
|GENERAL_LEDGER_INFO|
|-------------------|



- MUIS : ZARIBA_GENERAL_LEDGER.getFunctionTemplate() = 
Function: ZARIBA_GENERAL_LEDGER
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
GENERAL_LEDGER_INFO           ,ZXTGENLE                      ,h   ,u,0,0,101,202,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_INTERNAL_ORDER  *************************************************
SAP Function name = ZARIBA_INTERNAL_ORDER
ZARIBA_INTERNAL_ORDER as XML : <ZARIBA_INTERNAL_ORDER><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ORD_INFO></ORD_INFO></TABLES></ZARIBA_INTERNAL_ORDER>


- MUIS : ZARIBA_INTERNAL_ORDER.getChangingParameterList() = 
null


- MUIS : ZARIBA_INTERNAL_ORDER.getExportParameterList() = 
null


- MUIS : ZARIBA_INTERNAL_ORDER.getTableParameterList() = 
|--------|
| PARAMETERS 'TABLES'
|--------|
|ORD_INFO|
|--------|
|        |
|--------|
|ORD_INFO|
|--------|



- MUIS : ZARIBA_INTERNAL_ORDER.getFunctionTemplate() = 
Function: ZARIBA_INTERNAL_ORDER
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ORD_INFO                      ,ZXTORD                        ,h     ,u,0,0,64,128,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_WBS  *************************************************
SAP Function name = ZARIBA_WBS
ZARIBA_WBS as XML : <ZARIBA_WBS><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><WBS_INFO></WBS_INFO></TABLES></ZARIBA_WBS>


- MUIS : ZARIBA_WBS.getChangingParameterList() = 
null


- MUIS : ZARIBA_WBS.getExportParameterList() = 
null


- MUIS : ZARIBA_WBS.getTableParameterList() = 
|--------|
| PARAMETERS 'TABLES'
|--------|
|WBS_INFO|
|--------|
|        |
|--------|
|WBS_INFO|
|--------|



- MUIS : ZARIBA_WBS.getFunctionTemplate() = 
Function: ZARIBA_WBS
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
WBS_INFO                      ,ZXTWBS                        ,h     ,u,0,0,100,200,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_ACCOUNT_CATEGORY  *************************************************
SAP Function name = ZARIBA_ACCOUNT_CATEGORY
ZARIBA_ACCOUNT_CATEGORY as XML : <ZARIBA_ACCOUNT_CATEGORY><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ACCOUNT_ASSIGNMENT></ACCOUNT_ASSIGNMENT></TABLES></ZARIBA_ACCOUNT_CATEGORY>


- MUIS : ZARIBA_ACCOUNT_CATEGORY.getChangingParameterList() = 
null


- MUIS : ZARIBA_ACCOUNT_CATEGORY.getExportParameterList() = 
null


- MUIS : ZARIBA_ACCOUNT_CATEGORY.getTableParameterList() = 
|------------------|
| PARAMETERS 'TABLES'
|------------------|
|ACCOUNT_ASSIGNMENT|
|------------------|
|                  |
|------------------|
|ACCOUNT_ASSIGNMENT|
|------------------|



- MUIS : ZARIBA_ACCOUNT_CATEGORY.getFunctionTemplate() = 
Function: ZARIBA_ACCOUNT_CATEGORY
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ACCOUNT_ASSIGNMENT            ,ZXTIACCASS                    ,h ,u,0,0,91,182,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_ACC_FIELD_STATUS  *************************************************
SAP Function name = ZARIBA_ACC_FIELD_STATUS
ZARIBA_ACC_FIELD_STATUS as XML : <ZARIBA_ACC_FIELD_STATUS><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ACC_FS_INFO></ACC_FS_INFO></TABLES></ZARIBA_ACC_FIELD_STATUS>


- MUIS : ZARIBA_ACC_FIELD_STATUS.getChangingParameterList() = 
null


- MUIS : ZARIBA_ACC_FIELD_STATUS.getExportParameterList() = 
null


- MUIS : ZARIBA_ACC_FIELD_STATUS.getTableParameterList() = 
|-----------|
| PARAMETERS 'TABLES'
|-----------|
|ACC_FS_INFO|
|-----------|
|           |
|-----------|
|ACC_FS_INFO|
|-----------|



- MUIS : ZARIBA_ACC_FIELD_STATUS.getFunctionTemplate() = 
Function: ZARIBA_ACC_FIELD_STATUS
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ACC_FS_INFO                   ,ZXTACCST                      ,h   ,u,0,0,9,18,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_INTERNAL_ORDER  *************************************************
SAP Function name = ZARIBA_INTERNAL_ORDER
ZARIBA_INTERNAL_ORDER as XML : <ZARIBA_INTERNAL_ORDER><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ORD_INFO></ORD_INFO></TABLES></ZARIBA_INTERNAL_ORDER>


- MUIS : ZARIBA_INTERNAL_ORDER.getChangingParameterList() = 
null


- MUIS : ZARIBA_INTERNAL_ORDER.getExportParameterList() = 
null


- MUIS : ZARIBA_INTERNAL_ORDER.getTableParameterList() = 
|--------|
| PARAMETERS 'TABLES'
|--------|
|ORD_INFO|
|--------|
|        |
|--------|
|ORD_INFO|
|--------|



- MUIS : ZARIBA_INTERNAL_ORDER.getFunctionTemplate() = 
Function: ZARIBA_INTERNAL_ORDER
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ORD_INFO                      ,ZXTORD                        ,h     ,u,0,0,64,128,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_WBS  *************************************************
SAP Function name = ZARIBA_WBS
ZARIBA_WBS as XML : <ZARIBA_WBS><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><WBS_INFO></WBS_INFO></TABLES></ZARIBA_WBS>


- MUIS : ZARIBA_WBS.getChangingParameterList() = 
null


- MUIS : ZARIBA_WBS.getExportParameterList() = 
null


- MUIS : ZARIBA_WBS.getTableParameterList() = 
|--------|
| PARAMETERS 'TABLES'
|--------|
|WBS_INFO|
|--------|
|        |
|--------|
|WBS_INFO|
|--------|



- MUIS : ZARIBA_WBS.getFunctionTemplate() = 
Function: ZARIBA_WBS
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
WBS_INFO                      ,ZXTWBS                        ,h     ,u,0,0,100,200,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_GROUP  *************************************************
SAP Function name = ZARIBA_MATERIAL_GROUP
ZARIBA_MATERIAL_GROUP as XML : <ZARIBA_MATERIAL_GROUP><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_GROUP_INFO></MATERIAL_GROUP_INFO></TABLES></ZARIBA_MATERIAL_GROUP>


- MUIS : ZARIBA_MATERIAL_GROUP.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_GROUP.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_GROUP.getTableParameterList() = 
|-------------------|
| PARAMETERS 'TABLES'
|-------------------|
|MATERIAL_GROUP_INFO|
|-------------------|
|                   |
|-------------------|
|MATERIAL_GROUP_INFO|
|-------------------|



- MUIS : ZARIBA_MATERIAL_GROUP.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_GROUP
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_GROUP_INFO           ,ZXTMGRP                       ,h    ,u,0,0,29,58,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_CURRENCY_CONVERSION  *************************************************
SAP Function name = ZARIBA_CURRENCY_CONVERSION
ZARIBA_CURRENCY_CONVERSION as XML : <ZARIBA_CURRENCY_CONVERSION><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><CURRENCY_CONVERSION_INFO></CURRENCY_CONVERSION_INFO></TABLES></ZARIBA_CURRENCY_CONVERSION>


- MUIS : ZARIBA_CURRENCY_CONVERSION.getChangingParameterList() = 
null


- MUIS : ZARIBA_CURRENCY_CONVERSION.getExportParameterList() = 
null


- MUIS : ZARIBA_CURRENCY_CONVERSION.getTableParameterList() = 
|------------------------|
| PARAMETERS 'TABLES'
|------------------------|
|CURRENCY_CONVERSION_INFO|
|------------------------|
|                        |
|------------------------|
|CURRENCY_CONVERSION_INFO|
|------------------------|



- MUIS : ZARIBA_CURRENCY_CONVERSION.getFunctionTemplate() = 
Function: ZARIBA_CURRENCY_CONVERSION
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
CURRENCY_CONVERSION_INFO      ,ZXTCURCO                      ,h   ,u,0,0,72,144,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_VENDOR  *************************************************
SAP Function name = ZARIBA_VENDOR
ZARIBA_VENDOR as XML : <ZARIBA_VENDOR><INPUT><ENCODING></ENCODING><FILE_NAME_PORG_VEN></FILE_NAME_PORG_VEN><FILE_NAME_VENDOR></FILE_NAME_VENDOR><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><VENDOR_INFO></VENDOR_INFO><VENDOR_PORG_INFO></VENDOR_PORG_INFO></TABLES></ZARIBA_VENDOR>


- MUIS : ZARIBA_VENDOR.getChangingParameterList() = 
null


- MUIS : ZARIBA_VENDOR.getExportParameterList() = 
null


- MUIS : ZARIBA_VENDOR.getTableParameterList() = 
|-----------|----------------|
| PARAMETERS 'TABLES'
|-----------|----------------|
|VENDOR_INFO|VENDOR_PORG_INFO|
|-----------|----------------|
|           |                |
|-----------|----------------|
|VENDOR_INFO|VENDOR_PORG_INFO|
|-----------|----------------|



- MUIS : ZARIBA_VENDOR.getFunctionTemplate() = 
Function: ZARIBA_VENDOR
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME_PORG_VEN            ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
FILE_NAME_VENDOR              ,RLGRAP                        ,C     ,C,128,138,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,266,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,286,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
VENDOR_INFO                   ,ZXTVEND                       ,h    ,u,0,0,489,978,0
VENDOR_PORG_INFO              ,ZXTVENPO                      ,h   ,u,0,0,24,48,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MINORITY_VENDOR  *************************************************
SAP Function name = ZARIBA_MINORITY_VENDOR
ZARIBA_MINORITY_VENDOR as XML : <ZARIBA_MINORITY_VENDOR><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><MINORITY_VENDOR></MINORITY_VENDOR></TABLES></ZARIBA_MINORITY_VENDOR>


- MUIS : ZARIBA_MINORITY_VENDOR.getChangingParameterList() = 
null


- MUIS : ZARIBA_MINORITY_VENDOR.getExportParameterList() = 
null


- MUIS : ZARIBA_MINORITY_VENDOR.getTableParameterList() = 
|---------------|
| PARAMETERS 'TABLES'
|---------------|
|MINORITY_VENDOR|
|---------------|
|               |
|---------------|
|MINORITY_VENDOR|
|---------------|



- MUIS : ZARIBA_MINORITY_VENDOR.getFunctionTemplate() = 
Function: ZARIBA_MINORITY_VENDOR
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MINORITY_VENDOR               ,ZXTVENDMIN                    ,h ,u,0,0,1017,2034,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_TAX_CODE  *************************************************
SAP Function name = ZARIBA_TAX_CODE
ZARIBA_TAX_CODE as XML : <ZARIBA_TAX_CODE><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><TAX_CODE_INFO></TAX_CODE_INFO></TABLES></ZARIBA_TAX_CODE>


- MUIS : ZARIBA_TAX_CODE.getChangingParameterList() = 
null


- MUIS : ZARIBA_TAX_CODE.getExportParameterList() = 
null


- MUIS : ZARIBA_TAX_CODE.getTableParameterList() = 
|-------------|
| PARAMETERS 'TABLES'
|-------------|
|TAX_CODE_INFO|
|-------------|
|             |
|-------------|
|TAX_CODE_INFO|
|-------------|



- MUIS : ZARIBA_TAX_CODE.getFunctionTemplate() = 
Function: ZARIBA_TAX_CODE
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
TAX_CODE_INFO                 ,ZXTTAXCODE                    ,h ,u,0,0,55,110,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_COMPANY  *************************************************
SAP Function name = ZARIBA_COMPANY
ZARIBA_COMPANY as XML : <ZARIBA_COMPANY><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><COMPANY_INFO></COMPANY_INFO></TABLES></ZARIBA_COMPANY>


- MUIS : ZARIBA_COMPANY.getChangingParameterList() = 
null


- MUIS : ZARIBA_COMPANY.getExportParameterList() = 
null


- MUIS : ZARIBA_COMPANY.getTableParameterList() = 
|------------|
| PARAMETERS 'TABLES'
|------------|
|COMPANY_INFO|
|------------|
|            |
|------------|
|COMPANY_INFO|
|------------|



- MUIS : ZARIBA_COMPANY.getFunctionTemplate() = 
Function: ZARIBA_COMPANY
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
COMPANY_INFO                  ,ZXTCOMPANY                    ,h ,u,0,0,74,148,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_VENDOR  *************************************************
SAP Function name = ZARIBA_VENDOR
ZARIBA_VENDOR as XML : <ZARIBA_VENDOR><INPUT><ENCODING></ENCODING><FILE_NAME_PORG_VEN></FILE_NAME_PORG_VEN><FILE_NAME_VENDOR></FILE_NAME_VENDOR><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><VENDOR_INFO></VENDOR_INFO><VENDOR_PORG_INFO></VENDOR_PORG_INFO></TABLES></ZARIBA_VENDOR>


- MUIS : ZARIBA_VENDOR.getChangingParameterList() = 
null


- MUIS : ZARIBA_VENDOR.getExportParameterList() = 
null


- MUIS : ZARIBA_VENDOR.getTableParameterList() = 
|-----------|----------------|
| PARAMETERS 'TABLES'
|-----------|----------------|
|VENDOR_INFO|VENDOR_PORG_INFO|
|-----------|----------------|
|           |                |
|-----------|----------------|
|VENDOR_INFO|VENDOR_PORG_INFO|
|-----------|----------------|



- MUIS : ZARIBA_VENDOR.getFunctionTemplate() = 
Function: ZARIBA_VENDOR
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME_PORG_VEN            ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
FILE_NAME_VENDOR              ,RLGRAP                        ,C     ,C,128,138,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,266,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,286,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
VENDOR_INFO                   ,ZXTVEND                       ,h    ,u,0,0,489,978,0
VENDOR_PORG_INFO              ,ZXTVENPO                      ,h   ,u,0,0,24,48,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_COST_CENTER  *************************************************
SAP Function name = ZARIBA_COST_CENTER
ZARIBA_COST_CENTER as XML : <ZARIBA_COST_CENTER><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><COST_CENTER_INFO></COST_CENTER_INFO></TABLES></ZARIBA_COST_CENTER>


- MUIS : ZARIBA_COST_CENTER.getChangingParameterList() = 
null


- MUIS : ZARIBA_COST_CENTER.getExportParameterList() = 
null


- MUIS : ZARIBA_COST_CENTER.getTableParameterList() = 
|----------------|
| PARAMETERS 'TABLES'
|----------------|
|COST_CENTER_INFO|
|----------------|
|                |
|----------------|
|COST_CENTER_INFO|
|----------------|



- MUIS : ZARIBA_COST_CENTER.getFunctionTemplate() = 
Function: ZARIBA_COST_CENTER
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
COST_CENTER_INFO              ,ZXTCOSTC                      ,h   ,u,0,0,87,174,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_ACCOUNT_CAT_NAMES  *************************************************
SAP Function name = ZARIBA_ACCOUNT_CAT_NAMES
ZARIBA_ACCOUNT_CAT_NAMES as XML : <ZARIBA_ACCOUNT_CAT_NAMES><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ACCOUNT_ASS_LANG></ACCOUNT_ASS_LANG></TABLES></ZARIBA_ACCOUNT_CAT_NAMES>


- MUIS : ZARIBA_ACCOUNT_CAT_NAMES.getChangingParameterList() = 
null


- MUIS : ZARIBA_ACCOUNT_CAT_NAMES.getExportParameterList() = 
null


- MUIS : ZARIBA_ACCOUNT_CAT_NAMES.getTableParameterList() = 
|----------------|
| PARAMETERS 'TABLES'
|----------------|
|ACCOUNT_ASS_LANG|
|----------------|
|                |
|----------------|
|ACCOUNT_ASS_LANG|
|----------------|



- MUIS : ZARIBA_ACCOUNT_CAT_NAMES.getFunctionTemplate() = 
Function: ZARIBA_ACCOUNT_CAT_NAMES
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ACCOUNT_ASS_LANG              ,ZXTACCNAME                    ,h ,u,0,0,22,44,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_GROUP_NAMES  *************************************************
SAP Function name = ZARIBA_MATERIAL_GROUP_NAMES
ZARIBA_MATERIAL_GROUP_NAMES as XML : <ZARIBA_MATERIAL_GROUP_NAMES><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_GROUP_NAMES></MATERIAL_GROUP_NAMES></TABLES></ZARIBA_MATERIAL_GROUP_NAMES>


- MUIS : ZARIBA_MATERIAL_GROUP_NAMES.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_GROUP_NAMES.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_GROUP_NAMES.getTableParameterList() = 
|--------------------|
| PARAMETERS 'TABLES'
|--------------------|
|MATERIAL_GROUP_NAMES|
|--------------------|
|                    |
|--------------------|
|MATERIAL_GROUP_NAMES|
|--------------------|



- MUIS : ZARIBA_MATERIAL_GROUP_NAMES.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_GROUP_NAMES
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_GROUP_NAMES          ,ZXTMGRPNAM                    ,h ,u,0,0,30,60,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_COST_CENTER_NAMES  *************************************************
SAP Function name = ZARIBA_COST_CENTER_NAMES
ZARIBA_COST_CENTER_NAMES as XML : <ZARIBA_COST_CENTER_NAMES><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><COST_CENTER_NAMES></COST_CENTER_NAMES></TABLES></ZARIBA_COST_CENTER_NAMES>


- MUIS : ZARIBA_COST_CENTER_NAMES.getChangingParameterList() = 
null


- MUIS : ZARIBA_COST_CENTER_NAMES.getExportParameterList() = 
null


- MUIS : ZARIBA_COST_CENTER_NAMES.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|COST_CENTER_NAMES|
|-----------------|
|                 |
|-----------------|
|COST_CENTER_NAMES|
|-----------------|



- MUIS : ZARIBA_COST_CENTER_NAMES.getFunctionTemplate() = 
Function: ZARIBA_COST_CENTER_NAMES
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
COST_CENTER_NAMES             ,ZXTCOSTNAM                    ,h ,u,0,0,55,110,0
Exceptions:
BAD_CSKS_SELECT  (BAD_CSKS_SELECT)
*********************************************************************************************************


********************************* ZARIBA_GENERAL_LEDGER_NAMES  *************************************************
SAP Function name = ZARIBA_GENERAL_LEDGER_NAMES
ZARIBA_GENERAL_LEDGER_NAMES as XML : <ZARIBA_GENERAL_LEDGER_NAMES><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><GENERAL_LEDGER_NAMES></GENERAL_LEDGER_NAMES></TABLES></ZARIBA_GENERAL_LEDGER_NAMES>


- MUIS : ZARIBA_GENERAL_LEDGER_NAMES.getChangingParameterList() = 
null


- MUIS : ZARIBA_GENERAL_LEDGER_NAMES.getExportParameterList() = 
null


- MUIS : ZARIBA_GENERAL_LEDGER_NAMES.getTableParameterList() = 
|--------------------|
| PARAMETERS 'TABLES'
|--------------------|
|GENERAL_LEDGER_NAMES|
|--------------------|
|                    |
|--------------------|
|GENERAL_LEDGER_NAMES|
|--------------------|



- MUIS : ZARIBA_GENERAL_LEDGER_NAMES.getFunctionTemplate() = 
Function: ZARIBA_GENERAL_LEDGER_NAMES
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
GENERAL_LEDGER_NAMES          ,ZXTGLLANG                     ,h  ,u,0,0,85,170,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_TAX_CODE_NAMES  *************************************************
SAP Function name = ZARIBA_TAX_CODE_NAMES
ZARIBA_TAX_CODE_NAMES as XML : <ZARIBA_TAX_CODE_NAMES><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><TAX_CODE_NAMES></TAX_CODE_NAMES></TABLES></ZARIBA_TAX_CODE_NAMES>


- MUIS : ZARIBA_TAX_CODE_NAMES.getChangingParameterList() = 
null


- MUIS : ZARIBA_TAX_CODE_NAMES.getExportParameterList() = 
null


- MUIS : ZARIBA_TAX_CODE_NAMES.getTableParameterList() = 
|--------------|
| PARAMETERS 'TABLES'
|--------------|
|TAX_CODE_NAMES|
|--------------|
|              |
|--------------|
|TAX_CODE_NAMES|
|--------------|



- MUIS : ZARIBA_TAX_CODE_NAMES.getFunctionTemplate() = 
Function: ZARIBA_TAX_CODE_NAMES
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
TAX_CODE_NAMES                ,ZXTTAXNAME                    ,h ,u,0,0,56,112,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_VENDOR_INC  *************************************************
SAP Function name = ZARIBA_VENDOR_INC
ZARIBA_VENDOR_INC as XML : <ZARIBA_VENDOR_INC><INPUT><ENCODING></ENCODING><FILE_NAME_PORG_VEN></FILE_NAME_PORG_VEN><FILE_NAME_VENDOR></FILE_NAME_VENDOR><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><VENDOR_INFO></VENDOR_INFO><VENDOR_PORG_INFO></VENDOR_PORG_INFO></TABLES></ZARIBA_VENDOR_INC>


- MUIS : ZARIBA_VENDOR_INC.getChangingParameterList() = 
null


- MUIS : ZARIBA_VENDOR_INC.getExportParameterList() = 
null


- MUIS : ZARIBA_VENDOR_INC.getTableParameterList() = 
|-----------|----------------|
| PARAMETERS 'TABLES'
|-----------|----------------|
|VENDOR_INFO|VENDOR_PORG_INFO|
|-----------|----------------|
|           |                |
|-----------|----------------|
|VENDOR_INFO|VENDOR_PORG_INFO|
|-----------|----------------|



- MUIS : ZARIBA_VENDOR_INC.getFunctionTemplate() = 
Function: ZARIBA_VENDOR_INC
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME_PORG_VEN            ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
FILE_NAME_VENDOR              ,RLGRAP                        ,C     ,C,128,138,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,266,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,286,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
VENDOR_INFO                   ,ZXTVEND                       ,h    ,u,0,0,489,978,0
VENDOR_PORG_INFO              ,ZXTVENPO                      ,h   ,u,0,0,24,48,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_ASSET_INC  *************************************************
SAP Function name = ZARIBA_ASSET_INC
ZARIBA_ASSET_INC as XML : <ZARIBA_ASSET_INC><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><ASSET_INFO></ASSET_INFO></TABLES></ZARIBA_ASSET_INC>


- MUIS : ZARIBA_ASSET_INC.getChangingParameterList() = 
null


- MUIS : ZARIBA_ASSET_INC.getExportParameterList() = 
null


- MUIS : ZARIBA_ASSET_INC.getTableParameterList() = 
|----------|
| PARAMETERS 'TABLES'
|----------|
|ASSET_INFO|
|----------|
|          |
|----------|
|ASSET_INFO|
|----------|



- MUIS : ZARIBA_ASSET_INC.getFunctionTemplate() = 
Function: ZARIBA_ASSET_INC
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
ASSET_INFO                    ,ZXTASSET                      ,h   ,u,0,0,128,256,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_ALT  *************************************************
SAP Function name = ZARIBA_MATERIAL_ALT
ZARIBA_MATERIAL_ALT as XML : <ZARIBA_MATERIAL_ALT><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_ALT_INFO></MATERIAL_ALT_INFO></TABLES></ZARIBA_MATERIAL_ALT>


- MUIS : ZARIBA_MATERIAL_ALT.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_ALT.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_ALT.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_ALT_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_ALT_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_ALT.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_ALT
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_ALT_INFO             ,ZXTMATALT                     ,h  ,u,0,0,27,48,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_MRP  *************************************************
SAP Function name = ZARIBA_MATERIAL_MRP
ZARIBA_MATERIAL_MRP as XML : <ZARIBA_MATERIAL_MRP><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_MRP_INFO></MATERIAL_MRP_INFO></TABLES></ZARIBA_MATERIAL_MRP>


- MUIS : ZARIBA_MATERIAL_MRP.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_MRP.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_MRP.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_MRP_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_MRP_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_MRP.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_MRP
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_MRP_INFO             ,ZXTMATMRP                     ,h  ,u,0,0,25,50,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_CCR  *************************************************
SAP Function name = ZARIBA_MATERIAL_CCR
ZARIBA_MATERIAL_CCR as XML : <ZARIBA_MATERIAL_CCR><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_CCR_INFO></MATERIAL_CCR_INFO></TABLES></ZARIBA_MATERIAL_CCR>


- MUIS : ZARIBA_MATERIAL_CCR.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_CCR.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_CCR.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_CCR_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_CCR_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_CCR.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_CCR
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_CCR_INFO             ,ZXTMATCCR                     ,h  ,u,0,0,31,54,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_GEN  *************************************************
SAP Function name = ZARIBA_MATERIAL_GEN
ZARIBA_MATERIAL_GEN as XML : <ZARIBA_MATERIAL_GEN><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_GEN_INFO></MATERIAL_GEN_INFO></TABLES></ZARIBA_MATERIAL_GEN>


- MUIS : ZARIBA_MATERIAL_GEN.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_GEN.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_GEN.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_GEN_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_GEN_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_GEN.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_GEN
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_GEN_INFO             ,ZXTMATGEN                     ,h  ,u,0,0,156,312,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_STO  *************************************************
SAP Function name = ZARIBA_MATERIAL_STO
ZARIBA_MATERIAL_STO as XML : <ZARIBA_MATERIAL_STO><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_STO_INFO></MATERIAL_STO_INFO></TABLES></ZARIBA_MATERIAL_STO>


- MUIS : ZARIBA_MATERIAL_STO.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_STO.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_STO.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_STO_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_STO_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_STO.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_STO
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_STO_INFO             ,ZXTMATSTO                     ,h  ,u,0,0,26,52,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_PUR  *************************************************
SAP Function name = ZARIBA_MATERIAL_PUR
ZARIBA_MATERIAL_PUR as XML : <ZARIBA_MATERIAL_PUR><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_PUR_INFO></MATERIAL_PUR_INFO></TABLES></ZARIBA_MATERIAL_PUR>


- MUIS : ZARIBA_MATERIAL_PUR.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_PUR.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_PUR.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_PUR_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_PUR_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_PUR.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_PUR
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_PUR_INFO             ,ZXTMATPUR                     ,h  ,u,0,0,40,80,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_MATERIAL_DSU  *************************************************
SAP Function name = ZARIBA_MATERIAL_DSU
ZARIBA_MATERIAL_DSU as XML : <ZARIBA_MATERIAL_DSU><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><MATERIAL_DSU_INFO></MATERIAL_DSU_INFO></TABLES></ZARIBA_MATERIAL_DSU>


- MUIS : ZARIBA_MATERIAL_DSU.getChangingParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_DSU.getExportParameterList() = 
null


- MUIS : ZARIBA_MATERIAL_DSU.getTableParameterList() = 
|-----------------|
| PARAMETERS 'TABLES'
|-----------------|
|MATERIAL_DSU_INFO|
|-----------------|
|                 |
|-----------------|
|MATERIAL_DSU_INFO|
|-----------------|



- MUIS : ZARIBA_MATERIAL_DSU.getFunctionTemplate() = 
Function: ZARIBA_MATERIAL_DSU
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,158,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,OPTIONAL,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,166,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
MATERIAL_DSU_INFO             ,ZXTMATDSU                     ,h  ,u,0,0,153,306,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_WAREHOUSE  *************************************************
SAP Function name = ZARIBA_WAREHOUSE
ZARIBA_WAREHOUSE as XML : <ZARIBA_WAREHOUSE><INPUT><ENCODING></ENCODING><FILE_NAME></FILE_NAME><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><TABLES><WAREHOUSE_INFO></WAREHOUSE_INFO></TABLES></ZARIBA_WAREHOUSE>


- MUIS : ZARIBA_WAREHOUSE.getChangingParameterList() = 
null


- MUIS : ZARIBA_WAREHOUSE.getExportParameterList() = 
null


- MUIS : ZARIBA_WAREHOUSE.getTableParameterList() = 
|--------------|
| PARAMETERS 'TABLES'
|--------------|
|WAREHOUSE_INFO|
|--------------|
|              |
|--------------|
|WAREHOUSE_INFO|
|--------------|



- MUIS : ZARIBA_WAREHOUSE.getFunctionTemplate() = 
Function: ZARIBA_WAREHOUSE
Input:
ENCODING                      ,CHAR10                        ,C     ,C,10,0,10,20,0,Zone de 10 caractÃ¨res,IMPORT,OPTIONAL,CHAR10
FILE_NAME                     ,RLGRAP                        ,C     ,C,128,10,128,256,0,Fichier local pour tÃ©lÃ©chargement ou tÃ©lÃ©dÃ©chargement,IMPORT,OPTIONAL,RLGRAP,FILENAME
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,138,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,158,20,40,0,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
WAREHOUSE_INFO                ,ZXTLGORT                      ,h   ,u,0,0,240,480,0
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_GR_PUSH  *************************************************
SAP Function name = Z_ARIBA_GR_PUSH
Z_ARIBA_GR_PUSH as XML : <Z_ARIBA_GR_PUSH><INPUT><GR_HEADER><MBLNR></MBLNR><BLDAT>0000-00-00</BLDAT><BUDAT>0000-00-00</BUDAT><FRBNR></FRBNR><LFSNR></LFSNR><BWARTWE></BWARTWE><BKTXT></BKTXT><EBELN></EBELN><ARIBA_GRNO></ARIBA_GRNO></GR_HEADER><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><OUTPUT><E_PARTITION></E_PARTITION><E_VARIANT></E_VARIANT></OUTPUT><TABLES><ERROR_MSG_TABLE></ERROR_MSG_TABLE><GR_ITEMS></GR_ITEMS></TABLES></Z_ARIBA_GR_PUSH>


- MUIS : Z_ARIBA_GR_PUSH.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_GR_PUSH.getExportParameterList() = 
|--------------------|--------------------|
| PARAMETERS 'OUTPUT'
|--------------------|--------------------|
|E_PARTITION         |E_VARIANT           |
|--------------------|--------------------|
|01234567890123456789|01234567890123456789|
|--------------------|--------------------|
|                    |                    |
|--------------------|--------------------|



- MUIS : Z_ARIBA_GR_PUSH.getTableParameterList() = 
|---------------|--------|
| PARAMETERS 'TABLES'
|---------------|--------|
|ERROR_MSG_TABLE|GR_ITEMS|
|---------------|--------|
|               |        |
|---------------|--------|
|ERROR_MSG_TABLE|GR_ITEMS|
|---------------|--------|



- MUIS : Z_ARIBA_GR_PUSH.getFunctionTemplate() = 
Function: Z_ARIBA_GR_PUSH
Input:
    GR_HEADER                     ,ZXTGRHEADR                    ,u ,u,0,0,116,232,0,Goods Receipt header info,IMPORT
    PARTITION                     ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,Ariba partition,IMPORT,ZARIBTVARV,PARTIT
    VARIANT                       ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,Ariba variant,IMPORT,ZARIBTVARV,ZVARIANT
Changing:
    null
Output:
    E_PARTITION                   ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,PARTIT
    E_VARIANT                     ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Tables:
    ERROR_MSG_TABLE               ,ZXTGRERR                      ,h   ,u,0,0,355,710,0,Error messages
    GR_ITEMS                      ,ZXTGRITEMS                    ,h ,u,0,0,127,248,0,Goods Receipt line item info
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_BAPI_PO_CHANGE  *************************************************
SAP Function name = Z_ARIBA_BAPI_PO_CHANGE
Z_ARIBA_BAPI_PO_CHANGE as XML : <Z_ARIBA_BAPI_PO_CHANGE><INPUT><PARTITION></PARTITION><PO_HEADER><EBELN></EBELN><ERPORDERID></ERPORDERID><VERSION></VERSION><LIFNR></LIFNR><ORDERTYPE></ORDERTYPE><EKGRP></EKGRP><EKORG></EKORG><AEDAT>0000-00-00</AEDAT><UNSEZ></UNSEZ><WAERS></WAERS><CHGSTATE></CHGSTATE><PMNTTRMS></PMNTTRMS></PO_HEADER><VARIANT></VARIANT></INPUT><OUTPUT><ERPORDERID></ERPORDERID><E_PARTITION></E_PARTITION><E_VARIANT></E_VARIANT><RETURNMSG></RETURNMSG></OUTPUT><TABLES><DELPO_ACCNTS></DELPO_ACCNTS><DELPO_ITEMS></DELPO_ITEMS><ERROR_MSG_TABLE></ERROR_MSG_TABLE><PO_ACCOUNTS></PO_ACCOUNTS><PO_COND></PO_COND><PO_ITEMS></PO_ITEMS><PO_TEXT></PO_TEXT><PUR_ORDER_DELIVERY></PUR_ORDER_DELIVERY><PUR_ORDER_DETAILS></PUR_ORDER_DETAILS></TABLES></Z_ARIBA_BAPI_PO_CHANGE>


- MUIS : Z_ARIBA_BAPI_PO_CHANGE.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_BAPI_PO_CHANGE.getExportParameterList() = 
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
| PARAMETERS 'OUTPUT'
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
|ERPORDERID                                        |E_PARTITION         |E_VARIANT           |RETURNMSG                                         |
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
|01234567890123456789012345678901234567890123456789|01234567890123456789|01234567890123456789|01234567890123456789012345678901234567890123456789|
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
|                                                  |                    |                    |                                                  |
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|



- MUIS : Z_ARIBA_BAPI_PO_CHANGE.getTableParameterList() = 
|------------|-----------|---------------|-----------|-------|--------|-------|------------------|-----------------|
| PARAMETERS 'TABLES'
|------------|-----------|---------------|-----------|-------|--------|-------|------------------|-----------------|
|DELPO_ACCNTS|DELPO_ITEMS|ERROR_MSG_TABLE|PO_ACCOUNTS|PO_COND|PO_ITEMS|PO_TEXT|PUR_ORDER_DELIVERY|PUR_ORDER_DETAILS|
|------------|-----------|---------------|-----------|-------|--------|-------|------------------|-----------------|
|            |           |               |           |       |        |       |                  |                 |
|------------|-----------|---------------|-----------|-------|--------|-------|------------------|-----------------|
|DELPO_ACCNTS|DELPO_ITEMS|ERROR_MSG_TABLE|PO_ACCOUNTS|PO_COND|PO_ITEMS|PO_TEXT|PUR_ORDER_DELIVERY|PUR_ORDER_DETAILS|
|------------|-----------|---------------|-----------|-------|--------|-------|------------------|-----------------|



- MUIS : Z_ARIBA_BAPI_PO_CHANGE.getFunctionTemplate() = 
Function: Z_ARIBA_BAPI_PO_CHANGE
Input:
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,Ariba partition,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
PO_HEADER                     ,ZXTCPOHEADR                   ,u,u,0,20,127,254,0,Purchase Order header info,IMPORT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,Ariba variant,IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
ERPORDERID                    ,ZXTCPOHEADR                   ,C,C,50,0,50,100,0,EXPORT,OPTIONAL,ZXTCPOHEADR,ERPORDERID
E_PARTITION                   ,ZARIBTVARV                    ,C ,C,20,50,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,PARTIT
E_VARIANT                     ,ZARIBTVARV                    ,C ,C,20,70,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
RETURNMSG                     ,BAPIRET2                      ,C   ,C,50,90,50,100,0,Message text,EXPORT,OPTIONAL,BAPIRET2,MESSAGE_V1
Tables:
DELPO_ACCNTS                  ,ZXTCPODELACCNT                ,h,u,0,0,7,14,0,Ariba Extension for Deleted Accounts,OPTIONAL
DELPO_ITEMS                   ,ZXTCPODELITEMS                ,h,u,0,0,5,10,0,Ariba Extension for CPO Deleted Items,OPTIONAL
ERROR_MSG_TABLE               ,ZXTPOERR                      ,h   ,u,0,0,399,798,0,Error messages,OPTIONAL
PO_ACCOUNTS                   ,ZXTCPOACCNT                   ,h,u,0,0,106,212,0,Ariba Extension for Accounts -Change PO,OPTIONAL
PO_COND                       ,ZXTPOCOND                     ,h  ,u,0,0,15,24,0,OPTIONAL
PO_ITEMS                      ,ZXTCPOITEMS                   ,h,u,0,0,250,460,0,Purchase Order line item info
PO_TEXT                       ,ZARSTRING                     ,h  ,u,0,0,279,558,0,Purchase Order header and line item text,OPTIONAL
PUR_ORDER_DELIVERY            ,ZXTPODELIV                    ,h ,u,0,0,23,46,0,OPTIONAL
PUR_ORDER_DETAILS             ,ZXTPODET                      ,h   ,u,0,0,69,126,0,OPTIONAL
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_BAPI_PO_CANCEL  *************************************************
SAP Function name = Z_ARIBA_BAPI_PO_CANCEL
Z_ARIBA_BAPI_PO_CANCEL as XML : <Z_ARIBA_BAPI_PO_CANCEL><INPUT><PARTITION></PARTITION><PO_HEADER><EBELN></EBELN><ERPORDERID></ERPORDERID><VERSION></VERSION><LIFNR></LIFNR><ORDERTYPE></ORDERTYPE><EKGRP></EKGRP><EKORG></EKORG><AEDAT>0000-00-00</AEDAT><UNSEZ></UNSEZ><WAERS></WAERS><CHGSTATE></CHGSTATE><PMNTTRMS></PMNTTRMS></PO_HEADER><VARIANT></VARIANT></INPUT><OUTPUT><ERPORDERID></ERPORDERID><E_PARTITION></E_PARTITION><E_VARIANT></E_VARIANT><RETURNMSG></RETURNMSG></OUTPUT><TABLES><ERROR_MSG_TABLE></ERROR_MSG_TABLE></TABLES></Z_ARIBA_BAPI_PO_CANCEL>


- MUIS : Z_ARIBA_BAPI_PO_CANCEL.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_BAPI_PO_CANCEL.getExportParameterList() = 
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
| PARAMETERS 'OUTPUT'
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
|ERPORDERID                                        |E_PARTITION         |E_VARIANT           |RETURNMSG                                         |
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
|01234567890123456789012345678901234567890123456789|01234567890123456789|01234567890123456789|01234567890123456789012345678901234567890123456789|
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|
|                                                  |                    |                    |                                                  |
|--------------------------------------------------|--------------------|--------------------|--------------------------------------------------|



- MUIS : Z_ARIBA_BAPI_PO_CANCEL.getTableParameterList() = 
|---------------|
| PARAMETERS 'TABLES'
|---------------|
|ERROR_MSG_TABLE|
|---------------|
|               |
|---------------|
|ERROR_MSG_TABLE|
|---------------|



- MUIS : Z_ARIBA_BAPI_PO_CANCEL.getFunctionTemplate() = 
Function: Z_ARIBA_BAPI_PO_CANCEL
Input:
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,Ariba data partition,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
PO_HEADER                     ,ZXTCPOHEADR                   ,u,u,0,20,127,254,0,Ariba Extension for purchase order header,IMPORT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,Ariba Variant Name (do not confuse with an SAP Variant),IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
ERPORDERID                    ,ZARCPOHEADR                   ,C,C,50,0,50,100,0,EXPORT,OPTIONAL,ZARCPOHEADR,ERPORDERID
E_PARTITION                   ,ZARIBTVARV                    ,C ,C,20,50,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,PARTIT
E_VARIANT                     ,ZARIBTVARV                    ,C ,C,20,70,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
RETURNMSG                     ,BAPIRET2                      ,C   ,C,50,90,50,100,0,Messages, message variables,EXPORT,OPTIONAL,BAPIRET2,MESSAGE_V1
Tables:
ERROR_MSG_TABLE               ,ZXTPOERR                      ,h   ,u,0,0,399,798,0,Extension structure for ZARPOERR
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_PO_HEADER_STATUS  *************************************************
SAP Function name = Z_ARIBA_PO_HEADER_STATUS
Z_ARIBA_PO_HEADER_STATUS as XML : <Z_ARIBA_PO_HEADER_STATUS><INPUT><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><OUTPUT><E_PARTITION></E_PARTITION><E_VARIANT></E_VARIANT></OUTPUT><TABLES><HEADERSTATUSINFO></HEADERSTATUSINFO></TABLES></Z_ARIBA_PO_HEADER_STATUS>


- MUIS : Z_ARIBA_PO_HEADER_STATUS.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_PO_HEADER_STATUS.getExportParameterList() = 
|--------------------|--------------------|
| PARAMETERS 'OUTPUT'
|--------------------|--------------------|
|E_PARTITION         |E_VARIANT           |
|--------------------|--------------------|
|01234567890123456789|01234567890123456789|
|--------------------|--------------------|
|                    |                    |
|--------------------|--------------------|



- MUIS : Z_ARIBA_PO_HEADER_STATUS.getTableParameterList() = 
|----------------|
| PARAMETERS 'TABLES'
|----------------|
|HEADERSTATUSINFO|
|----------------|
|                |
|----------------|
|HEADERSTATUSINFO|
|----------------|



- MUIS : Z_ARIBA_PO_HEADER_STATUS.getFunctionTemplate() = 
Function: Z_ARIBA_PO_HEADER_STATUS
Input:
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,Ariba data partition,IMPORT,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,Ariba Variant Name (do not confuse with an SAP Variant),IMPORT,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
E_PARTITION                   ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,PARTIT
E_VARIANT                     ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Tables:
HEADERSTATUSINFO              ,ZXTCPOHEADERSTATUS            ,h,u,0,0,61,122,0,Header Status Structure
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_GR_TRANSFER  *************************************************
SAP Function name = Z_ARIBA_GR_TRANSFER
Z_ARIBA_GR_TRANSFER as XML : <Z_ARIBA_GR_TRANSFER><INPUT><PARTITION></PARTITION><VARIANT></VARIANT></INPUT><OUTPUT><STATUS></STATUS></OUTPUT><TABLES><ERROR_MSG_TABLE></ERROR_MSG_TABLE><GR_ITEM></GR_ITEM><GR_SERIAL></GR_SERIAL></TABLES></Z_ARIBA_GR_TRANSFER>


- MUIS : Z_ARIBA_GR_TRANSFER.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_GR_TRANSFER.getExportParameterList() = 
|-|
| PARAMETERS 'OUTPUT'
|-|
|S|
|-|
|0|
|-|
| |
|-|



- MUIS : Z_ARIBA_GR_TRANSFER.getTableParameterList() = 
|---------------|-------|---------|
| PARAMETERS 'TABLES'
|---------------|-------|---------|
|ERROR_MSG_TABLE|GR_ITEM|GR_SERIAL|
|---------------|-------|---------|
|               |       |         |
|---------------|-------|---------|
|ERROR_MSG_TABLE|GR_ITEM|GR_SERIAL|
|---------------|-------|---------|



- MUIS : Z_ARIBA_GR_TRANSFER.getFunctionTemplate() = 
Function: Z_ARIBA_GR_TRANSFER
Input:
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,IMPORT,ZARIBTVARV,PARTIT
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,IMPORT,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
STATUS                        ,ACTLV                         ,C      ,C,1,0,1,2,0,Statut traitement,EXPORT,OPTIONAL,ACTLV
Tables:
ERROR_MSG_TABLE               ,ZXTGRERR                      ,h   ,u,0,0,355,710,0,Extension structure for ZARGRERR
GR_ITEM                       ,ZXTEMTRANS                    ,h ,u,0,0,120,228,0,Ariba Extension for Good Receipt transfer quality
GR_SERIAL                     ,ZXTSERIAL                     ,h  ,u,0,0,36,72,0,Ariba Extension for Good Receipt transfer quality,OPTIONAL
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_GR_QUALITY  *************************************************
SAP Function name = Z_ARIBA_GR_QUALITY
Z_ARIBA_GR_QUALITY as XML : <Z_ARIBA_GR_QUALITY><INPUT><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><TABLES><GOOD_RECEIPT_PO></GOOD_RECEIPT_PO></TABLES></Z_ARIBA_GR_QUALITY>


- MUIS : Z_ARIBA_GR_QUALITY.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_GR_QUALITY.getExportParameterList() = 
null


- MUIS : Z_ARIBA_GR_QUALITY.getTableParameterList() = 
|---------------|
| PARAMETERS 'TABLES'
|---------------|
|GOOD_RECEIPT_PO|
|---------------|
|               |
|---------------|
|GOOD_RECEIPT_PO|
|---------------|



- MUIS : Z_ARIBA_GR_QUALITY.getFunctionTemplate() = 
Function: Z_ARIBA_GR_QUALITY
Input:
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,IMPORT,ZARIBTVARV,PARTIT
STARTDATE                     ,SYST                          ,D       ,D,8,20,8,16,0,Date et heure, date actuelle (serveur d'application),IMPORT,SYST,DATUM
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,28,20,40,0,IMPORT,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
null
Tables:
GOOD_RECEIPT_PO               ,ZXTEMMIGO                     ,h  ,u,0,0,290,568,0
Exceptions:
*********************************************************************************************************


********************************* ZARIBA_INVOICED_PO_ITEMS_SOAP  *************************************************
SAP Function name = ZARIBA_INVOICED_PO_ITEMS_SOAP
ZARIBA_INVOICED_PO_ITEMS_SOAP as XML : <ZARIBA_INVOICED_PO_ITEMS_SOAP><INPUT><ENDDATE>0000-00-00</ENDDATE><PARTITION></PARTITION><STARTDATE>0000-00-00</STARTDATE><VARIANT></VARIANT></INPUT><OUTPUT><SENDDATE>0000-00-00</SENDDATE></OUTPUT><TABLES><ZINVPOITEMS></ZINVPOITEMS></TABLES></ZARIBA_INVOICED_PO_ITEMS_SOAP>


- MUIS : ZARIBA_INVOICED_PO_ITEMS_SOAP.getChangingParameterList() = 
null


- MUIS : ZARIBA_INVOICED_PO_ITEMS_SOAP.getExportParameterList() = 
|--------|
| PARAMETERS 'OUTPUT'
|--------|
|SENDDATE|
|--------|
|01234567|
|--------|
|00000000|
|--------|



- MUIS : ZARIBA_INVOICED_PO_ITEMS_SOAP.getTableParameterList() = 
|-----------|
| PARAMETERS 'TABLES'
|-----------|
|ZINVPOITEMS|
|-----------|
|           |
|-----------|
|ZINVPOITEMS|
|-----------|



- MUIS : ZARIBA_INVOICED_PO_ITEMS_SOAP.getFunctionTemplate() = 
Function: ZARIBA_INVOICED_PO_ITEMS_SOAP
Input:
ENDDATE                       ,DATS                          ,D       ,D,8,0,8,16,0,Zone de type DATS,IMPORT,OPTIONAL,DATS
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,8,20,40,0,Ariba data partition,IMPORT,OPTIONAL,ZARIBTVARV,PARTIT
STARTDATE                     ,DATS                          ,D       ,D,8,28,8,16,0,Zone de type DATS,IMPORT,OPTIONAL,DATS
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,36,20,40,0,Ariba Variant Name (do not confuse with an SAP Variant),IMPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
SENDDATE                      ,DATS                          ,D       ,D,8,0,8,16,0,Zone de type DATS,EXPORT,OPTIONAL,DATS
Tables:
ZINVPOITEMS                   ,ZINVPOITEMS                   ,h,u,0,0,60,78,0,Postes Commandes FacturÃ©s (Interface SAP-ARIBA)
Exceptions:
*********************************************************************************************************


********************************* Z_ARIBA_BAPI_PO_CREATE  *************************************************
SAP Function name = Z_ARIBA_BAPI_PO_CREATE
Z_ARIBA_BAPI_PO_CREATE as XML : <Z_ARIBA_BAPI_PO_CREATE><INPUT><HEADER_ADD_DATA_RELEVANT></HEADER_ADD_DATA_RELEVANT><ITEM_ADD_DATA_RELEVANT></ITEM_ADD_DATA_RELEVANT><PARTITION></PARTITION><PO_ADDRESS><ADDRNUMBER></ADDRNUMBER><ADDRHANDLE></ADDRHANDLE><NATION></NATION><DATE>0000-00-00</DATE><DATE_FROM>0000-00-00</DATE_FROM><DATE_TO>0000-00-00</DATE_TO><TITLE></TITLE><NAME1></NAME1><NAME2></NAME2><NAME3></NAME3><NAME4></NAME4><NAME_TXT></NAME_TXT><NAME_CO></NAME_CO><CITY1></CITY1><CITY2></CITY2><CITY_CODE></CITY_CODE><CITYP_CODE></CITYP_CODE><CHCKSTATUS></CHCKSTATUS><POST_CODE1></POST_CODE1><POST_CODE2></POST_CODE2><POST_CODE3></POST_CODE3><PO_BOX></PO_BOX><PO_BOX_NUM></PO_BOX_NUM><PO_BOX_LOC></PO_BOX_LOC><CITY_CODE2></CITY_CODE2><PO_BOX_REG></PO_BOX_REG><PO_BOX_CTY></PO_BOX_CTY><POSTALAREA></POSTALAREA><TRANSPZONE></TRANSPZONE><STREET></STREET><STREETCODE></STREETCODE><STREETABBR></STREETABBR><HOUSE_NUM1></HOUSE_NUM1><HOUSE_NUM2></HOUSE_NUM2><HOUSE_NUM3></HOUSE_NUM3><STR_SUPPL1></STR_SUPPL1><STR_SUPPL2></STR_SUPPL2><LOCATION></LOCATION><BUILDING></BUILDING><FLOOR></FLOOR><ROOMNUMBER></ROOMNUMBER><COUNTRY></COUNTRY><LANGU></LANGU><REGION></REGION><SORT1></SORT1><SORT2></SORT2><SORT_PHN></SORT_PHN><ADDRORIGIN></ADDRORIGIN><EXTENSION1></EXTENSION1><EXTENSION2></EXTENSION2><TIME_ZONE></TIME_ZONE><TAXJURCODE></TAXJURCODE><ADDRESS_ID></ADDRESS_ID><REMARK></REMARK><DEFLT_COMM></DEFLT_COMM><TEL_NUMBER></TEL_NUMBER><TEL_EXTENS></TEL_EXTENS><FAX_NUMBER></FAX_NUMBER><FAX_EXTENS></FAX_EXTENS><BUILD_LONG></BUILD_LONG></PO_ADDRESS><PO_HEADER><DOC_DATE>0000-00-00</DOC_DATE><DOC_TYPE></DOC_TYPE><DOC_CAT></DOC_CAT><CO_CODE></CO_CODE><PURCH_ORG></PURCH_ORG><PUR_GROUP></PUR_GROUP><AGREEMENT></AGREEMENT><VENDOR></VENDOR><PO_NUMBER></PO_NUMBER><SUPPL_PLNT></SUPPL_PLNT><CREATED_BY></CREATED_BY><LANGU></LANGU><LANGU_ISO></LANGU_ISO><ARIBA_DOC_TYPE></ARIBA_DOC_TYPE><ERPORDERID></ERPORDERID></PO_HEADER><PO_HEADER_ADD_DATA><PMNTTRMS></PMNTTRMS><DSCNT1_TO>0</DSCNT1_TO><DSCNT2_TO>0</DSCNT2_TO><DSCNT3_TO>0</DSCNT3_TO><CASH_DISC1>0.000</CASH_DISC1><CASH_DISC2>0.000</CASH_DISC2><CREATED_BY></CREATED_BY><CURRENCY></CURRENCY><EXCH_RATE>0.00000</EXCH_RATE><EX_RATE_FX></EX_RATE_FX><INCOTERMS1></INCOTERMS1><INCOTERMS2></INCOTERMS2><REF_1></REF_1><SALES_PERS></SALES_PERS><TELEPHONE></TELEPHONE><TRNSP_MODE></TRNSP_MODE><CUSTOMS></CUSTOMS><EXCH_RATE_CM>0.00000</EXCH_RATE_CM><VPER_START>0000-00-00</VPER_START><VPER_END>0000-00-00</VPER_END><OUR_REF></OUR_REF></PO_HEADER_ADD_DATA><SKIP_ITEMS_WITH_ERROR>X</SKIP_ITEMS_WITH_ERROR><VARIANT></VARIANT></INPUT><OUTPUT><E_PARTITION></E_PARTITION><E_VARIANT></E_VARIANT><PURCHASEORDER></PURCHASEORDER></OUTPUT><TABLES><ERROR_MSG_TABLE></ERROR_MSG_TABLE><PO_COND></PO_COND><PO_CONTRACT_LIMITS></PO_CONTRACT_LIMITS><PO_ITEMS></PO_ITEMS><PO_ITEM_ACCOUNT_ASSIGNMENT></PO_ITEM_ACCOUNT_ASSIGNMENT><PO_ITEM_ADD_DATA></PO_ITEM_ADD_DATA><PO_ITEM_SCHEDULES></PO_ITEM_SCHEDULES><PO_ITEM_TEXT></PO_ITEM_TEXT><PO_LIMITS></PO_LIMITS><PO_SERVICES></PO_SERVICES><PO_SERVICES_TEXT></PO_SERVICES_TEXT><PO_SRV_ACCASS_VALUES></PO_SRV_ACCASS_VALUES><PO_ZZIMMOS></PO_ZZIMMOS><PUR_ORDER_DELIVERY></PUR_ORDER_DELIVERY><PUR_ORDER_DETAILS></PUR_ORDER_DETAILS><RETURN></RETURN></TABLES></Z_ARIBA_BAPI_PO_CREATE>


- MUIS : Z_ARIBA_BAPI_PO_CREATE.getChangingParameterList() = 
null


- MUIS : Z_ARIBA_BAPI_PO_CREATE.getExportParameterList() = 
|--------------------|--------------------|----------|
| PARAMETERS 'OUTPUT'
|--------------------|--------------------|----------|
|E_PARTITION         |E_VARIANT           |PURCHASEOR|
|--------------------|--------------------|----------|
|01234567890123456789|01234567890123456789|0123456789|
|--------------------|--------------------|----------|
|                    |                    |          |
|--------------------|--------------------|----------|



- MUIS : Z_ARIBA_BAPI_PO_CREATE.getTableParameterList() = 
|---------------|-------|------------------|--------|--------------------------|----------------|-----------------|------------|---------|-----------|----------------|--------------------|----------|------------------|-----------------|------|
| PARAMETERS 'TABLES'
|---------------|-------|------------------|--------|--------------------------|----------------|-----------------|------------|---------|-----------|----------------|--------------------|----------|------------------|-----------------|------|
|ERROR_MSG_TABLE|PO_COND|PO_CONTRACT_LIMITS|PO_ITEMS|PO_ITEM_ACCOUNT_ASSIGNMENT|PO_ITEM_ADD_DATA|PO_ITEM_SCHEDULES|PO_ITEM_TEXT|PO_LIMITS|PO_SERVICES|PO_SERVICES_TEXT|PO_SRV_ACCASS_VALUES|PO_ZZIMMOS|PUR_ORDER_DELIVERY|PUR_ORDER_DETAILS|RETURN|
|---------------|-------|------------------|--------|--------------------------|----------------|-----------------|------------|---------|-----------|----------------|--------------------|----------|------------------|-----------------|------|
|               |       |                  |        |                          |                |                 |            |         |           |                |                    |          |                  |                 |      |
|---------------|-------|------------------|--------|--------------------------|----------------|-----------------|------------|---------|-----------|----------------|--------------------|----------|------------------|-----------------|------|
|ERROR_MSG_TABLE|PO_COND|PO_CONTRACT_LIMITS|PO_ITEMS|PO_ITEM_ACCOUNT_ASSIGNMENT|PO_ITEM_ADD_DATA|PO_ITEM_SCHEDULES|PO_ITEM_TEXT|PO_LIMITS|PO_SERVICES|PO_SERVICES_TEXT|PO_SRV_ACCASS_VALUES|PO_ZZIMMOS|PUR_ORDER_DELIVERY|PUR_ORDER_DETAILS|RETURN|
|---------------|-------|------------------|--------|--------------------------|----------------|-----------------|------------|---------|-----------|----------------|--------------------|----------|------------------|-----------------|------|



- MUIS : Z_ARIBA_BAPI_PO_CREATE.getFunctionTemplate() = 
Function: Z_ARIBA_BAPI_PO_CREATE
Input:
HEADER_ADD_DATA_RELEVANT      ,BAPIMMPARA                    ,C ,C,1,0,1,2,0,IMPORT,OPTIONAL,BAPIMMPARA,SELECTION
ITEM_ADD_DATA_RELEVANT        ,BAPIMMPARA                    ,C ,C,1,1,1,2,0,IMPORT,OPTIONAL,BAPIMMPARA,SELECTION
PARTITION                     ,ZARIBTVARV                    ,C ,C,20,2,20,40,0,IMPORT,ZARIBTVARV,PARTIT
PO_ADDRESS                    ,BAPIADDRESS                   ,u,u,0,22,1243,2486,0,IMPORT,OPTIONAL
PO_HEADER                     ,ZARBAPIEKKOC                  ,u,u,0,22,133,266,0,IMPORT
PO_HEADER_ADD_DATA            ,BAPIEKKOA                     ,u  ,u,0,22,168,316,0,IMPORT,OPTIONAL
SKIP_ITEMS_WITH_ERROR         ,BAPIMMPARA                    ,C ,C,1,22,1,2,0,'X',IMPORT,OPTIONAL,BAPIMMPARA,SELECTION
VARIANT                       ,ZARIBTVARV                    ,C ,C,20,23,20,40,0,IMPORT,ZARIBTVARV,ZVARIANT
Changing:
null
Output:
E_PARTITION                   ,ZARIBTVARV                    ,C ,C,20,0,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,PARTIT
E_VARIANT                     ,ZARIBTVARV                    ,C ,C,20,20,20,40,0,EXPORT,OPTIONAL,ZARIBTVARV,ZVARIANT
PURCHASEORDER                 ,BAPIEKKOC                     ,C  ,C,10,40,10,20,0,EXPORT,OPTIONAL,BAPIEKKOC,PO_NUMBER
Tables:
ERROR_MSG_TABLE               ,ZARPOERR                      ,h   ,u,0,0,399,798,0
PO_COND                       ,ZXTPOCOND                     ,h  ,u,0,0,15,24,0,OPTIONAL
PO_CONTRACT_LIMITS            ,BAPIESUCC                     ,h  ,u,0,0,90,168,0,OPTIONAL
PO_ITEMS                      ,ZARIBABAPIEKPOC               ,h,u,0,0,389,750,0
PO_ITEM_ACCOUNT_ASSIGNMENT    ,BAPIEKKN                      ,h   ,u,0,0,401,794,0,OPTIONAL
PO_ITEM_ADD_DATA              ,BAPIEKPOA                     ,h  ,u,0,0,52,94,0,OPTIONAL
PO_ITEM_SCHEDULES             ,BAPIEKET                      ,h   ,u,0,0,108,210,0
PO_ITEM_TEXT                  ,BAPIEKPOTX                    ,h ,u,0,0,153,306,0,OPTIONAL
PO_LIMITS                     ,BAPIESUHC                     ,h  ,u,0,0,103,140,0,OPTIONAL
PO_SERVICES                   ,BAPIESLLC                     ,h  ,u,0,0,636,1186,0,OPTIONAL
PO_SERVICES_TEXT              ,BAPIESLLTX                    ,h ,u,0,0,158,316,0,OPTIONAL
PO_SRV_ACCASS_VALUES          ,BAPIESKLC                     ,h  ,u,0,0,40,66,0,OPTIONAL
PO_ZZIMMOS                    ,ZXTPOZZIMMOS                  ,h,u,0,0,54,108,0,OPTIONAL
PUR_ORDER_DELIVERY            ,ZXTPODELIV                    ,h ,u,0,0,23,46,0
PUR_ORDER_DETAILS             ,ZXTPODET                      ,h   ,u,0,0,69,126,0
RETURN                        ,BAPIRETURN                    ,h ,u,0,0,452,904,0,OPTIONAL
Exceptions:
*********************************************************************************************************
####################### END describeAllAribaFunctions() ######################
