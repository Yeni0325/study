package com.kh.chap03_class.model.vo;

public class Product {
		//클래스 구문에 작성가능한 접근제한자(public , default)
		//접근제한자 부분을 아예 안썼을 때가 defalut에 해당한다!
		//(default) class product  
		// public으로 하면 같은 패키지든 다른패키지든 해당 클래스 사용 가능
		// default로 하면 다른 패키지에서만 사용가능 / 다른 패키지에서는 해당 클래스사용 불가
		

	    //실습예제
		
	
		/*
		 * * 필드(field)
		 * 
		 *  필드 == 멤버변수 == 인스턴수변수
		 *  객체의 데이터가 저장되는 곳
		 * 
		 *  <표현법>
		 *  접근제한자[예약어] 자료형 변수명;
		 * 
		 */
	
		private String pName;
		private int price;
		private String brand;
		
		/*
		 * * 생성자
		 * - 객체를 생성하기 위한 일종의 메소드 
		 * - 객체 생성 시 초기화 역할 담당
		 * 
		 *  <표현법>
		 *  접근제한자 클래스명([매개변수, 매개변수, ...] ) {
		 *  
		 *  }
		 */
		public Product() { // 기본생성자
			System.out.println("Product 클래스의 기본생성자입니다.");
		}
		
		public Product(String pName, int price, String brand) { // 매개변수 생성자
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
		 * * 메소드
		 * - 기능을 처리를 담당
		 * - 객체의 동작에 해당하는 실행 블록
		 * 
		 *  <표현법>
		 *  접근제한자 [예약어] 반환형 메소드명([매개변수, 매개변수, ...]) {
		 *  
		 *  }
		 * 
		 * 
		 */
		
		//setter (데이터를 기록, 수정하는 메소드)
		
		public void setpName(String pName) { //기존에 메소드 명명 규칙으로 단어 시작 시 '대문자'를 사용해야하지만, 
			this.pName = pName;              // 앞에 소문자가 한글자인경우, 그냥 원래대로 작성한다!
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
			return brand;         // java에서 return값은 하나만 가능!
		}
	
		//모든 필드값들 다 합친 한 문자열을 반환해주는 메소드
		public String information() {
			return "pName : " + pName + ", price : " + price + ", brand : " + brand;
		}
	
	
	
	
}
