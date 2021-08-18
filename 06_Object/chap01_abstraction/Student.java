package com.kh.chap01_abstraction.model.vo;

/*
 * * 클래스의 구조
 * 
 * public class 클래스명 {
 * 
 *      // 필드부 : 객체의 데이터가 저장되는 곳.
 *      
 *      
 *      // 생성자부 : 객체 생성 시 초기화 역할 담당
 * 
 * 
 *      // 메소드 부 : 객체의 동작에 해당하는 실행 블록
 *      
 *      
 *      
 *      필드부, 생성자부, 메소드부를 작성할 때는 앞에 접근제한자(ex.public)를 먼저 써야함
 * }
 * 
 * 
 * 
 * 
 * 
 */





public class Student { //학생들을 추상화해서 만든 클래스(완벽한 상태는 아님)
	
	//필드부 => 값을 선언할 변수같은걸 필드부에 저장
	//접근제한자 [예약어] 자료형 필드명;
	
	// * 접근제한자 : 여기에 접근할 수 있는 범위를 제한하는 것
	//             public(개방적, 다 접근가능) > protected > default > private(범위가 제일 좁음) 
	public String name;
	public int age;
	public double height;
	
	//생성자부
	
	
	//메소드부
	
	
	

}
