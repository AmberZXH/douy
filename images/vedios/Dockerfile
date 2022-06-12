FROM openjdk:11-jre
ENV APP_PAHT=/apps
WORKDIR $APP_PAHT
COPY douy-videos-1.0-SNAPSHOT.jar $APP_PAHT/app.jar
EXPOSE 8983
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]
