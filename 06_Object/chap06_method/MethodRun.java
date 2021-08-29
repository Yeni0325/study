package com.kh.chap06_method.run;
import java.util.Scanner;

import com.kh.chap06_method.controller.NonStaticMethod;
import com.kh.chap06_method.controller.OverloadingTest;
import com.kh.chap06_method.controller.StaticMethod;

public class MethodRun {

	public static void main(String[] args) {
		
		//---------NonStaticMetod-----------
		NonStaticMethod test = new NonStaticMethod();
		
		// 1. 매개변수 없고 반환값 없는 메소드 호출
		test.method1();
		
		//2. 매개변수 없고 반환값 있는 메소드 호출
		//test.method2();
		/*
		String str = test.method2();
		System.out.println(str);
		=> 한 번 값을 기록한 후 활용할 목적이면 이 방법으로 하는것이 맞다.
		*/
		
		System.out.println(test.method2());
		// 값 기록 후 별도의 활용 없이 출력만 할 경우 위와 같이 한줄로 호출도 가능하다!
		
		//3. 매개변수 있고 반환값이 없는  메소드 호출
		test.method3(10, 0);
		//int a = test.method3(10, 20);
		//반환값이 없는 메소드이기 때문에 위와 같은 결과값을 변수에 저장하는 것이 불가능하다.
		
		//4. 매개변수도 있고 반환값도 있는 메소드 호출
		char ch = test.method4("pineapple", 3);
		System.out.println(ch);
		//System.out.println(test.method4("pineapple", 3));
		// 값 기록 후 별도의 활용 없이 출력만 할 경우 위와 같이 한 줄로 호출 가능!
		
		//응용1.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		System.out.println("결과 : " + test.method5(str, num));
		
		System.out.println();
		System.out.println();
		System.out.println("===StaticMethod===");
		//------------StaticMethod--------------
		StaticMethod test2 = new StaticMethod();
		
		//1.
		StaticMethod.method1();
		
		//2.
		System.out.println(StaticMethod.method2());
		
		//3. 
		StaticMethod.method3("홍길동");
		
		//4. 
		System.out.println(StaticMethod.method4("apple", "apple"));
		
		System.out.println();
		System.out.println();
		System.out.println("===OverloadingTEST===");
		//------------OverloadingTest--------------
		OverloadingTest ot = new OverloadingTest();
		ot.test();
		ot.test(20);
		ot.test(10, "ㅎㅎㅎ");
		ot.test("ㅎㅎㅎ", 20);
		ot.test(10,20);
		
		//오버로딩의 대표적인 예 => 출력문 print()
		System.out.print(10);
		System.out.print("ㄴㄴ");
		System.out.print(0.0);
		//System.out.println
	}

}
