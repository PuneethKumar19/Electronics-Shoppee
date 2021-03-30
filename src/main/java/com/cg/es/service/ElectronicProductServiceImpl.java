package com.cg.es.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductEntity;
import com.cg.es.entity.ElectronicProductOrderEntity;
import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.exception.ElectronicProductNotFoundException;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ElectronicProductRepository;

@Service
public class ElectronicProductServiceImpl implements IElectronicProductService{
	@Autowired
	private ElectronicProductRepository prodRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private EMParser parser;
	
	public ElectronicProductServiceImpl() {
		//no implementation
	}
	
	public ElectronicProductServiceImpl(ElectronicProductRepository prodRepo, EMParser parser) {
		super();
		this.prodRepo = prodRepo;
		this.parser = new EMParser();
	}
	

	@Override
	public ElectronicProductModel add(ElectronicProductModel electronicProductModel) throws ElectronicProductNotFoundException {
		
			if (electronicProductModel != null) {
				if (prodRepo.existsById(electronicProductModel.getProductId())) {
					throw new ElectronicProductNotFoundException("Product with Id " +electronicProductModel.getProductId() + " is exist already");
				} 
				else {
					electronicProductModel = parser.parse(prodRepo.save(parser.parse(electronicProductModel)));
				}
			}
			return electronicProductModel;
		}
	
	@Override
	public ElectronicProductModel update(ElectronicProductModel electronicProductModel, Long productId) throws ElectronicProductNotFoundException {
		if(electronicProductModel != null) {
			if(!prodRepo.existsById(productId)) {
				throw new ElectronicProductNotFoundException("no such id");
				}
			electronicProductModel = parser.parse(prodRepo.save(parser.parse(electronicProductModel)));
			}
		return electronicProductModel;
		}

	
	@Override
	public void deleteById(Long productId) {
		prodRepo.deleteById(productId);
		
	}


	@Override
	public ElectronicProductModel findById(Long productId) {
		return parser.parse(prodRepo.findById(productId).orElse(null));
	}


	@Override
	public List<ElectronicProductModel> findAll() {
		return prodRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public List<ElectronicProductModel> findAllByCustomerId(Long customerId){
		Optional<CustomerEntity> customerOptional = customerRepo.findById(customerId);	
		List<ElectronicProductEntity> products = customerOptional.get().getElecproduct();	
		return products.stream().map(parser::parse).collect(Collectors.toList());
	}


}
