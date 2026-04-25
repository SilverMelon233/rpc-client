FROM dhi.io/ruby:4-alpine3.23-dev AS build
WORKDIR /app
COPY Gemfile .
RUN bundle install
COPY demo_client.rb .

FROM dhi.io/ruby:4-alpine3.23
WORKDIR /app
COPY --from=build /usr/local/bundle /usr/local/bundle
COPY --from=build /app/client.rb .
CMD ["ruby", "demo_client.rb"]
