cmake_minimum_required(VERSION 3.16)
project(demo_client VERSION 0.1.0)

set(CMAKE_CXX_STANDARD 17)

find_package(Protobuf REQUIRED)
find_package(gRPC REQUIRED)

include(FetchContent)
FetchContent_Declare(rpc_stub
  GIT_REPOSITORY https://github.com/SilverMelon233/rpc-stub.git
  GIT_TAG        cpp
  GIT_TAG main
  SOURCE_SUBDIR cpp
)
FetchContent_MakeAvailable(rpc_stub)

add_executable(client client.cc)
target_link_libraries(client PRIVATE demo_stub gRPC::grpc++ protobuf::libprotobuf)
