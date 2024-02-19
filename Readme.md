# sapjco install on windows :
Add C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter\sapjco31P_7-20009381-win64 to 
CLASSPATH and LD_LIBRARY_PATH Windows Env var.

# Smoke test on Windows :
C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter> 
java -jar .\sapjco31P_7-20009381-win64\sapjco3.jar
OR just double-click on the sapjco3.jar file

# Install sapjco on Linux
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/root/IAM_SAP_Adapter-main/sap-libs
export CLASSPATH=$CLASSPATH:/root/IAM_SAP_Adapter-main/sap-libs/sapjco3.jar
# Install apache maven on Linux
wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz
gzunip, tar xvf and move to /opt, then :
export PATH=$PATH:/opt/apache-maven-3.9.1/bin

# Smoke Test on Linux :
java -jar /root/IAM_SAP_Adapter-main/sap-libs/sapjco3.jar -stdout

# Install sapjco into maven repo :
cmd as admin : 
    mvn install:install-file -DgroupId=org.hibersap -DartifactId=sapjco3 -Dversion=3.0 -Dpackaging=jar -Dfile=.\sapjco3-3.0.jar
     Installing C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter\sapjco3-3.0.jar to C:\Users\msentissi\.m2\repository\org\hibersap\sapjco3\3.0\sapjco3-3.0.jar
    [INFO] Installing C:\Users\MSENTI~1\AppData\Local\Temp\mvninstall122049965864333698.pom to C:\Users\msentissi\.m2\repository\org\hibersap\sapjco3\3.0\sapjco3-3.0.pom
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

mvn clean install
export JCO_ASHOST="sapqual6.iamdg.net.ma" JCO_SYSNR="00" JCO_CLIENT="200" JCO_USER="sapuser" JCO_PASSWD="sappwd" JCO_LANG="fr"
mvn spring-boot:run


# java -cp sap-libs/sapjco3.jar:target/Muis-Fuse-SAP-Adapter-1.0.0.jar org.springframework.boot.loader.JarLauncher

# Local run :
. sap_rec.env
mvn spring-boot:run
docker run --rm -it -p 61616:61616 -p 8161:8161 -e AMQ_USER=$AMQ_USER -e AMQ_PASSWORD=$AMQ_PASSWORD activemq-artemis-broker-init:artemis.2.28.0
#http://10.100.20.31:8161/console/auth/login
