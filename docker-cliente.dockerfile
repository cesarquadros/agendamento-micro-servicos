FROM openjdk:8-alpine
MAINTAINER Cesar Quadros
RUN apk update && apk add bash
RUN mkdir -p /opt/app
RUN mkdir -p /opt/app/db
ENV PROJECT_HOME /opt/app
COPY ./sala-agendamento-cliente/target/