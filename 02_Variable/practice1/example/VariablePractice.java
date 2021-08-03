package com.kh.practice1.example;

import java.util.Scanner;

public class VariablePractice {
	
	//실습문제1
	public void method1() {
		System.out.println("===실습문제1===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("성별을 입력하세요(남/여) : ");
		char gender = sc.nextLine().charAt(0);
				
		System.out.print("키를 입력하세요(cm) : ");
		double height = sc.nextDouble();
		
		//키 xxx.x인 xx살 x자 xxx님 반갑습니다^^
		System.out.println("키 " + height + "인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다^^");
	}
	
	//실습문제2
	public void method2() {
		System.out.println("===실습문제2===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int a = sc.nextInt();
		
		System.out.print("두 번째 정수를 입력하세요 : ");
		int b = sc.nextInt();
		
		System.out.println("더하기 결과 : " + (a+b) );
		System.out.println("빼기 결과 : " + (a-b) );
		System.out.println("곱하기 결과 : " + (a*b) );
		System.out.println("나누기 몫 결과 : " + (a/b) );
	}
	
	//실습문제3
	public void method3() {
		System.out.println("===실습문제3===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double dNum1 = sc.nextDouble();
		
		System.out.print("세로 : ");
		double dNum2 = sc.nextDouble();
		
		System.out.println("면적 : " + (dNum1 * dNum2) );
		System.out.println("둘레 : " + ((dNum1+dNum2)*2) );
	}
	
	//실습문제4
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		
		String str = sc.nextLine();
		
		System.out.println("첫 번째 문자 : " + str.charAt(0));
		System.out.println("두 번째 문자 : " + str.charAt(1));
		System.out.println("세 번째 문자 : " + str.charAt(2));
	}
}
