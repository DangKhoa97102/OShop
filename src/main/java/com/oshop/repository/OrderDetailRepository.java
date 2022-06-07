package com.oshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshop.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

	public List<OrderDetail> findByOrderId(Integer id);
}
