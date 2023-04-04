FROM adoptopenjdk:11
LABEL mentainer="akramyoubi.gstr@gmail.com"
WORKDIR /app
COPY target/company-service-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar
ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]
