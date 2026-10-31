
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY EV-Charging-Stations-Management-Prediction-System-main/pom.xml .
COPY EV-Charging-Stations-Management-Prediction-System-main/src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
