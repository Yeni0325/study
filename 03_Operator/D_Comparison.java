package com.kh.operator;
import java.util.Scanner;

public class D_Comparison {
	/*
	 * * �񱳿�����/���迬���� (���׿�����)
	 *   �� ���� ���ϴ� ������
	 *   �񱳿����ڴ� ������ �����ϸ� true(��), �������� ������ false(����)�� ��ȯ
	 *   ��, �񱳿��� ����� ����!!
	 *   
	 *   ��Һ񱳿����� : < > <= >=
	 *   ����񱳿����� : == !=
	 */
	
	public void method1() {
		
		//int a = 10, b = 25;  // �����ϱ� �ϳ� �������� ����!!
		int a = 10;    //���ʻ� ������ ���� �� �����ϴ°��� ����!
		int b = 25;
		
		System.out.println("a == b : " + (a == b) );
		System.out.println("a <=b : " + (a<=b) );
		
		boolean result = (a > b);
		System.out.println("result : " + result);
		
		// ������� + �񱳿��� 
		System.out.println( (a * 2) > (b / 5) );
		
		System.out.println("a�� ¦���ΰ� : " + (a % 2 ==0) );
		System.out.println("a�� Ȧ���ΰ� : " + (a % 2 != 0) );
		System.out.println("a�� Ȧ���ΰ� : " + !(a % 2 == 0) );
		System.out.println("a�� Ȧ���ΰ� : " + (a % 2 == 1) );
		
		// 2�� ������ ���� �������� 0�� ��� == 2�� �����������ٴ� �ǹ� == ¦��
		//           �������� 1�� ��� == 2�� ������������ ���� == Ȧ��
	}
	
	public void methdo2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�ι�° ����  : ");
		int num2 = sc.nextInt();
		
		System.out.println("ù��°�� �ι�°���� Ů�ϱ� : " + (num1 > num2 ) );
		System.out.println("ù��° ������  ¦���Դϱ� : " + (num1 % 2 == 0) );	
		
		// Ư�� ���̽� (���ڿ� ���ڰ��� ��Һ񱳰� ����!!)
		System.out.println(num2 < 'A');
		//'A' ~ 'Z'   65 ~ 90 ������ ���ڷ� ���޾� �����Ǿ� ����
	
	
	}
	
	
}
