package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter
public class OrderDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -5107599734422105937L;

	private Integer id;
	private String orderCode;
	private Timestamp createdDate;
	private Integer status;
	private String address;
	private String fullname;
	private String phoneNumber;
	private String email;
	@JsonIgnore
	private List<OrderDetailDTO> orderDetails;
	
	public Double getTotal() {
		return orderDetails.stream().mapToDouble(orderDetail -> orderDetail.getPrice() * orderDetail.getQuantity()).sum();
	}
}
