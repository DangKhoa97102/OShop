package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDTO implements Serializable {

	
	@Serial
	private static final long serialVersionUID = 8266234475103560871L;

	private int id;
	private String name;
	private String slug;
	@JsonIgnore
	private List<ProductDTO> products;
	public int getNumberBrandByCategory(int categoryId) {
		int quantity = 0;
		for (ProductDTO product : products) {
			if (product.getCategory().getId() == categoryId) {
				quantity += 1;
			}
		}
		return quantity;
	}
	
	public double getTotalPrice( ) {
		return products.size() > 0 ? products.stream().mapToDouble(ProductDTO::getTotalPrice).sum() : 0;
	}
	
}
