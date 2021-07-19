FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} stockmarket.jar
ENTRYPOINT ["java","-jar","/stockmarket.jar"]