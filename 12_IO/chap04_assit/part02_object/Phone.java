package com.kh.chap04_assist.part02_object.model.vo;

import java.io.Serializable;

//객체를 차곡차곡 담는 그릇과 같은 클래스
public class Phone implements Serializable { //직렬화
	
	//객체 자체를 입출력하고자 한다면 반드시 직렬화 과정 필수
	//자바에서는 직렬화와 관련된 인터페이스를 제공해주고 있다. => implements Serializable 
	
	private String name;
	private int price;
	
	//기본생성자, 매개변수생성자, getter/setter, toString
	//alt + shift + s 누르면 source창이 뜬다
	
	public Phone() {
		
	}
	
	//alt + shift + s => o(매개변수 생성창) => enter
	public Phone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	//alt + shift + s => r(getter/setter 생성창) => alt + a(모든필드 체크) => alt + r(generate)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//alt + shift + s => s(toString 생성창) => enter
	@Override
	public String toString() {
		return "Phone [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
