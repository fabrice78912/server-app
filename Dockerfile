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





FROM eclipse-temurin:17-jre-alpine
ARG PORT=8080
# Build the jar using maven 
RUN apk add maven
WORKDIR /app
COPY . /app/
RUN mvn -f pom.xml clean package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre
# Copy the packaged jar app file to a smaller JRE base image
COPY --from=compile "/app/target/server-app.jar" /usr/share/
EXPOSE $PORT
ENTRYPOINT ["java", "-jar", "/usr/share/server-app.jar"]
