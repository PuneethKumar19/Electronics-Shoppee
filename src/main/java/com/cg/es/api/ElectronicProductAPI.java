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

import com.cg.es.exception.ElectronicProductNotFoundException;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.service.ElectronicProductServiceImpl;

@RestController
@RequestMapping(path="/product")

public class ElectronicProductAPI {
	@Autowired
	private ElectronicProductServiceImpl elecprodService;
	
	@GetMapping("/getallproducts")
	public ResponseEntity<List<ElectronicProductModel>> findAll() {
		return new ResponseEntity<>(elecprodService.findAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/getproduct/{productId}")
	public ResponseEntity<ElectronicProductModel> findById(@PathVariable("productId") Long productId)throws ElectronicProductNotFoundException {
		ResponseEntity<ElectronicProductModel> response = null;
		System.out.println("find-by-prdid");
		ElectronicProductModel product = elecprodService.findById(productId);
		
		if (product == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/getproductbycustomerid/{customerId}")
	public ResponseEntity<List<ElectronicProductModel>> findAllByCustomerId(@PathVariable(name = "customerId") Long customerId)throws ElectronicProductNotFoundException {
		ResponseEntity<ElectronicProductModel> response = null;
		List<ElectronicProductModel> product = elecprodService.findAllByCustomerId(customerId);

		return new ResponseEntity<>(elecprodService.findAllByCustomerId(customerId), HttpStatus.OK); 
		
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<ElectronicProductModel> createProduct(@RequestBody ElectronicProductModel product) throws ElectronicProductNotFoundException {
		product = elecprodService.add(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
		ResponseEntity<Void> response = null;
		ElectronicProductModel product = elecprodService.findById(productId);
		if (product == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			elecprodService.deleteById(productId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping("/updateproduct/{productId}") /*update by id */
	public ResponseEntity<ElectronicProductModel> update(@RequestBody ElectronicProductModel product,@PathVariable("productId") Long productId)throws ElectronicProductNotFoundException {
		product = elecprodService.update(product ,product.getProductId());
		return new ResponseEntity<>(product, HttpStatus.OK);
	}


}
