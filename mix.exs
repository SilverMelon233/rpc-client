defmodule DemoClient.MixProject do
  use Mix.Project

  def project do
    [
      app: :demo_client,
      version: "0.1.0",
      elixir: "~> 1.17",
      start_permanent: Mix.env() == :prod,
      releases: [demo_client: [include_executables_for: [:unix]]],
      deps: deps()
    ]
  end

  def application do
    [mod: {DemoClient.Application, []}, extra_applications: [:logger]]
  end

  defp deps do
    [
      {:grpc, "~> 0.11"},
      {:protobuf, "~> 0.15"}
    ]
  end
end
