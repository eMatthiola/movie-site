# Use OpenJDK 17 to run the Spring Boot application
FROM openjdk17-jdk-slim

# Set the working directory
WORKDIR app

# Copy the built JAR file
COPY targetMovie-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
CMD [java, -jar, app.jar]
