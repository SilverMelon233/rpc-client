<?php
require __DIR__ . '/vendor/autoload.php';

use Demo\V1\DemoServiceClient;
use Demo\V1\EchoRequest;
use Google\Protobuf\GPBEmpty;

$serverAddr = getenv('SERVER_ADDR') ?: 'localhost:50051';

$client = new DemoServiceClient($serverAddr, [
    'credentials' => Grpc\ChannelCredentials::createInsecure(),
]);

// Echo
$echoRequest = new EchoRequest();
$echoRequest->setMessage('hello');
[$echoResponse, $status] = $client->Echo($echoRequest)->wait();
if ($status->code !== Grpc\STATUS_OK) {
    echo "Echo RPC failed: {$status->details}\n";
    exit(1);
}
echo "Echo response: " . $echoResponse->getMessage() . "\n";

// Health
$emptyRequest = new GPBEmpty();
[$healthResponse, $status] = $client->Health($emptyRequest)->wait();
if ($status->code !== Grpc\STATUS_OK) {
    echo "Health RPC failed: {$status->details}\n";
    exit(1);
}
echo "Health status: " . $healthResponse->getStatus() . "\n";
