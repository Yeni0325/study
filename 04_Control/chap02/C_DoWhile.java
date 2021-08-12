package com.kh.chap02.loop;
import java.util.Scanner;

public class C_DoWhile {
	
	/*
	 * * do-while��
	 * 
	 * do {
	 *      �ݺ������� ������ �ڵ�
	 * }while(���ǽ�);
	 * 
	 * ó���� ������ �����ڵ� ����
	 * --> ���ǽ� �˻� --> true�� ��� �����ڵ� ����
	 * --> ���ǽ� �˻� --> true�� ��� �����ڵ� ����
	 * --> ���ǽ� �˻� --> false�� ��� �����ڵ� ����x => �ݺ��� ��������
	 * 
	 *  
	 * * ������ for/while������ ������
	 *   for/while�� ���� ��� ó�� ����ɶ� ���ǰ˻� �Ŀ� true�� ��� ����
	 *   �ٵ� do-while���� ù ������ ���ǰ˻� ���� ������ ������!
	 */
	
	public void method1() {
		int num = 1;
		
		do {
			System.out.println(num);
		} while (num==0);
		//������ ���ʿ� ���� �ʾƵ� ������ �ѹ��� ������!!
		
	}
	
	public void method2() {
		//1 2 3 4 5
		
		int i =1;
		
		do {
			System.out.print(i++ + " ");
		}while(i<=5);
			
	}
	
	public void method3() {
		// 1���� ����ڰ� �Է��� �������� �� �հ�
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է� : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		int i = 1;
		do {
			sum += i++;
		}while(i<=num);
		
		System.out.println("1���� " + num + "������ �� �հ� : " + sum);
	}

}
