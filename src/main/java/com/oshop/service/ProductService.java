package com.oshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.oshop.dto.ProductDTO;
import com.oshop.dto.ProductUpdated;
import com.oshop.entity.Product;

public interface ProductService {

	List<Product> getTop8Products();
	List<Product> getPromotionalProducts();
	List<Product> getByProduct(String productName);
	List<Product> getAll();
	List<ProductUpdated> getAllByCategoryAndBrand(String categorySlug, String brandSlug);
	Page<Product> getAllByCategoryAndBrand(String categorySlug, String brandSlug, int page, int size, String direction);
	Page<ProductDTO> getPromotionalProducts(int page, int size);
	Product getProduct(String slug);
	ProductUpdated save(ProductUpdated product);
	void remove(String productSlug);
	void remove(Integer productId);
}
