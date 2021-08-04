package com.kh.operator;
import java.util.Scanner;

public class D_Comparison {
	/*
	 * * 비교연산자/관계연산자 (이항연산자)
	 *   두 값을 비교하는 연산자
	 *   비교연산자는 조건을 만족하면 true(참), 만족하지 않으면 false(거짓)을 반환
	 *   즉, 비교연산 결과는 논리값!!
	 *   
	 *   대소비교연산자 : < > <= >=
	 *   동등비교연산자 : == !=
	 */
	
	public void method1() {
		
		//int a = 10, b = 25;  // 가능하긴 하나 권장하지 않음!!
		int a = 10;    //관례상 변수는 한줄 씩 선언하는것이 좋음!
		int b = 25;
		
		System.out.println("a == b : " + (a == b) );
		System.out.println("a <=b : " + (a<=b) );
		
		boolean result = (a > b);
		System.out.println("result : " + result);
		
		// 산술연산 + 비교연산 
		System.out.println( (a * 2) > (b / 5) );
		
		System.out.println("a가 짝수인가 : " + (a % 2 ==0) );
		System.out.println("a가 홀수인가 : " + (a % 2 != 0) );
		System.out.println("a가 홀수인가 : " + !(a % 2 == 0) );
		System.out.println("a가 홀수인가 : " + (a % 2 == 1) );
		
		// 2로 나눴을 떄의 나머지가 0일 경우 == 2로 나눠떨어진다는 의미 == 짝수
		//           나머지가 1일 경우 == 2로 나눠떨어지지 않음 == 홀수
	}
	
	public void methdo2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수  : ");
		int num2 = sc.nextInt();
		
		System.out.println("첫번째가 두번째보다 큽니까 : " + (num1 > num2 ) );
		System.out.println("첫번째 정수가  짝수입니까 : " + (num1 % 2 == 0) );	
		
		// 특이 케이스 (문자와 숫자간의 대소비교가 가능!!)
		System.out.println(num2 < 'A');
		//'A' ~ 'Z'   65 ~ 90 까지의 숫자로 연달아 나열되어 있음
	
	
	}
	
	
}
