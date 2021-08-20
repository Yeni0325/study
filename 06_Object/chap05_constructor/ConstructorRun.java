package com.kh.chap05_constructor.run;

import com.kh.chap05_constructor.model.vo.User;

public class ConstructorRun {

	public static void main(String[] args) {
		
		//1. 기본생성자로 객체 생성 후 해당 객체 정보 출력
		User a = new User();
		
		System.out.println(a.information());
		//각 필드에 JVM의 초기값들 담겨있음!!
		
		
		//2. 매개변수 3개까지 생성자로 객체 생성 후 정보 출력
		User u2 = new User("user02", "pass02", "홍길동");
		
		/*
		u2.setUserId("user02");
		u2.setUserPwd("pass02");
		u2.setUserName("홍길동");
		*/
		
		System.out.println(u2.information());
		u2.setUserName("홍말동"); // 필드 하나씩 수정할 경우도 있을거기 때문에 setter메소드 필수!!
		
		//3. 매개변수 5개짜리 생성자로 객체 생성 후 정보 출력
		User u3 = new User("user03", "pass03", "김말똥", 23, '남');
		System.out.println(u3.information());
	}

}
