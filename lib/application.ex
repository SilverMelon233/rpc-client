defmodule DemoClient.Application do
  use Application

  @impl true
  def start(_type, _args) do
    children = [
      {GRPC.Client.Supervisor, []}
    ]
    opts = [strategy: :one_for_one, name: DemoClient.Supervisor]
    {:ok, pid} = Supervisor.start_link(children, opts)

    DemoClient.run()
    System.halt(0)

    {:ok, pid}
  end
end
