package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Roles;
import com.app.pojos.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String email,String pwd);

	User findByEmail(String email);

	
	@Query("select u.name from User u where u.role=:role and isActive=true")
	List<String> fetchMechanicName(@Param("role") Roles mech);

	
	
	List<User> findAllByRole(Roles role);

	int countByrole(Roles mechanic);
	
}
