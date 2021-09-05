package com.kh.chap01_poly.part02_electronic.mode.vo;

public class Desktop extends Electronic{
	
	//鞘靛何
	public static final String CPU = "intel";
	private String graphic;
	
	//积己磊何
	
	public Desktop() {
		
	}
	
	public Desktop(String brand, String name, int price, String graphic) {
		super(brand, name, price);
		this.graphic = graphic;
	}
	
	//皋家靛何
	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}
	
	public String getGraphic() {
		return graphic;
	}
	
	//toString皋家靛
	@Override
	public String toString() {
		return super.toString() + ", CPU : " + CPU + ", graphic : " + graphic;
	}
}
