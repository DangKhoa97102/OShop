package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 8369218594922335302L;

	private Integer id;
    private ProductDTO product;
    private OrderDTO order;
    private Integer quantity;
    private Double price;

    public Double getSubtotal() {
        return price * quantity;
    }
}
