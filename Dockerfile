FROM openjdk:17

WORKDIR /app

COPY target/clustered-data-warehouse.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
