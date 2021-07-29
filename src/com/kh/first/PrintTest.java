package com.kh.first;

public class PrintTest {
	
	//출력문 실습
	public static void main(String[] args) {
		
		System.out.println("println은 줄바꿈");
		
		System.out.print("print는  줄바꿈X\n"); //문자열(문장)의 경우는 그냥 쌍따옴표로 묶는다.
		
		System.out.print(1234 + "\n"); // 숫자의 경우 그냥 적어준다.
		
		System.out.print('A' + "\n"); // 문자의 경우 홑따옴표로 묶는다.
		
		//줄바꿈을 하고 싶지만 print문을 써야하는 경우는?
		System.out.print("줄바꿈이 하고 싶어\n");
		System.out.print("줄바꿈 시켜줘!\n");    // '\n' 개행문자로, 줄바꿈 효과를 준다.
		
		// 문자+숫자, 문자+문자열, 숫자+문자열과 같이 서로 다른 형태를 붙여서 나타내주는 기호는 '+'
		
		System.out.print("Hi\nEveryone!!\n"); //개행문자는 문장 중간에 아무데서나 쓰일 수 있다.

		System.out.print("\\n"); // \n 자체로도 \를 하나 더 붙여준다면 출력이 가능하다.
	}

}
