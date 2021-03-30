package com.cg.es.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductEntity;
import com.cg.es.entity.Manager;
import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.model.AddressModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ProductType;
import com.cg.es.repository.ElectronicProductRepository;

@ExtendWith(MockitoExtension.class)
public class ElectronicProductServiceTest {
	@Mock
	private ElectronicProductRepository ElectronicproductRepository;
	
	@InjectMocks
	private ElectronicProductServiceImpl service;
	
	
	@Test
	@DisplayName("Product Details add")
	void testAdd() throws CustomerNotFoundException {
		
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(1L,"mgr@123");
		CustomerEntity customer=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		ElectronicProductEntity product=new ElectronicProductEntity(1L,"DELL",5600.00,LocalDate.now(),ProductType.LAPTOPS,customer,manager);
		Mockito.when(ElectronicproductRepository.save(product)).thenReturn(product);
		assertTrue(ElectronicproductRepository.save(product) != null);

}

	
	@Test
	@DisplayName("ProductDetails should retrive")
	void testFindAll() {
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(1L,"mgr@123");
		CustomerEntity customer=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		List<ElectronicProductEntity> testData=Arrays.asList(new ElectronicProductEntity[] {
				new ElectronicProductEntity(1L,"DELL",5600.00,LocalDate.now(),ProductType.LAPTOPS,customer,manager)
				
		});
		
		Mockito.when(ElectronicproductRepository.findAll()).thenReturn(testData);
		AddressModel address2=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager2=new Manager(1L,"mgr@123");
		CustomerEntity customer2=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		List<ElectronicProductModel> expected=Arrays.asList(new ElectronicProductModel[] {
				new ElectronicProductModel(1L,"DELL",5600.00,LocalDate.now(),"LAPTOPS",1L,1L)
				
		});
		
		List<ElectronicProductModel> actual = service.findAll();
		
		assertEquals(expected,actual);

	}
//	
	@Test
	@DisplayName("get by Id ")
	void testGetById () {
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(1L,"mgr@123");
		CustomerEntity customer=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		ElectronicProductEntity testdata=new ElectronicProductEntity(1L,"DELL",5600.00,LocalDate.now(),ProductType.LAPTOPS,customer,manager);
		
		ElectronicProductModel expected=new ElectronicProductModel(1L,"DELL",5600.00,LocalDate.now(),"LAPTOPS",1L,1L);
		
		
		Mockito.when(ElectronicproductRepository.findById(testdata.getProductId())).thenReturn(Optional.of(testdata));
	
		ElectronicProductModel actual=service.findById(testdata.getProductId());
		
		assertEquals(expected,actual);
	}
	


}
