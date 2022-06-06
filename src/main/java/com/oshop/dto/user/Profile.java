package com.oshop.dto.user;

import java.io.Serial;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Profile implements Serializable {
	@Serial
	private static final long serialVersionUID = -8738384491707400126L;
	
	@NotBlank(message = "{NotBlank.fullName}")
    private String fullname;
    private String email;
    private String username;
    private String address;
    private String phoneNumber;
    private String photo;
    private MultipartFile photoFile;

}
