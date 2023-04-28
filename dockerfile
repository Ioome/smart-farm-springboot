FROM openjdk:8-jre
MAINTAINER sutton
WORKDIR /
ADD target/smart-farm-springboot-0.0.1-SNAPSHOT.jar farm-smart.jar
EXPOSE  9241
EXPOSE  7397
EXPOSE  8080
ENTRYPOINT ["java", "-jar"]
CMD ["farm-smart.jar"]