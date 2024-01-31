mvn clean install
or 
mvn dependency:purge-local-repository clean install -U

docker build -t muis-fuse-sap-adapter:iam_0.7.2 .

docker tag muis-fuse-sap-adapter:iam_0.7.2 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.7.2

docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.7.2
