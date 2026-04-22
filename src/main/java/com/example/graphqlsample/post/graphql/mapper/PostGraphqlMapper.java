package com.example.graphqlsample.post.graphql.mapper;

import com.example.graphqlsample.post.domain.entity.Post;
import com.example.graphqlsample.post.graphql.dto.PostResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostGraphqlMapper {

    PostResponse toResponse(Post post);
}
