package com.code.entity;

public class User {

	private String name;
	private String email;
	private String gender;
	private String mobileNo;

	public User() {
		super();
	}

	public User(String name, String email, String gender, String mobileNo) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", gender=" + gender + ", mobileNo=" + mobileNo + "]";
	}

}
