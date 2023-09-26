package com.qsp.springbootemployee.exception;

public class PhoneNotFound extends RuntimeException {
	
	String message;
	
	public String getMessage() {
		return message;
	}

	public PhoneNotFound(String message) {
		super();
		this.message = message;
	}
	
	
	

}
