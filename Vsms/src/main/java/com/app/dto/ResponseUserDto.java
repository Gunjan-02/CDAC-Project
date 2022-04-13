package com.app.dto;

public class ResponseUserDto {
	private int id;
	private String email;
	private String name;
	private long mobileNumber;

	public ResponseUserDto() {
		// TODO Auto-generated constructor stub
	}

	public ResponseUserDto(int id, String email, String name, long mobileNumber) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "ResponseUserDto [id=" + id + ", email=" + email + ", name=" + name + ", mobNo=" + mobileNumber + "]";
	}

}
