FROM openjdk:17-jdk-slim as build

WORKDIR /app

RUN apt-get update && \
    apt-get install -y maven

COPY pom.xml .
COPY src src

RUN mvn -f pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/Instructors-0.0.1-SNAPSHOT.jar app.jar

ENV SERVER_PORT 8080
EXPOSE $SERVER_PORT

ENTRYPOINT ["java", "-jar", "app.jar"]