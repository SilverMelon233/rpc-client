$LOAD_PATH.unshift File.join(__dir__, 'lib')
require 'grpc'
require 'demo/v1_services_pb'

def main
  server_addr = ENV.fetch('SERVER_ADDR', 'localhost:50051')
  stub = Demo::V1::DemoService::Stub.new(server_addr, :this_channel_is_insecure)

  echo_resp = stub.echo(Demo::V1::EchoRequest.new(message: 'hello'))
  puts "Echo response: #{echo_resp.message}"

  health_resp = stub.health(Google::Protobuf::Empty.new)
  puts "Health status: #{health_resp.status}"
end

main
