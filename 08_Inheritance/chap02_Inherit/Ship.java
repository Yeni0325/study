package com.kh.chap02_inherit.mode.vo;

public class Ship extends Vehicle {
	
	//�ʵ��
	private int propeller;
	
	//�����ں�
	public Ship() {
		
	}
	
	public Ship(String name, double mileage, String kind, int propeller) {
		super(name, mileage, kind);
		this.propeller = propeller;
	}
	
	
	//�޼ҵ��
	public void setPropeller(int propeller) {
		this.propeller = propeller;
	}
	
	public int getPropeller( ) {
		return propeller;
	}
	
	public String information() {
		return super.information() + ", propeller : " + propeller;
	}
	
	@Override   //������̼� => �Ƚᵵ �׸�������, �������̵��ߴٴ°��� �˷��� �� �ִ�.
	public void howToMove() {
		System.out.println("�����緯�� ������ �����δ�.");
	}
}
