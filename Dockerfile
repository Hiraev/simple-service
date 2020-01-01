FROM openjdk:8-jre-alpine
MAINTAINER Malik Khiraev

ENV APPLICATION_USER service
RUN adduser -D -g '' $APPLICATION_USER

ENV VERSION 1.0.0
ENV APP_NAME simple-service-$VERSION

RUN mkdir /app
RUN chown -R $APPLICATION_USER /app

USER $APPLICATION_USER

COPY ./build/libs/$APP_NAME.jar /app/$APP_NAME.jar
WORKDIR /app

ENTRYPOINT java -jar $APP_NAME.jar
