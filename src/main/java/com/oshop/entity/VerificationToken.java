package com.oshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Verification_token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {

	public static final int EXPIRATION = 10;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;
	
	@Column(name = "Token", nullable = false, length = 30)
	private String token;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "UserId", nullable = false)
	private User user;
	
	@Column(name = "ExpiryDate", nullable = false)
	private Date expiryDate;
	
}
