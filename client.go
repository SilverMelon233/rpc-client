package main

import (
	"context"
	"log"
	"os"
	"time"

	demov1 "github.com/SilverMelon233/rpc-stub/gen/demo"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"google.golang.org/protobuf/types/known/emptypb"
)

func main() {
	addr := os.Getenv("SERVER_ADDR")
	if addr == "" {
		addr = "server:50051"
	}

	conn, err := grpc.NewClient(addr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatalf("failed to connect: %v", err)
	}
	defer conn.Close()

	client := demov1.NewDemoServiceClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()

	echoResp, err := client.Echo(ctx, &demov1.EchoRequest{Message: "Hello from Go!"})
	if err != nil {
		log.Fatalf("Echo failed: %v", err)
	}
	log.Printf("Echo response: %s", echoResp.GetMessage())

	healthResp, err := client.Health(ctx, &emptypb.Empty{})
	if err != nil {
		log.Fatalf("Health failed: %v", err)
	}
	log.Printf("Health response: %s", healthResp.GetStatus())
}
