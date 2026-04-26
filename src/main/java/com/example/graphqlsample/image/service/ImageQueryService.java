package com.example.graphqlsample.image.service;

import com.example.graphqlsample.image.graphql.dto.ImageQueryDto.Response;
import com.example.graphqlsample.image.proto.GetImageMetadataRequest;
import com.example.graphqlsample.image.proto.ImageServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageQueryService {

    private final ImageServiceGrpc.ImageServiceBlockingStub imageServiceBlockingStub;

    public Response getImageMetadata(String imageId) {
        var response = imageServiceBlockingStub.getImageMetadata(
                GetImageMetadataRequest.newBuilder()
                        .setImageId(imageId)
                        .build()
        );

        return new Response(
                response.getImageId(),
                response.getOriginalFileName(),
                response.getContentType(),
                response.getSize(),
                response.getDownloadUrl()
        );
    }
}
