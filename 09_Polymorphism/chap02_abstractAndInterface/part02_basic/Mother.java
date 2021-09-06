package com.kh.chap02_abstractAndInterface.part02_basic.model.vo;
//                                   '구현하다'
public class Mother extends Person implements Basic{
	
	// * 클래스와 클래스간의 다중상속은 불가능하지만 인터페이스의 다중상속은 갯수제한없이 가능하다!!
	
	private String babyBirth; // 아이의 탄생 : 출산 | 입양 | 없음
	
	//기본 생성자
	public Mother() {
		
	}
	
	//매개변수 생성자
	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
	}
	
	//setter / getter
	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}
	
	public String getBabyBirth() {
		return babyBirth;
	}
	
	//toString
	@Override
	public String toString() {
		return "Mother [" + super.toString() + ", babyBirth : " + babyBirth + "]";
	}

	@Override
	public void eat() {
		// 밥먹으면 현재 몸무게에 10 증가
		super.setWeight(super.getWeight() + 10);  // 몸무게 값을 수정할건데 , 기존의 몸무게에 + 10증가한 값
		// 밥먹으면 건강도가 10 감소
		super.setHealth(super.getHealth() - 10); // 건강도를 수정할건데, 기존의 건강도에 -10 감소한 값
	}

	@Override
	public void sleep() {
		// 잠자면 건강도 20증가
		super.setHealth(super.getHealth() + 20); // 건강도를 수정할건데 , 기존의 건강도에 +20 증가한 값
	}
	
	

}
