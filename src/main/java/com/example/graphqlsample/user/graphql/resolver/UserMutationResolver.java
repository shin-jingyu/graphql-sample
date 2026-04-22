package com.example.graphqlsample.user.graphql.resolver;

import com.example.graphqlsample.user.graphql.mapper.UserGraphqlMapper;
import com.example.graphqlsample.user.service.UserMutationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserMutationResolver {

    private final UserMutationService userMutationService;
    private final UserGraphqlMapper userGraphqlMapper;
}
