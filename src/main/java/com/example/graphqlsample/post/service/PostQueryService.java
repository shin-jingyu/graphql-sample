package com.example.graphqlsample.post.service;

import com.example.graphqlsample.common.exception.NotFoundException;
import com.example.graphqlsample.post.domain.entity.Post;
import com.example.graphqlsample.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시글을 찾을 수 없습니다. id=" + id));
    }
}
