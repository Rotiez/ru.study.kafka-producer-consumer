FROM openjdk:17.0.2-jdk-slim-buster

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} kafka-producer.jar

EXPOSE 8080:8080

ENTRYPOINT ["java","-jar","/kafka-producer.jar"]

ENV KAFKA_BOOTSTRAP_SERVERS=host.docker.internal:29092