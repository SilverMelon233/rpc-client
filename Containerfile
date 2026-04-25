FROM dhi.io/rust:1-alpine3.23-dev AS builder
WORKDIR /app
RUN apk add --no-cache musl-dev
COPY Cargo.toml Cargo.lock* ./
COPY src/ src/
RUN cargo build --release

FROM dhi.io/alpine-base:3.23
COPY --from=builder /usr/lib/libgcc_s.so.1 /lib/
COPY --from=builder /app/target/release/demo-client /demo-client
EXPOSE 50051
CMD ["/demo-client"]
