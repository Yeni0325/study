package com.kh.chap02_objectArray.model.vo;

public class Phone {
	
	//�̸�, �귣���, ����, �ø���
	private String name;
	private String brand;
	private int price;
	private String series;
	
	//�⺻ ������
	public Phone() {
		
	}
	
	//�Ű����� ������
	public Phone(String name, String brand, int price, String series) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.series = series;
	}
	
	//�� �ʵ忡 ���� setter �޼ҵ��
	public void setName(String name){
		this.name = name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setSeries(String series) {
		this.series = series;
	}
	
	//�� �ʵ忡 ���� getter �޼ҵ��
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getSeries() {
		return series;
	}
	
	//��� �ʵ带 �� ���ڿ��� ��ģ �� ��ȯ�����ִ� information�޼ҵ�
	public String information() {
		return name + ", " + brand + ", " + price + ", " + series;
	}
}
