package com.example.graphqlsample.image.graphql.dto;

public final class ImageQueryDto {

    private ImageQueryDto() {
    }

    public record Response(
            String imageId,
            String originalFileName,
            String contentType,
            Long size,
            String downloadUrl
    ) {
    }
}
