FROM adoptopenjdk/openjdk16
VOLUME /redis-service
ARG JAR_FILE=target/spring-redis-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} redis-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/redis-service.jar"]
