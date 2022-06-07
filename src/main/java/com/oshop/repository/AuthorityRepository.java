package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.Authority;
import com.oshop.entity.Category;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
