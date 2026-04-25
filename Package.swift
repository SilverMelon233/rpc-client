// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "demo-client",
    dependencies: [
        .package(url: "https://github.com/grpc/grpc-swift.git", from: "1.27.5"),
        .package(url: "https://github.com/apple/swift-protobuf.git", from: "1.37.0"),
    ],
    targets: [
        .executableTarget(
            name: "demo-client",
            dependencies: [
                .product(name: "GRPC", package: "grpc-swift"),
                .product(name: "SwiftProtobuf", package: "swift-protobuf"),
            ],
            path: "Sources"
        )
    ]
)
