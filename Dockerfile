FROM openjdk:8
ADD target/placementportal.jar placementportal.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "placementportal.jar"]