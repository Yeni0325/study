package com.kh.chap01_oneVSmany.model.vo;

public class Book {
	
	// 도서명, 저자, 가격, 출판사
	
	//필드부
	private String title;
	private String author;
	private int price;
	private String publisher;
	
	//생성자부
	
	//기본 생성자(단지, 객체 생성만이 목적일 때, 내가 기본생성자를 작성하지 않아도 jvm이 작성해주지만, 
	//        매개변수 생성자를 작성할 경우 내가 작성해야함)
	public Book() {
		
	}
	
	//매개변수 생성자
	public Book(String title, String author, int price, String publisher) {
		this.title = title;  //this를 통해 해당 타이틀을 찾아가서 매개변수에 담긴 값을 대입시켜줌
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}
	
	//각 필드에 대한 setter 메소드들
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	//각 필드에 대한 getter 메소드들
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	
	//모든 필드의 값을 하나의 문자열로 합쳐 반환해주는 information 메소드
	
	public String information() {
		return "title : " + title + ", author : " + author + ", price : " + price + ", publisher : " + publisher;
	}
	
	
	
}
