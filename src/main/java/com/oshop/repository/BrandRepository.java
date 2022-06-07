package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

	Brand findBySlug(String slug);
	List<Brand> findDistinctByProductsCategorySlug(String categorySlug);
}
