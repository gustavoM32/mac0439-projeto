FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY gradle/ ./gradle
COPY gradlew build.gradle.kts settings.gradle.kts ./

RUN ./gradlew
