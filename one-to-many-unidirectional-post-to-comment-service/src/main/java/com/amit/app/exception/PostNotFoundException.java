package com.amit.app.exception;

public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6113554972781582362L;

	public PostNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PostNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PostNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PostNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
