package com.kh.operator;

public class F_Compound {

	/*
	 * * 복합 대입 연산자
	 *   산술연산자와 대입연산자가 결합되어있는 형태
	 *   연산처리 속도가 빨라지므로 사용하는걸 권장함!!
	 * 	 	
	 *   += -= *= /= %=
	 * 	
	 * 	 a = a + 3;      =>    a += 3;  (3을 a에 먼저 저장하는 것이 아닌, a에 3을 더하고 그 결과를 a에 저장)
	 * 	 a = a - 3;      =>    a -= 3;  (3에서 a를 먼저 빼고, 그 결과를 a값에 저장)
	 *   a = a * 3;      =>    a *= 3;  (3에서 a를 먼저 곱하고, 그 결과를 a값에 저장) 
	 *   a = a / 3;      =>    a /= 3;  (3에서 a를 먼저 나누고, 그 결과를 a값에 저장)
	 *   a = a % 3;      =>    a %= 3;  (3에서 a를 나눈 나머지의 값을 a값에 저장)
	 *   
	 */
	
	public void method1() {
		int num = 12;
		
		System.out.println("최초 num : " + num);
		
		num = num + 3; 
		//ㄴ기존에 만들어진 변수를 호출할 때는 그냥 변수명만 사용!
		System.out.println("3 증가시킨 num : " + num);
		
		num += 3;  // num = num + 3
		System.out.println("또 3 증가시킨 num : " + num);
		
		num -= 5;  // num = num - 5
		System.out.println("5 감소시킨 num : " + num);
		
		num *= 6; // num = num * 6
		System.out.println("6배 증가시킨 num : " + num);
		
		num /= 2; // num = num / 2
		System.out.println("2배 감소시킨 num : " + num);
		
		num %= 4; // num = num % 4
		System.out.println("num을 4로 나눴을 떄의 나머지 값인 num : " + num);
		
		
		String str = "Hello";
		//str = str + "World";    //"HelloWorld"   =>  문자열은 + 만 가능하다!
		str += "World";           //따라서 복합대입연산자도 문자열은 +가 가능하다!
		System.out.println(str);
	
	}
}
