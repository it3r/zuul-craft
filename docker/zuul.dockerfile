FROM openjdk:8-jdk-alpine
COPY res/podelki-zuul-server-0.1.0.jar app.jar
CMD "sleep 20"
ENTRYPOINT ["java","-jar","/app.jar"]