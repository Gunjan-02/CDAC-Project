package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer_enquiry")
public class CustomerEnquiry extends BaseEntity {

	@Column(name = "custId")
	private int custId;

	@Column(length = 20)
	private String customerName;
	@Column(length = 25)
	private String subject;

	private String description;

	private boolean isActive;
	
	@Column(length = 50)
	private String Response;

	public CustomerEnquiry() {
		// TODO Auto-generated constructor stub
	}

	public CustomerEnquiry(int custId, String customerName, String subject, String description, boolean isActive,
			String response) {
		super();
		this.custId = custId;
		this.customerName = customerName;
		this.subject = subject;
		this.description = description;
		this.isActive = isActive;
		Response = response;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "CustomerEnquiry [custId=" + custId + ", customerName=" + customerName + ", subject=" + subject
				+ ", description=" + description + ", isActive=" + isActive + ", Response=" + Response + "]";
	}

}
