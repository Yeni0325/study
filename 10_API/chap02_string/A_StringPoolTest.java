package com.kh.chap02_string.controller;

public class A_StringPoolTest {

	public void method1() {
		
		//1. 생성자를 통한 문자열 생성
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		//기존에는 Object클래스에 있는 toString클래스가 실행되면서 이상한 주소값이 출력되어야 하는데,
		//String 클래스에 toString메소드가 이미 오버라이딩 되어있음! (실제 담겨있는 문자열을 반환하도록)
		
		System.out.println(str1 == str2); //false (주소값 비교라서)
		
		System.out.println(str1.equals(str2));
		//String 클래스에 equals메소드는 이미 오버라이딩 되어있음!! (주소값 비교가 아닌 실제 담긴 문자열간 비교)
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//String클래스에 hashCode메소드가 이미 오버라이딩 되어있음!!(주소값이 아닌 실제 담긴 문자열을 가지고 hashcode를 만듬)
		
		//정말 주소값에 대해서 알고 싶다면 System.indentityHashCode(레퍼런스)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
	
	public void method2() {
		
		String str = new String("hello");
		//2. 문자열을 리터럴값으로 생성
		String str1 = "hello";
		String str2 = "hello";
		//리터럴 문자 제시 시 문자 그대로 출력되기 때문에 문자가 담겼다고 생각할 수 있지만
		//이 친구도 나름대로 heap영역에 올라가서 str1, str2영역에 주소값이 들어가있음
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//실제 담긴 문자열을 가지고 hashcode를 만들기 때문에 동일한 주소값 출력
		
		System.out.println(str1 == str2);
		//true => str1 주소값과 str2 주소값이 동일하다
		
		//정말 주소값이 일치하는지 진짜 주소값 출력
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str));
		//new라는 키워드를 통해 생성한 str만 주소값이 다름
		
		//리터럴 제시 시 Heap영역 안에 있는 String pool(상수풀)영역에 올라가게 된다. 
		//String pool(상수풀) 영역의 특징 : 동일한 문자열은 존재할 수 없음
		
		System.out.println("=======");
		String str3 = "hi";
		System.out.println(System.identityHashCode(str3));
		
		//String은 '불변클래스' 다. => 값이 변하지 않는 클래스다.
		//값 변경은 가능하나, 그 자리에서 수정되는 개념이 아님!
		str3 = "bye";
		System.out.println(System.identityHashCode(str3)); // 아예 새로운 주소값을 부여받게 된다.
		
		// hi가 bye로 바뀌는 것이 아니라 String pool(상수풀) 영역에  bye가 새로 생성되면서 새로운 주소값이 부여된다.
		// => 그 자리에서 수정되는 것이 아닌 수정 시 매번 새로운 곳을 참조하게 되는 불변클래스의 특징!
		//이 전에 참조하던 hi라는 레터럴박스는 참조되지 않는 상태이기 때문에 '가비지컬렉터'가 자동적으로 삭제시켜줌!
		
		str3 = "hello";
		System.out.println(System.identityHashCode(str3));
	}
	
	
	
	
}
