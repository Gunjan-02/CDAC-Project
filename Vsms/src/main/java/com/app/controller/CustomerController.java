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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.GetEmailDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	ICustomerService service;

	// Request to add new enquiry
	@PostMapping("/addenquiry")
	public ResponseEntity<?> addNewEnquiry(@RequestBody CustomerEnquiry enquiry) {
		System.out.println(enquiry);
		// service.addnewEnquiry(enquiry);
		return new ResponseEntity<>(service.addnewEnquiry(enquiry), HttpStatus.OK);
	}

	// request to get all the enquiries from db using custId
	@GetMapping("/viewenquiry/{custId}")
	public ResponseEntity<?> showEnquiries(@PathVariable int custId) {
		System.out.println("customerId = " + custId);
		List<CustomerEnquiry> list = service.findAllEnquiries(custId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Request to get all previous service records using custEmail
	@GetMapping("/previousrecord")
	public ResponseEntity<?> previousRecord(@RequestBody GetEmailDto dto) {
		System.out.println(dto.getEmail());
		// service.getPreviousRecord(dto.getEmail());
		return new ResponseEntity<>(service.getPreviousRecord(dto.getEmail()), HttpStatus.OK);
	}

	// Request to add new service Request
	@PostMapping("/requestbycustomer")
	public ResponseEntity<?> RequestByCustomer(@RequestBody ServiceRequest request) {
		String addRequest = service.addRequest(request);
		return new ResponseEntity<>(addRequest, HttpStatus.OK);
	}
	
	//Show All the service requests
	@GetMapping("/showpreviousrequest/{custId}")
	public ResponseEntity<?>  showPreviousRequest(@PathVariable int custId)
	{
		List<ServiceRequest> list=service.showPreviousRequest(custId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
