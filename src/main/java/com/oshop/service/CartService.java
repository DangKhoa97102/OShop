package com.oshop.service;

import java.util.List;

import com.oshop.entity.ShoppingCart;
import com.oshop.entity.User;

public interface CartService {
	List<ShoppingCart> getCartByUser(User user);
	
	ShoppingCart addCart(Integer productId, Integer quantity);
	
	ShoppingCart updateQuantity(Integer cartId, Integer quantity);
	
	void deleteCart(Integer cartId);
}
