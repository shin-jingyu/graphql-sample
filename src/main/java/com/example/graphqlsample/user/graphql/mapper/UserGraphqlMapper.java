package com.example.graphqlsample.user.graphql.mapper;

import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.graphql.dto.UserQueryDto.Response;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserGraphqlMapper {

    Response toResponse(User user);

}
