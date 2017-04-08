FROM tomcat:8.5.13-jre8
COPY tomcat_conf/tomcat-users.xml /usr/local/tomcat/conf
COPY tomcat_conf/manager_context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY build/libs/spring_boot_tutorial-0.0.1.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080
# ENV logging.config classpath:/log4j2-spring.xml
# ENV JAVA_OPTS -Dlogging.config=classpath:/log4j2-spring.xml
RUN echo ".level = INFO" >> /usr/local/tomcat/conf/logging.properties
