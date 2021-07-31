package com.kh.variable;

import java.util.Scanner;

// 사용자가 키보드로 입력한 값을 받아들이는 Scanner 실습
public class B_KeyboardInput {

	public void inputTest1() {
		
		/*
		 * 키보드로 값을 입력하는 방법
		 * Scanner 를 사용한다!
		 * (즉 java.util.Scanner 클래스를 이용하는 것이다!)
		 * Scanner 클래스 내부의 메소드를 호출하여 입력받는것.
		 */
		
		// 스캐너 클래스의 객체 생성
		Scanner sc = new Scanner(System.in);
		// System.in 은 입력받은 값을 바이트 단위로 받아들이겠다는 의미
		// 출력 시에는 System.out 이라는 구문을 썼었다!
		
		System.out.print("아무거나 입력해보세요 : ");
		String amuguna = sc.nextLine();
		
		System.out.println("입력받은 내용 : " + amuguna);
	}
}





