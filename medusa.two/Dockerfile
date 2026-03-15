FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY ./target/medusa.two-0.0.1-SNAPSHOT.jar /app
EXPOSE 8882
EXPOSE 7772
ENTRYPOINT ["java", "-jar", "medusa.two-0.0.1-SNAPSHOT.jar"]
