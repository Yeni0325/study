package com.kh.chap04_field.model.vo;

// 클래스 필드(static 변수), 상수필드에 대해서 알아보기
public class FieldTest3 {

	// static은 공유의 개념
	
	// static이 붙은 얘들은 프로그램 실행과 동시에 메모리의 static영역에 올라감!!
	
	// 프로그램을 실행하자마자  main메소드가 실행되기 전, '모든 클래스'를 스캔하면서 static클래스가 붙은 얘들을 메모리영역에 올림!!
	
	// 프로그램 실행과 동시에 메모리상에 한번 올려놓고 여기저기서 가져다 쓰는 개념!
	
	public static String sta = "static_FieldTest3";
	
	
	//static : 공유의 개념
	//final : 상수의 개념(한번 지정된 값은 변경이 X)
	
	//static final : 프로그램 시작과 동시에 메모리 상에 값이 저장되면서 더 이상 변경되지 않고 공유하면서 사용할 목적일 때 사용
	public static final String STA_FIN = "static final"; 
	/*
	 * 상수필드는 선언만 하고 초기화를 안하는것이 불가함!! 무조건 처음부터 값을 지정(초기화)해줘야 함! 
	 * static final은 시작과 동시에 메모리 영역에 올락가게 되는데 추후 값 변경이 불가능하기 때문에 처음부터 지정을 해줘야함!
	 */
	
	// static만 붙은것은 선언만 하는것이 가능! => 추후에 값 변경이 가능하기 때문에 나중에 값을 초기화해도 상관없음!
	// 상수는 암묵적으로 전부 대문자로 작성!!!
	
}
