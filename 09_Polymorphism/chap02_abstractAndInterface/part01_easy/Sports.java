package com.kh.chap02_abstractAndInterface.part01_easy.model.vo;

public abstract class Sports {
	
	//필드부
	private int people;
	
	//생성자부
	public Sports() {
		
	}
	
	public Sports(int people) {
		this.people = people;
	}
	
	//메소드부
	public void setPeople(int people) {
		this.people = people;
	}
	
	public int getPeople() {
		return people;
	}
	
	public String toString() {
		return "people : " + people;
	}
	
	//추상메소드(abstract) : 머리부만 작성하고 몸통부는 작성하지 않은 미완성된 메소드
	public abstract void rule(); //작성 시 메소드와 상단 클래스부분에 'abstract'를 작성해야한다!
	//나머지 미완성된 부분은 상속받는 자식클래스에서 완성시키면 된다!
	// 어떻게?? 오버라이딩을 통해서!
	
	//부모클래스에 미완성된 추상메소드를 두면, 자식클래스는 강제적으로 오버라이딩을 통해 해당 메소드를 완성시켜줘야 한다. 
	//추상클래스 : 추상메소드가 존재하는 클래스
}
