package demo.v1.v1

object ZioV1 {
  trait GDemoService[-Context, +Error] extends scalapb.zio_grpc.GenericGeneratedService[Context, Error, GDemoService] {
    self =>
    def echo(request: demo.v1.v1.EchoRequest, context: Context): _root_.zio.IO[Error, demo.v1.v1.EchoResponse]
    def health(request: com.google.protobuf.empty.Empty, context: Context): _root_.zio.IO[Error, demo.v1.v1.HealthResponse]
    
    def transform[Context1, Error1](f: scalapb.zio_grpc.GTransform[Context, Error, Context1, Error1]): demo.v1.v1.ZioV1.GDemoService[Context1, Error1] = new demo.v1.v1.ZioV1.GDemoService[Context1, Error1] {
      def echo(request: demo.v1.v1.EchoRequest, context: Context1): _root_.zio.IO[Error1, demo.v1.v1.EchoResponse] = f.effect(self.echo(request, _))(context)
      def health(request: com.google.protobuf.empty.Empty, context: Context1): _root_.zio.IO[Error1, demo.v1.v1.HealthResponse] = f.effect(self.health(request, _))(context)
    }
  }
  
  type ZDemoService[Context] = GDemoService[Context, io.grpc.StatusException]
  type RCDemoService = GDemoService[scalapb.zio_grpc.RequestContext, io.grpc.StatusException]
  
