FROM dhi.io/erlang-otp:28-alpine3.23-dev AS build
RUN apk add --no-cache elixir git
WORKDIR /app
ENV MIX_ENV=prod
RUN mix local.hex --force && mix local.rebar --force
COPY mix.exs .
RUN mix deps.get --only prod
RUN mix deps.compile
COPY lib/ lib/
RUN mix compile
RUN mix escript.build

FROM dhi.io/alpine-base:3.23
WORKDIR /app
COPY --from=build /app/demo_client .
CMD ["/app/demo_client"]
