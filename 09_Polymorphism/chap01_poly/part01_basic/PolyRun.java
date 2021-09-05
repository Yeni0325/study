package com.kh.chap01_poly.part01_basic.run;

import com.kh.chap01_poly.part01_basic.model.vo.Child1;
import com.kh.chap01_poly.part01_basic.model.vo.Child2;
import com.kh.chap01_poly.part01_basic.model.vo.Parent;

public class PolyRun {

	public static void main(String[] args) {
		
		//기억해둘것!! '=' 기준으로 해서 왼쪽과 오른쪽의 자료형(타입)은 동일해야함!!
		
		System.out.println("1. 부모타입 레퍼런스로 부모객체를 다루는 경우");
		Parent p1 = new Parent();
		p1.printParent();
		// p1  레퍼런스로 parent에만 접근 가능
		
		System.out.println("2. 자식타입 레퍼런스로 자식객체를 다루는 경우");
		Child1 c1 = new Child1();
		//상속을 진행 한 클래스의 경우 부모객체가 먼저 생성이 되고, 그 후에 자식 객체가 부모객체를 감싸면서 생성이 된다. 
		//자식클래스의 기본생성자에는 보여지진 않지만 항상 super( );가 생략되어 있음!
		c1.printChild1();
		c1.printParent(); // 자동형변환이 된거였음!! (Child1타입(자식) => Parent타입(부모))
		// c1이라는 레퍼런스로 Parent와 Child1에 둘 다 접근가능!
		// 엄연히 따지면 c1의 printParent라는 메소드를 호출하려면 Parent로 형변환 하는 과정이 필요하다.   =>  (Parent)c1.pritParent();
		// * but 자식클래스에서 부모클래스는 자동적으로 형변환이 되기때문에 접근이 가능하다!
		
		System.out.println("3. 부모타입 레퍼런스로 자식객체를 다루는 경우 (다형성)");
		Parent p2 = /*(Parent)*/ new Child1(); // 부모타입 레퍼런스로 자식객체인 Child1을 받아줌
		//왜냐 자식타입은 부모타입으로 자동형변환이 가능하기 때문에!!
		//클래스간의 형변환은 상속구조(부모, 자식간의 관계)만 가능
		p2.printParent();
		//p2.printChild1(); => 오류발생 : Parent라는 클래스 타입에 printChild1이라는 클래스 타입은 없다
		
		//Stack영역에 Parent타입의 p2박스가 생성, Heap영역에 Child1이라는 객체가 생성되기 전 부모를 상속하기 때문에 Parent타입의 객체가 먼저 생성이 되고, 
		//해당 객체를 감싸면서 Child1타입의 객체가 생성이 된다.
		
		//그러나 실제 참조되는것은 동일한 자료형(타입)만 가능하기 때문에 Parent타입의 p2박스는 Parnet타입인 부모객체에만 접근가능하지만
		//Child1에 접근하고자한다면 강제형변환을 하면 접근이 가능하다!!
		
		//Child1이라는 객체는 생성되어있는 상황이기 때문에 강제형변환 시 호출이 가능하다!
		
		((Child1)p2).printChild1();
		//* 부모에서 자식으로, 즉 위에서 아래로는 자동형변환이 되지 않는다! => 강제형변환 시켜줘야함!!
		
		/*
		 * 클래스와 클래스간의 형번환은 상속구조일 때만 가능하다.
		 * 부모 -> 자식 / 자식 -> 부모 가능
		 * 
		 * 1. UpCastriong (아래에서 위로)
		 *    자식 타입 -> 부모 타입으로 형변환
		 *    자동형변환 가능(생략 가능)
		 *    
		 *    ex) 자식.부모메소드()
		 *        부모 레퍼런스 = 자식객체;
		 *    ex) 2번째 케이스
		 * 
		 * 2. DownCasting (위에서 아래로)
		 *    부모 타입 -> 자식 타입으로 형변환
		 *    강제형변환 해야함!
		 *    ex)부모타입 레퍼런스를 가지고 자식 메소드를 호출하려고 할 때!
		 *       ((자식)부모).자식메소드(); => ((Child1)p2).printChild1();
		 */
		
		// * 다형성 정의
		// - 부모 타입으로부터 파생된 여러가지 타입의 자식 객체들을 부모클래스 타입 하나로 다 다룰 수 있는 기술
		//   하나의 타입으로 여러개의 자식객체를 다 받아줄 수 있다!
		
		// * 다형성을 쓰는 목적 (장점)
		// 다형성을 배우기 전...
		// Child1 객체 2개와 Child2 객체 2개를 관리해야하는 상황
		Child1[] arr1 = new Child1[2];
		//엄연히 Child1 배열에는 Child1 객체만 담길 수 있음!!
		arr1[0] = new Child1(1, 2, 4);
		arr1[1] = new Child1(2, 3, 5);
		
		Child2[] arr2 = new Child2[2];
		arr2[0] = new Child2(2, 1, 5);
		arr2[1] = new Child2(5, 7, 2);
		//엄연히 Child2 배열에는 Child2 객체만 담길 수 있다!!
		
		//----------------------------------------------
		// 다형성을 적용한 후...
		// 부모타입 하나만으로 여러 자식객체들을 관리할 수 있음 => 편리하다, 코드길이 감소
		Parent[] arr = new Parent[4];
     //Parent타입             Child1타입, Child2타입
		arr[0] = new Child1(1, 2, 4); //UpCasting (아래에서 위로 자동형변환!)
		arr[1] = new Child2(2, 1, 5);
		arr[2] = new Child2(5, 7, 2);
		arr[3] = new Child1(2, 3, 5);
		
		System.out.println("==========================================");	
		((Child1)arr[0]).printChild1(); //DownCastiong (위에서 아래로 강제형변환!)
		((Child2)arr[1]).printChild2();
		//((Child1)arr[2]).printChild1(); //ClassCastException : 적절하지 않은 형변환 오류 발생
		((Child2)arr[2]).printChild2();
		((Child1)arr[3]).printChild1();
		System.out.println("==========================================");
		System.out.println("==============반복문 이용해서 출력 ===============");
		
		//위에 내용을 반복문을 활용한다면?		
		for(int i=0; i<arr.length; i++) {
			
			if(i == 0 || i==3) {
			((Child1)arr[i]).printChild1();
			}else {
			((Child2)arr[i]).printChild2();
			}
		}
		
		//현재 레퍼런스가 어떤 자식객체를 참조하고 있는지 확인하는 연산자가 있음!!!!!   => instanceof
		/*
		 * instanceof 연산자 => 연산 결과를 true / false 로 반환 => 따라서 조건식으로 활용하기 좋음!
		 * 현재 레퍼런스가 실질적으로 어떤 클래스타입을 참조하는지 확인할 때 사용!
		 */
		
		System.out.println("==========================================");
		System.out.println("=======instanceof 연산자 이용해서 출력 ===========");
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] instanceof Child1) { //해당 레퍼런스가 실제 Child1 을 참조하고 있다면 true 아니면 false
			((Child1)arr[i]).printChild1();
			}else {
			((Child2)arr[i]).printChild2();
			}
		}
		System.out.println("==========================================");
		System.out.println("============오버라이딩 적용해서 출력 ==============");
		//위보다 더 쉬운 방법!
		//오버라이딩이 적용된 예시!
		
		//Parent pp = new Child1();
		//pp.print();    // '나 첫번째 자식이야'가 출력  => 동적 바인딩
		
		/*
		 * 동적바인딩 : 프로그램이 본격적으로 실행되기 전에는 컴파일 과정이 진행되면서 정적바인딩이 이루어짐 (해당 레퍼런스타입의 메소드를 가리킴)
		 *          단, 실질적으로 참조하는 자식클래스에 해당 메소드가 오버라이딩이 되어있다면 
		 *          본격적으로 프로그램이 실행될 때는 정적인 메소드가 아닌 동적으로 자식클래스에 오버라이딩 된 메소드를 실행시켜주는 것
		 * 
		 * 자식 자료형으로 자식객체를 다루는 경우에는 동적바인딩 X
		 * 부모 자료형으로 자식객체를 다루는 경우에는 동적바인딩O
		 */
		
		//이를 활용해 반복문을 통해 출력해보자
		for(int i=0; i<arr.length; i++) {
			arr[i].print();
		}
		
		
		
	}

}
