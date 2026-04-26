package com.example.graphqlsample.post.graphql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public final class PostMutationDto {

    private PostMutationDto() {
    }

    public record CreateRequest(
            @NotBlank(message = "제목은 필수입니다.")
            String title,
            @NotBlank(message = "내용은 필수입니다.")
            String content,
            @NotNull(message = "작성자 ID는 필수입니다.")
            Long userId
    ) {
    }

    public record UpdateRequest(
            @NotNull(message = "게시글 ID는 필수입니다.")
            Long id,
            String title,
            String content
    ) {
    }
}
