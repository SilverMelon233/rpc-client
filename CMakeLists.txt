cmake_minimum_required(VERSION 3.16)
project(demo-client VERSION 0.1.0)

set(CMAKE_CXX_STANDARD 17)
set(ABSL_ENABLE_INSTALL ON)
set(ABSL_PROPAGATE_CXX_STD ON)

include(FetchContent)

FetchContent_Declare(gRPC
  GIT_REPOSITORY https://github.com/grpc/grpc.git
  GIT_TAG        v1.76.0
  GIT_SHALLOW    TRUE
)
set(gRPC_BUILD_TESTS OFF)
set(gRPC_BUILD_GRPC_CPP_PLUGIN ON)
FetchContent_MakeAvailable(gRPC)

# Generate proto stubs using fetched protoc
get_target_property(GRPC_CPP_PLUGIN_EXECUTABLE grpc_cpp_plugin LOCATION)
set(PROTO_FILE ${CMAKE_SOURCE_DIR}/proto/demo/v1.proto)
set(GEN_DIR ${CMAKE_BINARY_DIR}/gen)
file(MAKE_DIRECTORY ${GEN_DIR}/demo)

add_custom_command(
  OUTPUT ${GEN_DIR}/demo/v1.pb.cc ${GEN_DIR}/demo/v1.pb.h
         ${GEN_DIR}/demo/v1.grpc.pb.cc ${GEN_DIR}/demo/v1.grpc.pb.h
  COMMAND $<TARGET_FILE:protoc>
    --proto_path=${CMAKE_SOURCE_DIR}/proto
    --cpp_out=${GEN_DIR}
    --grpc_out=${GEN_DIR}
    --plugin=protoc-gen-grpc=${GRPC_CPP_PLUGIN_EXECUTABLE}
    ${PROTO_FILE}
  DEPENDS ${PROTO_FILE} protoc grpc_cpp_plugin
)

add_executable(demo-client
  demo_client.cc
  ${GEN_DIR}/demo/v1.pb.cc
  ${GEN_DIR}/demo/v1.grpc.pb.cc
)
target_include_directories(demo-client PRIVATE ${GEN_DIR})
target_link_libraries(demo-client PRIVATE grpc++ grpc protobuf)
set_target_properties(demo-client PROPERTIES
  LINK_FLAGS "-static -static-libgcc -static-libstdc++")
