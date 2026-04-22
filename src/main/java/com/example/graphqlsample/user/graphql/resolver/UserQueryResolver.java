package com.example.graphqlsample.user.graphql.resolver;

import com.example.graphqlsample.user.graphql.mapper.UserGraphqlMapper;
import com.example.graphqlsample.user.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserQueryResolver {

    private final UserQueryService userQueryService;
    private final UserGraphqlMapper userGraphqlMapper;
}
