# Use a lightweight Java image
FROM eclipse-temurin:17-jdk-jammy
#FROM openjdk:25-jdk
#FROM eclipse-temurin:25-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY target/animal-rescue-jar-with-dependencies.jar app.jar
COPY data ./data

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]