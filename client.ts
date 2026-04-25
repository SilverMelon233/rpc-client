import * as grpc from '@grpc/grpc-js';
import { GrpcTransport } from '@protobuf-ts/grpc-transport';
import { DemoServiceClient } from '@silvermelon233/rpc-demo-stub/client';
import { EchoRequest } from '@silvermelon233/rpc-demo-stub';
import { Empty } from '@silvermelon233/rpc-demo-stub/google/protobuf/empty';

const addr = process.env.SERVER_ADDR ?? 'server:50051';
const transport = new GrpcTransport({
  host: addr,
  channelCredentials: grpc.credentials.createInsecure(),
});
const client = new DemoServiceClient(transport);

const { response: echoRes } = await client.echo(EchoRequest.create({ message: 'Hello from TypeScript!' }));
console.log(`Echo response: ${echoRes.message}`);

const { response: healthRes } = await client.health(Empty.create());
console.log(`Health response: ${healthRes.status}`);

transport.close();
