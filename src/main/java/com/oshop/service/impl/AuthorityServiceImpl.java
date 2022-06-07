package com.oshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.entity.Authority;
import com.oshop.repository.AuthorityRepository;
import com.oshop.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepo;

	@Override
	public List<Authority> getAll() {
		return authorityRepo.findAll();
	}

	@Override
	public Authority save(Authority authority) {
		return authorityRepo.save(authority);
	}

	@Override
	public void delete(Long authorityId) {
		authorityRepo.deleteById(authorityId);
	}
}
