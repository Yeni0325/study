package com.kh.chap01_beforeVSafter.after.model.vo;

//             자식 -----------> 부모
//             후손-----------> 조상
//             하위-----------> 상위
//             this----------> super
public class Desktop extends Product {
	
	//필드부
	private boolean allInOne;
	
	//생성자부
	public Desktop() {//기본 생성자
		
	}
	
	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
		//brand 부터 price의 네 개의 값들은 부모클래스(Product)의 필드에 대입
		//super. 으로 부모에 접근가능 
		//(단, 부모클래스가 private일 경우 자식이라도 접근이 불가!)
		//해결방법1. 부모클래스에 있는 필드를 private이 아닌, protected 접근제한자로 수정
		
		/*
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		*/
		
		//해결방법2. 부모클래스에 있는 setter메소드를 활용하는 방법
		//(setter는 public으로 되어 있기 때문에 접근이 가능하기 때문)
		/*
		super.setBrand(brand);
		super.setpCode(pCode);
		super.setpName(pName);
		super.setPrice(price);
		*/
		
		//해결방법3. 부모생성자를 호출하는 방법
		super(brand, pCode, pName, price); //또 다른 생성자를 호출하고자 할 때 반드시  첫 줄에 작성!!
		
		this.allInOne = allInOne;
	}
	
	//getter메소드
	public boolean isAllInOne() {//allInOne의 getter메소드
		return allInOne;
	}
	
	//setter메소드
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	//오버라이딩 : 부모클래스의 메소드를 자식클래스에서 재정의 하는 것
	public String information() {
		return super.information() + ", allInOne : " + allInOne;
	}
	
	
	
}
