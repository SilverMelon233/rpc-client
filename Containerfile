# Stage 1: compile ext-grpc and ext-protobuf
FROM dhi.io/php:8-alpine3.22-dev AS ext-build
RUN apk add --no-cache gcc make g++ autoconf linux-headers zlib-dev
RUN pecl install grpc protobuf

# Stage 2: install composer dependencies
FROM dhi.io/composer:2-alpine3.22-dev AS composer-build
WORKDIR /app
COPY composer.json .
RUN composer install --no-dev --optimize-autoloader

# Runtime
FROM dhi.io/php:8-alpine3.22-fpm
WORKDIR /app
COPY --from=ext-build /opt/php-8.5/lib/php/extensions/no-debug-non-zts-20250925/grpc.so \
     /opt/php-8.5/lib/php/extensions/no-debug-non-zts-20250925/grpc.so
COPY --from=ext-build /opt/php-8.5/lib/php/extensions/no-debug-non-zts-20250925/protobuf.so \
     /opt/php-8.5/lib/php/extensions/no-debug-non-zts-20250925/protobuf.so
RUN echo "extension=grpc.so" >> /opt/php-8.5/etc/php/php.ini \
 && echo "extension=protobuf.so" >> /opt/php-8.5/etc/php/php.ini
COPY --from=composer-build /app/vendor vendor/
COPY gen/ gen/
COPY demo_client.php .
ENV SERVER_ADDR=server:50051
CMD ["php", "demo_client.php"]
