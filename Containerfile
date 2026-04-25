FROM dhi.io/python:3-alpine3.23-dev AS build
WORKDIR /app
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

FROM dhi.io/python:3-alpine3.23
WORKDIR /app
COPY --from=build /usr/lib/python3.14/site-packages /usr/lib/python3.14/site-packages
COPY gen/ gen/
COPY demo_client.py .
ENV PYTHONPATH=/app/gen SERVER_ADDR=server:50051
ENTRYPOINT ["python", "demo_client.py"]
