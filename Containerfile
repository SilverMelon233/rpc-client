FROM dhi.io/ruby:4-alpine3.23-dev AS build
WORKDIR /app
COPY Gemfile .
RUN bundle install --path /deps
COPY lib/ lib/
COPY demo_client.rb .

FROM dhi.io/ruby:4-alpine3.23
WORKDIR /app
COPY --from=build /deps /deps
COPY --from=build /app/lib lib/
COPY --from=build /app/demo_client.rb .
ENV BUNDLE_PATH=/deps SERVER_ADDR=server:50051
CMD ["ruby", "demo_client.rb"]
