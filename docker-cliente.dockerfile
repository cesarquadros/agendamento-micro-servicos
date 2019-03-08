FROM openjdk:8-alpine
MAINTAINER Cesar Quadros
RUN apk update && apk add bash
RUN mkdir -p /opt/app
RUN mkdir -p /opt/app/db
ENV PROJECT_HOME /opt/app
COPY ./salas-agendamento-cliente/target/salas-agendamento-cliente-0.0.1-SNAPSHOT.jar $PROJECT_HOME
WORKDIR $PROJECT_HOME
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod","salas-agendamento-cliente-0.0.1-SNAPSHOT.jar"] 