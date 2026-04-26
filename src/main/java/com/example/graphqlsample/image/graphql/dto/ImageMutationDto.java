package com.example.graphqlsample.image.graphql.dto;

import jakarta.validation.constraints.NotBlank;

public final class ImageMutationDto {

    private ImageMutationDto() {
    }

    public record CreateUploadRequest(
            @NotBlank(message = "원본 파일명은 필수입니다.")
            String originalFileName,
            @NotBlank(message = "콘텐츠 타입은 필수입니다.")
            String contentType
    ) {
    }

    public record CreateUploadResponse(
            String imageId,
            String uploadUrl
    ) {
    }
}
