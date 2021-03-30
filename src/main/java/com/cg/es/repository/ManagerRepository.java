package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
	
}