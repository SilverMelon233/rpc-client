import os
import grpc
from demo_stub.demo import v1_pb2, v1_pb2_grpc
from google.protobuf import empty_pb2


def run():
    addr = os.environ.get("SERVER_ADDR", "server:50051")
    channel = grpc.insecure_channel(addr)
    stub = v1_pb2_grpc.DemoServiceStub(channel)

    echo_resp = stub.Echo(v1_pb2.EchoRequest(message="Hello from Python!"))
    print(f"Echo response: {echo_resp.message}")

    health_resp = stub.Health(empty_pb2.Empty())
    print(f"Health response: {health_resp.status}")


if __name__ == "__main__":
    run()
