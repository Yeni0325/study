package com.kh.chap01_poly.part01_basic.model.vo;

public class Parent {
	
	//鞘靛何
	private int x;
	private int y;
	
	//积己磊何
	public Parent() {
		
	}
	
	public Parent(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//皋家靛何
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void printParent() {
		System.out.println("唱 何葛具");
	}
	
	public void print() {
		System.out.println("唱 何葛具");
	}
	
	
}
