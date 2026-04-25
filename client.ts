import * as grpc from '@grpc/grpc-js';
import { GrpcTransport } from '@protobuf-ts/grpc-transport';
import { DemoServiceClient } from './gen/demo/v1.client.js';
import { EchoRequest } from './gen/demo/v1.js';
import { Empty } from './gen/google/protobuf/empty.js';

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
