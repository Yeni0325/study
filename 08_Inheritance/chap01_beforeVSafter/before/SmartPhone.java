package com.kh.chap01_beforeVSafter.before.model.vo;

public class SmartPhone {
	
	//�ʵ��
	private String brand;         //�귣��
	private String pCode;         //��ǰ��ȣ
	private String pName;         //��ǰ��
	private int price;            //����
	private String mobileAgency;  //��Ż�
	
	//�����ں�
	public SmartPhone() {
		
	}
	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgency) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.mobileAgency = mobileAgency;
	}
	
	//setter
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public void setprice(int price) {
		this.price = price;
	}
	
	public void setmobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	//getter
	public String getBrand() {
		return brand;
	}
	public String getpCode() {
		return pCode;
	}
	public String getpName() {
		return pName;
	}
	public int getPrice() {
		return price;
	}
	public String getMobileAgency() {
		return mobileAgency;
	}
	
	//������ ����ϴ� information�޼ҵ�
	
	public String information() {
		return brand + ", " + pCode + ", " + pName + ", " + price + ", " + mobileAgency;
	}
}
