FROM openjdk:21
WORKDIR /app
COPY ./target/hydra.one-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
EXPOSE 7770
ENTRYPOINT ["java", "-jar", "hydra.one-0.0.1-SNAPSHOT.jar"]