  trait DemoService extends scalapb.zio_grpc.GeneratedService {
    self =>
    type Generic[-C, +E] = GDemoService[C, E]
    def echo(request: demo.v1.v1.EchoRequest): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.EchoResponse]
    def health(request: com.google.protobuf.empty.Empty): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.HealthResponse]
    
    override def asGeneric: GDemoService[Any, io.grpc.StatusException] = new GDemoService[Any, io.grpc.StatusException] {
      def echo(request: demo.v1.v1.EchoRequest, context: Any): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.EchoResponse] = self.echo(request)
      def health(request: com.google.protobuf.empty.Empty, context: Any): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.HealthResponse] = self.health(request)
    }
    def transform(z: scalapb.zio_grpc.Transform): GDemoService[Any, io.grpc.StatusException] = asGeneric.transform(z)
    def transform[C, E](z: scalapb.zio_grpc.GTransform[Any, io.grpc.StatusException, C, E]): GDemoService[C, E] = asGeneric.transform(z)
  }
  
  object DemoService {
    implicit val genericBindable: scalapb.zio_grpc.GenericBindable[demo.v1.v1.ZioV1.DemoService] = new scalapb.zio_grpc.GenericBindable[demo.v1.v1.ZioV1.DemoService] {
      def bind(serviceImpl: demo.v1.v1.ZioV1.DemoService): zio.UIO[_root_.io.grpc.ServerServiceDefinition] = demo.v1.v1.ZioV1.GDemoService.genericBindable.bind(serviceImpl.asGeneric)
    }
  }
  
  object GDemoService {
    implicit val genericBindable: scalapb.zio_grpc.GenericBindable[demo.v1.v1.ZioV1.GDemoService[scalapb.zio_grpc.RequestContext, io.grpc.StatusException]] = new scalapb.zio_grpc.GenericBindable[demo.v1.v1.ZioV1.GDemoService[scalapb.zio_grpc.RequestContext, io.grpc.StatusException]] {
      def bind(serviceImpl: demo.v1.v1.ZioV1.GDemoService[scalapb.zio_grpc.RequestContext, io.grpc.StatusException]): zio.UIO[_root_.io.grpc.ServerServiceDefinition] =
        zio.ZIO.runtime[Any].map {
          runtime =>
            _root_.io.grpc.ServerServiceDefinition.builder(demo.v1.v1.DemoServiceGrpc.SERVICE)
            .addMethod(
              demo.v1.v1.DemoServiceGrpc.METHOD_ECHO,
              _root_.scalapb.zio_grpc.server.ZServerCallHandler.unaryCallHandler(runtime, serviceImpl.echo(_, _))
            )
            .addMethod(
              demo.v1.v1.DemoServiceGrpc.METHOD_HEALTH,
              _root_.scalapb.zio_grpc.server.ZServerCallHandler.unaryCallHandler(runtime, serviceImpl.health(_, _))
            )
            .build()
        }
      }
  }
  
  
  // accessor methods
  class DemoServiceAccessors(transforms: scalapb.zio_grpc.ClientTransform = scalapb.zio_grpc.ClientTransform.identity) extends scalapb.zio_grpc.GeneratedClient[DemoServiceAccessors] {
    def this(callOptionsFunc: io.grpc.CallOptions => io.grpc.CallOptions, metadataFunc: scalapb.zio_grpc.SafeMetadata => zio.UIO[scalapb.zio_grpc.SafeMetadata]) = this(scalapb.zio_grpc.ClientTransform.mapCallOptions(callOptionsFunc).andThen(scalapb.zio_grpc.ClientTransform.mapMetadataZIO(metadataFunc)))
    def echo(request: demo.v1.v1.EchoRequest): _root_.zio.ZIO[DemoServiceClient, io.grpc.StatusException, demo.v1.v1.EchoResponse] = _root_.zio.ZIO.serviceWithZIO[DemoServiceClient](_.transform(transforms).echo(request))
    def health(request: com.google.protobuf.empty.Empty): _root_.zio.ZIO[DemoServiceClient, io.grpc.StatusException, demo.v1.v1.HealthResponse] = _root_.zio.ZIO.serviceWithZIO[DemoServiceClient](_.transform(transforms).health(request))
    override def transform(t: scalapb.zio_grpc.ClientTransform): DemoServiceAccessors = new DemoServiceAccessors(transforms.andThen(t))
  }
  
  trait DemoServiceClient extends scalapb.zio_grpc.GeneratedClient[DemoServiceClient] {
    self =>
    def echo(request: demo.v1.v1.EchoRequest): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.EchoResponse]
    def health(request: com.google.protobuf.empty.Empty): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.HealthResponse]
    
    // Returns a client that gives access to headers and trailers from server's response
    def withResponseMetadata: DemoServiceClientWithResponseMetadata
  }
  
  object DemoServiceClient extends DemoServiceAccessors {
    
    private class ServiceStub(underlying: DemoServiceClientWithResponseMetadata)
        extends DemoServiceClient {
      def echo(request: demo.v1.v1.EchoRequest): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.EchoResponse] = underlying.echo(request).map(_.response)
      def health(request: com.google.protobuf.empty.Empty): _root_.zio.IO[io.grpc.StatusException, demo.v1.v1.HealthResponse] = underlying.health(request).map(_.response)
      // Returns a client that gives access to headers and trailers from server's response
      def withResponseMetadata: DemoServiceClientWithResponseMetadata = underlying
      override def transform(t: scalapb.zio_grpc.ClientTransform): DemoServiceClient = new ServiceStub(underlying.transform(t))
    }
    
    def scoped(managedChannel: scalapb.zio_grpc.ZManagedChannel, transforms: scalapb.zio_grpc.ClientTransform): zio.ZIO[zio.Scope, Throwable, DemoServiceClient] =
      DemoServiceClientWithResponseMetadata.scoped(managedChannel, transforms).map(client => new ServiceStub(client))
    def scoped(managedChannel: scalapb.zio_grpc.ZManagedChannel, options: io.grpc.CallOptions = io.grpc.CallOptions.DEFAULT, metadata: zio.UIO[scalapb.zio_grpc.SafeMetadata]=scalapb.zio_grpc.SafeMetadata.make): zio.ZIO[zio.Scope, Throwable, DemoServiceClient] =
      DemoServiceClient.scoped(managedChannel, scalapb.zio_grpc.ClientTransform.withCallOptions(options).andThen(scalapb.zio_grpc.ClientTransform.withMetadataZIO(metadata)))
    
    def live(managedChannel: scalapb.zio_grpc.ZManagedChannel, transforms: scalapb.zio_grpc.ClientTransform): zio.ZLayer[Any, Throwable, DemoServiceClient] =
      DemoServiceClientWithResponseMetadata.live(managedChannel, transforms).map(clientEnv => zio.ZEnvironment(new ServiceStub(clientEnv.get)))
    def live(managedChannel: scalapb.zio_grpc.ZManagedChannel, options: io.grpc.CallOptions=io.grpc.CallOptions.DEFAULT, metadata: zio.UIO[scalapb.zio_grpc.SafeMetadata] = scalapb.zio_grpc.SafeMetadata.make): zio.ZLayer[Any, Throwable, DemoServiceClient] =
      DemoServiceClient.live(managedChannel, scalapb.zio_grpc.ClientTransform.withCallOptions(options).andThen(scalapb.zio_grpc.ClientTransform.withMetadataZIO(metadata)))
  }
  
  // accessor with metadata methods
  class DemoServiceWithResponseMetadataAccessors(transforms: scalapb.zio_grpc.ClientTransform = scalapb.zio_grpc.ClientTransform.identity) extends scalapb.zio_grpc.GeneratedClient[DemoServiceWithResponseMetadataAccessors] {
    def this(callOptionsFunc: io.grpc.CallOptions => io.grpc.CallOptions, metadataFunc: scalapb.zio_grpc.SafeMetadata => zio.UIO[scalapb.zio_grpc.SafeMetadata]) = this(scalapb.zio_grpc.ClientTransform.mapCallOptions(callOptionsFunc).andThen(scalapb.zio_grpc.ClientTransform.mapMetadataZIO(metadataFunc)))
    def echo(request: demo.v1.v1.EchoRequest): _root_.zio.ZIO[DemoServiceClientWithResponseMetadata, io.grpc.StatusException, scalapb.zio_grpc.ResponseContext[demo.v1.v1.EchoResponse]] = _root_.zio.ZIO.serviceWithZIO[DemoServiceClientWithResponseMetadata](_.transform(transforms).echo(request))
    def health(request: com.google.protobuf.empty.Empty): _root_.zio.ZIO[DemoServiceClientWithResponseMetadata, io.grpc.StatusException, scalapb.zio_grpc.ResponseContext[demo.v1.v1.HealthResponse]] = _root_.zio.ZIO.serviceWithZIO[DemoServiceClientWithResponseMetadata](_.transform(transforms).health(request))
    override def transform(t: scalapb.zio_grpc.ClientTransform): DemoServiceWithResponseMetadataAccessors = new DemoServiceWithResponseMetadataAccessors(transforms.andThen(t))
  }
  
  trait DemoServiceClientWithResponseMetadata extends scalapb.zio_grpc.GeneratedClient[DemoServiceClientWithResponseMetadata] {
    self =>
    def echo(request: demo.v1.v1.EchoRequest): _root_.zio.IO[io.grpc.StatusException, scalapb.zio_grpc.ResponseContext[demo.v1.v1.EchoResponse]]
    def health(request: com.google.protobuf.empty.Empty): _root_.zio.IO[io.grpc.StatusException, scalapb.zio_grpc.ResponseContext[demo.v1.v1.HealthResponse]]
  }
  
  object DemoServiceClientWithResponseMetadata extends DemoServiceWithResponseMetadataAccessors {
    private class ServiceStub(channel: scalapb.zio_grpc.ZChannel, transforms: scalapb.zio_grpc.ClientTransform)
        extends DemoServiceClientWithResponseMetadata {
      def echo(request: demo.v1.v1.EchoRequest): _root_.zio.IO[io.grpc.StatusException, scalapb.zio_grpc.ResponseContext[demo.v1.v1.EchoResponse]] =
        scalapb.zio_grpc.SafeMetadata.make.flatMap { metadata =>
          transforms.effect { context => 
            scalapb.zio_grpc.client.ClientCalls.withMetadata.unaryCall[demo.v1.v1.EchoRequest, demo.v1.v1.EchoResponse](
              channel,
              context.method.asInstanceOf[io.grpc.MethodDescriptor[demo.v1.v1.EchoRequest, demo.v1.v1.EchoResponse]],
              context.options,
              context.metadata,
              request
            )
          }(scalapb.zio_grpc.ClientCallContext(demo.v1.v1.DemoServiceGrpc.METHOD_ECHO, io.grpc.CallOptions.DEFAULT, metadata))
        }
      def health(request: com.google.protobuf.empty.Empty): _root_.zio.IO[io.grpc.StatusException, scalapb.zio_grpc.ResponseContext[demo.v1.v1.HealthResponse]] =
        scalapb.zio_grpc.SafeMetadata.make.flatMap { metadata =>
          transforms.effect { context => 
            scalapb.zio_grpc.client.ClientCalls.withMetadata.unaryCall[com.google.protobuf.empty.Empty, demo.v1.v1.HealthResponse](
              channel,
              context.method.asInstanceOf[io.grpc.MethodDescriptor[com.google.protobuf.empty.Empty, demo.v1.v1.HealthResponse]],
              context.options,
              context.metadata,
              request
            )
          }(scalapb.zio_grpc.ClientCallContext(demo.v1.v1.DemoServiceGrpc.METHOD_HEALTH, io.grpc.CallOptions.DEFAULT, metadata))
        }
      override def transform(t: scalapb.zio_grpc.ClientTransform): DemoServiceClientWithResponseMetadata = new ServiceStub(channel, transforms.compose(t))
    }
    
    def scoped(managedChannel: scalapb.zio_grpc.ZManagedChannel, transforms: scalapb.zio_grpc.ClientTransform): zio.ZIO[zio.Scope, Throwable, DemoServiceClientWithResponseMetadata] = managedChannel.map {
      channel => new ServiceStub(channel, transforms)
    }
    def scoped(managedChannel: scalapb.zio_grpc.ZManagedChannel, options: io.grpc.CallOptions = io.grpc.CallOptions.DEFAULT, metadata: zio.UIO[scalapb.zio_grpc.SafeMetadata]=scalapb.zio_grpc.SafeMetadata.make): zio.ZIO[zio.Scope, Throwable, DemoServiceClientWithResponseMetadata] =
      scoped(managedChannel, scalapb.zio_grpc.ClientTransform.withCallOptions(options).andThen(scalapb.zio_grpc.ClientTransform.withMetadataZIO(metadata)))
    
    def live[Context](managedChannel: scalapb.zio_grpc.ZManagedChannel, transforms: scalapb.zio_grpc.ClientTransform): zio.ZLayer[Any, Throwable, DemoServiceClientWithResponseMetadata] =
      zio.ZLayer.scoped(scoped(managedChannel, transforms))
    def live[Context](managedChannel: scalapb.zio_grpc.ZManagedChannel, options: io.grpc.CallOptions=io.grpc.CallOptions.DEFAULT, metadata: zio.UIO[scalapb.zio_grpc.SafeMetadata] = scalapb.zio_grpc.SafeMetadata.make): zio.ZLayer[Any, Throwable, DemoServiceClientWithResponseMetadata] =
      zio.ZLayer.scoped(scoped(managedChannel, options, metadata))
  }
}