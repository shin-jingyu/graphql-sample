package com.example.graphqlsample.user.graphql.dto;

public record CreateUserRequest(
        String name,
        Long profileImageId
) {
}
