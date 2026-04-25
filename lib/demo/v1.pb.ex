defmodule Demo.V1.EchoRequest do
  @moduledoc false

  use Protobuf,
    full_name: "demo.v1.EchoRequest",
    protoc_gen_elixir_version: "0.16.0",
    syntax: :proto3

  field :message, 1, type: :string
end

defmodule Demo.V1.EchoResponse do
  @moduledoc false

  use Protobuf,
    full_name: "demo.v1.EchoResponse",
    protoc_gen_elixir_version: "0.16.0",
    syntax: :proto3

  field :message, 1, type: :string
end

defmodule Demo.V1.HealthRequest do
  @moduledoc false

  use Protobuf,
    full_name: "demo.v1.HealthRequest",
    protoc_gen_elixir_version: "0.16.0",
    syntax: :proto3
end

defmodule Demo.V1.HealthResponse do
  @moduledoc false

  use Protobuf,
    full_name: "demo.v1.HealthResponse",
    protoc_gen_elixir_version: "0.16.0",
    syntax: :proto3

  field :status, 1, type: :string
end

defmodule Demo.V1.DemoService.Service do
  @moduledoc false

  use GRPC.Service, name: "demo.v1.DemoService", protoc_gen_elixir_version: "0.16.0"

  rpc :Echo, Demo.V1.EchoRequest, Demo.V1.EchoResponse

  rpc :Health, Google.Protobuf.Empty, Demo.V1.HealthResponse
end

defmodule Demo.V1.DemoService.Stub do
  @moduledoc false

  use GRPC.Stub, service: Demo.V1.DemoService.Service
end
