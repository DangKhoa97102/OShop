package com.oshop.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.entity.Brand;
import com.oshop.repository.BrandRepository;
import com.oshop.service.BrandService;

public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandRepository brandRepo;
	@Autowired
	ModelMapper mapper;

	@Override
	public List<Brand> getAll() {
		return brandRepo.findAll();
	}

	@Override
	public List<Brand> getAllByCategory(String categorySlug) {
		return brandRepo.findDistinctByProductsCategorySlug(categorySlug);
	}

	@Override
	public Brand get(Integer brandId) {
		return brandRepo.getById(brandId);
	}

	@Override
	public Brand get(String brandSlug) {
		return brandRepo.findBySlug(brandSlug);
	}

	@Override
	public Brand updateBrand(Integer brandId, Brand brand) {
		Brand brandToUpdate = brandRepo.getById(brandId);
        brandToUpdate.setName(brand.getName());
        brandToUpdate.setSlug(brand.getSlug());
        return brandRepo.save(brandToUpdate);
	}

	@Override
	public Brand createBrand(Brand brand) {
		return brandRepo.save(brand);
	}

	@Override
	public void removeBrand(Integer brandId) {
		brandRepo.delete(brandRepo.getById(brandId));

	}
}
