FROM registry.redhat.io/ubi8/openjdk-11:1.14-12
#FROM openjdk:19-jdk-alpine3.16
USER root
RUN mkdir -p /opt/app/sap-libs /certs
WORKDIR /opt/app
ARG JAR_FILE=target/Muis-Fuse-SAP-Adapter-MasterData-1.0.0.jar
COPY ${JAR_FILE} app.jar
#COPY certs/certs_prod/keystore_prod_iam.jks /certs/keystore_iam.jks
##Disabled since iam_0.1 included : COPY certs/certs_rec/keystore_rec_iam.jks /certs/keystore_iam.jks

# Starting from iam_0.1 included, the file /certs/keystore_iam.jks is expected to be mounted as a configMap, eg :
#    kubectl create configmap sap-adapter-keystore-rec-iam-jks --from-file keystore_iam.jks
#    Then, in the deployment yaml :
#    spec:
#      volumes:
#        - name: keystore-rec-iam-jks
#          configMap:
#            name: keystore-rec-iam-jks
#            defaultMode: 420
#      containers:
#          volumeMounts:
#            - name: keystore-rec-iam-jks
#              mountPath: /certs


COPY sap-libs/* /opt/app/sap-libs
#COPY src /opt/app/src
#COPY pom.xml  /opt/app/pom.xml
ENV LD_LIBRARY_PATH="/opt/app/sap-libs"
ENV CLASSPATH="/opt/app/sap-libs/sapjco3.jar"
ENV PATH="$PATH:/opt/app/sap-libs"
RUN echo "LD_LIBRARY_PATH=$LD_LIBRARY_PATH, CLASSPATH=$CLASSPATH, PATH=$PATH" 

#ENTRYPOINT ["java","-classpath", "/opt/app/sap-libs/sapjco3.jar", "-jar","app.jar"]
ENTRYPOINT ["java","-cp", "sap-libs/sapjco3.jar:app.jar", "org.springframework.boot.loader.JarLauncher"]
#ENTRYPOINT ["/bin/sh"] # Use this entry with openjdk:19-jdk-alpine3.16 image to inspect java env behaviour inside container

# Update version in MuisApp.java ~ line 54
# mvn dependency:tree | grep xyz
# mvn dependency:purge-local-repository clean install -U
# mvn spring-boot:run
#1 mvn clean install

# Start Docker deamon
# docker login registry.redhat.io 
#2 docker build -t muis-fuse-sap-adapter-masterdata:iam_0.1 .
# Tag it and push to quay
#3 docker tag muis-fuse-sap-adapter-masterdata:iam_0.1 quay.io/msentissi/muis-fuse-sap-adapter-masterdata:iam_0.1
#4 docker push quay.io/msentissi/muis-fuse-sap-adapter-masterdata:iam_0.1
# OR tag it and push to dockerhub
#   docker push msentissi/muis-fuse-sap-adapter-masterdata:iam_0.1

# docker run --rm -ti muis-fuse-sap-adapter-masterdata:iam_0.1 bash