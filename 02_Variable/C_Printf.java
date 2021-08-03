package com.kh.variable;

public class C_Printf {
	
	public void printfTest() {
		
		//System.out.print(출력하고자하는 값); => 출력만 함(줄바꿈 발생x)
		//System.out.println(출력하고자하는 값); => 출력 후 줄바꿈 발생o
		
		//System.out.printf("출력하고자하는 형식(포맷), 출력하고자하는 값, 값, ...");
		//출력하고자하는 값들이 제시한 형식에 맞춰서 출력(줄바꿈x)만 진행. 즉, 한줄띄어쓰기 (개행) 안됌!!
		
		/*
		 * 포맷안에서 쓰일 수 있는 키워드
		 * %d : 정수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * %f : 실수
		 */
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		//정수형
		// "10 20"
		System.out.println(iNum1 + " " + iNum2);
		System.out.printf("%d %d", iNum1,iNum2);
		System.out.println();
		
		System.out.printf("%5d\n", iNum1); //5칸의 공간 확보 후 오른쪽정렬(음수면 왼쪽정렬)
		System.out.printf("%5d\n", 250);
		System.out.printf("%5d\n", 3000);
		System.out.printf("%5d\n", 16);
		
		//실수형
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t %f\n",dNum1, dNum2); //무조건 소수점 아래 6번째자리까지 보여줌  // '\t'는 tab과 같은 역할을 수행한다.
		System.out.printf("%.2f %.1f\n", dNum1, dNum2);
		
		//문자[열]
		char ch = 'a';
		String str = "Hello";
		
		System.out.printf("%c %s %s\n", ch, str, ch);
		
		System.out.printf("%C %S", ch, str); //대문자로도 출력 가능
	}

}
