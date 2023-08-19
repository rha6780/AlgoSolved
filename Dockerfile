FROM openjdk:17

WORKDIR .

COPY build/libs/algosolved-0.0.1-SNAPSHOT.jar app.jar

EXPOSE "8081"

ENTRYPOINT ["java", "-jar", "/app.jar"]