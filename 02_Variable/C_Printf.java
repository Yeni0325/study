package com.kh.variable;

public class C_Printf {
	
	public void printfTest() {
		
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
		
		// "10 20"
		System.out.println(iNum1 + " " + iNum2);
		System.out.printf("%d %d", iNum1,iNum2);
	}

}
