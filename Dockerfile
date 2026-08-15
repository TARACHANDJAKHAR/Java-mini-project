# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
# Download dependencies first to cache them
RUN mvn dependency:go-offline -B
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/university-management-system-1.0-SNAPSHOT.jar app.jar
# Expose port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
