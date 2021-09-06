package com.kh.chap02_abstractAndInterface.part02_basic.run;

import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Baby;
import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Basic;
import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Mother;
import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Person;

public class BasicRun {

	public static void main(String[] args) {
		
		//Person p = new Person();
		
		/* 인터페이스 적용 전
		Person mom = new Mother("김엄마", 50, 70, "출산");
		//부모 타입 레퍼런스로 자식 객체 생성 (다형성 적용)
		Person baby = new Baby("강아기", 3.5, 70);
		//부모 타입 레퍼런스로 자식 객체 생성 (다형성 적용)
		
		System.out.println(mom);
		System.out.println(baby);
		
		mom.eat(); //몸무게+10 건강도 -10
		baby.eat();//몸무게 +3 건강도 +1
		
		mom.sleep(); //건강도 +20
		baby.sleep(); //건강도 +3
		System.out.println("============= 다음날 ==============");
		System.out.println(mom);
		System.out.println(baby);
		*/
		
		//==========================================================
		//인터페이스 적용 후 
		
		//Basic b = new Basic();
		//인터페이스는 무조건 상수필드와 추상메소드밖에 작성을 못하기 때문에 완벽하게 미완성인 상태다!!
		//   => 따라서 당연히 객체 생성 불가!! but, 레퍼런스 변수로 선언하는 것은 가능하다!
		
		Basic mom = new Mother("김엄마", 50, 70, "출산");
		//부모 타입 레퍼런스로 자식 객체 받아주는 것 가능(다형성 적용)
		Basic baby = new Baby("강아기", 3.5, 70);
		//부모 타입 레퍼런스로 자식 객체 받아주는 것 가능(다형성 적용)
		
		System.out.println(mom);
		System.out.println(baby);
		
		mom.eat();
		baby.eat();
		
		mom.sleep();
		baby.sleep();
		
		System.out.println(mom);
		System.out.println(baby);
		
		/*
		 * 클래스에서 클래스를 상속받을 때 :  클래스 extends 클래스 (클래스와 클래스간의 상속은 다중상속 불가! 단일상속만 가능)
		 *                     : 화살표 "실선"
		 *                     
		 * 클래스에서 인터페이스를 구현할 때 : 클래스 implements 인터페이스, 인터페이스, .. (클래스와 인터페이스간의 상속은 다중상속 가능!)
		 *                       : 화살표 "점선"
		 *                       
		 * 인터페이스에서 인터페이스를 상속 : 인터페이스 extends 인터페이스, 인터페이스, .. (다중상속 가능) 
		 *                       : 화살표 "실선"
		 * 
		 * 화살표가 "실선"일 경우 => extends
		 * 화살표가 "점선"일 경우 => implements
		 * 
		 * * 추상클래스와 인터페이스의 차이점
		 *          |             추상클래스                         |            인터페이스                          
		 * =======================================================================
		 *  상속개수     |             단일상속                             |             다중상속                            
		 * -----------------------------------------------------------------------
		 *  키워드         |             extends           |          implements
		 * -----------------------------------------------------------------------
		 * 추상메소드     |       추상메소드 0개 이상                          |       모든 메소드가 추상메소드
		 * 표현법/갯수   |       명시적으로 abstract 기술            |     묵시적으로 abstract (생략가능)
 		 * ------------------------------------------------------------------------
		 * 일반메소드      |             O                |               X
		 * 작성 가능 여부 |                              |
		 * ------------------------------------------------------------------------
		 *    필드        |         일반필드 가질 수 있음                  | 상수필드만 가질 수 있음(묵시적으로 public static final)
		 *    
		 *    
		 *   extends 일반클래스  ---> extends 추상클래스  ---> implements 인터페이스
		 *   ------------------------------------------------------------->
		 *                         강제성이 더 짙어짐 (규약이 더 쎄짐)
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}

}
