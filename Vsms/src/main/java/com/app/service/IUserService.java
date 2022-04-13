package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	User authenticateUser(String email, String pwd);

	User createNewCustomer(User user);
	
	User createNewAdmin(User user);
	User createNewServiceAdvisor(User user);
	User createNewMechanic(User user);

	String changePassword(String email, String changePassword);
	
}
