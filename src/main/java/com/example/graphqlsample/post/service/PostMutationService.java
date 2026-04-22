package com.example.graphqlsample.post.service;

import com.example.graphqlsample.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostMutationService {

    private final PostRepository postRepository;
}
