name := "scala-client"
organization := "com.example"
version := "0.1.0"
scalaVersion := "3.8.3"

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % "0.11.20",
  "io.grpc"               % "grpc-netty-shaded"    % "1.80.0",
  "com.thesamet.scalapb.zio-grpc" %% "zio-grpc-core" % "0.6.3",
  "dev.zio" %% "zio" % "2.1.25",
)

assembly / mainClass := Some("Client")
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", xs @ _*)                        => MergeStrategy.discard
  case _                                                     => MergeStrategy.first
}
