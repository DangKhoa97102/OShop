package com.oshop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.entity.Category;
import com.oshop.repository.CategoryRepository;
import com.oshop.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
    CategoryRepository categoryRepo;

    @Autowired
    ModelMapper mapper;

	@Override
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}

	@Override
	public List<Category> getAllByBrand(String brandSlug) {
		return categoryRepo.findDistinctByProductsBrandSlug(brandSlug);
	}

	@Override
	public Category get(String categorySlug) {
		 return categoryRepo.findBySlug(categorySlug);
	}

	@Override
	public Category get(Integer categoryId) {
		 return categoryRepo.getById(categoryId);
	}

	@Override
	@Transactional
	public Category update(Integer id, Category category) {
		Category categoryToUpdate = categoryRepo.getById(id);
        categoryToUpdate.setNameEN(category.getNameEN());
        categoryToUpdate.setNameVI(category.getNameVI());
        categoryToUpdate.setSlug(category.getSlug());
        return categoryRepo.save(categoryToUpdate);
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Category category = categoryRepo.getById(id);
        categoryRepo.delete(category);
	}

	@Override
	@Transactional
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
    
    
}
