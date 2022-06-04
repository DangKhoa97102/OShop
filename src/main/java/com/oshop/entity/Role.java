package com.oshop.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
	
	public static final String DIRECTOR = "ROLE_DIRECTOR";
	public static final String STAFF = "ROLE_STAFF";
	public static final String CUSTOMER = "ROLE_CUSTOMER";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Long id;
	
	@Column(name = "Name", nullable = false, length = 50)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private Set<Authority> authorities = new LinkedHashSet<>();
}
