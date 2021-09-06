package com.kh.chap02_abstractAndInterface.part01_easy.run;

import com.kh.chap02_abstractAndInterface.part01_easy.model.vo.BasketBall;
import com.kh.chap02_abstractAndInterface.part01_easy.model.vo.FootBall;
import com.kh.chap02_abstractAndInterface.part01_easy.model.vo.Sports;

public class EasyRun {

	public static void main(String[] args) {
		
		//Sports s = new Sports();
		//객체 생성하는 과정을 '인스턴스화'라고 한다.
		//'추상클래스(미완성된 클래스)'로는 객체 생성이 불가능하다!
		//Sports s; // => 객체 생성이 안될 뿐이지 레퍼런스 변수로는 사용이 가능하다!
		//부모타입 레퍼런스로 자식객체를 받아주는 것 => 다형성인데, 
		//Sports라는 부모타입 레퍼런스로 BaksetBall, FootBall 자식객체를 생성할 수 있다.
		
		Sports s = new BasketBall(); // => 다형성 적용시켜서 부모타입으로 자식객체를 받아주는 형태 가능!(자동형변환)
		
		Sports[] arr = new Sports[2]; // 각각의 배열 자리는 Sports타입이다. 다형성 적용으로 BasketBall객체와 FootBall객체 생성 가능하다
		arr[0] = new BasketBall();
		arr[1] = new FootBall();
		
		for(int i=0; i<arr.length; i++) {
			arr[i].rule();
		}
		
		                    //arr이라는 배열의 자료형과 동일한 자료형의 변수를 생성해야한다!
		for(Sports a : arr) {//Sports a = 첫번째 반복시 arr[0]번 인덱스가 담기고, 그 다음 반복시 arr[1]번 인덱스 값이 담기게 된다.
			             
			
		}
		/*
		 * 동적바인딩: 컴파일 시점에는 정적바인딩으로 현재 레퍼런스(Sports)의 자료형 클래스에 있는  rule이라는 메소드를 가르키긴하지만, 
		 * 런타임시점(실제 실행 시점)에는 동적바인딩으로 자식 객체에 오버라이딩 된 메소드가 있을 경우 알아서 찾아져서 실행이 된다! 
		 */
		
		/*
		 * * 추상메소드
		 * - 미완성된 메소드로 몸통부({})가 구현되어 있지 않은 메소드
		 * 
		 * * 추상클래스
		 * - 미완성된 클래스
		 * - 객체 생성 불가 (단, 레퍼런스 변수로는 선언 가능!!)
		 * - 일반 필드 + 일반 메소드  + [추상 메소드 ]
		 *   => 추상메소드를 가진 클래스는 반드시 추상클래스로 명시해야한다!
		 * 
		 * * 추상메소드가 굳이 없어도 추상클래스로 만들 수 있음!!
		 *   언제 사용되나??
		 *   > 개념적 : 단지 이 클래스가 미완성된 클래스다 라는걸 부여할 목적
		 *   > 프로그래밍적 : 억지로 객체 생성이 불가하게끔 하고자 할 때
		 * 
		 *  * 추상메소드가 존재하는 추상클래스를 쓰는 이유
		 *  - 부모클래스에 추상메소드가 존재할 경우
		 *    자식클래스에서는 강제로 오버라이딩 해서 동일한 패턴의 메소드를 가지게 된다!
		 *    => 각 자식클래스마다 실행시킬 내용은 다르지만 동일한 형태의 메소드로 구현했으면 할 때 
		 *      => 메소드 통일성 확보 목적
		 *      => 표준화된 틀을 제공할 목적
		 *      
		 *    
		 *   추상메소드에서 조금 뻗어나간 개념 => 인터페이스 (일반필드, 일반메소드 존재 X , 추상메소드만 가능)
		 *   
		 * 
		 */
		
		
		
		
		
	}

}
