package com.kh.chap03_class.run;
import com.kh.chap03_class.model.vo.Person;


public class ClassRun {
	
	public static void main(String[] args) {
		
		Person a = new Person();
		a.setId("yeeun0325");
		a.setPwd("1234");
		a.setName("±è¿¹Àº");
		a.setAge(28);
		a.setGender('F');
		a.setPhone("010-9977-9422");
		a.setEmail("yeeun032%@naver.com");
		
		System.out.println(a.getId());
		System.out.println(a.getPwd());
		System.out.println(a.getName());
		System.out.println(a.getAge());
		System.out.println(a.getGender());
		System.out.println(a.getPhone());
		System.out.println(a.getEmail());
		
	}
}
