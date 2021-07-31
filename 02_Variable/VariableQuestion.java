package com.kh.variable;

public class VariableQuestion {
	public static void main (String[] args) {
		
		//실습문제1
		
		System.out.println("===실습문제1===");
		
		String name = "홍길동";
		String gender = "여";
		int age = 20;
		int height = 165;
		
		System.out.println("이름을 입력하세요 : " + name );
		System.out.println("성별을 입력하세요(남/여) : " + gender);
		System.out.println("나이를 입력하세요 : " + age);
		System.out.println("키를 입력하세요(cm) : " + height);
		System.out.println("키" + height + "cm인 " + age + "살 " + gender + "자" + name + "님 반갑습니다^^\n");
		
		//실습문제2
		
		System.out.println("===실습문제2===");
		
		int a = 17;
		int b = 3;
		
		System.out.println("첫 번째 정수 : " + a);
		System.out.println("두 번째 정수 : " + b);
		System.out.println("더하기 결과 : " + (a+b) );
		System.out.println("빼기 결과 : " + (a-b) );
		System.out.println("곱하기 결과 : " + (a*b) );
		System.out.println("나누기 결과 : " + (a/b) + "\n" );
		
		//실습문제3
		
		System.out.println("===실습문제3===");
		
		double wi = 21.2;
		double he = 7.3;
		
		System.out.println("가로 : " + wi);
		System.out.println("세로 : " + he);
		System.out.println("면적 : " + (wi * he) );
		System.out.println("둘레 : " + (wi + he)*2 + "\n" );
		
		//실습문제4
		
		System.out.println("===실습문제4===");
		
		String word = "travel";
		
		System.out.println("문자열을 입력하세요 : " + word);
		System.out.println("첫 번째 문자 : " + word.substring(0,1) );
		System.out.println("두 번째 문자 : " +  word.substring(1,2) );
		System.out.println("세 번째 문자 : " +  word.substring(2,3) );
	}

}
