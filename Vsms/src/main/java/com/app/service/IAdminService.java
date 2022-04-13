package com.app.service;

import java.util.List;

import com.app.dto.EnquiryResponsedto;
import com.app.dto.ResponseUserDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;

public interface IAdminService {

	public List<ResponseUserDto> fetchAllServiceAdvisor();

	public List<ResponseUserDto> fetchAllCustomers();

	public List<ResponseUserDto> fetchAllMechanic();

	public String updateMechanic(int id);

	public List<CustomerEnquiry> getCustomerEnquiry();

	public String setEnquiryResponse(EnquiryResponsedto response);

	public List<ResponseUserDto> fetchPendingApproval();

	public List<ServiceRequest> getCustomerRequest();

	public String setServiceResponse(ServiceRequest response);

	public int getAllMechanicCount();

	public int getAllServiceAdvisorCount();

	public int getAllCustomerCount();
	 
}
