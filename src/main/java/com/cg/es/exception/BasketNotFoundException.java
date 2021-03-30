package com.cg.es.exception;

public class BasketNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public BasketNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
