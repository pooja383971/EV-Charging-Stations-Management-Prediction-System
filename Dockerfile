git status
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven configuration and source code
COPY pom.xml .
COPY src ./src

# Build the executable JAR
RUN mvn -B -DskipTests clean package

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the generated executable JAR from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Render supplies the PORT environment variable
EXPOSE 8080

# Start Spring Boot on Render's assigned port
CMD ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar /app/app.jar"]
