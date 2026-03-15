FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY ./target/medusa.one-0.0.1-SNAPSHOT.jar /app
EXPOSE 8881
EXPOSE 7771
ENTRYPOINT ["java", "-jar", "medusa.one-0.0.1-SNAPSHOT.jar"]
