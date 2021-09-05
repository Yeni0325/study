package com.kh.chap03_override.model.vo;

public class Book /*extend Object*/ {
	
	private String title;
	private String author;
	private int price;
	
	// 기본생성자
	public Book() {
		
	}
	
	// 매개변수 생성자
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	//setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	//getter
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}
	
	/*
	 * * 오버라이딩
	 * - 자식클래스가 상속받고 있는 부모클래스의 메소드를 재정의(재작성)하는 것
	 * - 부모가 제공하고 있는 메소드를 자식이 일부 고쳐서 사용하겠다는 의미
	 *   자식 객체를 통해 실행 시 자식메소드가 우선권을 가짐!!
	 *   
	 * * 오버라이딩 성립 조건
	 * - 부모메소드명과 동일하게 작성
	 * - 매개변수 갯수, 자료형, 순서 동일 (매개변수명은 상관없음)
	 * - 부모메소드의 반환형 동일(jdk 버전업이 되면서 부모메소드의 반환형의 자식 자료형들로는 가능)
	 * - 부모메소드의 접근제한자보다 범위가 같거나 커야한다!
	 *   ex) 부모메소드의 접근제한자가 protected일 경우 오버라이딩하는 자식클래스의 메소드 접근제한자는
	 *       protected, public 둘 중에 가능하다!
	 *       
	 *  
	 *  => 규칙의 개념이 들어가 있음(너가 재정의할꺼면 이 정도의 규칙은 지켜줘!!)
	 *  
	 * * @Override 어노테이션
	 * - 생략 가능 함 (명시하지 않아도 상과없음)
	 * - 어노테이션을 붙이는 이유 
	 *   >> 부모 메소드명이나 매개변수가 수정 될 경우 => 오류가 빨간줄로 표시되기 때문에 찾아보기 쉽다! 
	 *      자식 메소드 기술 시 오타가 있을 경우 => 찾아보기 쉽다
	 *   >> 단지 해당 메소드를 오버라이딩 한 메소드라고 알리고 싶어서 
	 */
	
	@Override
	public String toString() {
		return "title= " + title + ", author= " + author + ", price" + price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
