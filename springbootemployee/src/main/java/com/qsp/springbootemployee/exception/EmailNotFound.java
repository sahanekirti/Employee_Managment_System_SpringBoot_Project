package com.qsp.springbootemployee.exception;

public class EmailNotFound extends RuntimeException {
	
	String message;
	
	

	public EmailNotFound(String message) {
		super();
		this.message = message;
	}
	
	
	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
	

}
