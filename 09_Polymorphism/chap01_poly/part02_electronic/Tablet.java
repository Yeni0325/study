package com.kh.chap01_poly.part02_electronic.mode.vo;

public class Tablet extends Electronic{

	//�ʵ��
	private boolean penFlag;
	
	//�����ں�
	public Tablet() {
		
	}
	
	public Tablet(String brand, String name, int price, boolean penFlag) {
		super(brand, name, price);
		this.penFlag = penFlag;
	}
	
	//�޼ҵ��
	
	public void setPenFlag(boolean penFlag) {
		this.penFlag = penFlag;
	}
	
	public boolean isPenFlag() { //boolean�ڷ����� ��� getter�޼ҵ常 'get-'�� �ƴ� 'is-'�� �ؾ��Ѵ�.
		return penFlag;
	}
	
	//toString�޼ҵ�
		@Override
		public String toString() {
			return super.toString() + ", penFlag : " + (penFlag ? "����" : "����");
		}
}
