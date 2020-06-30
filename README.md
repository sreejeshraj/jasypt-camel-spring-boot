
1.Download Jasypt from http://www.jasypt.org/download.html
2. Unzip to a location
3. Go to <Installed_Location>\jasypt-1.9.3\lib
4. Note the encrypted secret and update in your properties file (make sure properties file is externalized!) - Use format ENC(---encrypted_secret---)
5. Add Jasypt starter in pom.xml in Spring Boot project

Encryption command:

java -cp jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="my-secret-to-encrypt" password=jasypt-master-password algorithm=PBEWithMD5AndDES




Decryption command:

java -cp jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringDecryptionCLI input="3YAI79Zf8JzqNCoHB4ukyxD1fV33gs7v" password=jasypt-master-password algorithm=PBEWithMD5AndDES

You can add key in application properties as jasypt.encryptor.password=jasypt-master-password 
OR
You can also give it on runtime as program argument --jasypt.encryptor.password=jasypt-master-password
for Spring Boot


java -jar jasypt-camel-spring-boot-0.0.1-SNAPSHOT.jar --jasypt.encryptor.password=jasypt-master-password

Steps
-----

1. Clone the project
2. Go to root folder where pom.xml is
3. To build: mvn clean install
4. Run command: mvn spring-boot:run