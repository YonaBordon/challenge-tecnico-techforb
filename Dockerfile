FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests -Dmaven.test.skip=true -Dmaven.repo.local=/maven/repository

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
