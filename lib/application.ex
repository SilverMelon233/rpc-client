defmodule DemoClient.Application do
  use Application

  @impl true
  def start(_type, _args) do
    DemoClient.run()
    System.halt(0)
    Supervisor.start_link([], strategy: :one_for_one)
  end
end
