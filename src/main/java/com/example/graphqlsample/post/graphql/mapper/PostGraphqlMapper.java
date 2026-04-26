package com.example.graphqlsample.post.graphql.mapper;

import com.example.graphqlsample.post.domain.entity.Post;
import com.example.graphqlsample.post.graphql.dto.PostQueryDto.Response;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostGraphqlMapper {

    Response toResponse(Post post);
}
