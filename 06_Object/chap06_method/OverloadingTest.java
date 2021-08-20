package com.kh.chap06_method.controller;

public class OverloadingTest {
	
	// 오버로딩 : 한 클래스 내에 같은 메소드명으로 정의할 수 있는 것
	
	public void test() {
		
		
		
	}
	
	/*
	public void test() {
		
	} => 완전히 똑같은것은 불가.
	*/
	
	public void test(int a) {
		//똑같은 이름의 메소드지만 매개변수가 존재유무가 다르면서 구분이 가능하기 때문에 오버로딩이 가능하다!
	}
	
	public void test(int a, String s) {
		
	}
	
	public void test(String s, int a) {
		
	}
	
	public void test(int a, int b) {
		
	}
	
	/*
	public void test(int c, int d) {
	                                   => 오버로딩 시 매개변수의 이름은 중요하지 않다!	
	}
	*/
	//매개변수 명과는 상관없이 "매개변수의 자료형의 갯수"와 "순서"가 다르게 작성되어야 한다!!
	
	public void test(String str) {
		
	}
	
	/*
	public int test(String str) {
		                           => "반환형"만 달라도 안됨!! 무조건 매개번수가 달라야한다!!
	}
	*/
	/*
	private void test(String str) {
                                   => "접근제한자"도 상관없다!!		
                                   
	}
	*/
	
	/*
	 * * 결론
	 *   오버로딩 : 한 클래스 내에 동일한 이름의 메소드들
	 *           단, 매개변수명, 접근제한자, 반환형을 다 떠나서
	 *           매개변수의 자료형과 갯수, 순서가 다르게 작성되어야됨!!
	 */
}
