import 'dart:io';
import 'package:grpc/grpc.dart';
import 'package:demo_stub/demo/v1.pbgrpc.dart';
import 'package:protobuf/well_known_types/google/protobuf/empty.pb.dart';

Future<void> main(List<String> args) async {
  final serverAddr = Platform.environment['SERVER_ADDR'] ?? 'localhost:50051';
  final parts = serverAddr.split(':');
  final host = parts[0];
  final port = int.tryParse(parts.length > 1 ? parts[1] : '50051') ?? 50051;

  final channel = ClientChannel(
    host,
    port: port,
    options: const ChannelOptions(
      credentials: ChannelCredentials.insecure(),
    ),
  );

  final client = DemoServiceClient(channel);

  try {
    final echoResp = await client.echo(EchoRequest()..message = 'hello');
    print('Echo response: ${echoResp.message}');

    final healthResp = await client.health(Empty());
    print('Health status: ${healthResp.status}');
  } finally {
    await channel.shutdown();
  }
}
