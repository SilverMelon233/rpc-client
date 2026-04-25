defmodule DemoClient do
  alias Demo.V1.{EchoRequest, EchoResponse, HealthResponse}
  alias Demo.V1.DemoService.Stub

  def run do
    server_addr = System.get_env("SERVER_ADDR", "localhost:50051")
    {:ok, channel} = GRPC.Stub.connect(server_addr)

    echo_request = EchoRequest.new(message: "hello")
    {:ok, %EchoResponse{message: msg}} = Stub.echo(channel, echo_request)
    IO.puts("Echo response: #{msg}")

    health_request = Google.Protobuf.Empty.new()
    {:ok, %HealthResponse{status: status}} = Stub.health(channel, health_request)
    IO.puts("Health status: #{status}")
  end
end
