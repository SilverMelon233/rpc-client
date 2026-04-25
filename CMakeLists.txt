cmake_minimum_required(VERSION 3.16)
project(demo-client VERSION 0.1.0)

set(CMAKE_CXX_STANDARD 17)

find_package(PkgConfig REQUIRED)
pkg_check_modules(GRPC REQUIRED grpc++)
pkg_check_modules(PROTOBUF REQUIRED protobuf)

include_directories(gen ${GRPC_INCLUDE_DIRS} ${PROTOBUF_INCLUDE_DIRS})
add_executable(demo-client demo_client.cc gen/demo/v1.pb.cc gen/demo/v1.grpc.pb.cc)
target_link_libraries(demo-client PRIVATE ${GRPC_LIBRARIES} ${PROTOBUF_LIBRARIES})
target_link_directories(demo-client PRIVATE ${GRPC_LIBRARY_DIRS} ${PROTOBUF_LIBRARY_DIRS})
