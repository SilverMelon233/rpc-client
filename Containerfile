FROM sbtscala/scala-sbt:eclipse-temurin-alpine-25.0.1_8_1.12.9_3.8.3 AS build
WORKDIR /app
COPY build.sbt ./
COPY project ./project
COPY src ./src
RUN sbt assembly

FROM dhi.io/eclipse-temurin:25-alpine3.23
WORKDIR /app
COPY --from=build /app/target/scala-3.4.2/demo-client-assembly-0.1.0.jar app.jar
ENV SERVER_ADDR=server:50051
ENTRYPOINT ["java", "-jar", "app.jar"]
