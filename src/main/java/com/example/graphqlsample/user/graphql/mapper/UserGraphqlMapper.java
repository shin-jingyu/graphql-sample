package com.example.graphqlsample.user.graphql.mapper;

import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.graphql.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserGraphqlMapper {

    UserResponse toResponse(User user);
}
