package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderReport implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1624092124593942930L;

	@Id
	private int status;
	private Long quantity;
}
