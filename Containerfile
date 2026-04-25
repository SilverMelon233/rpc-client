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
RUN mix release demo_client

FROM dhi.io/alpine-base:3.23
WORKDIR /app
COPY --from=build /app/_build/prod/rel/demo_client ./
CMD ["bin/demo_client", "start"]
