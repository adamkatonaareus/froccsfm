
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_72\jre

java -cp froccsfm-server/target/froccsfm-server.jar;javax.servlet-api-3.1.0.jar -Dlog4j.configuration=file:log4j.xml hu.guci.froccsfm.server.App
 