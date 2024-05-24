#
# Build stage
#
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
#COPY src/main/resources/ffprobe /tmp/ffprobe
#COPY src/main/resources/samples /tmp/samples
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:21
COPY --from=build /home/app/target/SVNHook-0.0.1-SNAPSHOT.jar /usr/local/lib/server.jar
#COPY --from=build /tmp/ffprobe /tmp/ffprobe
#COPY --from=build /tmp/samples /tmp/samples
ENTRYPOINT ["java","-jar","/usr/local/lib/server.jar"]
