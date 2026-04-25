FROM dhi.io/golang:1-alpine3.23-dev AS build
WORKDIR /src
COPY go.mod ./
COPY client.go ./
RUN GOFLAGS=-mod=mod GOPROXY=direct go get github.com/SilverMelon233/rpc-stub/golang@golang && \
    GOFLAGS=-mod=mod GOPROXY=direct go build -o /client .

FROM dhi.io/alpine-base:3.23
COPY --from=build /client /client
ENV SERVER_ADDR=server:50051
ENTRYPOINT ["/client"]
