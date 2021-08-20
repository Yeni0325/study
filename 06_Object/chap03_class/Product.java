package com.kh.chap03_class.model.vo;

public class Product {
		//Ŭ���� ������ �ۼ������� ����������(public , default)
		//���������� �κ��� �ƿ� �Ƚ��� ���� defalut�� �ش��Ѵ�!
		//(default) class product  
		// public���� �ϸ� ���� ��Ű���� �ٸ���Ű���� �ش� Ŭ���� ��� ����
		// default�� �ϸ� �ٸ� ��Ű�������� ��밡�� / �ٸ� ��Ű�������� �ش� Ŭ������� �Ұ�
		

	    //�ǽ�����
		
	
		/*
		 * * �ʵ�(field)
		 * 
		 *  �ʵ� == ������� == �ν��ϼ�����
		 *  ��ü�� �����Ͱ� ����Ǵ� ��
		 * 
		 *  <ǥ����>
		 *  ����������[�����] �ڷ��� ������;
		 * 
		 */
	
		private String pName;
		private int price;
		private String brand;
		
		/*
		 * * ������
		 * - ��ü�� �����ϱ� ���� ������ �޼ҵ� 
		 * - ��ü ���� �� �ʱ�ȭ ���� ���
		 * 
		 *  <ǥ����>
		 *  ���������� Ŭ������([�Ű�����, �Ű�����, ...] ) {
		 *  
		 *  }
		 */
		public Product() { // �⺻������
			System.out.println("Product Ŭ������ �⺻�������Դϴ�.");
		}
		
		public Product(String pName, int price, String brand) { // �Ű����� ������
			this.pName = pName;
			this.price = price;
			this.brand = brand;
		}
		
		public Product(String pName, int price, String brand, String num) {
			this.pName = pName;
			this.price = price;
			this.brand = brand;
			this.pName = pName;
		}
		
		
		
		
		
		
		/*
		 * * �޼ҵ�
		 * - ����� ó���� ���
		 * - ��ü�� ���ۿ� �ش��ϴ� ���� ���
		 * 
		 *  <ǥ����>
		 *  ���������� [�����] ��ȯ�� �޼ҵ��([�Ű�����, �Ű�����, ...]) {
		 *  
		 *  }
		 * 
		 * 
		 */
		
		//setter (�����͸� ���, �����ϴ� �޼ҵ�)
		
		public void setpName(String pName) { //������ �޼ҵ� ��� ��Ģ���� �ܾ� ���� �� '�빮��'�� ����ؾ�������, 
			this.pName = pName;              // �տ� �ҹ��ڰ� �ѱ����ΰ��, �׳� ������� �ۼ��Ѵ�!
		}
		
		public void setPrice(int price) {
			this.price = price;
		}
		
		public void setBrand(String brand) {
			this.brand = brand;
		}
		
		//getter
		
		public String getpName() {
			return pName;
		}
		public int getPrice() {
			return price;
		}
		public String getBrand() {
			return brand;         // java���� return���� �ϳ��� ����!
		}
	
		//��� �ʵ尪�� �� ��ģ �� ���ڿ��� ��ȯ���ִ� �޼ҵ�
		public String information() {
			return "pName : " + pName + ", price : " + price + ", brand : " + brand;
		}
	
	
	
	
}
