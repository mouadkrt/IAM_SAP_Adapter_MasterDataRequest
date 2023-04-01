FROM registry.redhat.io/ubi8/openjdk-11:1.14-12
WORKDIR /opt/app
ARG JAR_FILE=target/Muis-Fuse-SAP-Adapter-1.0.0.jar
COPY ${JAR_FILE} app.jar
USER root
ENTRYPOINT ["java","-jar","app.jar"]

# mvn spring-boot:run
# mvn clean install

# Start Docker deamon
# docker build -t iam-complex-trf:iam_1.10 .
# Tag it and push to quay
# docker tag iam-complex-trf:iam_1.10 quay.io/msentissi/iam-complex-trf:iam_1.10
# docker push quay.io/msentissi/iam-complex-trf:iam_1.10
# OR tag it and push to dockerhub
# docker push msentissi/iam-complex-trf:1.5