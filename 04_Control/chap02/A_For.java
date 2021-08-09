package com.kh.chap02.loop;

import java.util.Scanner;

public class A_For {
	/*
	 * <반복문>
	 * 프로그램 흐름을 제어하는 제어문 중 하나
	 * 어떤 실행코드를 반복적으로 수행시켜줌
	 * 
	 * 크게 두 종류로 나뉨 (for문, while문(do-while문) )
	 * 
	 * 
	 * * for문
	 * 
	 *  for(초기식; 조건식; 증감식) { //반복 횟수를 지정하기 위해 제시하는 것들
	 *      반복적으로 실행시키고자하는 구문;
	 *  }
	 *  
	 *   - 초기식 : 반복문이 수행될 때 "처음에 단 한번만 실행되는 구문"
	 *           (보통 반복문 안에서 사용될 변수를 선언 및 초기화하는 구문)
	 *           
	 *   - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
	 *            조건식이 true일 경우 해당 구문을 실행
	 *            조건식이 false가 되는 순간 순간 반복을 멈추고 빠져나옴
	 *            (보통 초기식에 제시된 변수를 가지고 조건식을 작성함)
	 *   
	 *   - 증감식 : 반복문을 제어하는 변수 값을 증감시키는 구문
	 *            (보통 초기식에 제시된 변수를 가지고 증감연산자 (++, --)를 사용함)
	 *            
	 *   * for문을 만나는 순간
	 *   초기식 --> 조건식 검사 --> true일 경우 실행구문 실행 --> 증감식
	 *       --> 조건식 검사 --> true일 경우 실행구문 실행 --> 증감식
	 *       -------- 이 내용이 계속 반복 --------
	 *       --> 조건식 검사 --> false일 경우 실행구문 실행x ==> 반복문 빠져나옴
	 *       
	 *       
	 * * 알아둘 것
	 *   for문 안에 초기식, 조건식, 증감식 각각 생략 가능하긴 함 (단, ;은 반드시 필수)
	 */
	
	public void method1() {
		
		// "안녕하세요"를 5번 반복해서 출력하기
		for(int i=1; i<=5 ;i++) { // i값이 1에서부터 5까지 매번 1씩 증가하는동안 반복 수행 (1, 2, 3, 4, 5 => 5회)
			System.out.println("안녕하세요");
		}
		
		for(int i=0; i<=4 ; i++) { // 0, 1, 2, 3, 4
			System.out.println("반갑습니다.");
		}
		
		for(int i=11; i<=15; i++) { // i값이 11에서부터 15까지 매번 1씩 증가하는동안 반복 수행(11, 12, 13, 14, 15 => 5회) 
			System.out.println("저리가세요");
		}
		
		for(int i=1; i<=9 ;i+=2) { // i값이 1에서부터 9까지 매번 2씩 증가하는동안 반복 수행(1, 3, 5, 7, 9 => 5회)
			System.out.println("Hello");
		}
		
	}	
	
