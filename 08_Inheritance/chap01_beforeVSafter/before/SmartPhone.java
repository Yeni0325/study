package com.kh.chap01_beforeVSafter.before.model.vo;

public class SmartPhone {
	
	//필드부
	private String brand;         //브랜드
	private String pCode;         //상품번호
	private String pName;         //상품명
	private int price;            //가격
	private String mobileAgency;  //통신사
	
	//생성자부
	public SmartPhone() {
		
	}
	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgency) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.mobileAgency = mobileAgency;
	}
	
	//setter
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public void setprice(int price) {
		this.price = price;
	}
	
	public void setmobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	//getter
	public String getBrand() {
		return brand;
	}
	public String getpCode() {
		return pCode;
	}
	public String getpName() {
		return pName;
	}
	public int getPrice() {
		return price;
	}
	public String getMobileAgency() {
		return mobileAgency;
	}
	
	//정보를 출력하는 information메소드
	
	public String information() {
		return brand + ", " + pCode + ", " + pName + ", " + price + ", " + mobileAgency;
	}
}
