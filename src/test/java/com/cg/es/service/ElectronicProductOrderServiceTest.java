package com.cg.es.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.es.entity.BasketEntity;
import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductOrderEntity;
import com.cg.es.entity.Manager;
import com.cg.es.exception.ElectronicProductOrderNotFoundException;
import com.cg.es.model.AddressModel;
import com.cg.es.repository.ElectronicProductOrderRepository;

@ExtendWith(MockitoExtension.class)
public class ElectronicProductOrderServiceTest {
	@Mock
	private ElectronicProductOrderRepository electronicProductOrderRepo;
	
	@InjectMocks
	private ElectronicProductOrderServiceImpl service;
	
	@Test
	@DisplayName("Order Details add")
	void testAdd() throws ElectronicProductOrderNotFoundException {
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(1L,"mgr@123");
		CustomerEntity customer=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		BasketEntity basket=new BasketEntity(1L,1,50000.00,customer);
		ElectronicProductOrderEntity productOrder=new ElectronicProductOrderEntity(1L,1,LocalDate.now(),50000.00,customer,basket,manager);
		Mockito.when(electronicProductOrderRepo.save(productOrder)).thenReturn(productOrder);
		assertTrue(electronicProductOrderRepo.save(productOrder) != null);

	}
	


	
}
