FROM eclipse-temurin:17-jdk-alpine
LABEL author="oscarfhp"
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
