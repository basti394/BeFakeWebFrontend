# Use a base image with a JVM and Node.js installed
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Install Node.js and npm
RUN apt-get update && apt-get install -y nodejs npm

# Copy the necessary files into the container
COPY . .

# Run the Gradle build to compile the Kotlin/Wasm code
RUN ./gradlew :composeApp:wasmJsBrowserProductionWebpack

# Expose the port that your application will run on (if applicable)
EXPOSE 8080

# Command to start your application
CMD ["./gradlew", ":composeApp:wasmJsBrowserProductionRun"]
