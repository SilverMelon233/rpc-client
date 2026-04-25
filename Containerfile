FROM dhi.io/dart:3-alpine3.22-dev AS build
WORKDIR /app
COPY pubspec.yaml .
RUN dart pub get
COPY lib/ lib/
COPY bin/ bin/
RUN dart compile exe bin/demo_client.dart -o /app/demo_client

FROM dhi.io/alpine-base:3.23
COPY --from=build /app/demo_client /usr/local/bin/demo-client
CMD ["/usr/local/bin/demo-client"]
