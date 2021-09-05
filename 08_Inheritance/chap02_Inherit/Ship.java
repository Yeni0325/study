package com.kh.chap02_inherit.mode.vo;

public class Ship extends Vehicle {
	
	//필드부
	private int propeller;
	
	//생성자부
	public Ship() {
		
	}
	
	public Ship(String name, double mileage, String kind, int propeller) {
		super(name, mileage, kind);
		this.propeller = propeller;
	}
	
	
	//메소드부
	public void setPropeller(int propeller) {
		this.propeller = propeller;
	}
	
	public int getPropeller( ) {
		return propeller;
	}
	
	public String information() {
		return super.information() + ", propeller : " + propeller;
	}
	
	@Override   //어노테이션 => 안써도 그만이지만, 오버라이딩했다는것을 알려줄 수 있다.
	public void howToMove() {
		System.out.println("프로펠러를 돌려서 움직인다.");
	}
}
