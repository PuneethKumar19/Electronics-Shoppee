package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.UserNotFoundException;
import com.cg.es.model.UserModel;

public interface IUserService {

	boolean existsById(Long customerId);
	
	
	UserModel add(UserModel user) throws UserNotFoundException;	
	UserModel save(UserModel user) throws UserNotFoundException;
	
	UserModel signIn(UserModel user) throws UserNotFoundException;	
	UserModel signOut(UserModel user);
	
	void deleteById(Long customerId);
	
	UserModel findById(Long customerId);
	List<UserModel> findAll();
}
