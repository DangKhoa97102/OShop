package com.oshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	public VerificationToken findByToken(String token);
	public VerificationToken findByUserEmail(String email);
}
