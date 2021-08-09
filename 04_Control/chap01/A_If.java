package com.kh.chap01.condition;
import java.util.Scanner;

public class A_If {

	
	/*
	 * 기본적으로 프로그램의 진행은 순차적으로 진행
	 * 단, 이 순차적인 흐름을 바꾸고자할때 제어문이라는걸 이용해서 직접 제어가능
	 * 
	 * 선택적으로 실행시키고자할 때 => 조건문을 제시
	 * 반복적으로 실행시키고자할 때 => 반복문을 제시
	 * 그 외의 흐름을 제어할 때 => 분기문을 제시
	 * 
	 * * 조건문
	 *   "조건식"을 통해 참이냐 거짓이냐를 판단해서 참일경우 그에 해당하는 코드 실행
	 *   
	 *   조건식의 결과는 true/false 여야한다!
	 *   보통 조건식에서는 비교연산자(대소,동등), 논리연산자(&&,||)를 주로 사용
	 *   
	 *   * 조건문은 크게 if문과 swith문으로 나뉨
	 *   
	 */
	
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		/*
		 * * 단독 if문
		 * 
		 *   if(조건식) {
		 *    .. 실행시키고자 하는 코드 ..
		 *   }
		 * 
		 *    => 조건이 참(true)일 경우 => 중괄호 블럭 안의 코드 실행
		 *    => 조건이 거짓(false)일 경우 => 중괄호 블럭 안의 코드 무시하고 넘어감
		 */
		
		if(num > 0) {
			System.out.println("양수다");
		}
		
		if(num <= 0) {
			System.out.println("양수가 아니다.");
		}
			
			
		}
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		
		/*
		 * * if-else문
		 *  
		 *  if(조건식) {
		 *      ..실행 코드 1..
		 *   } else {
		 *      ..실행 코드 2..
		 *   }
		 *   
		 *   조건식의 결과가 참(true)일 경우 실행코드 1 수행 후 if-else문 빠져나감
		 *   단, 결과가 거짓(false)일 경우 무조건 실행코드2 수행
		 *   
		 */
		
		
		if(num > 0) {
			System.out.println("양수다.");
		} else {
			System.out.println("양수가 아니다.");
		}
	}
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		/*
		 * * if-else if문
		 * 
		 *   같은 비교대상으로 여러개의 조건을 제시해야될 경우
		 * 
		 * 	 if(조건식1) {
		 *      .. 실행 코드 1 ..
		 *   } else if (조건식2) {
		 *   	.. 실행 코드 2 ..	
		 *   } else if (조건식3) {
		 *      .. 실행 코드 3 ..
		 *   } else {
		 *      위의 조건들이 다 false일 경우 실행할 코드
		 *   }
		 * 
		 */
		
		if(num > 0) {
			System.out.println("양수다.");
		} else if(num == 0) {
			System.out.println("0이다.");
		} else /*if(num < 0)*/ {
			System.out.println("음수다.");           // 모든 조건을 충족하지 않을 때 마지막에는 else만 사용해도 된다.
		}
	}
	
	public void method4() {
		
		// 13세 이하 : 어린아
		// 13세 초과 19세 이하 : 청소년
		// 19세 초과 : 성인
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이(정수만) : ");
		int age = sc.nextInt();
		
		
		//방법1
		/*
		if(age <=13) {
			System.out.println("어린이");
		} else if(age <= 19) {
			System.out.println("청소년");
		} else {
			System.out.println("성인");
		}
		*/		
		
		
		//방법2
		String result;
		
		if(age <= 13) {
			result = "어린이";
		}else if(age <= 19) {
		    result = "청소년";
		}else {
			result = "성인";
		}
		
		System.out.println(result);
	}
	
	public void method5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		// xxx님은 xxx이다.
		
		
		//방법1
		/*
		if(gender == 'M' || gender == 'm') {
			System.out.println(name + "님은 남학생이다.");
		} else if (gender == 'F' || gender == 'f') {
			System.out.println(name + "님은 여학생이다.");
		} 
		*/
		
		
		//방법2
		String result = "";                //변수를 미리 세팅해둘때 반드시 초기화 해놓는 습관을 들이자!!
		
		if(gender == 'M' || gender =='m') {
			result = "남학생";
		} else if (gender == 'F' || gender == 'f') {
			result = "여학생";
		} else {
			System.out.println("성별을 잘못 입력하였습니다.");
			return; // => ** 해당 메소드 자체를 빠져나가는 구문(이 메소드를 호출했던 곳으로 빠져나감) **
		}
		
		System.out.println(name + "님은 " + result + "이다.");	
	}
	
	
	//특이케이스
	public void method6() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();                              
		
		/*		
		if(name == "홍길동") {
			System.out.println("홍길동님 반갑습니다.");                   => 홍길동을 입력해도 else값이 입력이 된다. why??!
		} else {
			System.out.println("홍길동님이 아닌데요? 저리가세요~~~~");
		}
		*/
		
		  
		
		/*
		 * 기본자료형 : boolean(1byte), byte(1byte), short(2byte), int(4byte), long(8byte), 
		 *          float(4byte), double(8byte), char(2byte) (8개)
		 *          
		 * 참조자료형 : String
		 * 
		 * 기본자료형들끼리 동등 비교시에는 ==, !=   => 사용가능 (정상적으로 비교됨)
		 * 단, 참조차료형은 동등 비교시 ==, != 사용시 정상적으로 비교가 안됨
		 *    => equals() 메소드를 이용해서 비교해야됨
		 *       [표현법]   
		 *       문자열.equals(문자열)
		 */  
				
		if(name.equals("홍길동")) {
			System.out.println("홍길동님 반갑습니다.");
		} else {
			System.out.println("홍길동님이 아닌데요? 저리가세요~~~~");
		}
			
	}
	
	//조건문 중첩사용
	public void method7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수(양수) 입력 :  ");
		int num = sc.nextInt();
		
		if(num > 0) { // 양수일 경우
			
			if( num % 2 == 0) { // (양수이고) 짝수일 경우
				System.out.println("짝수다.");
			} else { // (양수이고) 홀수일경우
				System.out.println("홀수다.");
			}
			
		} else { // 양수가 아닐경우
			System.out.println("양수가 아닙니다. 잘못입력하셨습니다.");
		}
		
	}
	
}
