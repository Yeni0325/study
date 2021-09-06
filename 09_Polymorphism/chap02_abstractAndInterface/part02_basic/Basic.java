package com.kh.chap02_abstractAndInterface.part02_basic.model.vo;

public interface Basic {
	//인터페이스도 클래스의 한 종류지만 , 그냥 인터페이스로 명명한것!

	//추상클래스(abstract class) : 일반필드 작성가능 + 일반메소드 작성가능 + [추상메소드 작성가능]
	//인터페이스(interface)      : [Only 상수필드] + 추상메소드
	
	//private int a; => 인터페이스는 오직 상수필드만 가능하기 때문에 오류발생
	public static final int NUM = 10;
	//인터페이스에서의 필드는 무조건 상수필드임!!
	
	//따라서 어차피 무조건 상수필드이기 때문에 'public static final'부분은 생략이 가능하다!
	/*public static final*/ int NUM2 = 20;
			
	/*
	public void test() {
	                          => 인터페이스는 일반메소드 작성 불가	
	}
	*/
	
	//인터페이스의 메소드는 무조건 추상메소드임!!
	public abstract void eat();
	public abstract void sleep();
	
	//따라서 어차피 무조건 추상메소드이기 때문에 
	/*
	 * [public abstract] void eat();      => 'public abstract'생략 가능!!
	 * [public abstract] void sleep();
	 */
	
	//인터페이스를 생성하는 순간 '상수필드' '추상메소드' 두개만 작성이 가능하기 때문에 무조건 오버라이딩해야하는 메소드 밖에 없다!!!!
	// => 일반적인 추상클래스보다 강제성이 높다!
	
	
	
	
	
	
}
