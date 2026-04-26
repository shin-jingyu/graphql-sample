package com.example.graphqlsample.user.graphql.dto;

public final class UserQueryDto {

    private UserQueryDto() {
    }

    public record Response(
            Long id,
            String name,
            Long profileImageId
    ) {
    }
}
