package com.example.graphqlsample.user.service;

import com.example.graphqlsample.common.exception.NotFoundException;
import com.example.graphqlsample.image.service.ImageCommandService;
import com.example.graphqlsample.image.service.ImageQueryService;
import com.example.graphqlsample.post.repository.PostRepository;
import com.example.graphqlsample.user.domain.entity.User;
import com.example.graphqlsample.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserMutationService {

    private final UserRepository userRepository;
    private final ImageQueryService imageQueryService;
    private final ImageCommandService imageCommandService;
    private final PostRepository postRepository;

    public User createUser(String name, String profileImageId) {
        validateProfileImage(profileImageId);
        User user = User.create(name, profileImageId);
        return userRepository.save(user);
    }

    public User updateUser(Long id, String name, String profileImageId) {
        validateProfileImage(profileImageId);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다. id=" + id));
        user.update(name, profileImageId);
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다. id=" + id));

        deleteProfileImage(user.getProfileImageId());
        postRepository.deleteByUserId(user.getId());
        userRepository.delete(user);
    }

    private void validateProfileImage(String profileImageId) {
        if (profileImageId == null || profileImageId.isBlank()) {
            return;
        }

        imageQueryService.getImageMetadata(profileImageId);
    }

    private void deleteProfileImage(String profileImageId) {
        if (profileImageId == null || profileImageId.isBlank()) {
            return;
        }

        imageCommandService.deleteImage(profileImageId);
    }
}
