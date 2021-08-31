package com.kh.chap02_string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizerTest {

	public void method() {
		
		String str = "JAVA,Oracle,JDBC,HTML,CSS,Spring";
		
		//구분자를 기준으로 해서 문자열을 분리시키는 방법
		
		//방법1. 분리된 문자열들을 String[] 배열에 차곡차곡 담고자 할때
		//      String클래스에 제공하는 split 메소드 이용
		//      문자열.split(구분자) : String[]   => 각각 쪼개진 문자열들의 String[]배열로 반환된다
		
		String[] arr = str.split(",");
		//String[]로 반환되기 때문에 동일한 자료형인 String[] arr로 담아줘야한다.
		
		System.out.println("배열의 길이 : " + arr.length);
		
		/*
		for(int i=0; i<arr.length; i++) {
			System.out.println(i + "번째 인덱스 : " + arr[i]);
		}
		*/
		//for-loop문을 쓰게되면 i값을 활용가능하다
		
		//for-each문(향상된 for문) : 배열의 0번 인덱스부터 마지막인덱스까지 순차적으로 접근하고자 할 때 사용!
		for(String s : arr) { // s = arr[0] => s = arr[1] => ...
			System.out.println(s);
		}
		
		//for-each문은 for-loop문과 다르게 인덱스를 활용하는 방법은 다소 불편하다.
		// ↓ 아래와 같은 방법으로 가능하긴함!
		/*
		 * int i = 0;
		 * for(String s : arr) {
		 *  System.out.println(i++ + "번째 인덱스 : " + s);
		 * }
		 */
		
		
		//방법2. 분리된 문자열들을 각각 토큰으로써 관리하고자 할 때
		//      java.util.StringTokenizer 클래스를 이용하는 방법
		//      StringTokenizer stn = new StringTokenizer(분리시키고자하는문자열, 구분자);
		StringTokenizer stn = new StringTokenizer(str, ",");
		
		System.out.println("분리된 문자열의 갯수 : " + stn.countTokens());
		//배열의 경우 각각의 분리된 문자열을 가져오고 싶을 경우 각각의 인덱스에 접근할 수 있었으나, 여기서는 인덱스라는 개념이 존재x
		// 따라서 순차적으로 뽑을수만 있음!
		
		/*
		System.out.println(stn.nextToken());  //=> 첫번째로 메소드 호출 시 첫토근을 가져옴
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		*/
		
		//=> stn이라는 공간으로부터 하나씩 순차적으로 뽑아온다!
		// 배열의 경우 인덱스에서 뽑아올 경우 소멸되지 않고 배열에 계속 존재하지만, nextToken의 경우 '일회성'!!
		
		
		//System.out.println(stn.countTokens());
		// stn공간에서 아예 뽑아서 가져오므로 다 뽑고나서 토근의 갯수를 출력할경우 0이 출력된다.
		//0개 남은 상황에서 nextToken을 실행할경우 'NoSuchElementException'에러 발생 => 더 이상 요소가 없다.
		
		//만약 토근의 개수가 100개라면, 위에 6개의 토근을 뽑아온것처럼 반복하기는 어렵다!
		
		/* 잘못된방법(반복문이 3번만 돈다)
		for(int i=0; i<stn.countTokens(); i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
		//i=0  ,  i < 6 => true 출력 => JAVA
		//i=1  ,  i < 5 => true 출력 => Oracle (JAVA가 뽑혀나왔기 때문에 stn.countTokens는 5가 된다)
		//i=2  ,  i < 4 => true 출력 => JDBC   (Oracle가 뽑혀나왔기 때문에 stn.countTokens는 4가 된다)
		//i=3  ,  i < 3 => false 출력 => 반복문 종료!
		
		//반복문의 갯수가 6으로 고정이었다면 끝까지 뽑아올 수 있지만 stn.countToken의 숫자가 점점 줄어들기 때문에 
		//모든 토큰이 출력되지 않는다.
		
		//해결방법1.(토근의 개수가 100개라면)
		/*
		int count = stn.countTokens(); // count = 6
		
		for(int i=0; i<count; i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
		
		//해결방법2.(토큰의 개수가 100개라면)
		while(stn.hasMoreTokens()/*반복이 수행될 조건*/) { // stn.hasMoreTokens() => 공간에 토큰이 남아있으면 true, 없으면 false출력!
			System.out.println(stn.nextToken());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
