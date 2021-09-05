package com.kh.chap01_beforeVSafter.before.model.vo;

public class Desktop {
	
	//필드부
	private String brand;      //브랜드
	private String pCode;      //상품번호
	private String pName;      //상품명
	private int price;         //가격
	private boolean allInOne;  //일체여부
	
	
	//생성자부
	public Desktop() {
		
	}
	
	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.allInOne = allInOne;
	}
	
	//setter 메소드
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
	
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	//getter 메소드
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
	
	public boolean isAllInOne() { // boolean자료형에 대해서 getter메소드를 사용할 땐 getAllInOne이 아닌 'isAllInOne' 을 사용해한다!!
		return allInOne;
	}
	
	//정보를 한번에 출력하는 information 메소드
	public String information() {
		return brand + ", " + pCode + ", " + pName + ", " + price + ", " + allInOne; 
	 }
	

}
