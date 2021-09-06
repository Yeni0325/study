package com.kh.chap04_assist.part02_object.model.vo;

import java.io.Serializable;

//��ü�� �������� ��� �׸��� ���� Ŭ����
public class Phone implements Serializable { //����ȭ
	
	//��ü ��ü�� ������ϰ��� �Ѵٸ� �ݵ�� ����ȭ ���� �ʼ�
	//�ڹٿ����� ����ȭ�� ���õ� �������̽��� �������ְ� �ִ�. => implements Serializable 
	
	private String name;
	private int price;
	
	//�⺻������, �Ű�����������, getter/setter, toString
	//alt + shift + s ������ sourceâ�� ���
	
	public Phone() {
		
	}
	
	//alt + shift + s => o(�Ű����� ����â) => enter
	public Phone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	//alt + shift + s => r(getter/setter ����â) => alt + a(����ʵ� üũ) => alt + r(generate)
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
	
	//alt + shift + s => s(toString ����â) => enter
	@Override
	public String toString() {
		return "Phone [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
