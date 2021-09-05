package com.kh.chap02_objectArray.run;

import java.util.Scanner;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ObjectArrayRun {

	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		//for loop문
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		Phone[] phones = new Phone[3];
		/*
		System.out.println(phones);   
		System.out.println(phones[0]);  //null
		phones[0].setName("아이폰");      //NullPointerException   
		*/
		
		phones[0] = new Phone();
		phones[1] = new Phone("아이뽄", "사과", 1300000, "11pro");
		phones[2] = new Phone("은하수", "샘송", 1200000, "s20");
		
		//나중에 phones[0]에 값을 담고싶다면?
		phones[0].setName("벨벳폰");
		phones[0].setBrand("헬지");
		phones[0].setPrice(1000000);
		phones[0].setSeries("1");
		
		int total = 0;
		for(int i=0;i<phones.length;i++) {
			System.out.println(phones[i].information());
			total += phones[i].getPrice();
		}
		
		System.out.println("총 가격 : " + total + "원");
		System.out.println("평균가 : " + total / phones.length + "원");
		
		
		
		// 사용자에게 구매하고자하는 핸드폰명을 입력받아 해당 핸드폰을 찾은 후에 그 가격을 알려주도록
		Scanner sc = new Scanner(System.in);
		System.out.print("구매하고자 하는 핸드폰 입력 : ");
		String buy = sc.nextLine();
		
		for(int i=0;i<phones.length;i++) {
			if(phones[i].getName().equals(buy)) {
				System.out.println("당신이 구매하고자 하는 핸드폰의 가격 " + phones[i].getPrice() + "원 입니다.");
			}
		}
		
		
		
	}

}
