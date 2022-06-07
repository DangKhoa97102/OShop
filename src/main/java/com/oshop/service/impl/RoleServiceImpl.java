package com.oshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.entity.Role;
import com.oshop.repository.RoleRepository;
import com.oshop.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<Role> getAll() {
		return roleRepo.findAll();
	}

}
