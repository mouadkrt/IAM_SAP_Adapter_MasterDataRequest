FROM registry.redhat.io/ubi8/openjdk-11:1.14-12
WORKDIR /opt/app
ARG JAR_FILE=target/Muis-Fuse-SAP-Adapter-1.0.0.jar
COPY ${JAR_FILE} app.jar
ADD sapjco31P_7-70004517-linux64 /sapjco31P_7-70004517-linux64
ADD sapjidoc31P_3-80004914 /sapjidoc31P_3-80004914
COPY ${JAR_FILE} app.jar
FROM ubuntu:latest
ENV LD_LIBRARY_PATH ="$LD_LIBRARY_PATH:/sapjco31P_7-70004517-linux64"
ENV LD_LIBRARY_PATH ="$LD_LIBRARY_PATH:/sapjidoc31P_3-80004914"
RUN echo $PATH
USER root
# ENV CLASSPATH=/sapjco31P_7-70004517-linux64/sapjco3.jar:${CLASSPATH}

ENTRYPOINT ["java","-classpath", "/sapjco31P_7-70004517-linux64/sapjco3.jar;/sapjidoc31P_3-80004914/sapidoc3.jar", "-jar","app.jar"]


# mvn spring-boot:run
# mvn clean install

# Start Docker deamon
# docker build -t iam-complex-trf:iam_1.10 .
# Tag it and push to quay
# docker tag iam-complex-trf:iam_1.10 quay.io/msentissi/iam-complex-trf:iam_1.10
# docker push quay.io/msentissi/iam-complex-trf:iam_1.10
# OR tag it and push to dockerhub
# docker push msentissi/iam-complex-trf:1.5