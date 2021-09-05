package com.kh.chap02_inherit.mode.vo;

public class Car extends Vehicle {

	//필드부
	private int tire;
	
	//생성자부
	public Car() {
		
	}
	
	public Car(String name, double mileage, String kind, int tire) {
		super(name, mileage, kind);
		this.tire = tire;
	}
	
	//메소드부
	public void setTire(int tire) {
		this.tire = tire;
	}
	
	public int getTire() {
		return tire;
	}
	
	public String information() {
		return super.information() + ", tire : " + tire;
	}
	
	@Override //어노테이션 => 안써도 그만이지만, 부모클래스를 오버라이딩했다는것을 알려줄 수 있음.
	public void howToMove() {
		System.out.println("바퀴를 굴려 움직인다.");
	}
	
	
	
}
