package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EnquiryResponsedto;
import com.app.dto.MechanicNameDto;
import com.app.dto.ResponseUserDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	IAdminService admin;

	@GetMapping("/fetchserviceadvisor")
	public ResponseEntity<?> fetchServiceAdvisor() {
		List<ResponseUserDto> serviceAdvisors = admin.fetchAllServiceAdvisor();
		return new ResponseEntity<>(serviceAdvisors, HttpStatus.OK);
	}

	@GetMapping("/fetchcustomers")
	public ResponseEntity<?> fetchcustomers() {
		List<ResponseUserDto> names = admin.fetchAllCustomers();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}

	@GetMapping("/fetchmechanics")
	public ResponseEntity<?> fetchmechanic() {
		List<ResponseUserDto> names = admin.fetchAllMechanic();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}

	// request to approve mechanic by id
	@PostMapping("/updatemechanicstatus/{id}")
	public ResponseEntity<?> updateMechanic(@PathVariable int id)

	{
		String message = admin.updateMechanic(id);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	// request to show allactive customer enquiry
	@GetMapping("/getcustomerenquiry")
	public ResponseEntity<?> getCustomerEnquiry() {
		List<CustomerEnquiry> customer = admin.getCustomerEnquiry();
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	// request to show allactive customer service requests
	@GetMapping("/getcustomerrequest")
	public ResponseEntity<?> getCustomerRequest() {
		List<ServiceRequest> requests = admin.getCustomerRequest();
		return new ResponseEntity<>(requests, HttpStatus.OK);
	}

	// request to set response for Service Request

	@PostMapping("/setserviceresponse")
	public ResponseEntity<?> setEnquiryResponse(@RequestBody ServiceRequest response) {

		String message = admin.setServiceResponse(response);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	// request to set response for customer enquiry
	@PostMapping("/setresponse")
	public ResponseEntity<?> setEnquiryResponse(@RequestBody EnquiryResponsedto response) {

		String message = admin.setEnquiryResponse(response);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Request to get all inactive mechanic list
	@GetMapping("/pendingapproval")
	public ResponseEntity<?> pendingApproval() {
		List<ResponseUserDto> names = admin.fetchPendingApproval();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}
	

	//Request to count all Mechanic
	@GetMapping("/countmechanic")
	public ResponseEntity<?> getAllMechanicCount() {
		int count = admin.getAllMechanicCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	

	//Request to count all ServiceAdvisors
	@GetMapping("/countserviceadvisor")
	public ResponseEntity<?> getAllServiceAdvisorCount() {
		int count = admin.getAllServiceAdvisorCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
		
	
	//Request to count all customers
	@GetMapping("/countcustomer")
	public ResponseEntity<?> getAllCustomerCount() {
		int count = admin.getAllCustomerCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	
	
	
	
	

}
