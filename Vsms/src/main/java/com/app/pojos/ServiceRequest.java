package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "service_request")
public class ServiceRequest extends BaseEntity {

	private int custId;
	@Column(length = 30)
	private String customerName;
	@Column(length = 30)
	private String vehicleNumber;
	@Column(length = 30)
	private String model;

	private long mobileNumber;
	
	private boolean isactive;

	private LocalDate date;
	
	

	

	public ServiceRequest(int custId, String customerName, String vehicleNumber, String model, long mobileNumber,
			boolean isactive, LocalDate date) {
		super();
		this.custId = custId;
		this.customerName = customerName;
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.mobileNumber = mobileNumber;
		this.isactive = isactive;
		this.date = date;
	}

	public ServiceRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "ServiceRequest [custId=" + custId + ", customerName=" + customerName + ", vehicleNumber="
				+ vehicleNumber + ", model=" + model + ", mobileNumber=" + mobileNumber + ", isactive=" + isactive
				+ ", date=" + date + "]";
	}

	
	

}
