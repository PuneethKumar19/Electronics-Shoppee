package com.cg.es.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.exception.UserNotFoundException;
import com.cg.es.model.UserModel;
import com.cg.es.repository.UserRepository;



@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EMParser parser;
	
	public UserServiceImpl() {
		
	}
	
	/**
	 * @param userRepo
	 * @param parser
	 */
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
		this.parser = new EMParser();
	}

	
	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public EMParser getParser() {
		return parser;
	}

	public void setParser(EMParser parser) {
		this.parser = parser;
	}

	@Override
	public UserModel add(UserModel user) throws UserNotFoundException {
		if(user !=null) {
			if(userRepo.existsById(user.getCustomerId())) {
				throw new UserNotFoundException("User "+user.getCustomerId()+" is already Exists");
			}if(!user.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$")) {
				System.out.println(user.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$")+" "+user.getPassword());
				throw new UserNotFoundException("Password should contain upper case, Lower case, Special charecter, numbers and length minimum 8");
			}
			else {
				user=parser.parse(userRepo.save(parser.parse(user)));
			}
		}
		return user;
	}

	@Override
	public UserModel save(UserModel user) throws UserNotFoundException {
		UserModel old=parser.parse(userRepo.findById(user.getCustomerId()).orElse(null));
		if(old == null) {
			throw new UserNotFoundException("No user with Id "+user.getCustomerId()+" is present");
		}else if(!user.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$")) {
			throw new UserNotFoundException("Password should contain upper case, Lower case, Special charecter, numbers and length minimum 8");
		}else {
			user=parser.parse(userRepo.save(parser.parse(user)));
		}
		return user;
	}

	@Override
	public List<UserModel> findAll() {
		return userRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long customerId) {
		userRepo.deleteById(customerId);
		
	}

	@Override
	public UserModel findById(Long customerId) {
		return parser.parse(userRepo.findById(customerId).orElse(null));
	}

	@Override
	public boolean existsById(Long customerId) {
		return userRepo.existsById(customerId);
	}

	@Override
	public UserModel signIn(UserModel user) throws UserNotFoundException {
		if(userRepo.findById(user.getCustomerId()).orElse(null).getPassword()==user.getPassword()) {
			return user;
		}else {
			throw new UserNotFoundException("Invalid password / user");
		}
	}

	@Override
	public UserModel signOut(UserModel user) {
		return null;
	}


	}
