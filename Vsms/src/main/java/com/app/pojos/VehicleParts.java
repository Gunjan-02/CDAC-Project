package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder.Default;

@Entity
@Table(name = "vehicle_parts")
public class VehicleParts extends BaseEntity {

	@Column(name = "part_name", length = 50)
	private String partName;

	private double rate;

	@Column(name = "qty_available")
	private int quantity;

	

	public VehicleParts() {
		System.out.println("in vehicle_parts ctor");
	}

	public VehicleParts(String partName, double rate, int quantity) {
		super();
		this.partName = partName;
		this.rate = rate;
		this.quantity = quantity;
		
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "VehicleParts [partName=" + partName + ", rate=" + rate + ", quantity=" + quantity + "]";
	}

}