# Use a lightweight Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY target/animal-rescue.jar app.jar
COPY data ./data

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]