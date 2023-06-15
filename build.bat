mvn clean install

docker build -t muis-fuse-sap-adapter:iam_0.4.6 .

docker tag muis-fuse-sap-adapter:iam_0.4.6 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.6

docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.6
