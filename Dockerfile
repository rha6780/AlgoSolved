FROM openjdk:17

WORKDIR /usr/src/app

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/algosolved-0.0.1-SNAPSHOT.jar ${JAR_PATH}/algosolved-0.0.1-SNAPSHOT.jar

EXPOSE "8081"

CMD ["java", "-jar", "./build/libs/algosolved-0.0.1-SNAPSHOT.jar"]