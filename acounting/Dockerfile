FROM openjdk:11-jre
VOLUME /tmp
ADD target/acounting.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT exec java -server -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app.jar
