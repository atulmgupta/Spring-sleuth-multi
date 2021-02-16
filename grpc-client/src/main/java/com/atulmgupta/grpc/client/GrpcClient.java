package com.atulmgupta.grpc.client;

import com.atulmgupta.grpc.HelloRequest;
import com.atulmgupta.grpc.HelloResponse;
import com.atulmgupta.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        for (int i = 0; i < 10; i++) {

            HelloResponse welcomeResponse = stub.welcome(HelloRequest.newBuilder()
                    .setFirstName("Atul")
                    .setLastName("Gupta")
                    .build());

            System.err.println("Greeting Message " + i + " " + welcomeResponse.getGreeting());

//            HelloResponse helloResponse = stub.hello((HelloRequest.newBuilder())
//                    .setFirstName("Atul")
//                    .setLastName("Gupta")
//                    .build());
//            System.err.println("Greeting Message " + i + " " + helloResponse.getGreeting());
        }


        channel.shutdown();
    }


}
