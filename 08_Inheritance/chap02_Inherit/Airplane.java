package com.kh.chap02_inherit.mode.vo;

public class Airplane extends Vehicle {
	
	//�ʵ��
	private int tire;
	private int wing;
	
	
	//�����ں�
	public Airplane() {
		
	}
	
	public Airplane(String name, double mileage, String kind, int tire, int wing) {
		super(name, mileage, kind);
		this.tire = tire;
		this.wing = wing;
	}
	
	//�޼ҵ��
	
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
		System.out.println("������ �����ٰ� ������ �������� ���ư���.");
	}
}
