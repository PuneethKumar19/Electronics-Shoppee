package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.BasketNotFoundException;
import com.cg.es.model.BasketModel;
import com.cg.es.model.ElectronicProductModel;

public interface IBasketService {
	BasketModel add(BasketModel basketModel) throws BasketNotFoundException;
	void deleteById(Long basketId);
	BasketModel findById(Long basketId);
	List<BasketModel> findAll();
	List<ElectronicProductModel> showAll();
	BasketModel update(BasketModel basketModel,Long basketId)throws BasketNotFoundException;
	List<BasketModel> findAllByCustomerId(Long customerId);


}
