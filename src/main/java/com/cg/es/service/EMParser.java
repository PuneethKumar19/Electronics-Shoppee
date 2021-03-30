package com.cg.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.BasketEntity;
import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductEntity;
import com.cg.es.entity.ElectronicProductOrderEntity;
import com.cg.es.entity.Manager;
import com.cg.es.entity.UserEntity;
import com.cg.es.model.BasketModel;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.model.ProductType;
import com.cg.es.model.UserModel;
import com.cg.es.repository.BasketRepository;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ElectronicProductOrderRepository;
import com.cg.es.repository.ElectronicProductRepository;
import com.cg.es.repository.ManagerRepository;

@Service
public class EMParser {
	
	@Autowired
	private ManagerRepository managerRepo;

	@Autowired
	private CustomerRepository customerRepo;

	
	@Autowired
	private BasketRepository basketRepo;

	
	@Autowired
	private ElectronicProductRepository eRepo;
	
	@Autowired
	private ElectronicProductOrderRepository electronicproductorderrepo;

	public CustomerModel parse(CustomerEntity source) {
		return source == null ? null
				: new CustomerModel(source.getCustomerId(),
						source.getCustomerName(),
						source.getCustomerPassword(),
						source.getCustomerEmail(),
						source.getCustomerPhone(),
						source.getAddress(),
						source.getManager().getManagerId());
	}

	public CustomerEntity parse(CustomerModel source) {
		return source == null ? null
				: new CustomerEntity(source.getCustomerId(),
						source.getCustomerName(),
						source.getCustomerPassword(),
						source.getCustomerEmail(),
						source.getCustomerPhone(),
						source.getAddress(),
						managerRepo.findById(source.getManagerId()).orElse(null));
	}
	
	public ElectronicProductModel parse(ElectronicProductEntity source) {
		return source == null ? null
				: new ElectronicProductModel(source.getProductId(),
						source.getProductName(),
						source.getProductPrice(),
						source.getCreatedDate(),
						String.valueOf(source.getProductType()),
						source.getCustomer().getCustomerId(),
						source.getManager().getManagerId());
	}

	
	 
	 public ElectronicProductEntity parse(ElectronicProductModel source) { 
		 return source==null?null:
			 new  ElectronicProductEntity(source.getProductId(),
						source.getProductName(),
						source.getProductPrice(),
						source.getCreatedDate(),
						ProductType.valueOf(source.getProductType()),
						customerRepo.findById(source.getCustomerId()).orElse(null),
						managerRepo.findById(source.getManagerId()).orElse(null));
							 
	 }
	
	public ElectronicProductOrderModel parse(ElectronicProductOrderEntity source) {
		return source == null ? null
				: new ElectronicProductOrderModel(source.getOrderId(),
						source.getProductQty(),
						source.getOrderDate(),
						source.getAmount(),
						source.getCustomer().getCustomerId(),
						source.getBasket().getBasketId(),
						source.getManager().getManagerId());
	}
	
	public ElectronicProductOrderEntity parse(ElectronicProductOrderModel source) {
		return source == null ? null
				: new ElectronicProductOrderEntity(source.getOrderId(),
						source.getProductQty(),
						source.getOrderDate(),
						source.getAmount(),
						customerRepo.findById(source.getCustomerId()).orElse(null),
						basketRepo.findById(source.getBasketId()).orElse(null),
						managerRepo.findById(source.getManagerId()).orElse(null));
	}
	
	public BasketModel parse(BasketEntity source) {

		return source == null ? null
				: new BasketModel(source.getBasketId(),
						source.getGrandTotal(),
						source.getQuantityOfProduct(),
						source.getCustomer().getCustomerId());
	}
	
	public BasketEntity parse(BasketModel source) {
		
		return source == null ? null
				: new BasketEntity(source.getBasketId(),
						source.getQuantityOfProduct(),
						source.getGrandTotal(),
						customerRepo.findById(source.getCustomerId()).orElse(null));
	}
	
	public ManagerModel parse(Manager source) {
		return source == null ? null
				: new ManagerModel(source.getManagerId(),
						source.getPassword());
	}
	
	public Manager parse(ManagerModel source) {
		return source == null ? null
				: new Manager(source.getManagerId(),
						source.getPassword());
	}
	
	public UserModel parse(UserEntity source) {
		return source==null?null:
			new UserModel(source.getCustomerId(),
						source.getPassword(),
						source.getRole());
	}

	public UserEntity parse(UserModel source) {
		return source==null?null:
			new UserEntity(source.getCustomerId(),
						source.getPassword(),
						source.getRole());
	}
	

	
	
	
	
}
