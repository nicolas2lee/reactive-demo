FROM openjdk:11.0
MAINTAINER Tao ZHENG nicolas2lee@gmail.com

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/reactive-demo/reactive-demo.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/reactive-demo/reactive-demo.jar