package com.kh.chap01_poly.part02_electronic.mode.vo;

public class NoteBook extends Electronic{
	
	//鞘靛何
	private int usbPort;
	
	//积己磊何
	public NoteBook() {
		
	}
	
	public NoteBook(String brand, String name, int price, int usbPort) {
		super(brand, name, price);
		this.usbPort = usbPort;
	}
	
	//皋家靛何
	public void setUsbPort(int usbPort) {
		this.usbPort = usbPort;
	}
	public int getUsbPort() {
		return usbPort;
	}
	
	//toString皋家靛
	@Override
	public String toString() {
		return super.toString() + ", usbPort : " + usbPort;
	}
	
}
