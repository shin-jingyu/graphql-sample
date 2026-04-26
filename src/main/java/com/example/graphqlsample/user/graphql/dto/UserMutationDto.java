package com.example.graphqlsample.user.graphql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public final class UserMutationDto {

    private UserMutationDto() {
    }

    public record CreateRequest(
            @NotBlank(message = "이름은 필수입니다.")
            String name,
            Long profileImageId
    ) {
    }

    public record UpdateRequest(
            @NotNull(message = "사용자 ID는 필수입니다.")
            Long id,
            String name,
            Long profileImageId
    ) {
    }
}
