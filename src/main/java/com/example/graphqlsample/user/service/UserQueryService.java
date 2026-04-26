package com.example.graphqlsample.user.service;

import com.example.graphqlsample.common.exception.NotFoundException;
import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다. id=" + id));
    }
}
