FROM openjdk:21

COPY target/fullStackProject-0.0.1-SNAPSHOT.jar fullStackProject.jar

ENTRYPOINT [ "java", "-jar", "/fullStackProject.jar" ]