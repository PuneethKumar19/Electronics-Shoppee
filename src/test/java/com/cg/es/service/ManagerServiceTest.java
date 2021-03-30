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

import com.cg.es.entity.Manager;
import com.cg.es.exception.ManagerNotFoundException;
import com.cg.es.model.ManagerModel;
import com.cg.es.repository.ManagerRepository;

@ExtendWith(MockitoExtension.class)
public class ManagerServiceTest {
	@Mock
	private ManagerRepository managerRepository;
	
	@InjectMocks
	private ManagerServiceImpl service;
	
	@Test
	@DisplayName("Manager Details should retrive")
	void testGetAll() {
		List<Manager> testData=Arrays.asList(new Manager[] {
				new Manager(1L,"mgr@123"),
				new Manager(2L,"pun@1926"),
				new Manager(3L,"mahi@4689")
		});
		
		Mockito.when(managerRepository.findAll()).thenReturn(testData);
		
		List<ManagerModel> expected=Arrays.asList(new ManagerModel[] {
				new ManagerModel(1L,"mgr@123"),
				new ManagerModel(2L,"pun@1926"),
				new ManagerModel(3L,"mahi@4689")
		});
		
		List<ManagerModel> actual = service.findAll();
		
		assertEquals(expected,actual);

	}
	
	@Test
	@DisplayName("Manager Details add")
	void testAdd() throws ManagerNotFoundException {
		Manager manager1=new Manager(1L,"mgr@123");
		
		Mockito.when(managerRepository.save(manager1)).thenReturn(manager1);
		assertTrue(managerRepository.save(manager1) != null);

	}
	

	
	@Test
	@DisplayName("get by Id ")
	void testGetById () {
		Manager testdata=new Manager(1L,"mgr@456");
		
		ManagerModel expected=new ManagerModel(1L,"mgr@456");
		
		
		Mockito.when(managerRepository.findById(testdata.getManagerId())).thenReturn(Optional.of(testdata));
		
		ManagerModel actual=service.findById(testdata.getManagerId());
		
		assertEquals(expected,actual);
	}

}