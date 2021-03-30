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

import com.cg.es.exception.BasketNotFoundException;
import com.cg.es.model.BasketModel;
import com.cg.es.service.BasketServiceImpl;

@RestController
@RequestMapping(path="/basket")
public class BasketAPI {
	@Autowired
	private BasketServiceImpl basketService;
	
	@GetMapping("/getallbasket")
	public ResponseEntity<List<BasketModel>> findAll() {
		return new ResponseEntity<>(basketService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getbasket/{basketId}")
	public ResponseEntity<BasketModel> findById(@PathVariable("basketId") Long basketId)throws BasketNotFoundException {
		ResponseEntity<BasketModel> response = null;
		System.out.println("find-by-basketid");
		BasketModel basket = basketService.findById(basketId);
		
		if (basket == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(basket, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/getbasketbycustomerid/{customerId}")
	public ResponseEntity<List<BasketModel>> findAllByCustomerId(@PathVariable(name = "customerId") Long customerId)throws BasketNotFoundException {
		ResponseEntity<BasketModel> response = null;
		List<BasketModel> basket = basketService.findAllByCustomerId(customerId);

		return new ResponseEntity<>(basketService.findAllByCustomerId(customerId), HttpStatus.OK); 
		
	}
	
	@PostMapping("/addbasket")
	public ResponseEntity<BasketModel> createBasket(@RequestBody BasketModel basket) throws BasketNotFoundException {
		basket = basketService.add(basket);
		return new ResponseEntity<>(basket, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletebasket/{basketId}")
	public ResponseEntity<Void> deleteBasket(@PathVariable("basketId") Long basketId) {
		ResponseEntity<Void> response = null;
		BasketModel basket = basketService.findById(basketId);
		if (basket == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			basketService.deleteById(basketId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping("/updatebasket/{basketId}")
	public ResponseEntity<BasketModel> updateCustomer(@RequestBody BasketModel basket,@PathVariable("basketId") Long basketId)throws BasketNotFoundException {
		basket = basketService.update(basket,basket.getBasketId());
		return new ResponseEntity<>(basket, HttpStatus.OK);
	}
	
	@GetMapping("/getallproducts")
	public ResponseEntity<List<BasketModel>> showAll() {
		return new ResponseEntity<>(basketService.findAll(), HttpStatus.OK);
	}

}
