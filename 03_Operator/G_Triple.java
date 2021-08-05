package com.kh.operator;
import java.util.Scanner;

public class G_Triple {
	
	/*
	 * * 삼항 연산자 (항목 3개를 가지고 연산해주는 연산자)
	 * 
	 *  [표현법]
	 *  조건식 ? 조건식이 참일 경우 돌려줄 결과값 : 조건식이 거짓일 경우 돌려줄 결과값
	 *  
	 *  이때, 조건식은 반드시 true 또는 false가 나오도록 작성해야됨!
	 *  주로 비교, 논리연산자를 통해 작성하게된다. 
	 */
	
	public void method1() {
		//입력받은 정수값이 양수인지 아닌지 판별한 후 결과 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		
		//1-1
		String result = num > 0 ? "양수이다." : "양수가 아니다.";
		
		//XX은 XXXX.
		System.out.println(num + "은 " + result);
		
		
		//1-2
		System.out.println(num + "은 " + (num <=0 ? "양수가 아니다." : "양수이다."));	
	}
	
	public void method2() {
		//입력받은 정수값이 짝수인지 홀수인지 판별한 후 결과 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		//String result = num % 2 == 0 ? "짝수이다." : "홀수이다."; 
		String result = num % 2 ==1 ? "홀수이다." : "짝수이다.";
		
		System.out.println(num + "은 " + result);
			
	}
	
	public void method3() {
		//사용자에게 종료의사여부 입력받은 후 판별해서 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("종료하시려면 y를 입력해주세요 : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch == 'y' || ch == 'Y') ? "프로그램을 종료합니다." : "계속진행하겠습니다.";
		    //  ㄴ 사용자가 입력한 값이 y거나 Y일 경우
		System.out.println(result);
	}

	public void method4() {
		//입력받은 문자 값이 영어 소문자인지 아닌지 판별한 후 결과 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영문자 입력 : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch >= 'a' && ch <= 'z') ? "소문자이다." : "소문자가아니다.";
		System.out.println(result);
	}
	
	//중첩 삼항연산자
	public void method5() {
		//사용자가 입력한 정수값이 
		//양수인지, 음수인지, 0인지를 정확하게 판별한 후 결과 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		//String result = (num > 0 ? "양수이다." : (num < 0 ? "음수이다." : "0이다."));
		String result = (num > 0 ? "양수이다." : (num == 0 ? "0이다." : "음수이다."));
		
		System.out.println(result);
	}
	
	public void method6() {
		// 사용자에게 두개의 정수값 입력받고
		// + 또는 -를 입력받아서 그에 맞는 연산결과를 출력해주기
		// 단, + 또는 - 외의 다른문자를 입력했을 경우 "잘못 입력했습니다" 출력
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("연산자 입력(+ 또는 -) : ");
		char op = sc.nextLine().charAt(0);
		
		String result = (op == '+' ? (num1 + num2 + "") : (op == '-' ? (num1 - num2 + "") : "잘못입력했습니다.") );
		System.out.println("결과 : " + result);
		
	}
	
}
