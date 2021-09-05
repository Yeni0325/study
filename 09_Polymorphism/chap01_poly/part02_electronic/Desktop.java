package com.kh.chap01_poly.part02_electronic.mode.vo;

public class Desktop extends Electronic{
	
	//�ʵ��
	public static final String CPU = "intel";
	private String graphic;
	
	//�����ں�
	
	public Desktop() {
		
	}
	
	public Desktop(String brand, String name, int price, String graphic) {
		super(brand, name, price);
		this.graphic = graphic;
	}
	
	//�޼ҵ��
	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}
	
	public String getGraphic() {
		return graphic;
	}
	
	//toString�޼ҵ�
	@Override
	public String toString() {
		return super.toString() + ", CPU : " + CPU + ", graphic : " + graphic;
	}
}
