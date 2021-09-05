package com.kh.chap02_objectArray.run;

import com.kh.chap02_objectArray.model.vo.Phone;

public class WrongSample {

	public static void main(String[] args) {
		
		Phone[] arr = new Phone[3];
		
		//--- 1번 문제의 조치내용 ---
		arr[0] = new Phone();
		arr[1] = new Phone();
		arr[2] = new Phone();
		//---------------------
		
		//for(int i=0; i<=arr.length; i++) {
		//--- 2번 문제의 조치 내용---
		for(int i=0; i<arr.length; i++) {
		//---------------------
			System.out.println(arr[i].getName());
		}
		
		//발생하는 문제
		//1. NullPointerException
		//i에 각각의 인덱스별로 for문 객체를 생성했었어야하나 현재 객체 배열의 각 인덱스에 담긴 값이 null인 상태에서 해당 메소드를 호출하려고 했기 때문에
		// => 객체 배열을 만든 후 각 인덱스별로 객체 생성을 진행해야됨
		
		//2. ArrayIndexOutOfBoundsException
		// 부적절한 범위를 제시했을 때 발생하는 오류 , 인덱스의 범위를 벗어났을 때 발생하는 오류
		// 조건식으로 'i<=배열의 길이' 라고 제시되어있었기 때문에 배열의 마지막 인덱스보다 큰 값이 제시되었다.
		// 조치 내용 => 조건식 수정 => i < 배열의 길이
		
		
		
		
	}

}
