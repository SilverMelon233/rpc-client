name := "demo-client"
organization := "com.silvermelos233"
version := "0.1.0"
scalaVersion := "3.4.2"


libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % "0.11.20",
  "io.grpc" % "grpc-netty-shaded" % "1.73.0",
  "com.thesamet.scalapb.zio-grpc" %% "zio-grpc-core" % "0.6.3",
  "dev.zio" %% "zio" % "2.1.9",
)

assembly / mainClass := Some("Client")
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
