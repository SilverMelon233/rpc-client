// This is a generated file - do not edit.
//
// Generated from demo/v1.proto.

// @dart = 3.3

// ignore_for_file: annotate_overrides, camel_case_types, comment_references
// ignore_for_file: constant_identifier_names
// ignore_for_file: curly_braces_in_flow_control_structures
// ignore_for_file: deprecated_member_use_from_same_package, library_prefixes
// ignore_for_file: non_constant_identifier_names, prefer_relative_imports

import 'dart:async' as $async;
import 'dart:core' as $core;

import 'package:grpc/service_api.dart' as $grpc;
import 'package:protobuf/protobuf.dart' as $pb;
import 'package:protobuf/well_known_types/google/protobuf/empty.pb.dart' as $1;

import 'v1.pb.dart' as $0;

export 'v1.pb.dart';

@$pb.GrpcServiceName('demo.v1.DemoService')
class DemoServiceClient extends $grpc.Client {
  /// The hostname for this service.
  static const $core.String defaultHost = '';

  /// OAuth scopes needed for the client.
  static const $core.List<$core.String> oauthScopes = [
    '',
  ];

  DemoServiceClient(super.channel, {super.options, super.interceptors});

  /// Echo a message back to the caller.
  $grpc.ResponseFuture<$0.EchoResponse> echo(
    $0.EchoRequest request, {
    $grpc.CallOptions? options,
  }) {
    return $createUnaryCall(_$echo, request, options: options);
  }

  /// Return the current health status of this service.
  $grpc.ResponseFuture<$0.HealthResponse> health(
    $1.Empty request, {
    $grpc.CallOptions? options,
  }) {
    return $createUnaryCall(_$health, request, options: options);
  }

  // method descriptors

  static final _$echo = $grpc.ClientMethod<$0.EchoRequest, $0.EchoResponse>(
      '/demo.v1.DemoService/Echo',
      ($0.EchoRequest value) => value.writeToBuffer(),
      $0.EchoResponse.fromBuffer);
  static final _$health = $grpc.ClientMethod<$1.Empty, $0.HealthResponse>(
      '/demo.v1.DemoService/Health',
      ($1.Empty value) => value.writeToBuffer(),
      $0.HealthResponse.fromBuffer);
}

@$pb.GrpcServiceName('demo.v1.DemoService')
abstract class DemoServiceBase extends $grpc.Service {
  $core.String get $name => 'demo.v1.DemoService';

  DemoServiceBase() {
    $addMethod($grpc.ServiceMethod<$0.EchoRequest, $0.EchoResponse>(
        'Echo',
        echo_Pre,
        false,
        false,
        ($core.List<$core.int> value) => $0.EchoRequest.fromBuffer(value),
        ($0.EchoResponse value) => value.writeToBuffer()));
    $addMethod($grpc.ServiceMethod<$1.Empty, $0.HealthResponse>(
        'Health',
        health_Pre,
        false,
        false,
        ($core.List<$core.int> value) => $1.Empty.fromBuffer(value),
        ($0.HealthResponse value) => value.writeToBuffer()));
  }

  $async.Future<$0.EchoResponse> echo_Pre(
      $grpc.ServiceCall $call, $async.Future<$0.EchoRequest> $request) async {
    return echo($call, await $request);
  }

  $async.Future<$0.EchoResponse> echo(
      $grpc.ServiceCall call, $0.EchoRequest request);

  $async.Future<$0.HealthResponse> health_Pre(
      $grpc.ServiceCall $call, $async.Future<$1.Empty> $request) async {
    return health($call, await $request);
  }

  $async.Future<$0.HealthResponse> health(
      $grpc.ServiceCall call, $1.Empty request);
}
