package com.app.service;

import java.util.List;

import com.app.pojos.JobCard;

public interface IServiceAdvisorService {

	public String addJob(JobCard card) ;

	public List<String> fetchMechanicName();

	public List<JobCard> fetchRecentJobCards();
		
		
	

}
