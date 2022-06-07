package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.Product;
import com.oshop.entity.ShoppingCart;
import com.oshop.entity.User;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
	public List<ShoppingCart> findByUser(User user);
	public ShoppingCart findByUserAndProduct(User user, Product product);
	public Boolean existsByUserAndProduct(User user, Product product);
}
