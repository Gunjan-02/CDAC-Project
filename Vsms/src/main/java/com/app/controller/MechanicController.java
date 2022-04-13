package com.app.controller;

import java.util.ArrayList;
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

import com.app.dto.AddProductArrayDto;
import com.app.dto.MechanicNameDto;
import com.app.service.IMechanicService;

@RestController
@RequestMapping("/mechanic")
@CrossOrigin
public class MechanicController {

	@Autowired
	private IMechanicService mechanicService;

	// Request to get all the pending work
	@GetMapping("/pending")
	public ResponseEntity<?> showPendingJobCards(@RequestBody MechanicNameDto mech) {
		System.out.println("mechName =" + mech);
		return new ResponseEntity<>(mechanicService.showPendingRequest(mech.getMechName()), HttpStatus.OK);

	}

	// request to get the list of all parts
	@GetMapping("/getparts")
	public ResponseEntity<?> showParts() {
		return new ResponseEntity<>(mechanicService.showallParts(), HttpStatus.OK);
	}

	// request to mark a jobcard as complete and app products in db by job id
	@PostMapping("/completed/{jobid}")
	public ResponseEntity<?> completedService(@PathVariable int jobid, @RequestBody AddProductArrayDto products) {

		List<String> allproducts = new ArrayList<>();
		String[] product = products.getProducts();

		for (String p : product) {
			allproducts.add(p);

		}
		System.out.println(allproducts);
		String message = mechanicService.serviceComplete(jobid, allproducts);

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// request to get count of jobs completed
	@GetMapping("/completedreq")
	public ResponseEntity<?> getAllCompletedRequest(@RequestBody MechanicNameDto mech) {
		int count = mechanicService.getAllCompletedRequest(mech.getMechName());
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// request to get count of pending jobs
	@GetMapping("/pendingreq")
	public ResponseEntity<?> getAllPendingRequest(@RequestBody MechanicNameDto mech) {
		int count = mechanicService.getAllPendingRequest(mech.getMechName());
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

}
