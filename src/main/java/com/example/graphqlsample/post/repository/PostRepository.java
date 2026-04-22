package com.example.graphqlsample.post.repository;

import com.example.graphqlsample.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
