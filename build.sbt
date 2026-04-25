name := "demo-client"
organization := "com.example"
version := "0.1.0"
scalaVersion := "3.8.3"

libraryDependencies ++= Seq(
  "com.thesamet.scalapb"          %% "scalapb-runtime-grpc" % "0.11.20",
  "io.grpc"                        % "grpc-netty"            % "1.80.0",
  "com.thesamet.scalapb.zio-grpc" %% "zio-grpc-core"        % "0.6.3",
  "dev.zio"                       %% "zio"                   % "2.1.25",
)

assembly / mainClass := Some("DemoClient")
assembly / assemblyMergeStrategy := {
  // services 文件必须合并（filterDistinctLines 追加去重），不能 discard
  case PathList("META-INF", "services", _*)                 => MergeStrategy.filterDistinctLines
  case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _*)                             => MergeStrategy.discard
  case _                                                     => MergeStrategy.first
}
