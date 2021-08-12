package com.kh.chap02.loop;
import java.util.Scanner;

public class C_DoWhile {
	
	/*
	 * * do-while문
	 * 
	 * do {
	 *      반복적으로 실행할 코드
	 * }while(조건식);
	 * 
	 * 처음에 무조건 실행코드 실행
	 * --> 조건식 검사 --> true일 경우 실행코드 실행
	 * --> 조건식 검사 --> true일 경우 실행코드 실행
	 * --> 조건식 검사 --> false일 경우 실행코드 실행x => 반복문 빠져나감
	 * 
	 *  
	 * * 기존의 for/while문과의 차이점
	 *   for/while문 같은 경우 처음 수행될때 조건검사 후에 true일 경우 실행
	 *   근데 do-while문은 첫 실행은 조건검사 없이 무조건 실행함!
	 */
	
	public void method1() {
		int num = 1;
		
		do {
			System.out.println(num);
		} while (num==0);
		//조건이 애초에 맞지 않아도 무조건 한번은 실행함!!
		
	}
	
	public void method2() {
		//1 2 3 4 5
		
		int i =1;
		
		do {
			System.out.print(i++ + " ");
		}while(i<=5);
			
	}
	
	public void method3() {
		// 1부터 사용자가 입력한 수까지의 총 합계
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		int i = 1;
		do {
			sum += i++;
		}while(i<=num);
		
		System.out.println("1부터 " + num + "까지의 총 합계 : " + sum);
	}

}
