package com.kh.chap02_inherit.mode.vo;

public class Vehicle {
	
	//필드부
	private String name;
	private double mileage;
	private String kind;
	
	//생성자부
	public Vehicle() {
		
	}
	
	public Vehicle(String name, double mileage, String kind) {
		this.name = name;
		this.mileage = mileage;
		this.kind = kind;
	}
	
	//메소드부
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	//getter
	public String getName() {
		return name;
	}
	
	public double getMileage() {
		return mileage;
	}
	
	public String getKind() {
		return kind;
	}
	
	public String information() {
		return "name : " + name + ", mileage : " + mileage + ", kind : " + kind;
	}
	
	public void howToMove() {
		System.out.println("움직인다.");
	}
		
}
