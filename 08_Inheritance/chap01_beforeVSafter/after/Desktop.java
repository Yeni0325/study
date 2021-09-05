package com.kh.chap01_beforeVSafter.after.model.vo;

//             �ڽ� -----------> �θ�
//             �ļ�-----------> ����
//             ����-----------> ����
//             this----------> super
public class Desktop extends Product {
	
	//�ʵ��
	private boolean allInOne;
	
	//�����ں�
	public Desktop() {//�⺻ ������
		
	}
	
	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
		//brand ���� price�� �� ���� ������ �θ�Ŭ����(Product)�� �ʵ忡 ����
		//super. ���� �θ� ���ٰ��� 
		//(��, �θ�Ŭ������ private�� ��� �ڽ��̶� ������ �Ұ�!)
		//�ذ���1. �θ�Ŭ������ �ִ� �ʵ带 private�� �ƴ�, protected ���������ڷ� ����
		
		/*
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		*/
		
		//�ذ���2. �θ�Ŭ������ �ִ� setter�޼ҵ带 Ȱ���ϴ� ���
		//(setter�� public���� �Ǿ� �ֱ� ������ ������ �����ϱ� ����)
		/*
		super.setBrand(brand);
		super.setpCode(pCode);
		super.setpName(pName);
		super.setPrice(price);
		*/
		
		//�ذ���3. �θ�����ڸ� ȣ���ϴ� ���
		super(brand, pCode, pName, price); //�� �ٸ� �����ڸ� ȣ���ϰ��� �� �� �ݵ��  ù �ٿ� �ۼ�!!
		
		this.allInOne = allInOne;
	}
	
	//getter�޼ҵ�
	public boolean isAllInOne() {//allInOne�� getter�޼ҵ�
		return allInOne;
	}
	
	//setter�޼ҵ�
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	//�������̵� : �θ�Ŭ������ �޼ҵ带 �ڽ�Ŭ�������� ������ �ϴ� ��
	public String information() {
		return super.information() + ", allInOne : " + allInOne;
	}
	
	
	
}
