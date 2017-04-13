FROM jboss/wildfly
RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main
COPY wildfly_setup/pgsql/postgresql-42.0.0.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main
COPY wildfly_setup/pgsql/module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main
# COPY wildfly_setup/pgsql/postgresql-42.0.0.jar /tmp
# RUN /opt/jboss/wildfly/bin/jboss-cli.sh -c "module add --name=org.postgresql --resources=/tmp/postgresql-42.0.0.jar --dependencies=javax.api,javax.transaction.api"
# RUN /opt/jboss/wildfly/bin/jboss-cli.sh -c "/subsystem=datasources/jdbc-driver=postgresql:add(driver-name=postgresql,driver-module-name=org.postgresql,driver-xa-datasource-class-name=org.postgresql.xa.PGXADataSource)"
# COPY wildfly_setup/datasources/*-ds.xml /opt/jboss/wildfly/standalone/deployments
COPY wildfly_setup/pgsql/postgresql-42.0.0.jar /opt/jboss/wildfly/standalone/deployments
COPY wildfly_setup/standalone.xml /opt/jboss/wildfly/standalone/configuration
COPY build/libs/spring_boot_tutorial-0.0.1.war /opt/jboss/wildfly/standalone/deployments/app.war
