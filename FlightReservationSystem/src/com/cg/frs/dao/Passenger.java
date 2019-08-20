package com.cg.frs.dao;

public class Passenger{
	
	private String name;
	private int age;
	private String mobileNo;
	private String emailId;
	private float luggage;
	private float extraLuggage;
	
	public Passenger(String name, int age, String mobileNo, String emailId, float luggage, float extraLuggage) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.luggage = luggage;
		this.extraLuggage = extraLuggage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public float getLuggage() {
		return luggage;
	}

	public void setLuggage(float luggage) {
		this.luggage = luggage;
	}

	public float getExtraLuggage() {
		return extraLuggage;
	}

	public void setExtraLuggage(float extraLuggage) {
		this.extraLuggage = extraLuggage;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", luggage=" + luggage + ", extraLuggage=" + extraLuggage + "]";
	}
	
}
