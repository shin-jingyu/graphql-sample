package com.example.graphqlsample.user.graphql.dto;

public record UserResponse(
        Long id,
        String name,
        Long profileImageId
) {
}
