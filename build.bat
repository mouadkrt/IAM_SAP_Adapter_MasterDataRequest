REM Ctrl-A, Ctrl-C, Ctrl-V into a terminal
mvn clean install
docker build -t muis-fuse-sap-adapter:iam_0.8-rec .
docker tag muis-fuse-sap-adapter:iam_0.8-rec quay.io/msentissi/muis-fuse-sap-adapter:iam_0.8-rec
docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.8-rec

