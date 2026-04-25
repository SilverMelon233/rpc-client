package demo.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DemoServiceGrpc {

  private DemoServiceGrpc() throws io.grpc.StatusException {}

  public static final java.lang.String SERVICE_NAME = "demo.v1.DemoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<demo.v1.V1.EchoRequest,
      demo.v1.V1.EchoResponse> getEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Echo",
      requestType = demo.v1.V1.EchoRequest.class,
      responseType = demo.v1.V1.EchoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<demo.v1.V1.EchoRequest,
      demo.v1.V1.EchoResponse> getEchoMethod() throws io.grpc.StatusException {
    io.grpc.MethodDescriptor<demo.v1.V1.EchoRequest, demo.v1.V1.EchoResponse> getEchoMethod;
    if ((getEchoMethod = DemoServiceGrpc.getEchoMethod) == null) throws io.grpc.StatusException {
      synchronized (DemoServiceGrpc.class) throws io.grpc.StatusException {
        if ((getEchoMethod = DemoServiceGrpc.getEchoMethod) == null) throws io.grpc.StatusException {
          DemoServiceGrpc.getEchoMethod = getEchoMethod =
              io.grpc.MethodDescriptor.<demo.v1.V1.EchoRequest, demo.v1.V1.EchoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Echo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  demo.v1.V1.EchoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  demo.v1.V1.EchoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DemoServiceMethodDescriptorSupplier("Echo"))
              .build();
        }
      }
    }
    return getEchoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      demo.v1.V1.HealthResponse> getHealthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Health",
      requestType = com.google.protobuf.Empty.class,
      responseType = demo.v1.V1.HealthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      demo.v1.V1.HealthResponse> getHealthMethod() throws io.grpc.StatusException {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, demo.v1.V1.HealthResponse> getHealthMethod;
    if ((getHealthMethod = DemoServiceGrpc.getHealthMethod) == null) throws io.grpc.StatusException {
      synchronized (DemoServiceGrpc.class) throws io.grpc.StatusException {
        if ((getHealthMethod = DemoServiceGrpc.getHealthMethod) == null) throws io.grpc.StatusException {
          DemoServiceGrpc.getHealthMethod = getHealthMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, demo.v1.V1.HealthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Health"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  demo.v1.V1.HealthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DemoServiceMethodDescriptorSupplier("Health"))
              .build();
        }
      }
    }
    return getHealthMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DemoServiceStub newStub(io.grpc.Channel channel) throws io.grpc.StatusException {
    io.grpc.stub.AbstractStub.StubFactory<DemoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemoServiceStub>() throws io.grpc.StatusException {
        @java.lang.Override
        public DemoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
          return new DemoServiceStub(channel, callOptions);
        }
      };
    return DemoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static DemoServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) throws io.grpc.StatusException {
    io.grpc.stub.AbstractStub.StubFactory<DemoServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemoServiceBlockingV2Stub>() throws io.grpc.StatusException {
        @java.lang.Override
        public DemoServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
          return new DemoServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return DemoServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DemoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) throws io.grpc.StatusException {
    io.grpc.stub.AbstractStub.StubFactory<DemoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemoServiceBlockingStub>() throws io.grpc.StatusException {
        @java.lang.Override
        public DemoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
          return new DemoServiceBlockingStub(channel, callOptions);
        }
      };
    return DemoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DemoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) throws io.grpc.StatusException {
    io.grpc.stub.AbstractStub.StubFactory<DemoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemoServiceFutureStub>() throws io.grpc.StatusException {
        @java.lang.Override
        public DemoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
          return new DemoServiceFutureStub(channel, callOptions);
        }
      };
    return DemoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Echo a message back to the caller.
     * </pre>
     */
    default void echo(demo.v1.V1.EchoRequest request,
        io.grpc.stub.StreamObserver<demo.v1.V1.EchoResponse> responseObserver) throws io.grpc.StatusException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return the current health status of this service.
     * </pre>
     */
    default void health(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<demo.v1.V1.HealthResponse> responseObserver) throws io.grpc.StatusException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DemoService.
   */
  public static abstract class DemoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() throws io.grpc.StatusException {
      return DemoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DemoService.
   */
  public static final class DemoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DemoServiceStub> {
    private DemoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      return new DemoServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Echo a message back to the caller.
     * </pre>
     */
    public void echo(demo.v1.V1.EchoRequest request,
        io.grpc.stub.StreamObserver<demo.v1.V1.EchoResponse> responseObserver) throws io.grpc.StatusException {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return the current health status of this service.
     * </pre>
     */
    public void health(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<demo.v1.V1.HealthResponse> responseObserver) throws io.grpc.StatusException {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DemoService.
   */
  public static final class DemoServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DemoServiceBlockingV2Stub> {
    private DemoServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      return new DemoServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Echo a message back to the caller.
     * </pre>
     */
    public demo.v1.V1.EchoResponse echo(demo.v1.V1.EchoRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEchoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the current health status of this service.
     * </pre>
     */
    public demo.v1.V1.HealthResponse health(com.google.protobuf.Empty request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getHealthMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DemoService.
   */
  public static final class DemoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DemoServiceBlockingStub> {
    private DemoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      return new DemoServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Echo a message back to the caller.
     * </pre>
     */
    public demo.v1.V1.EchoResponse echo(demo.v1.V1.EchoRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEchoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the current health status of this service.
     * </pre>
     */
    public demo.v1.V1.HealthResponse health(com.google.protobuf.Empty request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getHealthMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DemoService.
   */
  public static final class DemoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DemoServiceFutureStub> {
    private DemoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) throws io.grpc.StatusException {
      return new DemoServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Echo a message back to the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<demo.v1.V1.EchoResponse> echo(
        demo.v1.V1.EchoRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return the current health status of this service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<demo.v1.V1.HealthResponse> health(
        com.google.protobuf.Empty request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO = 0;
  private static final int METHODID_HEALTH = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) throws io.grpc.StatusException {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) throws io.grpc.StatusException {
      switch (methodId) throws io.grpc.StatusException {
        case METHODID_ECHO:
          serviceImpl.echo((demo.v1.V1.EchoRequest) request,
              (io.grpc.stub.StreamObserver<demo.v1.V1.EchoResponse>) responseObserver);
          break;
        case METHODID_HEALTH:
          serviceImpl.health((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<demo.v1.V1.HealthResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) throws io.grpc.StatusException {
      switch (methodId) throws io.grpc.StatusException {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) throws io.grpc.StatusException {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getEchoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              demo.v1.V1.EchoRequest,
              demo.v1.V1.EchoResponse>(
                service, METHODID_ECHO)))
        .addMethod(
          getHealthMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              demo.v1.V1.HealthResponse>(
                service, METHODID_HEALTH)))
        .build();
  }

  private static abstract class DemoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DemoServiceBaseDescriptorSupplier() throws io.grpc.StatusException {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() throws io.grpc.StatusException {
      return demo.v1.V1.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() throws io.grpc.StatusException {
      return getFileDescriptor().findServiceByName("DemoService");
    }
  }

  private static final class DemoServiceFileDescriptorSupplier
      extends DemoServiceBaseDescriptorSupplier {
    DemoServiceFileDescriptorSupplier() throws io.grpc.StatusException {}
  }

  private static final class DemoServiceMethodDescriptorSupplier
      extends DemoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DemoServiceMethodDescriptorSupplier(java.lang.String methodName) throws io.grpc.StatusException {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() throws io.grpc.StatusException {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() throws io.grpc.StatusException {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) throws io.grpc.StatusException {
      synchronized (DemoServiceGrpc.class) throws io.grpc.StatusException {
        result = serviceDescriptor;
        if (result == null) throws io.grpc.StatusException {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DemoServiceFileDescriptorSupplier())
              .addMethod(getEchoMethod())
              .addMethod(getHealthMethod())
              .build();
        }
      }
    }
    return result;
  }
}
