FROM openjdk:18
EXPOSE 8080
ADD target/server-app.jar server-app.jar
ENTRYPOINT ["java","-jar","/server-app.jar"]