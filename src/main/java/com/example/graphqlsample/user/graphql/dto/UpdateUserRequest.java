package com.example.graphqlsample.user.graphql.dto;

public record UpdateUserRequest(
        Long id,
        String name,
        Long profileImageId
) {
}
