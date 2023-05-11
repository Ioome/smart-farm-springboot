FROM openjdk:8-jre-alpine
MAINTAINER sutton
WORKDIR /
ADD target/smart-farm-springboot-0.0.1-SNAPSHOT.jar farm-smart.jar
EXPOSE  9241
EXPOSE  7397
EXPOSE  8080
ENTRYPOINT ["java", "-jar"]
CMD ["farm-smart.jar"]


# 基于 fabric8/java-alpine-openjdk11-jre 镜像构建
#FROM fabric8/java-alpine-openjdk11-jre
#
## 调整时区
#RUN rm -f /etc/localtime \
#    && ln -sv /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
#    && echo "Asia/Shanghai" > /etc/timezone
#
## 添加jar包到容器中
#ADD target/smart-farm-springboot-0.0.1-SNAPSHOT.jar /app/app.jar
#
## 指定容器启动时运行jar包
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]
