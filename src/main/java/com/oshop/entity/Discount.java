package com.oshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discount")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;
	
	@Column(name = "Name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "SaleOff", nullable = false)
	private Double saleOff;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "StartDate", nullable = false)
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "EndDate", nullable = false)
	private Date endDate;
	
	@Column(name = "IsActive", nullable = false)
	private Boolean isActive = false;
	
	@Column(name = "CreatedDate", nullable = false)
	private Date createdDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "discount", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<>();
}
