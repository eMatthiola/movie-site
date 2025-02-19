# Use OpenJDK 17 slim image
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file
COPY target/Movie-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
