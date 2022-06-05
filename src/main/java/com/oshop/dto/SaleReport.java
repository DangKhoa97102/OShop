package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.oshop.entity.Category;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SaleReport implements Serializable {

	@Serial
	private static final long serialVersionUID = 7464135614505378764L;

	@Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category category;
    private double revenue;
    private long quantity;
}
