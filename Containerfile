FROM dhi.io/rust:1-alpine3.23-dev AS builder
WORKDIR /app
RUN apk add --no-cache musl-dev git
COPY Cargo.toml Cargo.lock* ./
RUN mkdir -p src && echo "fn main(){}" > src/main.rs && cargo build --release 2>/dev/null || true
COPY src/ src/
RUN touch src/main.rs && cargo build --release

FROM dhi.io/alpine-base:3.23
COPY --from=builder /usr/lib/libgcc_s.so.1 /lib/
COPY --from=builder /app/target/release/client /client

ENV SERVER_ADDR=http://server:50051
CMD ["/client"]
