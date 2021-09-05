package com.kh.chap01_beforeVSafter.after.model.vo;

public class Tv extends Product {
	
	//필드부
	private int inch;
	
	//생성자부
	public Tv() {//기본 생성자
		
	}
	
	public Tv(String brand, String pCode, String pName, int price, int inch) {//매개변수 생성자
		super(brand,pCode,pName,price);
		this.inch = inch;
	}
	
	//inch값을 돌려주는 getter 메소드
	public int getInch() {
		return inch;
	}
	
	//setter메소드
	public void setInch(int inch) {
		this.inch = inch;
	}
	
	public String information() {
		return super.information() + ", inch : " + inch;
	}
	
	
	
	
	
}
