FROM maven:3.8-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTest
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/bff-agendador.jar
EXPOSE 8083
CMD ["java", "-jar", "/app/bff-agendador.jar"]