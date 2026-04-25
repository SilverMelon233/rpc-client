FROM dhi.io/alpine-base:3.23-dev AS build
RUN apk add --no-cache grpc-dev protobuf-dev cmake samurai g++ openssl-dev git
WORKDIR /app
COPY CMakeLists.txt .
COPY demo_client.cc .
RUN cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release .
RUN cmake --build build

FROM dhi.io/alpine-base:3.23
COPY --from=build /app/build/demo-client /usr/local/bin/client
CMD ["/usr/local/bin/client"]
