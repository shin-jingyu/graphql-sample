package com.example.graphqlsample.user.graphql.resolver;

import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.graphql.dto.UserMutationDto.UpdateRequest;
import com.example.graphqlsample.user.graphql.dto.UserMutationDto.CreateRequest;
import com.example.graphqlsample.user.graphql.dto.UserQueryDto.Response;
import com.example.graphqlsample.user.graphql.mapper.UserGraphqlMapper;
import com.example.graphqlsample.user.service.UserMutationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
@RequiredArgsConstructor
public class UserMutationResolver {

    private final UserMutationService userMutationService;
    private final UserGraphqlMapper userGraphqlMapper;

    @MutationMapping
    public Response createUser(@Argument("input") @Valid CreateRequest input) {
        User user = userMutationService.createUser(input.name(), input.profileImageId());
        return userGraphqlMapper.toResponse(user);
    }

    @MutationMapping
    public Response updateUser(@Argument("input") @Valid UpdateRequest input) {
        User user = userMutationService.updateUser(input.id(), input.name(), input.profileImageId());
        return userGraphqlMapper.toResponse(user);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        userMutationService.deleteUser(id);
        return true;
    }

}
