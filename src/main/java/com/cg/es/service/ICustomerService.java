package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.model.CustomerModel;

public interface ICustomerService {
	CustomerModel add(CustomerModel customerModel) throws CustomerNotFoundException;
	CustomerModel update(CustomerModel customerModel,Long customerId) throws CustomerNotFoundException;
	void deleteById(Long customerId);
	CustomerModel findById(Long customerId);
	List<CustomerModel> findAll();
	boolean existsByCustomerPhone(String customerPhone); 
	boolean existsByCustomerEmail(String customerEmail);
	
	

}
