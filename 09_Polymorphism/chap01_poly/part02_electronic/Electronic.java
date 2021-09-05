package com.kh.chap01_poly.part02_electronic.mode.vo;

public class Electronic {

	//鞘靛何
	private String brand;
	private String name;
	private int price;
	
	//积己磊何
	public Electronic(){
		
	}
	public Electronic(String brand, String name, int price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	
	//皋家靛何
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	//toString皋家靛
	@Override
	public String toString() {
		return "brand : " + brand + ", name : " + name + ", price : " + price;
	}
}
