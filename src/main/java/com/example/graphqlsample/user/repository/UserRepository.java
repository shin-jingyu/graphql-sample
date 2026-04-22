package com.example.graphqlsample.user.repository;

import com.example.graphqlsample.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
