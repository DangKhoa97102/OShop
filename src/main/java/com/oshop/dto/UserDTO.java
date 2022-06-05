package com.oshop.dto;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Setter
@Getter
@ToString
public class UserDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 5917831090586225909L;

	private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String phoneNumber;
    private String photo = "default.png";
    private Timestamp createdDate;
    private String enabled;
    private MultipartFile photoFile;
}
