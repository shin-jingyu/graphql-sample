package com.example.graphqlsample.post.graphql.dto;

public record CreatePostRequest(
        String title,
        String content,
        Long userId
) {
}
