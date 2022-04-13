package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailAndPasswordDto;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody EmailAndPasswordDto login) {
		User user = userService.authenticateUser(login.getEmail(), login.getPassword());
		if (user != null) {

			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>("No User Found With this credentials", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/customerregister")
	public ResponseEntity<?> addCustomer(@RequestBody User user) {
		User temp = userService.createNewCustomer(user);

		return new ResponseEntity<>(temp, HttpStatus.OK);
	}

	@PostMapping("/adminregister")
	public ResponseEntity<?> addAdmin(@RequestBody User user) {
		User temp = userService.createNewAdmin(user);

		return new ResponseEntity<>(temp, HttpStatus.OK);
	}

	@PostMapping("/serviceregister")
	public ResponseEntity<?> addServiceAdvisor(@RequestBody User user) {
		User temp = userService.createNewServiceAdvisor(user);

		return new ResponseEntity<>(temp, HttpStatus.OK);
	}

	@PostMapping("/mechanicregister")
	public ResponseEntity<?> addMechanic(@RequestBody User user) {
		User temp = userService.createNewMechanic(user);

		return new ResponseEntity<>(temp, HttpStatus.OK);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody EmailAndPasswordDto details) {
		String message = userService.changePassword(details.getEmail(), details.getPassword());
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
