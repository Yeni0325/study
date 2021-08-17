package com.kh.array;

import java.util.Arrays;
//import java.lang.*;       =>       알게모르게 포함되어있음

public class B_ArrayCopy {
	
	//배열 복사
	public void method1() {
		
		int[] origin = {1, 2, 3, 4, 5};
		
		System.out.println("=== 원본 배열 출력 ===");
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.println();
		
		//단순하게 origin을 다시 대입시킨 copy 배열 세팅
		int[] copy = origin;
		System.out.println("=== 복사본 배열 출력 ===");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println();
		
		copy[2] = 99;
		System.out.println("----------- 복사본 배열 값 변경 후 -------------");
		System.out.println("=== 원본 배열 출력 ===");
		for(int i=0;i<origin.length;i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println("\n=== 복사본 배열 출력 ===");
		for(int i=0;i<copy.length;i++) {
			System.out.print(copy[i] + " ");
		}
		
		//copy만을 가지고 수정을 해도 원본까지 변경되어있음
		//왜? origin과 copy가 같은 곳을 참조하고 있기 때문(즉, 같은 주소값)
		System.out.println("\norigin주소값 : " + origin.hashCode());
		System.out.println("copy주소값 : " + copy.hashCode());
		
		// => 얕은 복사 : 주소값을 복사
		
	}
	
	//얕은 복사의 문제를 해결하기 위해서 깊은복사
	
	public void method2() {
		
		//방법1.for문을 활용한 방법
		//  새로운 배열을 아싸리 생성한 후 반복문을 활용해서 원본배열의 값들을 새로이 만든 배열에 대입
		int[] origin = {1, 2, 3, 4, 5};
		
		//int[] copy = origin; // 얕은복사 : 주소값 대입
		int[] copy = new int[5];
		/*
		 * copy[0] = origin[0];
		 * copy[1] = origin[1];
		 * ...
		 * copy[4] = origin[4];
		 */
		
		for(int i=0; i<copy.length ; i++) {
			copy[i] = origin[i];
			
		}
		
		copy[2] = 99;
		System.out.println("--- copy 수정 후 ---");
		System.out.println("=== 원본 배열 출력 ===");
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println("\n=== 복사본 배열 출력 ===");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
	
		System.out.println("\norigin주소값 : " + origin.hashCode());
		System.out.println("copy주소값 : " + copy.hashCode());
		
		
		
	}
	
	public void method3() {
		
		//방법2. 새로운 배열 생성 후 System 클래스에서의 arraycopy() 메소드를 이용한 복사
		
		int[] origin = {1, 2, 3, 4, 5}; //원본배열
		int[] copy = new int[10]; //복사본배열 (넉넉하게 크기 생성 )  // 0~9인덱스까지 0이 담겨있는 상태!
		
		// System.arraycopy(원본배열명, 복사시작할 원본배열의 인덱스, 복사본배열명, 복사본배열의 복사될 시작인덱스, 복사할 갯수);
		/*
		 * 1. 어떤 배열을 복사할건지(원본배열명) 제시
		 * 2. 복사 시작할 원본 배열의 인덱스 제시
		 * 3. 복사본배열명 제시
		 * 4. 몇번 인덱스부터 원본인덱스를 복사할건지 제시
		 * 5. 원본인덱스에서 몇개를 복사할건지 갯수 제시
		 */
		
		System.arraycopy(origin, 1, copy, 3, 3);
		
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\norigin주소값 : " + origin.hashCode());
		System.out.println("copy주소값 : " + origin.hashCode());
		//주소값이 다름(깊은 복사)
		// => 각자 다른 배열을 참조하고 있음
		// => 즉, 배열 수정시 서로에게 영향을 주지 않음
	}
	
	public void method4() {
		//방법3. Arrays 클래스에서 제공하는 copyOf() 메소드 사용
		//   새로운 배열을 생성하지 않아도 내부적으로 알아서 배열을 만들어줌!
		
		int[] origin = {1, 2, 3, 4, 5};
		// 복사본 배열 = Arrays.copyOf(원본배열명, 복사할길이);
		int[] copy = Arrays.copyOf(origin,10);
		
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		/*
		 * Array.copyOf 메소드
		 * => 내가 제시한 길이 만큼 복사본 배열의 크기가 할당이 된다.
		 * => 단, 내가 제시한 길이가 원본배열의 크기보다 클 경우, 기존의 배열값들을 다 복사 한 후 나머지는 0으로 채움!!
		 * =>     내가 제시한 길이가 원본배열의 크기보다 작을 경우, 기존의 배열에 있는 값 중 내가 제시한 길이만큼 복사!
		 */
		
		System.out.println("\norigin 주소값 : " + origin.hashCode());
		System.out.println("copy 주소값 : " + copy.hashCode());
	}
	
	public void method5() {
		//원본배열과 똑같이 복사할 목적인 경우
		
		//방법4. clone() 메소드 이용한 복사
		//      인덱스 지정 불가, 크기 지정 별도로 못함
		int[] origin = {1,2,3,4,5};
		
		//복사본 배열 = 원본배열.clone();
		int[] copy = origin.clone();
		
		for(int i=0; i<copy.length ;i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\norigin 주소값 : " + origin.hashCode());
		System.out.println("copy 주소값 : " + copy.hashCode());
	}
	
	/*
	 * [참고]
	 * java.lang.Math
	 * java.lang.String               => java.lang은 자주쓰이는 메소드로 import를 할 필요가 없음
	 * java.lang.System
	 * 
	 * java.util.Scanner
	 * java.util.Arrays               => java.lang 이외의 패키지에 있는 클래스를 쓸 때는 무조건 import해야됨!!
	 */
	
}
