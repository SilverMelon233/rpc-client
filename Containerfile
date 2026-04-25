FROM dhi.io/dotnet:10-sdk-alpine3.23 AS build
RUN apk add --no-cache git
WORKDIR /src
# Build and pack the stub from GitHub
RUN git clone --branch csharp --depth 1 https://github.com/SilverMelon233/rpc-stub /tmp/rpc-stub && \
    dotnet pack /tmp/rpc-stub/DemoStub.csproj -o /tmp/nuget-feed
# Add local NuGet source and build client
COPY client.csproj .
COPY *.cs ./
RUN dotnet nuget add source /tmp/nuget-feed --name local && \
    dotnet publish -c Release -r linux-musl-x64 --self-contained true \
      /p:PublishSingleFile=true /p:PublishTrimmed=true -o /app

FROM dhi.io/alpine-base:3.23
COPY --from=build /app/Client /client
ENV SERVER_ADDR=http://server:50051
ENTRYPOINT ["/client"]
