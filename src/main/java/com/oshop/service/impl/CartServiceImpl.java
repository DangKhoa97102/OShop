package com.oshop.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;

import com.oshop.entity.Product;
import com.oshop.entity.ShoppingCart;
import com.oshop.entity.User;
import com.oshop.repository.ProductRepository;
import com.oshop.repository.ShoppingCartRepository;
import com.oshop.repository.UserRepository;
import com.oshop.service.CartService;

public class CartServiceImpl implements CartService {

	@Autowired
	ShoppingCartRepository cartRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<ShoppingCart> getCartByUser(User user) {
		return cartRepo.findByUser(user);
	}

	@Override
	public ShoppingCart addCart(Integer productId, Integer quantity) {
		User user = userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productRepo.getById(productId);

        ShoppingCart cart = cartRepo.findByUserAndProduct(user, product);
        if (cart == null) {
            cart = new ShoppingCart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setCreatedDate(new Timestamp(System.currentTimeMillis()));


            cart.setQuantity(quantity);
        } else {

            cart.setQuantity(cart.getQuantity() + quantity);
        }

        return cartRepo.save(cart);
	}

	@Override
	@Transactional
	public ShoppingCart updateQuantity(Integer cartId, Integer quantity) {
		ShoppingCart cart = cartRepo.getById(cartId);
        if (cart.getProduct().getQuantity() < quantity) {
            if (LocaleContextHolder.getLocale().getLanguage().equals("vi")) {
                throw new RuntimeException("Số lượng sản phẩm không đủ (" + cart.getProduct().getQuantity() + " sản phẩm có sẵn)");
            } else {
                throw new RuntimeException("The quantity of product is not enough (" + cart.getProduct().getQuantity() + " product available)");
            }

        }
        cart.setQuantity(quantity);
        return cartRepo.save(cart);
	}

	@Override
	@Transactional
	public void deleteCart(Integer cartId) {
		cartRepo.delete(cartRepo.getById(cartId));
	}

}
