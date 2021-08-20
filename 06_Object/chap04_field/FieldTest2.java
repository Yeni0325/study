package com.kh.chap04_field.model.vo;


//필드들의 접근제한자를 테스트 해보기 위한 클래스
public class FieldTest2 {
	
	/*
	 * * 필드에서 사용가능한 접근제한자 4가지
	 * 
	 * - public : 어디서든(같은패키지, 다른패키지 모두) 접근 가능
	 * 
	 * - protected : 같은 패키지 접근 가능, 다른 패키지일 경우 상속구조(부모자식간의 관계)에서는 접근 가능
	 *                                          상속구조가 아니면 접근이 불가능!
	 * 
	 * - default : 같은 패키지만 접근 가능, 다른 패키지일 경우 무조건 접근이 불가함!
	 * 
	 * - private : 오직 해당 클래스에서만 접근이 가능!
	 * 
	 * 위에서부터 아래로 내려갈수록 접근할 수 있는 범위가 좁아짐
	 */
	
	public String pub = "public";
	protected String pro = "protected";
	String def = "default";                   //default는 접근제한자를 생략해야함!
	private String pri = "private";
	
	public static String sta = "static_FieldTest2";
}
