package com.amit.app.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1456749947284231301L;
	
	private Long customerId;
	
	public CustomerNotFoundException(String message) {
		super(message);
		this.customerId = -1L;
	}
	
	public CustomerNotFoundException(Long customerId, String message) {
		super(message);
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
