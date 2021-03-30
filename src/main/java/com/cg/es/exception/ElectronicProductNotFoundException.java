package com.cg.es.exception;

public class ElectronicProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ElectronicProductNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
