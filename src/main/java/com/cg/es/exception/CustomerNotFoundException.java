package com.cg.es.exception;

public class CustomerNotFoundException extends Exception {
private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
