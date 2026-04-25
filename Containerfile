FROM dhi.io/gradle:9-jdk25-alpine3.23-dev AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle shadowJar --no-daemon

FROM dhi.io/eclipse-temurin:25-alpine3.23
WORKDIR /app
COPY --from=build /app/build/libs/*-all.jar app.jar
ENV SERVER_ADDR=server:50051
ENTRYPOINT ["java", "-jar", "app.jar"]
