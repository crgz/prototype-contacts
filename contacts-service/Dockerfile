# this file is just for playing around. the real dockerfile is build by the maven build.
# docker build -t miguelrf/contacts-service .
# docker run -p 8080:8080 -v /c/Development/logs://logs -d miguelrf/contacts-service
# volume share doesn't work on windows/boot2docker this way (https://github.com/boot2docker/boot2docker#folder-sharing)

FROM java:8-jre
ADD target/contacts-service-0.0.1-SNAPSHOT.jar /data/contacts-service.jar
ADD src/main/resources/docker-config.yml /data/docker-config.yml
RUN mkdir /logs
VOLUME /logs
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/data/contacts-service.jar", "server", "/data/docker-config.yml"]
# use CMD[] to provide run arguments (like ENTRYPOINT), but they can be overridden by the client calling 'docker run'
# or use CMD[] instead of ENTRYPOINT[] so let the user override it with something like "//bin/bash" -> good for debugging