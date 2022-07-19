FROM openjdk:17-jdk-alpine

COPY /build/libs/projeto.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
