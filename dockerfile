# Use slim OpenJDK image as base
FROM adoptopenjdk:17-jdk-hotspot-slim AS builder

# Set the working directory in the container
WORKDIR /app

# Copy Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file to enable dependency resolution
COPY pom.xml .

# Download dependencies specified in pom.xml and cache them in Docker layer
RUN ./mvnw dependency:go-offline

# Copy the entire application
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Create a new layer for the final image
FROM adoptopenjdk:17-jre-hotspot-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
