FROM dhi.io/dart:3-alpine3.22-dev AS build
WORKDIR /app
COPY pubspec.yaml .
RUN dart pub get
COPY bin/ bin/
RUN dart compile exe bin/client.dart -o /app/client

FROM dhi.io/alpine-base:3.23
COPY --from=build /app/client /usr/local/bin/client
CMD ["/usr/local/bin/client"]
