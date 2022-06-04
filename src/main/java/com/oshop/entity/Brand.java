package com.oshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false, precision = 10)
	private int id;
	
	@Column(name = "Name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "Slug", nullable = false, length = 50)
	private String slug;
	
	@JsonIgnore
	@OneToMany(mappedBy = "brand")
	private List<Product> products = new ArrayList<>();
}
