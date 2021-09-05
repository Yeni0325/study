package com.kh.chap01_beforeVSafter.after.model.vo;

public class SmartPhone extends Product {
	
	//필드부
	private String mobileAgency;
	
	//생성자부
	public SmartPhone() {// 기본 생성자
		
	}
	
	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgency) {
		super(brand,pCode,pName,price);
		this.mobileAgency = mobileAgency;
	}
	
	//getter메소드	
	public String getMobileAgency() {
		return mobileAgency;
	}
	
	//setter메소드
	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	public String information() {
		return super.information() + ", mobileAgency : " + mobileAgency;
	}
	
	
	
	
	
	
	
	
}
