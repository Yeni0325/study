package com.kh.chap02_objectArray.run;

import java.util.Scanner;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ArrayForEach {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30};
		
		//for each문 (향상된 for문 /개선된 for문)
		//여태까지 초기식, 조건식, 증감식을 쓰던 단순한 for문에서 향상된 for문
		//배열 또는 컬렉션과 함께 사용됨
		//언제 쓰면 되나? 배열 또는 컬렉션의 0번 인덱스부터 마지막 인덱스부터 순차적으로 모두 접근할 목적일 때 사용
		/*
		 * for(순차적으로 접근한 값을 담을 변수 선언 : 순차적으로 접근할 배열 혹은 컬렉션) {// 반복 횟수 == 배열 또는 컬렉션의 크기
		 *       ㄴ 순차적으로 접근할 배열의 0번인덱스, 1번인덱스의 값이 변수에 담긴다.
		 * }
		 */
		
		//      int  int[]
		for(int value:arr) { //변수에는 반복문이 돌 때 마다 arr[0]의 값, arr[1]의 값, arr[2]값이 변수에 담기게 된다.
			        // arr의 값에는 10, 20, 30, 즉, 정수값이기 때문에 int 자료형의 변수를 생성해야 한다.
			System.out.println(value);
		}
		
		//0번 인덱스부터 마지막 인덱스까지의 값을 위와 같이 표현할 수 있다. 
		
		Phone[] phones = new Phone[3];
		
		phones[0] = new Phone("갤럭시", "삼성", 1500000, "노트20");
		phones[1] = new Phone("아이폰", "애플", 1300000, "11프로");
		phones[2] = new Phone("벨벳폰", "엘지", 900000, "없음");
		
		phones[2].setSeries("1");
		
		int total=0;
		//phones배열의 자료형은 Phone이기 때문에 Phone자료형인 변수 p를 생성!!
		for(Phone p:phones) {//반복문이 돌때마다 phones의 0번, 1번, 2번 인덱스의 값이 변수에 담긴다.
			System.out.println(p.information());
			//반복문이 돌 때마다 0번 인덱스에 담긴 information
			//            2번 인덱스에 담긴 information이 담기게 된다.
			total += p.getPrice();
			//반복문이 돌 때마다 0,1,2번 인덱스에 담긴 getPice값이 total에 더해지게 된다. 
		}
		//실질적으로 p라는 변수에는 각 객체의 주소값이 담기게 된다. 주소값이 담기게 되면서 phones 배열의 값을 가져오게 될 수 있게된다.
		
		
		System.out.println("총합계  : " + total + "원");
		System.out.println("평균가 : " + total / phones.length + "원");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매하고자 하는 핸드폰 : ");
		String buy = sc.nextLine();
		
		for(Phone p:phones) {
			if(p.getName().equals(buy)) {
				System.out.println("가격 : " + p.getPrice() + "원");
			}
		}
		
		
		
		
	}

}
