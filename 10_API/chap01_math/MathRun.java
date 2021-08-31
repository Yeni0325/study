package com.kh.chap01_math.run;

public class MathRun {

	public static void main(String[] args) {
		
		//java.lang.Math (java.lang패키지는 우리가 명시하지 않아도 자동적으로 import 되어있음!!)

		//상수필드
		System.out.println("파이 : " + Math.PI);
		
		//절대값을 알고자 할 때 : abs
		int num1 = -10;
		System.out.println("절대값 : " + Math.abs(num1));
		
		//올림 : ceil
		double num2 = 4.349;
		System.out.println("올림 : " + Math.ceil(num2));
		//자바에서 올림 자릿수 지정은 불가하다. 무조건 소수점 첫번째 자리에서 진행!
		
		//반올림 : round
		System.out.println("반올림 : " + Math.round(num2));
		
		//버림 : floor
		System.out.println("버림 : " + Math.floor(num2));
		
		//가장 가까운 정수값을 알아낸 후 실수형 반환 : rint
		System.out.println("가장 가까운 정수값 : " + Math.rint(num2));
		
		//제곱근(루트) : sqrt
		System.out.println("4의 제곱근 : " + Math.sqrt(4));
		
		//제곱 : pow
		System.out.println("2의 10제곱 : " + Math.pow(2,10));
		
		//Math m = new Math();
		
		/*
		 * * Math 특징
		 * - 모든 필드 상수필드, 모든 메소드 static 메소드! (싹 다 static임!)
		 * - 생성자 모두 private으로 되어 있음 => 생성 불가하도록
		 * 
		 * ** 한번만 메모리 영역에 올려놓고 재사용하는 개념 => 싱글톤 패턴
		 * 
		 */
		
		
		
		
		
	}

}
