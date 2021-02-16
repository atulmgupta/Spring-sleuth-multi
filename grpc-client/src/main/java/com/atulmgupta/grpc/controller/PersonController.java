package com.atulmgupta.grpc.controller;

import com.atulmgupta.grpc.HelloRequest;
import com.atulmgupta.grpc.HelloResponse;
import com.atulmgupta.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping(value = "/grpc")
@RestController
class PersonController {

    @Autowired
    RestTemplate restTemplate;

    Logger log = LoggerFactory.getLogger(PersonController.class);


    @GetMapping(value = "/test")
    public String test() {
        log.info("Bar service called");
        for (int i = 0; i < 5; i++) {
            makeGrpcCall(i);
        }
        log.info("Foo Service Respose ${result}");
        return "Service is running @ " + System.currentTimeMillis();
    }


    public void makeGrpcCall(int i) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);


        HelloResponse welcomeResponse = stub.welcome(HelloRequest.newBuilder()
                .setFirstName("Atul")
                .setLastName("Gupta")
                .build());


        log.info("Greeting Message " + i + " " + welcomeResponse.getGreeting());
//            System.err.println("Greeting Message " + i + " " + welcomeResponse.getGreeting());

//        HelloResponse helloResponse = stub.hello((HelloRequest.newBuilder())
//                .setFirstName("Atul")
//                .setLastName("Gupta")
//                .build());
////            System.err.println("Greeting Message " + i + " " + helloResponse.getGreeting());
//        log.info("Greeting Message " + i + " " + helloResponse.getGreeting());


        channel.shutdown();
    }

}