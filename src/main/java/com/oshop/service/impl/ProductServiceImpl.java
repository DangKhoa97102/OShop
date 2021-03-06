package com.oshop.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.oshop.dto.ProductDTO;
import com.oshop.dto.ProductUpdated;
import com.oshop.entity.Product;
import com.oshop.repository.BrandRepository;
import com.oshop.repository.CategoryRepository;
import com.oshop.repository.DiscountRepository;
import com.oshop.repository.ProductRepository;
import com.oshop.service.ProductService;
import com.oshop.utils.MapperUtils;

public class ProductServiceImpl implements ProductService {
	@Autowired
    ProductRepository productRepo;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    BrandRepository brandRepo;
    @Autowired
    DiscountRepository discountRepo;
    @Autowired
    ModelMapper mapper;
	@Override
	public List<Product> getTop8Products() {
		return productRepo.findTop8ByOrderByCreatedDateDesc();
	}
	@Override
	public List<Product> getPromotionalProducts() {
		List<Product> products = productRepo.findByDiscountNotNull();
        if (products.size() == 0) {
            products = productRepo.findTop8ByOrderByCreatedDateDesc();
        }
        return products;
	}
	@Override
	public List<Product> getByProduct(String productName) {
		 return productRepo.findByNameContainingAllIgnoreCase(productName);
	}
	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	@Override
	public List<ProductUpdated> getAllByCategoryAndBrand(String categorySlug, String brandSlug) {
		 List<Product> products = null;
	        if (!categorySlug.isBlank() && !brandSlug.isBlank()) {
	            products = productRepo.findByCategorySlugAndBrandSlug(categorySlug, brandSlug);
	        } else if (!categorySlug.isBlank()) {
	            products = productRepo.findByCategorySlug(categorySlug);
	        } else if (!brandSlug.isBlank()) {
	            products = productRepo.findByBrandSlug(brandSlug);
	        } else {
	            products = productRepo.findAll();
	        }
	        return products.stream().map(Product::toProductUpdated).collect(Collectors.toList());
	    
	}
	@Override
	public Page<Product> getAllByCategoryAndBrand(String categorySlug, String brandSlug, int page, int size,
			String direction) {
		Sort sort = Sort.by(direction.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, "name");
        /*if (brandSlug.isBlank()) {
            return productRepo.findByCategorySlugAndAvailable(categorySlug, 0, PageRequest.of(page, size, sort));
        } else {
            return productRepo.findByCategorySlugAndBrandSlugAndAvailable(categorySlug, brandSlug, 0, PageRequest.of(page, size, sort));
        }*/
        return productRepo.findByCategorySlugContainingAndBrandSlugContainingAndAvailable(categorySlug, brandSlug, 0, PageRequest.of(page, size, sort));
    
	}
	@Override
	public Page<ProductDTO> getPromotionalProducts(int page, int size) {
		Page<Product> products = productRepo.findByDiscountNotNullAndAvailable(0, PageRequest.of(page, size));
        if (products.getTotalElements() == 0) {
            List<Product> lstProduct = productRepo.findTop8ByOrderByCreatedDateDesc();
            products = new PageImpl<Product>(lstProduct, PageRequest.of(page, size), lstProduct.size());
        }
        return MapperUtils.mapAll(products, ProductDTO.class);
	}
	@Override
	public Product getProduct(String slug) {
		return productRepo.findBySlug(slug);
	}
	@Override
	@Transactional
	public ProductUpdated save(ProductUpdated productUpdated) {
		Product product = MapperUtils.map(productUpdated, Product.class);

        product.setCategory(categoryRepo.findBySlug(productUpdated.getCategorySlug()));
        product.setBrand(brandRepo.findBySlug(productUpdated.getBrandSlug()));
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setDiscount(productUpdated.getDiscountId() != null ? discountRepo.getById(productUpdated.getDiscountId()) : null);

        return productRepo.save(product).toProductUpdated();
	}
	@Override
	@Transactional
	public void remove(String productSlug) {
		productRepo.delete(productRepo.findBySlug(productSlug));
		
	}
	@Override
	@Transactional
	public void remove(Integer productId) {
		productRepo.deleteById(productId);
	}
	
 
    
}
