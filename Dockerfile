FROM adoptopenjdk/openjdk16:latest
ARG JAR_FILE=out/*.jar
COPY ${JAR_FILE} Converter.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/Converter.jar"]

