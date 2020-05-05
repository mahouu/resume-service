FROM ubuntu:18.04
FROM adoptopenjdk/openjdk11
COPY ./target/resume-service-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src/
ENV DATABASE_NAME=resumedb
ENV DATABASE_USER="myuser"
ENV DATABASE_PASSWORD="mypassword"
ENV CORS_IP=http://raspagorda.duckdns.org
EXPOSE 8082
CMD ["java", "-jar", "resume-service-0.0.1-SNAPSHOT.jar"]