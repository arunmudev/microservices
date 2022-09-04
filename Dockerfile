FROM openjdk:18-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} product.jar

ENTRYPOINT ["java","-jar","product.jar"]

EXPOSE 8006