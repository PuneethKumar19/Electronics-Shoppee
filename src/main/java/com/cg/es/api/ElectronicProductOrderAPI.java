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

import com.cg.es.exception.ElectronicProductOrderNotFoundException;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.service.IElectronicProductOrderService;

@RestController
@RequestMapping(path="/orders")
public class ElectronicProductOrderAPI {
	@Autowired
	private IElectronicProductOrderService orderService;
	
	@GetMapping("/getallorders")
	public ResponseEntity<List<ElectronicProductOrderModel>> findAll() {
		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/getorder/{orderId}")
	public ResponseEntity<ElectronicProductOrderModel> findById(@PathVariable("orderId") Long orderId)throws ElectronicProductOrderNotFoundException {
		ResponseEntity<ElectronicProductOrderModel> response = null;
		ElectronicProductOrderModel order = orderService.findById(orderId);
		
		if (order == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(order, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/getorderbycustomerid/{customerId}")
	public ResponseEntity<List<ElectronicProductOrderModel>> findAllByCustomerId(@PathVariable(name = "customerId") Long customerId)throws ElectronicProductOrderNotFoundException {
		ResponseEntity<ElectronicProductOrderModel> response = null;
		List<ElectronicProductOrderModel> order = orderService.findAllByCustomerId(customerId);

		return new ResponseEntity<>(orderService.findAllByCustomerId(customerId), HttpStatus.OK); 
		
	}
	
	@PostMapping("/addorder")
	public ResponseEntity<ElectronicProductOrderModel> createOrder(@RequestBody ElectronicProductOrderModel order) throws ElectronicProductOrderNotFoundException {
		order = orderService.add(order);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteorder/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long orderId) {
		ResponseEntity<Void> response = null;
		ElectronicProductOrderModel order = orderService.findById(orderId);
		if (order == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			orderService.deleteById(orderId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	@PutMapping("/updateorder/{orderId}")
	public ResponseEntity<ElectronicProductOrderModel> updateOrder(@RequestBody ElectronicProductOrderModel order,@PathVariable("orderId") Long orderId)throws ElectronicProductOrderNotFoundException {
		order = orderService.update(order,order.getOrderId());
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	
	
}