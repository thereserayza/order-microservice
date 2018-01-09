FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/order-service*.jar order-service.jar
RUN sh -c 'touch /order-service.jar'
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "order-service.jar" ]