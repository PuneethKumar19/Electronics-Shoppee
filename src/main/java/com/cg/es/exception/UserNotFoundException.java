package com.cg.es.exception;

public class UserNotFoundException extends  Exception{	
private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String err) {
		super(err);

	}
}
