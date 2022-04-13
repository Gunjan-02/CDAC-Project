package com.app.dto;

import com.app.pojos.ServiceType;

public class PreviousServiceDto {

	private String customerName;

	private String customerEmail;

	private String vehicleNo;

	private String chasisNo;

	private ServiceType serviceType;

	private boolean isActive;
	
	public PreviousServiceDto() {
		// TODO Auto-generated constructor stub
	}

	public PreviousServiceDto(String customerName, String customerEmail, String vehicleNo, String chasisNo,
			ServiceType serviceType, boolean isActive) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.vehicleNo = vehicleNo;
		this.chasisNo = chasisNo;
		this.serviceType = serviceType;
		this.isActive = isActive;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "PreviousServiceDto [customerName=" + customerName + ", customerEmail=" + customerEmail + ", vehicleNo="
				+ vehicleNo + ", chasisNo=" + chasisNo + ", serviceType=" + serviceType + ", isActive=" + isActive
				+ "]";
	}
	
	
}
