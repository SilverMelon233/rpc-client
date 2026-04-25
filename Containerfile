FROM php:8-cli-alpine AS build
RUN pecl install grpc protobuf && docker-php-ext-enable grpc protobuf
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
WORKDIR /app
COPY composer.json .
RUN composer install --no-dev
COPY client.php .
CMD ["php", "client.php"]
