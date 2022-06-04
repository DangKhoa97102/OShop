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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;
	
	@Column(name = "NameVI", nullable = false, length = 50)
	private String nameVI;
	
	@Column(name = "NameEN", nullable = false, length = 50)
	private String nameEN;
	
	@Column(name = "Slug", nullable = false, length = 50)
	private String slug;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
}
