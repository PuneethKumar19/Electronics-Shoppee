package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.ManagerNotFoundException;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.model.ManagerModel;

public interface IManagerService {
	ManagerModel add(ManagerModel managerModel) throws ManagerNotFoundException;
	ManagerModel update(ManagerModel managerModel,Long managerId)throws ManagerNotFoundException;
	void deleteById(Long managerId);
	ManagerModel findById(Long managerId);
	List<ManagerModel> findAll();
	List<CustomerModel> getAllByManagerId(Long managerId);
	List<ElectronicProductModel> showAllByManagerId(Long managerId);
	List<ElectronicProductOrderModel> findAllByManagerId(Long managerId);

}
