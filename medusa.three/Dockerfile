FROM openjdk:21
WORKDIR /app
COPY ./target/medusa.three-0.0.1-SNAPSHOT.jar /app
EXPOSE 8883
EXPOSE 7773
ENTRYPOINT ["java", "-jar", "medusa.three-0.0.1-SNAPSHOT.jar"]