package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jobcard")
public class JobCard extends BaseEntity {
	@Column(length = 20)
	private String customerName;
	@Column(length = 20)
	private String customerEmail;
	@Column(length = 20)
	private String vehicleNo;
	@Column(length = 20)
	private String chasisNo;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ServiceType serviceType;
	@Column(length = 20)
	private String mechanicAssigned;
	@Column(length = 100)
	private String suggestedWork;

	private double esitmatedBill;

	private boolean isActive;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "parts_replaced")
	@Column(name = "parts", length = 30)
	private List<String> partsReplaced = new ArrayList<>();

	private LocalDate date;

	private LocalDate estimateDate;

	private long mobNo;

	private String model;

	public JobCard() {
		System.out.println("in pojo of JobCArd");
	}

	

	public JobCard(String customerName, String customerEmail, String vehicleNo, String chasisNo,
			ServiceType serviceType, String mechanicAssigned, String suggestedWork, double esitmatedBill,
			boolean isActive, List<String> partsReplaced, LocalDate date, LocalDate estimateDate, long mobNo,
			String model) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.vehicleNo = vehicleNo;
		this.chasisNo = chasisNo;
		this.serviceType = serviceType;
		this.mechanicAssigned = mechanicAssigned;
		this.suggestedWork = suggestedWork;
		this.esitmatedBill = esitmatedBill;
		this.isActive = isActive;
		this.partsReplaced = partsReplaced;
		this.date = date;
		this.estimateDate = estimateDate;
		this.mobNo = mobNo;
		this.model = model;
	}



	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getMechanicAssigned() {
		return mechanicAssigned;
	}

	public void setMechanicAssigned(String mechanicAssigned) {
		this.mechanicAssigned = mechanicAssigned;
	}

	public String getSuggestedWork() {
		return suggestedWork;
	}

	public void setSuggestedWork(String suggestedWork) {
		this.suggestedWork = suggestedWork;
	}

	public double getEsitmatedBill() {
		return esitmatedBill;
	}

	public void setEsitmatedBill(double esitmatedBill) {
		this.esitmatedBill = esitmatedBill;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<String> getPartsReplaced() {
		return partsReplaced;
	}

	@JsonIgnore
	public void setPartsReplaced(List<String> partsReplaced) {
		this.partsReplaced = partsReplaced;
	}

	public LocalDate getEstimateDate() {
		return estimateDate;
	}

	public void setEstimateDate(LocalDate estimateDate) {
		this.estimateDate = estimateDate;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	

	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public String getChasisNo() {
		return chasisNo;
	}



	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}



	@Override
	public String toString() {
		return "JobCard [customerName=" + customerName + ", customerEmail=" + customerEmail + ", vehicleNo=" + vehicleNo
				+ ", chasisNo=" + chasisNo + ", serviceType=" + serviceType + ", mechanicAssigned=" + mechanicAssigned
				+ ", suggestedWork=" + suggestedWork + ", esitmatedBill=" + esitmatedBill + ", isActive=" + isActive
				+ ", partsReplaced=" + partsReplaced + ", date=" + date + ", estimateDate=" + estimateDate + ", mobNo="
				+ mobNo + ", model=" + model + "]";
	}




}
