# Set base image
FROM adoptopenjdk:11-jre-hotspot
# Copy the application JAR file and the configuration file to the container
COPY target/*.jar app.jar
# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
