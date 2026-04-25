cmake_minimum_required(VERSION 3.16)
project(demo_client VERSION 0.1.0)

set(CMAKE_CXX_STANDARD 17)

find_package(Protobuf REQUIRED)
find_package(gRPC REQUIRED)


include_directories(gen)
add_executable(client client.cc gen/demo/v1.pb.cc gen/demo/v1.grpc.pb.cc)
target_link_libraries(client PRIVATE gRPC::grpc++ protobuf::libprotobuf)
