#FROM openjdk:18
#EXPOSE 8080
#COPY target/server-app.jar ./
#RUN mvn -f pom.xml clean package -DskipTests
#ADD target/server-app.jar server-app.jar
#ENTRYPOINT ["java","-jar","/server-app.jar"]

#FROM eclipse-temurin:18-alpine
#VOLUME /tmp
#COPY target/*.jar server-app.jar
#COPY --chown=appuser:appuser target/**.jar /home/appuser/server-app.jar
#ENTRYPOINT ["java","-jar","/server-app.jar"]





#FROM eclipse-temurin:17-jre-alpine
#ARG PORT=8080
# Build the jar using maven 
#RUN apk add maven
#WORKDIR /app
#COPY . /app/
#RUN mvn -f pom.xml clean package -DskipTests

3FROM adoptopenjdk/openjdk11:alpine-jre
# Copy the packaged jar app file to a smaller JRE base image
#COPY /app/target/server-app.jar /usr/share/
#EXPOSE $PORT
#ENTRYPOINT ["java", "-jar", "/usr/share/server-app.jar"]



# Step 1: Builder le projet avec maven
FROM maven:3.8.3-openjdk-17-slim AS maven-builder
WORKDIR /app
COPY . /app
RUN mvn -f pom.xml clean package -DskipTests

# Step 2: Copier et lancer le .jar file
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=maven-builder ./app/target/server-app.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "server-app.jar"]
