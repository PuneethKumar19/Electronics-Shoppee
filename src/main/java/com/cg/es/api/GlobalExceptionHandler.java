package com.cg.es.api;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.exception.ElectronicProductNotFoundException;
import com.cg.es.exception.ElectronicProductOrderNotFoundException;

public class GlobalExceptionHandler {

	@ExceptionHandler(value = {CustomerNotFoundException.class,ElectronicProductNotFoundException.class,ElectronicProductOrderNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	static String messageFrom(BindingResult result) {		
		return result.getAllErrors().stream()
				.map(err -> err.getObjectName() + "-" +err.getDefaultMessage())
				.collect(Collectors.toList()).toString();
	}
}