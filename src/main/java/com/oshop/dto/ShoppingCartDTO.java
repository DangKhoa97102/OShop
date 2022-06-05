package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;

@Getter @Setter
public class ShoppingCartDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -6557867907564160854L;
	
	private Integer id;
    private Integer quantity;
    private String note;
    private ProductDTO product;
	
    public Double getUnitPrice() {
    	return quantity * product.getPromotionalPrice();
    }
}
