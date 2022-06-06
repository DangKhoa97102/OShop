package com.oshop.dto.user;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class CheckoutDetail implements Serializable {
	@Serial
	private static final long serialVersionUID = -8117616949151606197L;

	private String fullname;
    private String address;
    private String phoneNumber;
    private String note;
}
