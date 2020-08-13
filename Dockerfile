FROM tomcat:jdk14-openjdk

COPY target/*.war /usr/local/tomcat/webapps/ 
