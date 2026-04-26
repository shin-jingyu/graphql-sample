package com.example.graphqlsample.post.service;

import com.example.graphqlsample.common.exception.NotFoundException;
import com.example.graphqlsample.post.domain.entity.Post;
import com.example.graphqlsample.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostMutationService {

    private final PostRepository postRepository;

    public Post createPost(String title, String content, Long userId) {
        Post post = Post.create(title, content, userId);
        return postRepository.save(post);
    }

    public Post updatePost(Long id, String title, String content) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시글을 찾을 수 없습니다. id=" + id));
        post.update(title, content);
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시글을 찾을 수 없습니다. id=" + id));
        postRepository.delete(post);
    }
}
