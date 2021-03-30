package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.ElectronicProductOrderEntity;

@Repository
public interface ElectronicProductOrderRepository extends JpaRepository<ElectronicProductOrderEntity, Long> {

}
