use demo_stub::demo::v1::{
    demo_service_client::DemoServiceClient,
    EchoRequest,
};
use std::env;

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let addr = env::var("SERVER_ADDR").unwrap_or_else(|_| "http://server:50051".to_string());

    let mut client = DemoServiceClient::connect(addr).await?;

    let echo_resp = client
        .echo(tonic::Request::new(EchoRequest {
            message: "Hello from Rust!".to_string(),
        }))
        .await?;
    println!("Echo response: {}", echo_resp.into_inner().message);

    let health_resp = client.health(tonic::Request::new(())).await?;
    println!("Health response: {}", health_resp.into_inner().status);

    Ok(())
}
