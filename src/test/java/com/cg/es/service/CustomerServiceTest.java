package com.cg.es.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.cg.es.entity.Manager;
import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.model.AddressModel;
import com.cg.es.model.CustomerModel;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ManagerRepository;



@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepo;
	
	@InjectMocks
	private CustomerServiceImpl service;
	@Mock
	private ManagerRepository managerRepo;
	
	@InjectMocks
	private ManagerServiceImpl managerService;
	
	@Test
	@DisplayName("add customer")
	void testAdd() throws CustomerNotFoundException {
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(1L,"mgr@123");
		CustomerEntity customer=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		assertTrue(customerRepo.save(customer) != null);
	}


	@Test
	@DisplayName("CustomerDetails should retrive")
	void testFindAll() {
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(1L,"mgr@123");
		List<CustomerEntity> testData=Arrays.asList(new CustomerEntity[] {
				new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager)
				
		});
		
		Mockito.when(customerRepo.findAll()).thenReturn(testData);
		AddressModel address=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		List<CustomerModel> expected=Arrays.asList(new CustomerModel[] {
				new CustomerModel(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address,1L)
				
		});
		
		List<CustomerModel> actual = service.findAll();
		
		assertEquals(expected,actual);

	}
	
	
	@Test
	@DisplayName("get by Id ")
	void testFindById () {
		AddressModel address1=new AddressModel("20-1-02","kvr street","ap nagar","chennai","Tamil Nadu",600062);
		Manager manager=new Manager(101L,"mgr@123");
		CustomerEntity testdata=new CustomerEntity(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,manager);
		
		CustomerModel expected=new CustomerModel(101L,"Ajay","ajay@123","ajay@gmail.com","7731026762",address1,101L);
		
		
		Mockito.when(customerRepo.findById(testdata.getCustomerId())).thenReturn(Optional.of(testdata));
	
		CustomerModel actual=service.findById(testdata.getCustomerId());
		
		assertEquals(expected,actual);
	}
	
	
	@Test
	@DisplayName("exists by number ")
	void testExistsBynumber () {
		AddressModel address1=new AddressModel("1-100","west coast","sarojini","Mumbai","Maharastra",500001);
		Manager manager=new Manager(101L,"manager@123");
		CustomerEntity testdata=new CustomerEntity(101L,"9988776655","vishal123@gmail.com","Vishal","vishal@123",address1,manager);
		
		boolean expected=true;
		
		Mockito.when(customerRepo.existsByCustomerPhone(testdata.getCustomerPhone())).thenReturn(true);
	
		boolean actual=service.existsByCustomerPhone(testdata.getCustomerPhone());
		
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("exists by Email ")
	void testExistsByEmail() {
		AddressModel address1=new AddressModel("1-100","west coast","sarojini","Mumbai","Maharastra",500001);
		Manager manager=new Manager(101L,"manager@123");
		CustomerEntity testdata=new CustomerEntity(101L,"9988776655","vishal123@gmail.com","Vishal","vishal@123",address1,manager);
		
		boolean expected=true;
		
		Mockito.when(customerRepo.existsByCustomerEmail(testdata.getCustomerEmail())).thenReturn(true);
	
		boolean actual=service.existsByCustomerEmail(testdata.getCustomerEmail());
		
		assertEquals(expected,actual);
	}
	
	
	
}
