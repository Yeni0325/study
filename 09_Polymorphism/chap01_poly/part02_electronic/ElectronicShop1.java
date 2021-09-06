package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.mode.vo.Desktop;
import com.kh.chap01_poly.part02_electronic.mode.vo.NoteBook;
import com.kh.chap01_poly.part02_electronic.mode.vo.Tablet;

//다형성 적용안했을 때의 예시
public class ElectronicShop1 {
	
	//용산 전자상가에 있는 가계
	
	//각각의 제품을 납품업체에 받아서 저장할 공간이 필요함
	
	//필드부
	//특정 객체 자체를 저장하는 필드도 가능
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	//세개의 제품을 가져다 놓기 위한 자리만을 마련한 상태
	//특정 클래스에 있는 필드는 클래스를 가지고 객체생성하는 순간 해당 클래스에 해당하는 필드만큼의 자리가 메모리상에 생성된다!!
	
	//생성자부
	
	
	
	//메소드부
	public void insert(Desktop d) {  //Desktop d = new Desktop(~~~~);
		desk = d;
	}
	
	public void insert(NoteBook n) { //NoteBook n = new NoteBook(~~~~~);
		note = n;
	}
	
	public void insert(Tablet t) { //Tablet t = new Tablet(~~~~~~~);
		tab = t;
	}
	
	// 위에 3개의 메소드는 '오버로딩'이 적용된 예시임!!
	
	public Desktop selectDesktop() {
		return desk;
	}
	
	public NoteBook selectNoteBook() {
		return note;
	}
	
	public Tablet selectTablet() {
		return tab;
	}
	
	
	
	
	
	
	
}
