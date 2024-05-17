# Base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/KaliteGuvence-0.0.1-SNAPSHOT.jar /app

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "KaliteGuvence-0.0.1-SNAPSHOT.jar"]