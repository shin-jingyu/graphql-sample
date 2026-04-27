package com.example.graphqlsample.image.service;

import com.example.graphqlsample.image.proto.DeleteImageRequest;
import com.example.graphqlsample.image.proto.ImageServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageCommandService {

    private final ImageServiceGrpc.ImageServiceBlockingStub imageServiceBlockingStub;

    public void deleteImage(String imageId) {
        imageServiceBlockingStub.deleteImage(
                DeleteImageRequest.newBuilder()
                        .setImageId(imageId)
                        .build()
        );
    }
}
