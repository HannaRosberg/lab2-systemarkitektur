# Use the WildFly base image from Quay.io
FROM quay.io/wildfly/wildfly:latest

# Set the working directory
WORKDIR /opt/jboss/wildfly/standalone/deployments/

# Copy the WAR file into the WildFly deployments directory
COPY target/lab2-systemarkitektur-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

# Expose the default port for WildFly
EXPOSE 8080


# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]

