# Use Maven image to build the application
FROM maven:latest

LABEL authors="vicheatachea"

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml to download dependencies first (caching optimization)
COPY ShoppinCart/pom.xml /app/

# Copy the entire project to the container
COPY .. /app/

# Package the application using Maven
RUN mvn package

# Run the main class from the built JAR
CMD ["java", "-jar", "target/shoppingcart.jar"]
