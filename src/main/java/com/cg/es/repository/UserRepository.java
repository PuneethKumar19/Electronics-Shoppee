package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.es.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	
}
