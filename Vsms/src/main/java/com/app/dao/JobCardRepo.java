package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.JobCard;

public interface JobCardRepo extends JpaRepository<JobCard, Integer>{

	@Query("select j from JobCard j where j.mechanicAssigned=:mech and isActive=true")
	List<JobCard> getJobs(@Param("mech") String mech);
	
	@Query("select count(*) from JobCard j where j.mechanicAssigned=:mech and isActive=false")
	int  countCompletedRequest(String mech);
	
	
	@Query("select count(*) from JobCard j where j.mechanicAssigned=:mechName and isActive=true")
	int countPendingRequest(String mechName);

	@Query(value = "select * from jobcard order by id desc limit 2",nativeQuery = true)
	List<JobCard> fetchRecentjobCards();

	
	List<JobCard> findAllBycustomerEmail(String email);
	
	//select * from jobcard order by id desc limit 10;
	/*
	 * @Query("update JobCard j set isActive=false where j.id=:id") String
	 */
	//List<JobCard> findById(int id);
	///@Query("select j from JobCard j ")
	//List<JobCard> getJobs(@Param("mechName") String mechName);
}
