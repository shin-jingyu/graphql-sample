package com.example.graphqlsample.post.graphql.dto;

public record UpdatePostRequest(
        Long id,
        String title,
        String content
) {
}
