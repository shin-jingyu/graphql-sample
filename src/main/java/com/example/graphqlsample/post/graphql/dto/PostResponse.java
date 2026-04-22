package com.example.graphqlsample.post.graphql.dto;

public record PostResponse(
        Long id,
        String title,
        String content,
        Long userId
) {
}
