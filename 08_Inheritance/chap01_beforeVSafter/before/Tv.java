package com.kh.chap01_beforeVSafter.before.model.vo;

public class Tv {

	//필드부
	private String brand;     //브랜드
	private String pCode;     //상품번호
	private String pName;     //상품명
	private int price;        //가격
	private int inch;         //인치
	
	//생성자부
	
	public Tv() {
		
	}
	
	public Tv(String brand, String pCode, String pName, int price, int inch) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.inch = inch;
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
	public void setPrice(int price) {
		this.price = price;
	}
	public void setInch(int inch) {
		this.inch = inch;
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
	public int getInch() {
		return inch;
	}
	
	//정보를 한번에 출력하는 information메소드
	public String information() {
		return brand + ", " + pCode + ", " + pName + ", " + price + ", " + inch;
	}
	
	
}
