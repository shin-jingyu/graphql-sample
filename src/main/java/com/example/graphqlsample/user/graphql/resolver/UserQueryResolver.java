package com.example.graphqlsample.user.graphql.resolver;

import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.graphql.dto.UserQueryDto.Response;
import com.example.graphqlsample.user.graphql.mapper.UserGraphqlMapper;
import com.example.graphqlsample.user.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserQueryResolver {

    private final UserQueryService userQueryService;
    private final UserGraphqlMapper userGraphqlMapper;

    @QueryMapping
    public List<Response> users() {
        return userQueryService.getUsers()
                .stream()
                .map(userGraphqlMapper::toResponse)
                .toList();
    }

    @QueryMapping
    public Response user(@Argument Long id) {
        User user = userQueryService.getUser(id);
        return userGraphqlMapper.toResponse(user);
    }
}
