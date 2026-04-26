package com.example.graphqlsample.user.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String profileImageId;

    public void update(String name, String profileImageId) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
        if (profileImageId != null) {
            this.profileImageId = profileImageId;
        }
    }

    public static User create(String name, String profileImageId) {
        return new User(null, name, profileImageId);
    }
}
