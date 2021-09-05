package com.kh.chap01_beforeVSafter.after.model.vo;

public class Product {
	// 세 클래스(Desktop, SmartPhone, Tv) 모두 공통적으로 가지고 있는 요소들(필드, 메소드)만을 기술
	
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	
	public Product() {
		
	}
	
	public Product(String brand, String pCode, String pName, int price) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
	}
	
	//brand
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	//pCode
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	
	//pName
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	//price
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//정보를 한번에 출력하는 information메소드
	public String information() {
		return "brand : " + brand + ", pCode : " + pCode + ", pName : " + pName + ", price : " + price;
	}
	
	
	
	
}
