package com.example.graphqlsample.post.graphql.dto;

public final class PostQueryDto {

    private PostQueryDto() {
    }

    public record Response(
            Long id,
            String title,
            String content,
            Long userId
    ) {
    }
}
