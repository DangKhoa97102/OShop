package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = -6883089166204414360L;

	private Integer id;
	private String name;
	private String slug;
	private String image;
	private String imagePreview1;
	private String imagePreview2;
	private String imagePreview3;
	private String imagePreview4;
	private String videoPreview;
	private String description;
	private Integer quantity;
	private Double price;
	private Timestamp createdDate;
	private Integer available;
	private CategoryDTO category;
	private BrandDTO brand;
	private DiscountDTO discount;
	@JsonIgnore
	private List<ShoppingCartDTO> shoppingCarts;
	@JsonIgnore
	private List<OrderDetailDTO> orderDetails;
	
	public Double getPromotionalPrice() {
		if(discount != null) {
			return price - (price * discount.getSaleOff() / 100);
		}
		return price;
	}
	public Double getTotalPrice() {
		return quantity * price;
	}
}
