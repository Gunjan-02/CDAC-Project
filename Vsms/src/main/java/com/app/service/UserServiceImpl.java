package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepo;
import com.app.pojos.Roles;
import com.app.pojos.User;

@Service 
@Transactional 
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public User authenticateUser(String email, String pwd) {
	
		return userRepo.findByEmailAndPassword(email, pwd);
	}
	
	
	@Override
	public User createNewCustomer(User user) {
		user.setRole(Roles.CUSTOMER);
		user.setActive(true);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}
	
	@Override
	public User createNewAdmin(User user) {
		user.setRole(Roles.ADMIN);
		user.setActive(true);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}
	
	@Override
	public User createNewServiceAdvisor(User user) {
		user.setRole(Roles.SERVICEADVISOR);
		user.setActive(true);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}
	
	@Override
	public User createNewMechanic(User user) {
		user.setRole(Roles.MECHANIC);
		user.setActive(false);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}


	@Override
	public String changePassword(String email, String changePassword) {
		User user=userRepo.findByEmail(email);
		user.setPassword(changePassword);
		userRepo.save(user);
		return "Password is changed Successfully";
	}

}
