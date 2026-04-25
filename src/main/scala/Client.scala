import demo.v1.v1.ZioV1
import demo.v1.v1.{EchoRequest, HealthResponse}
import com.google.protobuf.empty.Empty
import scalapb.zio_grpc.ZManagedChannel
import io.grpc.ManagedChannelBuilder
import zio.*

object Client extends ZIOAppDefault:
  def run =
    val serverAddr = sys.env.getOrElse("SERVER_ADDR", "server:50051")
    val stripped = serverAddr.stripPrefix("http://").stripPrefix("https://")
    val (host, port) =
      if stripped.contains(':') then
        val parts = stripped.split(':')
        (parts(0), parts(1).toInt)
      else
        (stripped, 50051)

    val channel = ZManagedChannel(
      ManagedChannelBuilder.forAddress(host, port).usePlaintext()
    )

    ZIO.scoped {
      ZioV1.DemoServiceClient.scoped(channel).flatMap { client =>
        for
          echoResp   <- client.echo(EchoRequest(message = "hello from scala client"))
          _          <- Console.printLine(s"Echo response: ${echoResp.message}")
          healthResp <- client.health(Empty())
          _          <- Console.printLine(s"Health response: ${healthResp.status}")
        yield ()
      }
    }
