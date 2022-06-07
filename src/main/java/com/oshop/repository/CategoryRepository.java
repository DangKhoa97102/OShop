package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findBySlug(String slug);
	public List<Category> findDistinctByProductsBrandSlug(String brandSlug);
}
