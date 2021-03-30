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

import com.cg.es.exception.ManagerNotFoundException;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.service.CustomerServiceImpl;
import com.cg.es.service.EMParser;
import com.cg.es.service.ElectronicProductServiceImpl;
import com.cg.es.service.IManagerService;

@RestController
@RequestMapping(path="/manager")
public class ManagerAPI {
	@Autowired
	private IManagerService mgrService;
	
	@Autowired
	private ElectronicProductServiceImpl prodService;
	
	@Autowired
	private CustomerServiceImpl cusService;
	
	@Autowired
	private EMParser parser;
	
	@GetMapping("/getallmanagers")  /* to see all managers list */
	public ResponseEntity<List<ManagerModel>> findAllmanager() {
		return new ResponseEntity<>(mgrService.findAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/getmanager/{managerId}")
	public ResponseEntity<ManagerModel> findById(@PathVariable("managerId") Long managerId)throws ManagerNotFoundException {
		ResponseEntity<ManagerModel> response = null;
		System.out.println("find-by-mgrid");
		ManagerModel mgr = mgrService.findById(managerId);
		
		if (mgr == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(mgr, HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/addmanager") /* add manager */
	public ResponseEntity<ManagerModel> createManager(@RequestBody ManagerModel mgr) throws ManagerNotFoundException {
		mgr = mgrService.add(mgr);
		return new ResponseEntity<>(mgr, HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/deletemanager/{managerId}") /* delete by id */
	public ResponseEntity<Void> deleteManager(@PathVariable("managerId") Long managerId) {
		ResponseEntity<Void> response = null;
		ManagerModel mgr = mgrService.findById(managerId);
		if (mgr == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			mgrService.deleteById(managerId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping("/updatemanager/{managerId}") /*update by id */
	public ResponseEntity<ManagerModel> updateManager(@RequestBody ManagerModel mgr,@PathVariable("managerId") Long managerId)throws ManagerNotFoundException {
		mgr = mgrService.update(mgr ,mgr.getManagerId());
		return new ResponseEntity<>(mgr, HttpStatus.OK);
	}
	
	
/************************************************************************************************/
	
	@GetMapping("/getallcustomers/{managerId}")
	public ResponseEntity<List<CustomerModel>> getAllByManagerId(@PathVariable(name = "managerId") Long managerId)throws ManagerNotFoundException {
		ResponseEntity<CustomerModel> response = null;
		List<CustomerModel> manager = mgrService.getAllByManagerId(managerId);

		return new ResponseEntity<>(mgrService.getAllByManagerId(managerId), HttpStatus.OK); 
		
	}
	
	@GetMapping("/getallproducts/{managerId}")
	public ResponseEntity<List<ElectronicProductModel>> showAllByManagerId(@PathVariable(name = "managerId") Long managerId)throws ManagerNotFoundException {
		ResponseEntity<ElectronicProductModel> response = null;
		List<ElectronicProductModel> manager = mgrService.showAllByManagerId(managerId);

		return new ResponseEntity<>(mgrService.showAllByManagerId(managerId), HttpStatus.OK); 
		
	}
	
	@GetMapping("/getallorders/{managerId}")
	public ResponseEntity<List<ElectronicProductOrderModel>> findAllByManagerId(@PathVariable(name = "managerId") Long managerId)throws ManagerNotFoundException {
		ResponseEntity<ElectronicProductOrderModel> response = null;
		List<ElectronicProductOrderModel> manager = mgrService.findAllByManagerId(managerId);

		return new ResponseEntity<>(mgrService.findAllByManagerId(managerId), HttpStatus.OK); 
		
	}
	
//	@GetMapping(path = "/getallcust") /* get customer from manager */
//	public ResponseEntity<List<CustomerModel>> findAll() {
//		return new ResponseEntity<>(cusService.findAll(), HttpStatus.OK); 
//	}
//	
//	@DeleteMapping("deletecustomer/{1}")  /* manager can delete customer */
//	public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerId) {
//		ResponseEntity<Void> response = null;
//		CustomerModel cus = cusService.findById(customerId);
//		if (cus == null) {
//			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			cusService.deleteById(customerId);
//			response = new ResponseEntity<>(HttpStatus.OK);
//		}
//		return response;
//	}
//	@GetMapping(path = "/getallprod") /* manager can find all products */
//	public ResponseEntity<List<ElectronicProductModel>> findAllprod() {
//		return new ResponseEntity<>(prodService.findAll(), HttpStatus.OK); 
//	}
//	@GetMapping("/getprod/{1}") /* manager can find product by id */
//	public ResponseEntity<ElectronicProductModel> findByIdmed(@PathVariable("code") Long code)throws ElectronicProductNotFoundException {
//		ResponseEntity<ElectronicProductModel> response = null;
//		System.out.println("find-by-prodcode");
//		ElectronicProductModel product = prodService.findById(code);
//		
//		if (product == null) {
//			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			response = new ResponseEntity<>(product, HttpStatus.OK);
//		}
//		return response;
//	}
//	@PostMapping(path ="/addprod") /* manager can add product */
//	public ResponseEntity<ElectronicProductModel> createProduct(@RequestBody ElectronicProductModel product) throws ElectronicProductNotFoundException {
//		product = prodService.add(product);
//		return new ResponseEntity<>(product, HttpStatus.CREATED);
//	}
//	@DeleteMapping("/deleteprod/{1}") /* manager can delete product by id */
//	public ResponseEntity<Void> deleteProduct(@PathVariable("code") Long code) {
//		ResponseEntity<Void> response = null;
//		ElectronicProductModel product = prodService.findById(code);
//		if (product == null) {
//			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			prodService.deleteById(code);
//			response = new ResponseEntity<>(HttpStatus.OK);
//		}
//		return response;
//	}
//	@PutMapping("/updateprod/{1}") /* manager can update product by id */
//	public ResponseEntity<ElectronicProductModel> updateProduct(@RequestBody ElectronicProductModel product)throws ElectronicProductNotFoundException {
//		product = prodService.save(product);
//		return new ResponseEntity<>(product, HttpStatus.OK);
//	}
	

}