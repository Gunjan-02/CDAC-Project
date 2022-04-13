package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;

public interface ServiceRequestRepo extends JpaRepository<ServiceRequest, Integer>{

	List<ServiceRequest> findAllBycustId(int custId);

	List<ServiceRequest> findAllByisactive(boolean b);

}
