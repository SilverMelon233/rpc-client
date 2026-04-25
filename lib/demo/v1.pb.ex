defmodule Demo.V1.EchoRequest do
  use Protobuf, protoc_gen_elixir_version: "0.15.0", syntax: :proto3

  field :message, 1, type: :string
end

defmodule Demo.V1.EchoResponse do
  use Protobuf, protoc_gen_elixir_version: "0.15.0", syntax: :proto3

  field :message, 1, type: :string
end

defmodule Demo.V1.HealthRequest do
  use Protobuf, protoc_gen_elixir_version: "0.15.0", syntax: :proto3
end

defmodule Demo.V1.HealthResponse do
  use Protobuf, protoc_gen_elixir_version: "0.15.0", syntax: :proto3

  field :status, 1, type: :string
end
