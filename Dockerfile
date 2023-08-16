FROM openjdk:17

WORKDIR .

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/algosolved-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]