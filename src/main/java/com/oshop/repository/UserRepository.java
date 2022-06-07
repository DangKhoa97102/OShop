package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEnabled(boolean enabled);
    User findByEmail(String email);
    User findByVerificationTokenToken(String token);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
