FROM dhi.io/python:3-alpine3.23-dev AS build
WORKDIR /app
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt --target /deps

FROM dhi.io/python:3-alpine3.23
WORKDIR /app
COPY --from=build /deps /deps
COPY gen/ gen/
COPY *.py .
ENV PYTHONPATH=/app/gen:/deps
ENV SERVER_ADDR=server:50051
ENTRYPOINT ["python", "client.py"]
