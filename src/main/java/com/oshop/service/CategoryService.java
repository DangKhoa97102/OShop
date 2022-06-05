package com.oshop.service;

import java.util.List;

import com.oshop.entity.Category;

public interface CategoryService {
	List<Category> getAll();
	List<Category> getAllByBrand(String brandSlug);
	Category get(String categorySlug);
	Category get(Integer categoryId);
	Category update(Integer id, Category category);
	void remove(Integer id);
	Category create(Category category);
}
