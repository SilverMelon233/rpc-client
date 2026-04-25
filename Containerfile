FROM dhi.io/golang:1-alpine3.23-dev AS build
WORKDIR /src
COPY go.mod ./
COPY gen/ gen/
COPY *.go ./
RUN GOPROXY=https://proxy.golang.org,direct go mod tidy && \
    go build -o /demo-client .

FROM dhi.io/alpine-base:3.23
COPY --from=build /demo-client /demo-client
EXPOSE 50051
ENTRYPOINT ["/demo-client"]
