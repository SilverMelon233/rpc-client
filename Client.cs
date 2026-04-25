using Demo.V1;
using Google.Protobuf.WellKnownTypes;
using Grpc.Net.Client;

var serverAddr = Environment.GetEnvironmentVariable("SERVER_ADDR") ?? "http://server:50051";

// Ensure scheme is present for GrpcChannel
if (!serverAddr.StartsWith("http"))
{
    serverAddr = "http://" + serverAddr;
}

using var channel = GrpcChannel.ForAddress(serverAddr);
var client = new DemoService.DemoServiceClient(channel);

// Echo RPC
var echoResponse = await client.EchoAsync(new EchoRequest { Message = "hello from csharp client" });
Console.WriteLine($"Echo response: {echoResponse.Message}");

// Health RPC
var healthResponse = await client.HealthAsync(new Empty());
Console.WriteLine($"Health response: {healthResponse.Status}");
