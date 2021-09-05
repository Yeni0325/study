package com.kh.chap02_inherit.mode.vo;

public class Car extends Vehicle {

	//�ʵ��
	private int tire;
	
	//�����ں�
	public Car() {
		
	}
	
	public Car(String name, double mileage, String kind, int tire) {
		super(name, mileage, kind);
		this.tire = tire;
	}
	
	//�޼ҵ��
	public void setTire(int tire) {
		this.tire = tire;
	}
	
	public int getTire() {
		return tire;
	}
	
	public String information() {
		return super.information() + ", tire : " + tire;
	}
	
	@Override //������̼� => �Ƚᵵ �׸�������, �θ�Ŭ������ �������̵��ߴٴ°��� �˷��� �� ����.
	public void howToMove() {
		System.out.println("������ ���� �����δ�.");
	}
	
	
	
}
