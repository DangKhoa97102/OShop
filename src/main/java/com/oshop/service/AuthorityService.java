package com.oshop.service;

import java.util.List;

import com.oshop.entity.Authority;

public interface AuthorityService {

	List<Authority> getAll();
	Authority save(Authority authority);
	void delete(Long authorityId);
}
