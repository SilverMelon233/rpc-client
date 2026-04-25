import demo.v1.DemoServiceGrpc;
import demo.v1.V1;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DemoClient {
    public static void main(String[] args) throws Exception {
        String serverAddr = System.getenv("SERVER_ADDR");
        if (serverAddr == null || serverAddr.isEmpty()) serverAddr = "server:50051";
        serverAddr = serverAddr.replaceFirst("^https?://", "");
        String host = serverAddr.contains(":") ? serverAddr.substring(0, serverAddr.lastIndexOf(':')) : serverAddr;
        int port = serverAddr.contains(":") ? Integer.parseInt(serverAddr.substring(serverAddr.lastIndexOf(':') + 1)) : 50051;

        // grpc-java 1.80 may resolve hostnames with '-' as unix sockets.
        // Setting defaultServiceConfig overrides the resolver to use pick_first/round_robin.
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .defaultLoadBalancingPolicy("pick_first")
                .build();

        DemoServiceGrpc.DemoServiceBlockingV2Stub stub = DemoServiceGrpc.newBlockingV2Stub(channel);

        V1.EchoResponse echoRes = stub.echo(V1.EchoRequest.newBuilder().setMessage("hello from java client").build());
        System.out.println("Echo response: " + echoRes.getMessage());

        V1.HealthResponse healthRes = stub.health(com.google.protobuf.Empty.getDefaultInstance());
        System.out.println("Health response: " + healthRes.getStatus());

        channel.shutdown();
    }
}
