package com.oshop.entity;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shopping_Cart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "UserId", nullable = false)
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ProductId", nullable = false)
	private Product product;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name = "CreatedDate", nullable = false)
	private Timestamp createdDate;
	
}
