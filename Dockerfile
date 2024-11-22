FROM gradle:8.10.1-jdk21-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:21-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/gs-spring-energy-java-api.jar

RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup
USER appuser

ENTRYPOINT ["java", "-jar", "/app/gs-spring-energy-java-api.jar"]
