package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.BasketEntity;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {

}
