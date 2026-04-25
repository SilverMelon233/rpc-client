plugins {
    kotlin("jvm") version "2.0.21"
    application
    id("com.gradleup.shadow") version "9.0.0-beta9"
}
group = "com.silvermelos233"
repositories {
    mavenCentral()
    }
dependencies {
    implementation("io.grpc:grpc-netty-shaded:1.73.0")
    implementation("io.grpc:grpc-protobuf:1.73.0")
    implementation("io.grpc:grpc-kotlin-stub:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")
}
application {
    mainClass.set("ClientKt")
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "ClientKt"
    }
}
