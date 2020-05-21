#FROM openjdk:11-jre
FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
ADD target/inventory.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT exec java -server -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app.jar
