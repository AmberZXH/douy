FROM openjdk:11-jre
ENV APP_PAHT=/apps
WORKDIR $APP_PAHT
COPY douy-gateway-1.0-SNAPSHOT.jar $APP_PAHT/app.jar
EXPOSE 9999
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]
