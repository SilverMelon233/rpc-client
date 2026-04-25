import demo.v1.DemoServiceGrpc;
import demo.v1.V1;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DemoClient {
    public static void main(String[] args) throws Exception {
        String serverAddr = System.getenv("SERVER_ADDR");
        if (serverAddr == null || serverAddr.isEmpty()) serverAddr = "server:50051";
        // strip scheme
        serverAddr = serverAddr.replaceFirst("^https?://", "");
        String host = serverAddr.contains(":") ? serverAddr.substring(0, serverAddr.lastIndexOf(':')) : serverAddr;
        int port = serverAddr.contains(":") ? Integer.parseInt(serverAddr.substring(serverAddr.lastIndexOf(':') + 1)) : 50051;

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        DemoServiceGrpc.DemoServiceBlockingV2Stub stub = DemoServiceGrpc.newBlockingV2Stub(channel);

        V1.EchoResponse echoResponse = stub.echo(
                V1.EchoRequest.newBuilder().setMessage("hello from java client").build());
        System.out.println("Echo response: " + echoResponse.getMessage());

        V1.HealthResponse healthResponse = stub.health(com.google.protobuf.Empty.getDefaultInstance());
        System.out.println("Health response: " + healthResponse.getStatus());

        channel.shutdown();
    }
}
