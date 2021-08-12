package com.kh.chap03.branch;

public class B_Continue {
	
	/*
	 * continue;      :      반복문 안에 기술되는 구문
	 *                  continue; 구문 실행 시 그 뒤의 구문들은 실행되지 않고 곧바로 현재 속해있는 반복문 위로 올라감!
	 */
	public void method1() {
		
		//1부터 10까지 홀수 출력
		
		
		//방법1.
		/*
		for(int i=1; i<=10; i++) { // i값이 1에서부터 10까지 매번 1씩 증가하는 동안 반복 (10회 반복)
			
			
			if(i % 2 == 1) { // i값이 홀수일 경우
				System.out.println(i + " ");
			} 
		*/
		
		//방법2.
		for(int i=1; i<=10; i++) {
			
			if(i % 2 == 0) { //i값이 짝수일 경우
				continue; // 반복문 내의 뒤의 구문들은 실행되지 않고 반복문 위로 올라감(증감식)
			}
			System.out.println(i + " ");
		
		}
		
	}
	
	
	public void method2() {
		//1부터 100까지의 총 합계
		//단, 6월 배수값은 빼고 덧셈 연산

		int sum = 0;
		for(int i=1; i<=100; i++) {
	
			if(i % 6 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("결과 : " + sum);
	}
	
	
	
	public void method3() {
		//2~9단까지 출력
		//단,3의 배수단은 빼고 출력
		
		
		//방법1. 중첩 for문 사용
		
		/*
		for(int i=2;i<=9;i++) {
			
			System.out.println("=== " + i + "단 ===");
			for(int j=1;j<=9;j++) {
				
				if(i % 3 == 0) {
					continue;
				}
				System.out.printf("%d x %d = %d\n", i, j, i*j);
			}
			
		}
		*/
		
		//방법2. continue 사용
		for(int i=2;i<=9;i++) {
			if(i %3 == 0) {
				continue;
			}
			System.out.println("=== " + i + "단 ===");
			for(int j=1;j<=9;j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j);
				
			}
			System.out.println();
		}

		
		
		
	}
}
