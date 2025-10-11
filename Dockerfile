# Step 1: Build the app using Maven Wrapper
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Maven Wrapper and project files
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .
COPY src ./src

# Give execution permission for the wrapper (Linux-based container)
RUN chmod +x mvnw

# Build using the wrapper
RUN ./mvnw clean package -DskipTests

# Step 2: Run the built JAR
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
