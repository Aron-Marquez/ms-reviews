FROM gradle:8.7-jdk21 AS build
WORKDIR /app

COPY --chown=gradle:gradle . .
RUN gradle clean bootJar --no-daemon


FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
