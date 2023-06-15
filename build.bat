mvn clean install

docker build -t muis-fuse-sap-adapter:iam_0.4.5 .

docker tag muis-fuse-sap-adapter:iam_0.4.5 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.5

docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.5
