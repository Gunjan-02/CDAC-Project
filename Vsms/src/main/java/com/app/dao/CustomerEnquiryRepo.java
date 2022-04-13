package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CustomerEnquiry;

public interface CustomerEnquiryRepo extends JpaRepository<CustomerEnquiry, Integer> {

	List<CustomerEnquiry> findAllBycustId(int custId);

	List<CustomerEnquiry> findAllByisActive(boolean b);

}
