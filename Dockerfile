FROM eclipse-temurin:17-jdk-jammy
EXPOSE 8080

COPY target/java-maven-app-1.1.7.jar /usr/app/java-maven-app.jar

WORKDIR /usr/app

CMD ["java", "-jar", "java-maven-app.jar"]

