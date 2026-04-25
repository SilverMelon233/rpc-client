plugins {
    kotlin("jvm") version "2.3.21"
    application
    id("com.gradleup.shadow") version "9.4.1"
}
group = "com.example"
repositories { mavenCentral() }
dependencies {
    implementation("io.grpc:grpc-netty-shaded:1.80.0")
    implementation("io.grpc:grpc-stub:1.80.0")
    implementation("io.grpc:grpc-protobuf:1.80.0")
    implementation("io.grpc:grpc-kotlin-stub:1.5.0")
    implementation("com.google.protobuf:protobuf-java:4.34.1")
    implementation("com.google.protobuf:protobuf-kotlin:4.34.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")
}
application {
    mainClass.set("ServerKt")
}
