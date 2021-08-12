package com.kh.chap02.loop;

import java.util.Scanner;

public class B_While {
	
	/*
	 * * while��
	 * 
	 * 
	 * [�ʱ��;]
	 * while(���ǽ�) {
	 * 	         �ݺ������� ������ �ڵ�;
	 * 	    [������;]
	 * }
	 * 
	 * ���ǽ��� true�� ��� �ش� �ڵ� ����
	 * 
	 * ���ǽ� �˻� --> true�� ��� �����ڵ� ����
	 * ���ǽ� �˻� --> true�� ��� �����ڵ� ����
	 * ���ǽ� �˻� --> false�� ��� �����ڵ� ����x => �ݺ��� ��������
	 * 
	 */
	
	public void method1() {
		// �ȳ��ϼ��� 5�� ���
		
		int i=1;
		while(i <= 5) {
			System.out.println("�ȳ��ϼ���");
			i++;
		}
		System.out.println(i); //6

	}
	
	public void method2() {
		// 1 2 3 4 5
		
		int i=1;
		while(i<=5){
			//���1.
			/*
			System.out.print(i + " ");
			i++;
			*/
			
			//���2.
			System.out.print(i++ + " "); // ���� ������ ������ ���� ���ٷ� ���� �� �ִ�.
		}
	}
	
	public void method3() {
		//1�������� 10������ Ȧ������ ���
		// 1 3 5 7 9
		
		//���1.
		/*
		int i=1;
		while(i<10) {
			System.out.print(i + " ");
			i+=2;
		}
		*/
		
		//���2.
		int i=1;
		while(i<10) {
			if(i%2 == 1) {
				System.out.print(i + " ");
			}
				i++;
		}
	}
	
	public void method4() {
		// 1���� ������(1~100) ������ �հ�
		
		int random = (int)(Math.random() * 100 + 1) ;
		
		int sum = 0;
		
		int i = 1;
		while(i<=random) {
			sum += i; 
			i++;         // sum += i++; �� ����!
		}
		System.out.println("1�������� " + random + "������ �� �հ�  : " + sum);
	}
	
	public void method5() {
		// A_For Ŭ������ method10�� while������ �����ؼ� ����
		// ����ڰ� �Է��� ���� ������ �ε��� ������ ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� :");
		String str = sc.nextLine();
		
		int i=0;
		while(i<str.length()) {
			System.out.println(str.charAt(i));
			i++;
		}
		
			
	}
}
