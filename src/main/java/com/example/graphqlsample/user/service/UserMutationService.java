package com.example.graphqlsample.user.service;

import com.example.graphqlsample.common.exception.NotFoundException;
import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMutationService {

    private final UserRepository userRepository;

    public User createUser(String name, Long profileImageId) {
        User user = User.create(name, profileImageId);
        return userRepository.save(user);
    }

    public User updateUser(Long id, String name, Long profileImageId) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다. id=" + id));
        user.update(name, profileImageId);
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다. id=" + id));
        userRepository.delete(user);
    }
}
