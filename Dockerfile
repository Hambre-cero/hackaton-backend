FROM openjdk:11
COPY "./web-services/build/libs/hambre-cero-web-service-1.0.0.jar" "app.jar"
ENV SPRING_DATASOURCE_USERNAME=gdkhfxwdsbcjhv SPRING_DATASOURCE_PASSWORD=b69947789887fa05fa945db667f5eb871cc12c9e13714a793a71f57888deaeaa SPRING_DATASOURCE_URL=jdbc:postgresql://ec2-23-23-164-251.compute-1.amazonaws.com:5432/dene8ufk8bmet8
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]