package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerEnquiryRepo;
import com.app.dao.ServiceRequestRepo;
import com.app.dao.UserRepo;
import com.app.dto.EnquiryResponsedto;
import com.app.dto.ResponseUserDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.Roles;
import com.app.pojos.ServiceRequest;
import com.app.pojos.User;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	CustomerEnquiryRepo custrepo;
	
	@Autowired
	ServiceRequestRepo servicerequestrepo;

	@Override
	public List<ResponseUserDto> fetchAllServiceAdvisor() {

		List<User> users = userRepo.findAllByRole(Roles.SERVICEADVISOR);
		System.out.println(users.toString());

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			BeanUtils.copyProperties(u, dto);
			list.add(dto);

		}
		return list;

	}

	@Override
	public List<ResponseUserDto> fetchAllCustomers() {

		List<User> users = userRepo.findAllByRole(Roles.CUSTOMER);
		System.out.println(users.toString());

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			BeanUtils.copyProperties(u, dto);
			System.out.println(dto.toString());
			list.add(dto);
		}
		return list;
	}

	@Override
	public List<ResponseUserDto> fetchAllMechanic() {

		List<User> users = userRepo.findAllByRole(Roles.MECHANIC);

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			if (u.isActive() == true) {
				BeanUtils.copyProperties(u, dto);
				list.add(dto);
			}

		}
		return list;

	}

	@Override
	public String updateMechanic(int id) {
		Optional<User> u = userRepo.findById(id);
		User mech = u.get();
		mech.setActive(true);
		userRepo.save(mech);
		return "Request Approved Successfully";
	}

	@Override
	public List<CustomerEnquiry> getCustomerEnquiry() {
		List<CustomerEnquiry> list = custrepo.findAllByisActive(true);
		return list;
	}

	@Override
	public String setEnquiryResponse(EnquiryResponsedto response) {
		Optional<CustomerEnquiry> customer = custrepo.findById(response.getId());
		CustomerEnquiry enquiry = customer.get();
		enquiry.setResponse(response.getResponse());
		enquiry.setActive(false);
		custrepo.save(enquiry);

		return "Response is been sended";
	}

	@Override
	public List<ResponseUserDto> fetchPendingApproval() {
		List<User> users = userRepo.findAllByRole(Roles.MECHANIC);

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			if (u.isActive() == false) {
				BeanUtils.copyProperties(u, dto);
				list.add(dto);
			}

		}
		return list;

	}

	@Override
	public List<ServiceRequest> getCustomerRequest() {
		List<ServiceRequest> list = servicerequestrepo.findAllByisactive(true);
		
		return list;
	}

	@Override
	public String setServiceResponse(ServiceRequest response) {
		response.setIsactive(false);
		servicerequestrepo.save(response);
		return "Response is been sended";
	}

	@Override
	public int getAllMechanicCount() {
			return userRepo.countByrole(Roles.MECHANIC);
	}

	@Override
	public int getAllServiceAdvisorCount() {
		return userRepo.countByrole(Roles.SERVICEADVISOR);
	}

	@Override
	public int getAllCustomerCount() {
		return userRepo.countByrole(Roles.CUSTOMER);
	}

}
