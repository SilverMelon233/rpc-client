#include <iostream>
#include <memory>
#include <string>
#include <cstdlib>

#include "demo/v1.pb.h"
#include <grpcpp/grpcpp.h>
#include "demo/v1.grpc.pb.h"

using grpc::Channel;
using grpc::ClientContext;
using grpc::Status;
using demo::v1::DemoService;
using demo::v1::EchoRequest;
using demo::v1::EchoResponse;
using demo::v1::HealthResponse;
using google::protobuf::Empty;

int main() {
    const char* addr_env = std::getenv("SERVER_ADDR");
    std::string server_addr = addr_env ? addr_env : "localhost:50051";

    auto channel = grpc::CreateChannel(server_addr, grpc::InsecureChannelCredentials());
    auto stub = DemoService::NewStub(channel);

    // Echo
    {
        EchoRequest request;
        request.set_message("hello");
        EchoResponse response;
        ClientContext ctx;
        Status status = stub->Echo(&ctx, request, &response);
        if (!status.ok()) {
            std::cerr << "Echo RPC failed: " << status.error_message() << std::endl;
            return 1;
        }
        std::cout << "Echo response: " << response.message() << std::endl;
    }

    // Health
    {
        Empty request;
        HealthResponse response;
        ClientContext ctx;
        Status status = stub->Health(&ctx, request, &response);
        if (!status.ok()) {
            std::cerr << "Health RPC failed: " << status.error_message() << std::endl;
            return 1;
        }
        std::cout << "Health status: " << response.status() << std::endl;
    }

    return 0;
}
