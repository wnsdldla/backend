package com.backend.demo.error;

public class DuplicatedUsernameException extends RuntimeException{

	public DuplicatedUsernameException(String message, Throwable cause) {
		super(message,cause);
	}
	public DuplicatedUsernameException(String message) {
		super(message);
	}
	public DuplicatedUsernameException(Throwable cause) {
		super(cause);
	}
}