	public void method2() {
		// 1부터 5까지 출력
		
		/*
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		*/
		
		/*
		for(int i=1; i<=5 ; i++) {
			System.out.println(i);
		}
		//1
		//2
		//3
		//4
		//5
		*/
		
		// 1 2 3 4 5
		for(int i=1; i<6; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		
		
	}
	
	public void method3() {
		// 5 4 3 2 1
		for(int i=5;i>=1; i--) { // i값이 5에서부터 1까지 1씩 감소하는동안 반복 수행(5,4,3,2,1 => 5회)
			System.out.print(i + " ");
		}
		
	}
	
	public void method4() {
		// 1부터 10사이의 홀수만을 출력
		// 1 3 5 7 9
		
		//1-1
		
		/*
		 for(int i=1;i<=9;i+=2) { // i값이 1에서부터 10까지 매번 2씩 증가되는동안 반복 (1, 3, 5, 7, 9 => 5회)
		 
			System.out.print(i + " ");
		}
		*/
		
		//1-2
		for(int i=1; i<=10; i++) { // i값이 1에서부터 10까지 매번 1씩 증가되는 동안 반복(10회)
			if(i % 2 == 1) {
			System.out.print(i + " ");
			}
		}
		
	}
	
	public void method5() {
		//1 2 3 4 5 ... 10
		for(int i=0; i<=10 ;i++) { // i값이 0에서부터 9까지 매번 1씩 증가되는 반복
			if(i>=1) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	public void method6() {
		// 1에서부터 10까지의 총 합계
		
		// 방법1. int sum = 1+2+3+4....+8+9+10;
		
		// 방법2
		/* int sum = 0;
		 * sum += 1;
		 * sum += 2;
		 * sum += 3;
		 * sum += 4;
		 * ....
		 * sum += 9;
		 * sum += 10;
		 * 
		 * 규칙을 찾자!! sum변수에 누적해서 합산하는거 반복적으로 진행됨
		 * 단, 누적해서 더하고자하는 값이 1에서부터 10까지 1씩 증가되는걸 파악할 수 있음!
		 */
		
		
		int sum=0;
		
		for(int i=0;i<=10;i++) {
			sum+=i;
		}
		System.out.println("1에서부터 10까지의 총 합계 : " + sum);
	}
	
	public void method7() {
		//1에서부터 사용자가 입력한 수까지의 총 합계
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		/* int sum = 0;
		 * 
		 * sum +=1;
		 * sum +=2;
		 * ...
		 * sum += num;
		 * 
		 * 누적해서 더해주고자하는 값이 1에서부터 num까지 1씩 증가
		 */
		
		int sum = 0;
		
		for(int i=1;i<=num;i++) { // i값이 1에서부터 num까지 매번 1씩 증가되는동안 반복 수행
			sum+=i;
		}
		System.out.println("1에서부터 " + num + "까지의 총 합계 : " + sum);
	}
	
	public void method8() {
		// 1에서부터 어떤 랜덤값(1~10사이의 랜덤값)까지의 총 합계
		
		/*
		 * java.lang.Math 클래스에서 재공하는 random() 메소드 호출해서 매번 다른 랜덤값을 얻어낼 수 있음!!
		 * 
		 * Math.random() 호출 시  ==> 0.0 ~ 0.9999999사이의 랜덤값 발생
		 *                         (0.0 <=   < 1.0)
		 */
		
		//int random = Math.random(); //double형이라서 안됨
		//              0.0 <=  <1.0  => 0.0 ~ 0.999999999
		
		//int random = Math.random() * 10;
		//               0.0 <=  <10.0  => 0.0 ~ 9.99999999
		
		//int random = Math.random() * 10 + 1;
        //               1.0 <=  <11.0  => 1.0 ~ 10.99999999
		
		int random = (int)(Math.random() * 10 + 1);
		//               1<=     <11    => 1~10
		
		System.out.println("1~10사이의 랜덤값  : " + random);
		
		int sum = 0;
		for(int i=1; i<=random ;i++) {
			sum+=random;
		}
		System.out.println("1에서부터 " + random + "값까지의 합 : " + sum);
	}
	
	public void method9() {
		
		String str = "Hello";
		
		// 각 인덱스별 문자 뽑아서 출력
		/*
		 * H => str.charAt(0) 출력
		 * e => str.charAt(1) 출력
		 * l => str.charAt(2) 출력
		 * l => str.charAt(3) 출력
		 * 0 => str.charAt(4) 출력
		 * 
		 * 0번 인덱스에서부터 4번 인덱스(마지막 인덱스)까지 매번 1씩 증가하면서 반복 수행
		 */
		for(int i=0; i<5 ;i++) {
			System.out.println(str.charAt(i));
		}
		
	}
	
	public void method10() {
		//사용자한테 문자열 입력받아서 (str변수에 대입)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		// 각 인덱스별 문자를 뽑아서 출력
		// apple 입력 : 5글자
		// 01234
		
		// strawberry 입력 : 10글자
		// 0123456789 
		
		// kiwi 입력 : 4글자
 		// 0123
		
		// 아! 마지막 인덱스는 항상 문자열의 길이-1 이구나!!
		// 추출하고자 하는 인덱스값이 0 ~ (문자열의 길이-1) 까지 매번 1씩 증가
		
		System.out.println("문자열의 길이 : " + str.length());
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}
	
	public void method11() {
		//2단 출력하기
		/*
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * 2 x 3 = 6
		 * ...
		 * 2 x 8 = 16
		 * 2 x 9 = 18
		 */
		
		for(int i=1; i<10 ;i++) {
			//방법 1. 
			//System.out.println("2 x " + i + " = " + (2*i));
			//방법 2
			System.out.printf("%d x %d = %d\n",2 ,i ,(2*i) );
		}
	}
	
	public void method12() {
		//사용자가 입력한 단수 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 수 (2~9)를 입력 : ");
		int dan = sc.nextInt();
		
		//사용자가 입력한 dan 값이 정말 2~9사이 값인지 확인
		if(dan>=2 && dan<=9) { // 잘 입력했을 경우 => 해당 단 출력해주기
			for(int i=1; i<=9; i++) {
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
			}
		}else { // 잘못 입력했을 경우 => "잘못입력했음"출력
			System.out.println("2~9사이의  숫자를 입력해야합니다. 잘못입력하셨습니다.");
		}
	}
	
}
