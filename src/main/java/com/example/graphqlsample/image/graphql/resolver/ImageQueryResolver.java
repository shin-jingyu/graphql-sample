package com.example.graphqlsample.image.graphql.resolver;

import com.example.graphqlsample.image.graphql.dto.ImageQueryDto.Response;
import com.example.graphqlsample.image.service.ImageQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ImageQueryResolver {

    private final ImageQueryService imageQueryService;

    @QueryMapping
    public Response imageMetadata(@Argument String imageId) {
        return imageQueryService.getImageMetadata(imageId);
    }
}
