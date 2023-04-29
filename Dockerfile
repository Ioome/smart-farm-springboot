#FROM openjdk:8-jre
#MAINTAINER sutton
#WORKDIR /
#ADD target/smart-farm-springboot-0.0.1-SNAPSHOT.jar farm-smart.jar
#EXPOSE  9241
#EXPOSE  7397
#EXPOSE  8080
#ENTRYPOINT ["java", "-jar"]
#CMD ["farm-smart.jar"]


#该镜像需要依赖的基础镜像
FROM fabric8/java-alpine-openjdk11-jre
#调整时区
RUN rm -f /etc/localtime \
&& ln -sv /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo "Asia/Shanghai" > /etc/timezone
#将当前目录下的jar包复制到docker容器的/目录下
ADD target/smart-farm-springboot-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE  9241
EXPOSE  7397
EXPOSE  8080
#指定docker容器启动时运行jar包
ENTRYPOINT["java","-jar"]
CMD ["app/app.jar"]
