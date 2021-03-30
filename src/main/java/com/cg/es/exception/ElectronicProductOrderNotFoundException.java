package com.cg.es.exception;

public class ElectronicProductOrderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ElectronicProductOrderNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
