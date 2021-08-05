package com.kh.practice.example;
import java.util.Scanner;


public class OperatorPractice {
	
	
	//실습문제1
	public void practice1() {
		
		System.out.println("=== 실습문제1 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		System.out.println(num > 0 ? "양수다" : "양수가 아니다");
	}
	
	//실습문제2
	public void practice2() {
		
		System.out.println("=== 실습문제2 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
			
		System.out.println( (num > 0 ? "양수다" : (num == 0 ? "0이다" : "음수다 ") ) ) ;		
	}
	
	//실습문제3
	public void practice3() {
		
		System.out.println("=== 실습문제3 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		System.out.println(num % 2 == 0 ? "짝수다" : "홀수다");
	}
	
	//실습문제4
	public void practice4() {
		
		System.out.println("=== 실습문제4 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + (candy / people) );
		System.out.println("남는 사탕 개수 : " + (candy % people) );		
	}
	
	//실습문제5
	public void practice5() {
		
		System.out.println("=== 실습문제5 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int cla = sc.nextInt();
		
		System.out.print("번호(숫자만) : ");
		int number = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		double test = sc.nextDouble();
				
		String student = (gender == 'M') ? "남학생" : "여학생";
		
		
		//x학년 xx반 x번 xxx x학생의 성적은 xx.xx이다.
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", grade, cla, number, name, student, test);	
	}
	
	//실습문제6
	public void practice6() {
		
		System.out.println("=== 실습문제6 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.println(age <= 13 ? "어린이" : age <= 19 ? "청소년" : "성인" );
	}
	
	//실습문제7
	public void practice7() {
		
		System.out.println("=== 실습문제7 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int a = sc.nextInt();
		
		System.out.print("영어 : ");
		int b = sc.nextInt();
		
		System.out.print("수학 : ");
		int c = sc.nextInt();
		
		double d = (a + b + c) / 3.0;
		
		System.out.println("합계 : " + (a + b + c) );
		System.out.println("평균 : " + d);
		System.out.println( a>=40 && b>=40 && c>=40 & d>=60? "합격" : "불합격" );
	}
	
	//실습문제8
	public void practice8() {
		
		System.out.println("=== 실습문제8 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(-포함) : ");
		//char ch = sc.nextLine().charAt(7);
		String str = sc.nextLine(); //940325-2341536;
		
		char gender = str.charAt(7);
		
		System.out.println(gender == '1'|| gender == '3' ? "남자" : "여자");
	}
	
}
