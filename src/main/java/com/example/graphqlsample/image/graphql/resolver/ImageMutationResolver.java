package com.example.graphqlsample.image.graphql.resolver;

import com.example.graphqlsample.image.graphql.dto.ImageMutationDto.CreateUploadRequest;
import com.example.graphqlsample.image.graphql.dto.ImageMutationDto.CreateUploadResponse;
import com.example.graphqlsample.image.service.ImageCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
@RequiredArgsConstructor
public class ImageMutationResolver {

    private final ImageCommandService imageCommandService;

    @MutationMapping
    public CreateUploadResponse createImageUpload(@Argument("input") @Valid CreateUploadRequest input) {
        return imageCommandService.createImageUpload(input.originalFileName(), input.contentType());
    }

    @MutationMapping
    public Boolean deleteImage(@Argument String imageId) {
        imageCommandService.deleteImage(imageId);
        return true;
    }
}
