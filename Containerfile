FROM docker.io/library/swift:latest AS build
WORKDIR /app
COPY Package.swift .
COPY Sources/ Sources/
RUN swift build -c release -Xswiftc -static-executable

FROM dhi.io/alpine-base:3.23
COPY --from=build /app/.build/release/demo-client /usr/local/bin/demo-client
CMD ["/usr/local/bin/demo-client"]
