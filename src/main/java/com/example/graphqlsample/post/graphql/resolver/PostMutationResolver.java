package com.example.graphqlsample.post.graphql.resolver;

import com.example.graphqlsample.post.domain.entity.Post;
import com.example.graphqlsample.post.graphql.dto.PostMutationDto.CreateRequest;
import com.example.graphqlsample.post.graphql.dto.PostMutationDto.UpdateRequest;
import com.example.graphqlsample.post.graphql.dto.PostQueryDto.Response;
import com.example.graphqlsample.post.graphql.mapper.PostGraphqlMapper;
import com.example.graphqlsample.post.service.PostMutationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
@RequiredArgsConstructor
public class PostMutationResolver {

    private final PostMutationService postMutationService;
    private final PostGraphqlMapper postGraphqlMapper;

    @MutationMapping
    public Response createPost(@Argument("input") @Valid CreateRequest input) {
        Post post = postMutationService.createPost(input.title(), input.content(), input.userId());
        return postGraphqlMapper.toResponse(post);
    }

    @MutationMapping
    public Response updatePost(@Argument("input") @Valid UpdateRequest input) {
        Post post = postMutationService.updatePost(input.id(), input.title(), input.content());
        return postGraphqlMapper.toResponse(post);
    }

    @MutationMapping
    public Boolean deletePost(@Argument Long id) {
        postMutationService.deletePost(id);
        return true;
    }
}
