FROM dhi.io/python:3-alpine3.23-dev AS build
WORKDIR /app
RUN apk add --no-cache git
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt --target /deps

FROM dhi.io/python:3-alpine3.23
WORKDIR /app
COPY --from=build /deps /usr/local/lib/python3.13/site-packages
COPY client.py .
ENV SERVER_ADDR=server:50051
ENTRYPOINT ["python", "client.py"]
