package com.example.graphqlsample.post.graphql.resolver;

import com.example.graphqlsample.post.graphql.mapper.PostGraphqlMapper;
import com.example.graphqlsample.post.service.PostMutationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostMutationResolver {

    private final PostMutationService postMutationService;
    private final PostGraphqlMapper postGraphqlMapper;
}
