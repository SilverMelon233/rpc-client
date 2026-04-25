FROM dhi.io/golang:1-alpine3.23-dev AS build
WORKDIR /src
COPY go.mod ./
COPY gen/ gen/
COPY *.go ./
RUN go mod tidy && go build -o /out .

FROM dhi.io/alpine-base:3.23
COPY --from=build /out /app
EXPOSE 50051
ENTRYPOINT ["/app"]
