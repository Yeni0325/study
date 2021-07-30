package com.kh.first;

public class PrintTest {

	// 출력문 실습
	public static void main(String[] args) {
		
		System.out.println("println은 줄바꿈");
		
		System.out.print("print는 줄바꿈X\n"); // 문자열(문장)의 경우는 쌍따옴표로 묶는다
		
		System.out.print(12345 + "\n"); // 숫자의 경우는 그냥 적어준다
		
		System.out.print('A' + "\n"); // 문자의 경우는 홑따옴표로 묶는다
		
		// 줄바꿈을 하고싶지만 print 문을 써야하는 경우에는?
		System.out.print("줄바꿈이 하고싶어!!!\n");
		System.out.print("줄바꿈 시켜줘!!!\n");
		
		// \n : 개행문자, 줄바꿈 시켜주는 역할, 즉 엔터 키를 누른것과 같다.
		// 참고 => 문자+숫자, 문자+문자열, 숫자+문자열 과 같이 서로 다른 형태를 붙여서 나타내주는 기호는 +
		
		System.out.print("\nHi\nEveryone!!\n"); // 개행문자는 문장 중간에 아무데서나 쓰일수 있다.
		
		System.out.print("\\n"); // \n 자체로도 출력이 된다.
		
		System.out.println();
		
		// 같은 결과값이여도 출력 방법은 다양하다!! 
		System.out.println("123\n456");
		
		System.out.println(123 + "\n" + 456);
		
		System.out.println(123);
		System.out.println(456);
		
		// 역슬래시는 그 자체만으로 문자로 인식이 되지 않기 때문에 문자로 인식하고 싶을 경우에는 역슬래시를 한번 더 붙여준다
		System.out.println("\\");
	}
}
