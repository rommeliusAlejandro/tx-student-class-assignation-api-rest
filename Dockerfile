FROM java:8
EXPOSE 9090
ADD /target/restapi-0.0.1-SNAPSHOT.jar restapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "restapi-0.0.1-SNAPSHOT.jar"]

