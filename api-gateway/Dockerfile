FROM eclipse-temurin:23-jdk

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} apigateway.jar

ENTRYPOINT ["java","-jar","/apigateway.jar"]

EXPOSE 9090
