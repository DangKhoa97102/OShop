package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer>{

	List<Discount> findByIsActive(boolean isActive);
    List<Discount> findAllByOrderBySaleOffAsc();
    List<Discount> findAllByOrderByCreatedDateDesc();
    List<Discount> findByIsActiveOrderBySaleOffAsc(boolean isActive);
    List<Discount> findByIsActiveOrderByCreatedDateDesc(boolean isActive);
}
