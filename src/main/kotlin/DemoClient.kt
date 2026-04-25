import com.google.protobuf.Empty
import demo.v1.DemoServiceGrpcKt
import demo.v1.V1
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val serverAddr = System.getenv("SERVER_ADDR")?.takeIf { it.isNotEmpty() } ?: "server:50051"
    val stripped = serverAddr.removePrefix("http://").removePrefix("https://")
    val host = if (stripped.contains(':')) stripped.substringBeforeLast(':') else stripped
    val port = if (stripped.contains(':')) stripped.substringAfterLast(':').toInt() else 50051

    val channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build()

    val stub = DemoServiceGrpcKt.DemoServiceCoroutineStub(channel)

    val echoResponse = stub.echo(
        V1.EchoRequest.newBuilder().setMessage("hello from kotlin client").build()
    )
    println("Echo response: ${echoResponse.message}")

    val healthResponse = stub.health(Empty.getDefaultInstance())
    println("Health response: ${healthResponse.status}")

    channel.shutdown()
    Unit
}
