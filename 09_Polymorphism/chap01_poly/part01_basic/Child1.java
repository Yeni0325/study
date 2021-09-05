package com.kh.chap01_poly.part01_basic.model.vo;

public class Child1 extends Parent {
	
	//필드부
	private int z;

	//생성자부
	public Child1() {
		//super();생략되어 있음
		//부모 클래스의 기본생성자를 가져오고 있음
		// 따라서 기본생성자를 항상 반드시 생성해야 하는 이유가 또 여기에 있음 => 언제 해당 클래스가 상속구조가 될 지 모르기 때문에!
	}
	
	public Child1(int x, int y, int z) {
		super(x, y);  //부모 생성자 호출
		this.z = z;
	}
	
	//메소드부
	public void setZ(int z) {
		this.z = z;
	}
	
	public int getZ() {
		return z;
	}
	
	public void printChild1() {
		System.out.println("나 첫번째 자식이야");
	}
	
	@Override
	public void print() {
		System.out.println("나 첫번째 자식이야");
	}
	
	
	
	
	
}
