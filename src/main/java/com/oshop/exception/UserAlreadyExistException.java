package com.oshop.exception;

import java.io.Serial;

public class UserAlreadyExistException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 6523336549364178265L;

	public UserAlreadyExistException() {
		super();
	}
	
	public UserAlreadyExistException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	public UserAlreadyExistException(final String message) {
		super(message);
	}
	
	public UserAlreadyExistException(final Throwable cause) {
		super(cause);
	}
}
