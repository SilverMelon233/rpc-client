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
