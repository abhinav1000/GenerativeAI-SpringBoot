FROM openjdk:24
# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies (this is to cache them, so builds are faster)
#RUN ./mvnw dependency:go-offline

# Copy the source code
#COPY src ./src

# Package the application
#RUN ./mvnw package -DskipTests

# Specify the JAR file name
ARG JAR_FILE=target/generativeAI-0.0.1-SNAPSHOT.jar
# Copy the JAR file into the container
COPY ${JAR_FILE} app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]