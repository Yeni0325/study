package com.kh.chap01_beforeVSafter.after.model.vo;

public class SmartPhone extends Product {
	
	//�ʵ��
	private String mobileAgency;
	
	//�����ں�
	public SmartPhone() {// �⺻ ������
		
	}
	
	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgency) {
		super(brand,pCode,pName,price);
		this.mobileAgency = mobileAgency;
	}
	
	//getter�޼ҵ�	
	public String getMobileAgency() {
		return mobileAgency;
	}
	
	//setter�޼ҵ�
	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	public String information() {
		return super.information() + ", mobileAgency : " + mobileAgency;
	}
	
	
	
	
	
	
	
	
}
