package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.JobCard;
import com.app.service.IServiceAdvisorService;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceAdvisorController {
	
	@Autowired
	IServiceAdvisorService advisor;
	
	
	//Request to get add new Job card
	@PostMapping("/add")
	public ResponseEntity<?> addJobCard(@RequestBody JobCard card)
	{
		String message = advisor.addJob(card);
		return new ResponseEntity<>(message,HttpStatus.OK);
		
	}
	  
	//Fetch all mechanic name whose actice status is true
	@GetMapping("/fetchmechanic")
	public ResponseEntity<?> fetchMechanic()
	{
		List<String> names = advisor.fetchMechanicName();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}
	
	
	//Request to fetch last 10 jobs Done
	@GetMapping("/fetchrecentjobs")
	public ResponseEntity<?> fetchRecentJobCards()
	{
		List<JobCard> jobs = advisor.fetchRecentJobCards();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
	
}
