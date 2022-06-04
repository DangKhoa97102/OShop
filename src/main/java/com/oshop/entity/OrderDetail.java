package com.oshop.entity;

import javax.persistence.*;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_Detail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;
	
	@Column(name = "Quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "Price", nullable = false)
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OrderId", nullable = false)
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ProductId", nullable = false)
	private Product product;
}
