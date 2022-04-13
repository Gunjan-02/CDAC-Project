package com.app.dto;

public class MechanicNameDto {
	private String mechName;
	public MechanicNameDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MechanicNameDto(String mechName) {
		super();
		this.mechName = mechName;
	}


	public String getMechName() {
		return mechName;
	}
	public void setMechName(String mechName) {
		this.mechName = mechName;
	}


	@Override
	public String toString() {
		return "MechanicPendingGetRequest [mechName=" + mechName + "]";
	}
	
	
	
}
