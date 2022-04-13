package com.app.service;

import java.util.List;

import com.app.dto.PreviousServiceDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;

public interface ICustomerService {
	public String addnewEnquiry(CustomerEnquiry enquiry);

	public List<CustomerEnquiry> findAllEnquiries(int custId);

	public List<PreviousServiceDto> getPreviousRecord(String email);

	public String addRequest(ServiceRequest request);

	public List<ServiceRequest> showPreviousRequest(int custId);
}
