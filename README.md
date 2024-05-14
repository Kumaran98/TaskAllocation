To run the backend Services

Open folder named "JAR Files"

Open the config folder

Edit the application-dev.properties to setup the MYSQL Database.

"spring.datasource.url=jdbc:mysql://localhost:3306/task?useSSL=false

spring.datasource.username=root

spring.datasource.password=admin"

Give the name of a existing database schema to replace "task" in the first line.

Give the correct username and password for the below lines/

Open a terminal in the "JAR File" Folder

run the command "java -jar TaskAllocation-0.0.1-SNAPSHOT.jar"
