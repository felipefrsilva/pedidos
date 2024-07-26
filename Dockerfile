# Build stage
FROM maven:3.9.2 AS builder
WORKDIR /tmp/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests

# Final stage
FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y curl \
    && curl -sSL https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz | tar -xz -C /usr/local/bin \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace
EXPOSE 8080

COPY --from=builder /tmp/app/target/pedidos-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["dockerize", "-wait", "tcp://mysql-service:3306", "-timeout", "90s", "java", "-jar", "/workspace/app.jar"]
