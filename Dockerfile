FROM openjdk:latest
COPY ./target/SwEngMthdsCw-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SwEngMthdsCw-0.1.0.2-jar-with-dependencies.jar"]