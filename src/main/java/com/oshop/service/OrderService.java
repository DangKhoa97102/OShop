package com.oshop.service;

import java.util.Date;
import java.util.List;

import com.oshop.entity.Order;

public interface OrderService {
	List<Order> getByUser();
	List<Order> getAll();
	List<OrderReport> getOrderReports();
	List<SaleReport> getSaleReports();
	List<SaleReport> getSaleReports(Date startDate, Date endDate);
	Order createOrder(String fullname, String email, String address, String phoneNumber);
	
}
