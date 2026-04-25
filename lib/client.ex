defmodule Demo.V1.DemoService.Service do
  use GRPC.Service, name: "demo.v1.DemoService", protoc_gen_elixir_version: "0.15.0"

  rpc(:Echo, Demo.V1.EchoRequest, Demo.V1.EchoResponse)
  rpc(:Health, Google.Protobuf.Empty, Demo.V1.HealthResponse)
end

defmodule Demo.V1.DemoService.Stub do
  use GRPC.Stub, service: Demo.V1.DemoService.Service
end

defmodule DemoClient do
  alias Demo.V1.{EchoRequest, EchoResponse, HealthResponse}
  alias Demo.V1.DemoService.Stub

  def run do
    server_addr = System.get_env("SERVER_ADDR", "localhost:50051")
    {:ok, channel} = GRPC.Stub.connect(server_addr)

    {:ok, %EchoResponse{message: msg}} = Stub.echo(channel, %EchoRequest{message: "hello"})
    IO.puts("Echo response: #{msg}")

    {:ok, %HealthResponse{status: status}} = Stub.health(channel, %Google.Protobuf.Empty{})
    IO.puts("Health status: #{status}")
  end
end
