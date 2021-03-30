package com.cg.es.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.exception.UserNotFoundException;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.UserModel;
import com.cg.es.service.ICustomerService;
import com.cg.es.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<UserModel> findById(@PathVariable("customerId") Long customerId){
		return ResponseEntity.ok(userService.findById(customerId));
	}
	
	
	
	@PostMapping("/signIn")
	public ResponseEntity<CustomerModel> signIn(@RequestBody UserModel user) throws CustomerNotFoundException{
		ResponseEntity<CustomerModel> response=null;
		CustomerModel customer=customerService.findById(user.getCustomerId());
		if(user.getPassword().equals(user.getPassword())) {
			response=new ResponseEntity<>(customer,HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
		return response;
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("customerId") Long customerId) {
		ResponseEntity<Void> response=null;
		UserModel user=userService.findById(customerId);
		if(user==null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			userService.deleteById(customerId);
			System.out.println("deleted");
		}
		return response;
	}
	
	@PutMapping
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user) throws UserNotFoundException{
		user =userService.save(user);
		return ResponseEntity.ok(user);
	}
}
