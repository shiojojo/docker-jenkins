FROM tomcat:jdk14-openjdk

COPY target/*.war /usr/local/tomcat/webapps/ 

CMD [ "/opt/apache-tomcat-9.0.6/bin/catalina.sh", "run" ]
