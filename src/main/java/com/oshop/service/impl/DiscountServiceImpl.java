package com.oshop.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.oshop.dto.DiscountDTO;
import com.oshop.entity.Discount;
import com.oshop.repository.DiscountRepository;
import com.oshop.repository.ProductRepository;
import com.oshop.service.DiscountService;
import com.oshop.utils.MessageUtils;

public class DiscountServiceImpl implements DiscountService {
	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	MessageUtils messageUtils;

	@Override
	public List<Discount> getAll() {
		return discountRepository.findAll();
	}

	@Override
	public List<Discount> getByActivated() {
		return discountRepository.findByIsActive(true);
	}

	@Override
	public List<Discount> getActived() {
		return discountRepository.findByIsActive(true);
	}

	@Override
	public List<Discount> getActivedOrderByCreateDateDesc(boolean isActive) {
		return discountRepository.findByIsActiveOrderByCreatedDateDesc(isActive);
	}

	@Override
	@Transactional
	public Discount save(DiscountDTO discountDTO) {
		 Discount discount = null;
	        if (discountDTO.getId() == null) {
	            discount = new Discount();
	            discount.setCreatedDate(new Timestamp(System.currentTimeMillis()));
	        } else {
	            discount = discountRepository.getById(discountDTO.getId());
	        }
	        discount.setSaleOff(discountDTO.getSaleOff());
	        discount.setEndDate(discountDTO.getEndDate());
	        discount.setStartDate(discountDTO.getStartDate());
	        discount.setIsActive(true);
	        discount.setName(discountDTO.getName());

	        return discountRepository.save(discount);
	}

	@Override
	public Discount save(Discount discount) {
		if (discount.getEndDate().before(discount.getStartDate())) {
            throw new IllegalArgumentException(messageUtils.getMessage("EndTimeAfterStartTime"));
        }
        if (discount.getEndDate().before(new Date())) {
            throw new IllegalArgumentException(messageUtils.getMessage("EndTimeAfterCurrentTime"));
        }
        if (discount.getId() == null) {
            discount.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        }
        discount.setIsActive(true);
        return discountRepository.save(discount);
	}

	@Override
	@Transactional
	public void delete(Integer discountId) {
		Discount discount = discountRepository.getById(discountId);
        discount.setIsActive(false);
        discount.setEndDate(new Date());

        discount.getProducts().forEach(product -> {
            product.setDiscount(null);
            productRepository.save(product);
        });

        discountRepository.save(discount);
	}

	@Override
	@Transactional
	public void deleteFromDB(Integer discountId) {
		Discount discount = discountRepository.getById(discountId);

        discount.getProducts().forEach(product -> {
            product.setDiscount(null);
            productRepository.save(product);
        });

        discountRepository.delete(discount);
	}
	
	@Scheduled(fixedDelay = 5000, initialDelay = 10000)
    public void run() {
        // Deactivate the promotion when it expires
        List<Discount> discounts = discountRepository.findByIsActive(true);
        discounts.forEach(discount -> {
            if (discount.getEndDate().before(new Date())) {
                this.delete(discount.getId());
            }
        });
    }
}
