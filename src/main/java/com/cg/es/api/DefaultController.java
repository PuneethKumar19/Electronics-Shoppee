package com.cg.es.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class DefaultController {

	@GetMapping
	public ResponseEntity<String> defaultAction() {
		return new ResponseEntity<>("Welcome to RESTful Service", HttpStatus.OK);
	}
}
