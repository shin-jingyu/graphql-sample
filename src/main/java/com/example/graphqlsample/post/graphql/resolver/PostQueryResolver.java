package com.example.graphqlsample.post.graphql.resolver;

import com.example.graphqlsample.post.domain.entity.Post;
import com.example.graphqlsample.post.graphql.dto.PostQueryDto.Response;
import com.example.graphqlsample.post.graphql.mapper.PostGraphqlMapper;
import com.example.graphqlsample.post.service.PostQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostQueryResolver {

    private final PostQueryService postQueryService;
    private final PostGraphqlMapper postGraphqlMapper;

    @QueryMapping
    public List<Response> posts() {
        return postQueryService.getPosts()
                .stream()
                .map(postGraphqlMapper::toResponse)
                .toList();
    }

    @QueryMapping
    public Response post(@Argument Long id) {
        Post post = postQueryService.getPost(id);
        return postGraphqlMapper.toResponse(post);
    }
}
