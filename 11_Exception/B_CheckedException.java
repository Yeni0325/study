package com.kh.exception.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_CheckedException {
	//예측 불가기 때문에 조건문 자체를 작성할 수 없다
	//CheckedExcption은 컴파일에러로 예외처리 하라고 미리 알려준다.
	
	/*
	 * CheckedException은 반드시 예외처리를 해야되는 예외들임
	 * => 조건문 미리 제시할 수 없음 (왜? 예측이 불가한 곳에서 문제가 발생하기 때문에 미리 예외처리 구문을 작성해야됨!)
	 * => 외부 매개채와 입출력이 일어날 때 주로 발생됨! (IOException(input/output 입출력))
	 */
	
	public void method1() throws IOException {
		method2();
	}
	
	public void method2() throws IOException {
		
		//Scanner와 같이 키보드로 값을 입력받을 수 있는 객체 (단, 문자열로 읽어들여짐)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아무거나 입력해주세요 : ");
		
		//예외처리 방법 
		// 1. try ~ catch 문 : 여기 이 자리에서 곧바로 예외를 처리하겠다.
		// try{} : 예외가 발생할 가능성이 있는 코드를 작성
		// catch(발생될예외클래스 매개변수) {} : try구문 내에서 예외가 발생했을 경우 어떻게 처리할껀지에 대한 내용 작성
		/*
		try {
			String str = br.readLine();
			System.out.println(str);
		} catch(IOException e) {
			System.out.println("예외가 발생했습니다.");
		}
		*/
		
		//2. throws : 지금 이 자리에서 예외 처리하지 않고 현재 이 메소드를 '호출하는 곳'으로 예외처리를 떠넘기겠다.(위임하겠다.)
		String str = br.readLine(); //readLIne()메소드 자체에서 throws IOException을 하고 있음(떠넘기고 있음)
		System.out.println(str);
	}
	
	
	/*
	 *                              예외클래스                            예외발생시점                         예외처리
	 * UnCheckedException      RuntimeException         런타임시점                 세모(필수아님, 개발자가 선택적으로 => if문을 통해 애초에 예외가 발생안되도록 / 예외처리구문)
	 *  CheckedException      RuntimeException 그 외         컴파일에러(빨간줄)     필수(조건문안됨)
	 * 
	 */
	

}
