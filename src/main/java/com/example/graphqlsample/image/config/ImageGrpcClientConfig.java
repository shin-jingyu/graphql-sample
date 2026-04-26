package com.example.graphqlsample.image.config;

import com.example.graphqlsample.image.proto.ImageServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class ImageGrpcClientConfig {

    @Bean
    ImageServiceGrpc.ImageServiceBlockingStub imageServiceBlockingStub(GrpcChannelFactory channels) {
        return ImageServiceGrpc.newBlockingStub(channels.createChannel("default"));
    }
}
