FROM dhi.io/gradle:9-jdk25-alpine3.23-dev AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build --no-daemon -q

FROM dhi.io/eclipse-temurin:25-alpine3.23
WORKDIR /app
COPY --from=build /app/build/libs/java-*.jar app.jar
COPY --from=build /app/build/libs/deps deps
EXPOSE 50051
ENTRYPOINT ["java", "-cp", "app.jar:deps/*", "DemoClient"]
