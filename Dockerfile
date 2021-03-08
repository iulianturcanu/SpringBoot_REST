FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/demo-0.1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
