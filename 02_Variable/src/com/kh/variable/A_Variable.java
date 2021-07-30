package com.kh.variable;

public class A_Variable {
	
	// 시급과 근무시간과 근무일수를 곱해서 월급을 계산해서 출력하는 메소드
	
	public void printVariable() {
		System.out.println("===== 변수 사용 전 =====");
		
		System.out.println("시급 : 8500원");
		System.out.println("근무시간 : 6시간");
		System.out.println("근무일수 : 8일");
		
		//월급 = 시급 * 근무시간  * 근무일수
		// 김갑생 : OOOOO원 형식으로 출력하려면??
		System.out.println("김갑생 : " + (9450 * 6 * 8) + "원");
		System.out.println("권다현 : " + (9450 * 6 * 8) + "원");
		System.out.println("권수연 : " + (9450 * 6 * 8) + "원");
		System.out.println("권윤지 : " + (9450 * 6 * 8) + "원");
		System.out.println("권한나 : " + (9450 * 6 * 8) + "원");
		
		//변수 사용 후 
		System.out.println("===== 변수 사용 후 =====");
		
		int pay = 9450; // 자바에서 '=' 기호는 동등하다 라는 뜻이 아니라 8500 이라는 값을 pay라는 상자에 넣겠다 즉, 대입하겠다는 의미!
		int time = 6;
		int day = 8;
		
		System.out.println("김가연 : " + (pay * time * day) + "원" );
		System.out.println("김란 : "  + (pay * time * day) + "원");
		System.out.println("김민지 : " + (pay * time * day) + "원");
		System.out.println("김비안 : " + (pay * time * day) + "원");
		System.out.println("김예은 : " + (pay * time * day) + "원");
		
		/*
		 *  변수를 사용하는 이유
		 *  1. 변수는 우선적으로 값에 의미를 부여할 목적으로 쓴다. (가독성이 높아진다.)
		 *  2. 단 한번 값을 기록하고 필요할 때마다 가져다 쓰는 목적으로 쓴다. (재사용성이 높아진다.)
		 *  3. 유지보수를 보다 쉽게할 수 있다.
		 */
		
	}

}
