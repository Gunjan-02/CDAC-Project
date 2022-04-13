package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.JobCardRepo;
import com.app.dao.VehiclePartsRepo;
import com.app.pojos.JobCard;
import com.app.pojos.VehicleParts;

@Service
@Transactional
public class MechanicServiceImpl  implements IMechanicService{

	@Autowired
	private JobCardRepo jobCardRepo;
	
	@Autowired
	private VehiclePartsRepo vehiclePartRepo;
	
	@Override
	public List<JobCard> showPendingRequest(String mech) {
		
		List<JobCard> jobs = jobCardRepo.getJobs(mech);
		System.out.println(jobs);
		
		
		return jobs;
	}

	@Override
	public List<VehicleParts> showallParts() {
		return vehiclePartRepo.findAll();
	}

	@Override
	public String serviceComplete(int id,List<String> allproducts) {
		Optional<JobCard> card=jobCardRepo.findById(id);
		if(card !=null)
		{
			JobCard j=card.get();
			j.setActive(false);
			j.setPartsReplaced(allproducts);
			jobCardRepo.save(j);
			return "Job Card Successfully submitted"; 
		}
		return "No Job Card Found";
	}

	@Override
	public int getAllCompletedRequest(String mech) {
		return jobCardRepo.countCompletedRequest(mech);
		
	}

	@Override
	public int getAllPendingRequest(String mechName) {
		return jobCardRepo.countPendingRequest(mechName);
	}
 
}
