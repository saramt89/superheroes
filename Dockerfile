FROM openjdk:21
COPY /target/*.jar superheroes-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","superheroes-0.0.1-SNAPSHOT.jar"]