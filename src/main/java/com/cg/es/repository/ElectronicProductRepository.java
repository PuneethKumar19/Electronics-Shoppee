package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.ElectronicProductEntity;

@Repository
public interface ElectronicProductRepository extends JpaRepository<ElectronicProductEntity, Long>{

	

}
