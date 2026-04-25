import GRPC
import NIO
import SwiftProtobuf

let serverAddr = ProcessInfo.processInfo.environment["SERVER_ADDR"] ?? "localhost:50051"
let parts = serverAddr.split(separator: ":")
let host = String(parts[0])
let port = parts.count > 1 ? Int(parts[1]) ?? 50051 : 50051

let group = MultiThreadedEventLoopGroup(numberOfThreads: 1)
defer { try? group.syncShutdownGracefully() }

let channel = try GRPCChannelPool.with(
    target: .host(host, port: port),
    transportSecurity: .plaintext,
    eventLoopGroup: group
)
defer { try? channel.close().wait() }

let client = Demo_V1_DemoServiceNIOClient(
    channel: channel,
    defaultCallOptions: CallOptions()
)

// Echo
var echoRequest = Demo_V1_EchoRequest()
echoRequest.message = "hello"
let echoResponse = try client.echo(echoRequest).response.wait()
print("Echo response: \(echoResponse.message)")

// Health
let healthResponse = try client.health(Google_Protobuf_Empty()).response.wait()
print("Health status: \(healthResponse.status)")
