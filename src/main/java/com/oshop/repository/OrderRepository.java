package com.oshop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oshop.dto.OrderReport;
import com.oshop.dto.SaleReport;
import com.oshop.entity.Order;
import com.oshop.entity.User;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	Boolean existsByOrderCode(String orderCode);
    List<Order> findByUser(User user);
    
    @Query(
    		 """
            select new OrderReport (o.status, count(o))
            from Order o
            group by o.status
            """
    )
    List<OrderReport> findOrderReports();
    
    @Query(
            """
            select new SaleReport (od.product.category, sum(od.quantity * od.price), sum(od.quantity))
            from OrderDetail od
            where od.order.status = 1
            group by od.product.category
            """
    )
    List<SaleReport> findSaleReports();
	
    @Query(
            """
            select new SaleReport (od.product.category, sum(od.quantity * od.price), sum(od.quantity))
            from OrderDetail od
            where od.order.status = 1 and od.order.createdDate >= ?1 and od.order.createdDate <= ?2
            group by od.product.category
            """
    )
    List<SaleReport> findSaleReports(Date startDate, Date endDate);
}
