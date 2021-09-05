package com.kh.chap02_inherit.mode.vo;

public class Airplane extends Vehicle {
	
	//필드부
	private int tire;
	private int wing;
	
	
	//생성자부
	public Airplane() {
		
	}
	
	public Airplane(String name, double mileage, String kind, int tire, int wing) {
		super(name, mileage, kind);
		this.tire = tire;
		this.wing = wing;
	}
	
	//메소드부
	
	public void setTire(int tire) {
		this.tire = tire;
	}
	
	public int getTire() {
		return tire;
	}
	
	public String information() {
		return super.information() + ", tire : " + tire + ", wing : " + wing;
	}

	public void howToMove() {
		System.out.println("바퀴를 굴리다가 날개를 휘저으며 날아간다.");
	}
}
