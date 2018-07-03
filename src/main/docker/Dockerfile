FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD web.jar web.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/web.jar"]