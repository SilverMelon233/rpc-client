defmodule DemoClient.MixProject do
  use Mix.Project

  def project do
    [
      app: :demo_client,
      version: "0.1.0",
      elixir: "~> 1.17",
      start_permanent: Mix.env() == :prod,
      deps: deps(),
      escript: [main_module: DemoClient]
    ]
  end

  def application do
    [extra_applications: [:logger]]
  end

  defp deps do
    [
      {:grpc, "~> 0.11"},
      {:protobuf, "~> 0.16"}
    ]
  end
end
