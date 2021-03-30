package com.cg.es.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.BasketEntity;
import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductEntity;
import com.cg.es.exception.BasketNotFoundException;
import com.cg.es.exception.ManagerNotFoundException;
import com.cg.es.model.BasketModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.repository.BasketRepository;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ElectronicProductRepository;

@Service
public class BasketServiceImpl implements IBasketService{
	@Autowired
	private BasketRepository basketRepo;
	@Autowired
	private ElectronicProductRepository elecprodRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private EMParser parser;
	
	public BasketServiceImpl() {
		
	}

	public BasketServiceImpl(BasketRepository basketRepo, ElectronicProductRepository elecprodRepo, EMParser parser) {
		super();
		this.basketRepo = basketRepo;
		this.elecprodRepo = elecprodRepo;
		this.parser = new EMParser();
	}

	@Override
	public BasketModel add(BasketModel basketModel) throws BasketNotFoundException {
		if (basketModel != null) {
			if (basketRepo.existsById(basketModel.getBasketId())) {
				throw new BasketNotFoundException("Basket with Id " + basketModel.getBasketId() + " is exist already");
				} else {
					basketModel = parser.parse(basketRepo.save((parser.parse(basketModel))));
					}
			}
		return basketModel;
		}

//	@Override
//	public BasketModel save(BasketModel basketModel) throws BasketNotFoundException {
//		BasketEntity oldbasket = basketRepo.findById(basketModel.getBasketId()).orElse(null);
//		if (oldbasket == null) {
//			throw new BasketNotFoundException("No Order with id " + basketModel.getBasketId() + " is present");
//		}  else {
//			basketModel = parser.parse(basketRepo.save(parser.parse(basketModel)));
//		}
//		return basketModel;
//	}

	@Override
	public void deleteById(Long BasketId) {
		basketRepo.deleteById(BasketId);
		
	}

	@Override
	public BasketModel findById(Long BasketId) {
		return parser.parse(basketRepo.findById(BasketId).orElse(null));
	}

	@Override
	public List<BasketModel> findAll() {
		return basketRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public List<ElectronicProductModel> showAll() {
		return elecprodRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}


	@Override
	public BasketModel update(BasketModel basketModel, Long BasketId) throws BasketNotFoundException {
		if(basketModel != null) {
			if(!basketRepo.existsById(BasketId)) {
				throw new BasketNotFoundException("no such id");
			}
			basketModel = parser.parse(basketRepo.save(parser.parse(basketModel)));
		}
		return basketModel;
	}
	
	@Override
	public List<BasketModel> findAllByCustomerId(Long customerId){
		Optional<CustomerEntity> customerOptional = customerRepo.findById(customerId);	
		List<BasketEntity> products = customerOptional.get().getBasket();	
		return products.stream().map(parser::parse).collect(Collectors.toList());
	}

}
