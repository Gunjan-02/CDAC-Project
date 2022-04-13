package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerEnquiryRepo;
import com.app.dao.JobCardRepo;
import com.app.dao.ServiceRequestRepo;
import com.app.dto.PreviousServiceDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.JobCard;
import com.app.pojos.ServiceRequest;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerEnquiryRepo repo;

	@Autowired
	JobCardRepo jobRepo;
	
	@Autowired
	ServiceRequestRepo servicerepo;

	@Override
	public String addnewEnquiry(CustomerEnquiry enquiry) {
		enquiry.setActive(true);
		repo.save(enquiry);
		return "Enquiry Successfully Submitted";
	}

	@Override
	public List<CustomerEnquiry> findAllEnquiries(int custId) {
		return repo.findAllBycustId(custId);
	}

	@Override
	public List<PreviousServiceDto> getPreviousRecord(String email) {
		List<JobCard> cards= jobRepo.findAllBycustomerEmail(email);
		List<PreviousServiceDto> dtoList=new ArrayList<>();
	
		
		for (JobCard c : cards) {
			PreviousServiceDto dto =new PreviousServiceDto();
			BeanUtils.copyProperties(c, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public String addRequest(ServiceRequest request) {
		request.setIsactive(true);
		servicerepo.save(request);
		return "Request added successfully";
	}

	@Override
	public List<ServiceRequest> showPreviousRequest(int custId) {
		List<ServiceRequest> list =servicerepo.findAllBycustId(custId);
		return list;
	}

}
