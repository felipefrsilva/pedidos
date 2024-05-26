# syntax=docker/dockerfile:1
FROM maven:3.9.2 AS builder
WORKDIR /tmp/app

COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests

FROM openjdk:17.0.2-oracle

WORKDIR /workspace
EXPOSE 8080 8000

COPY --from=builder /tmp/app/target/*.jar app.jar
RUN chmod +x app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
