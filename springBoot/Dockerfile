FROM fabric8/java-alpine-openjdk8-jdk

RUN apk add --no-cache tzdata

ADD build/libs/springBoot-0.0.1-SNAPSHOT.jar /deployments/springBoot.jar

ENV JAVA_APP_JAR springBoot.jar
#ENV JAVA_MAX_MEM_RATIO 80
ENV AB_OFF true