package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.ElectronicProductOrderNotFoundException;
import com.cg.es.model.ElectronicProductOrderModel;

public interface IElectronicProductOrderService {
	ElectronicProductOrderModel add(ElectronicProductOrderModel electronicProductOrderModel) throws ElectronicProductOrderNotFoundException;
	ElectronicProductOrderModel update(ElectronicProductOrderModel electronicProductOrderModel,Long orderId) throws ElectronicProductOrderNotFoundException;
	void deleteById(Long orderId);
	ElectronicProductOrderModel findById(Long orderId);
	List<ElectronicProductOrderModel> findAll();
	List<ElectronicProductOrderModel> findAllByCustomerId(Long customerId);
	

}
