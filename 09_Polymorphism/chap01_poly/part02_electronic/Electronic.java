package com.kh.chap01_poly.part02_electronic.mode.vo;

public class Electronic {

	//�ʵ��
	private String brand;
	private String name;
	private int price;
	
	//�����ں�
	public Electronic(){
		
	}
	public Electronic(String brand, String name, int price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	
	//�޼ҵ��
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	//toString�޼ҵ�
	@Override
	public String toString() {
		return "brand : " + brand + ", name : " + name + ", price : " + price;
	}
}
