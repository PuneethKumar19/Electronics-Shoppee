package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.ElectronicProductNotFoundException;
import com.cg.es.model.ElectronicProductModel;

public interface IElectronicProductService {
	ElectronicProductModel add(ElectronicProductModel electronicProductModel) throws ElectronicProductNotFoundException;
	ElectronicProductModel update(ElectronicProductModel electronicProductModel,Long productId) throws ElectronicProductNotFoundException;
	void deleteById(Long productId);
	ElectronicProductModel findById(Long productId);
	List<ElectronicProductModel> findAll();
	List<ElectronicProductModel> findAllByCustomerId(Long customerId);
	

}
