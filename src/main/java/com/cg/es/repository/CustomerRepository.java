package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.CustomerEntity;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	boolean existsByCustomerPhone(String customerPhone);
	boolean existsByCustomerEmail(String customerEmail);
	
}
