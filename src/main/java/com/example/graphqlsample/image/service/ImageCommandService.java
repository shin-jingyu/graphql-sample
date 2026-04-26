package com.example.graphqlsample.image.service;

import com.example.graphqlsample.image.graphql.dto.ImageMutationDto.CreateUploadResponse;
import com.example.graphqlsample.image.proto.CreateImageUploadRequest;
import com.example.graphqlsample.image.proto.DeleteImageRequest;
import com.example.graphqlsample.image.proto.ImageServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageCommandService {

    private final ImageServiceGrpc.ImageServiceBlockingStub imageServiceBlockingStub;

    public CreateUploadResponse createImageUpload(String originalFileName, String contentType) {
        var response = imageServiceBlockingStub.createImageUpload(
                CreateImageUploadRequest.newBuilder()
                        .setOriginalFileName(originalFileName)
                        .setContentType(contentType)
                        .build()
        );

        return new CreateUploadResponse(response.getImageId(), response.getUploadUrl());
    }

    public void deleteImage(String imageId) {
        imageServiceBlockingStub.deleteImage(
                DeleteImageRequest.newBuilder()
                        .setImageId(imageId)
                        .build()
        );
    }
}
