FROM dhi.io/alpine-base:3.23-dev AS build
RUN apk add --no-cache g++ cmake samurai openssl-dev openssl-libs-static \
    linux-headers musl-dev pkgconf git
WORKDIR /app
COPY CMakeLists.txt .
COPY demo_client.cc .
COPY proto/ proto/
RUN cmake -B build -G Ninja \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_EXE_LINKER_FLAGS="-static -static-libgcc -static-libstdc++" \
    -Wno-dev . \
 && cmake --build build

FROM dhi.io/alpine-base:3.23
COPY --from=build /app/build/demo-client /usr/local/bin/client

CMD ["/usr/local/bin/client"]
