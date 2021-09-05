package com.kh.chap01_poly.part02_electronic.mode.vo;

public class Tablet extends Electronic{

	//필드부
	private boolean penFlag;
	
	//생성자부
	public Tablet() {
		
	}
	
	public Tablet(String brand, String name, int price, boolean penFlag) {
		super(brand, name, price);
		this.penFlag = penFlag;
	}
	
	//메소드부
	
	public void setPenFlag(boolean penFlag) {
		this.penFlag = penFlag;
	}
	
	public boolean isPenFlag() { //boolean자료형의 경우 getter메소드만 'get-'이 아닌 'is-'로 해야한다.
		return penFlag;
	}
	
	//toString메소드
		@Override
		public String toString() {
			return super.toString() + ", penFlag : " + (penFlag ? "있음" : "없음");
		}
}
