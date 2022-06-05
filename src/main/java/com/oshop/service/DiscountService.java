package com.oshop.service;

import java.util.List;

import com.oshop.entity.Discount;

public interface DiscountService {
	List<Discount> getAll();
	List<Discount> getByActivated();
	List<Discount> getActived();
	List<Discount> getActivedOrderByCreateDateDesc(boolean isActive);
	Discount save(DiscountDTO discountDTO);
	Discount save(Discount discount);
	void delete(Integer discountId);
	void deleteFromDB(Integer discountId);
}
