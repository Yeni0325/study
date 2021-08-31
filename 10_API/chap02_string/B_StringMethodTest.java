package com.kh.chap02_string.controller;

public class B_StringMethodTest {
	
	public void method1() {
		
		String str1 = "Hello World";
		
		// 메소드 (매개변수) : 반환형
		
		//1. 문자열.charAt(int index) : char
		//   문자열에서 전달받은 index위치의 문자만을 추출해서 리턴
		char ch = str1.charAt(3);
		System.out.println("ch : " + ch);
		
		//2. 문자열.concat(String str) : String
		//   해당 문자열에 전달된 문자열을 하나로 합쳐서 새로운 문자열 리턴
		String str2 = str1.concat("!!!");
		System.out.println("str2 : " + str2);
		
		//문자열과 문자열을 이어붙이려면 concat이 아닌 '+'(덧셈연산)를 활용한 방법도 가능했다.
		String str3 = str1 + "!!!";
		System.out.println("str3 : " + str3);
		
		//str2와 str3의 동등비교
		System.out.println("str2와 str3가 일치합니까 : " + (str2 == str3));
		//str2와 str3의 박스에 담긴 주소값이 다르기 때문에 false 출력
		//str2와 str3에 담긴 문자열은 일치하나 실제 담겨있는 주소값은 다름!!
		
		//3. 문자열.equals(Object obj) : boolean
		//   문자열과 전달된 또다른 문자열을 가지고 주소값 비교가 아닌 실제 문자열값을 가지고 동등비교 해줌
		System.out.println("str2와 str3가 일치합니까(equals) : " + str2.equals(str3));
		
		//4. 문자열.contains(CharSequence s) : boolean
		//   String이 CharSequence를 상속받고 있음
		
		
		//5. 문자열.length() : int
		//   문자열의 길이 반환
		System.out.println("str1의 길이 : " + str1.length());
		
		//6. 문자열.substring(int beginIndex) : String
		//   => 문자열의 beginIndex 위치에서부터 끝까지의 문자열을 추출해서 리턴
		System.out.println(str1.substring(6));
		//   문자열.substring(int beginIndex, int endIndex) : String
		//   => 문자열의 beginIndex 위치에서부터  endIndex -1 까지의 문자열을 추출해서 리턴 
		System.out.println(str1.substring(0,4)); // begin <=   < end
		
		//7. 문자열.replace(char oldChar, char newChar) : String
		//   해당 문자열에서 oldChar에 해당하는 문자들을 newChar로 변환한 '새 문자열' 리턴
		String str4 = str1.replace('l', 'c');
		System.out.println("str1에서 l을 c로 바꾼 문자열 리턴 : " + str4);
		System.out.println("str1이 변경됐나? : " + str1);
		
		//8. 문자열.toUpperCase() : String
		//   해당 문자열을 다 대문자로 변경한 새 문자열 리턴
		String str5 = str1.toUpperCase();
		System.out.println("str5 : " + str5);
		//   문자열.toLoserCase() : String
		//   해당 문자열을 다 소문자로 변경한 새 문자열 리턴
		System.out.println(str1.toLowerCase());
		
		/*
		 * System.out.print("계속하시겠습니까?(y/n) : ");
		 * char ch = sc.nextLine().toUpperCase().charAt(0);    => toUpperCase는 문자열 메소드기 때문에 sc.nextLine.CharAt().toUpperCast는 불가
         *                 //메소드 연이어 호출 == 메소드 체이닝
		 * => 사용자가 소문자를 입력해도 대문자로 변환한 후 ch에 담기게 됨
		 * 
		 * if(ch == 'N'){
		 *    //프로그램 종료
		 * }
		 * 
		 * 
		 */
		
		
		//9. 문자열.trim() : String
		//   문자열 앞뒤에 공백을 제거하는 메소드
		String str6 = "    JA   VA     ";
		System.out.println("str6 : " + str6.trim());
		
		//10. 문자열.toCharArray() : char[]
		//    문자열에 있는 각각의 문자들을 char 배열에 옮겨담는 메소드
		char[] arr = str1.toCharArray();
		System.out.println(arr[0]);
		
		//11. static valueOf(char[] data) : String
		//    char[] 배열에 흩어져 있는 문자들을 문자열로 합쳐주는 메소드
		System.out.println(String.valueOf(arr));
		//static메소드기 떄문에 '클래스명.'으로 호출해야햔다!!
	}
	
	
	
	
	
	
	
	
	
	
	
}
