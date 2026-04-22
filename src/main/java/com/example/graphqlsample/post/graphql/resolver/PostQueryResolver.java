package com.example.graphqlsample.post.graphql.resolver;

import com.example.graphqlsample.post.graphql.mapper.PostGraphqlMapper;
import com.example.graphqlsample.post.service.PostQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostQueryResolver {

    private final PostQueryService postQueryService;
    private final PostGraphqlMapper postGraphqlMapper;
}
