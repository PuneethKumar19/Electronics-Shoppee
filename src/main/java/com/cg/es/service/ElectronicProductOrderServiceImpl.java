package com.cg.es.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductOrderEntity;
import com.cg.es.exception.ElectronicProductOrderNotFoundException;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ElectronicProductOrderRepository;
@Service
public class ElectronicProductOrderServiceImpl implements IElectronicProductOrderService{
	@Autowired
	private ElectronicProductOrderRepository ordRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private EMParser parser;
	
	public ElectronicProductOrderServiceImpl() {
		
	}
	
	public ElectronicProductOrderServiceImpl(ElectronicProductOrderRepository ordRepo, EMParser parser) {
		super();
		this.ordRepo = ordRepo;
		this.parser = new EMParser();
	}

	@Override
	public ElectronicProductOrderModel add(ElectronicProductOrderModel orderModel) throws ElectronicProductOrderNotFoundException {
		
			if (orderModel != null) {
				if (ordRepo.existsById(orderModel.getOrderId())) {
					throw new ElectronicProductOrderNotFoundException("Product with Id " +orderModel.getOrderId() + " is exist already");
				} 
				else {
					orderModel = parser.parse(ordRepo.save(parser.parse(orderModel)));
				}
			}
			return orderModel;
		}

//	@Override
//	public ElectronicProductOrderModel save(ElectronicProductOrderModel orderModel) throws ElectronicProductOrderNotFoundException {
//		ElectronicProductOrder oldproduct = ordRepo.findById(orderModel.getOrderId()).orElse(null);
//		if (oldproduct == null) {
//			throw new ElectronicProductOrderNotFoundException("No Order with id " + orderModel.getOrderId() + " is present");
//		}  else {
//			orderModel = parser.parse(ordRepo.save(parser.parse(orderModel)));
//		}
//		return orderModel;
//	}
	
	

	@Override
	public void deleteById(Long orderId) {
		ordRepo.deleteById(orderId);
		
	}


	@Override
	public ElectronicProductOrderModel findById(Long orderId) {
		return parser.parse(ordRepo.findById(orderId).orElse(null));
	}


	@Override
	public List<ElectronicProductOrderModel> findAll() {
		return ordRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public ElectronicProductOrderModel update(ElectronicProductOrderModel orderModel, Long orderId) throws ElectronicProductOrderNotFoundException {
		if(orderModel != null) {
			if(!ordRepo.existsById(orderId)) {
				throw new ElectronicProductOrderNotFoundException("no such id");
			}
			orderModel = parser.parse(ordRepo.save(parser.parse(orderModel)));
		}
		return orderModel;
	}
	
	@Override
	public List<ElectronicProductOrderModel> findAllByCustomerId(Long customerId){
		Optional<CustomerEntity> customerOptional = customerRepo.findById(customerId);	
		List<ElectronicProductOrderEntity> orders = customerOptional.get().getProductOrders();	
		return orders.stream().map(parser::parse).collect(Collectors.toList());
	}

}
