package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DiscountDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 312888452691610600L;

	private Integer id;
    private String name;
    private Double saleOff;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    private Date createdDate;
    @JsonIgnore
    private List<ProductDTO> products;
}
