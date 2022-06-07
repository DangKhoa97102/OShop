package com.oshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
