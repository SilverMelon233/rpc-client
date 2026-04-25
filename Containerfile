FROM dhi.io/dotnet:10-sdk-alpine3.23 AS build
WORKDIR /src
COPY gen/ gen/
COPY *.csproj .
COPY *.cs ./
RUN dotnet publish -c Release -o /app

FROM dhi.io/dotnet:10-sdk-alpine3.23
WORKDIR /app
COPY --from=build /app .
EXPOSE 50051
ENTRYPOINT ["dotnet", "Client.dll"]
