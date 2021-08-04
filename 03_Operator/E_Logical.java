package com.kh.operator;
import java.util.Scanner;

public class E_Logical {
	
	/*
	 *  * �������� (���׿�����)
	 *    �ΰ��� ������ �������ִ� ������
	 *    �������� ��������� ������!!
	 * 	  
	 *    ���� && ���� : ����, ������ �� �� true�� ��� ������� true 
	 *                  �� �߿� �ϳ��� false�� ��� ������� false
	 *    
	 *    ���� || ���� : ����, ������ �� �ϳ��� true�� ��� ������� true  
	 */

	
	public void method1() {
		
		// ����ڰ� �Է��� '����'���� 1���� 100������ ������ Ȯ��
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ϳ� �Է� : ");
		int num = sc.nextInt();
		
		//boolean result = (1 <= num <= 100);
		
		boolean result = (num >=1) && (num <= 100); // num���� 1�̻��̰� �׸��� num���� 100������ ���
		// && �� �ǹ� : ~�̰�, �׸���, ~�ϸ鼭
		
		System.out.println("����ڰ� �Է��� ���� 1�̻� 100�����Դϱ� : " + result);
		
		// && : �� ���� ������ ��� true���� && ������ ������� ���������� true
		//      �� �߿� �ϳ��� false�� ��� && ������ ������� ���������� false
	}
	
	public void method2() {
		
		// ����ڰ� �Է��� '����'���� ���� �빮������ Ȯ��
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ϳ� �ӷ� : ");
		
		char ch = sc.nextLine().charAt(0);
		
		//boolean result = (65 <= ch <=90);
		
		//ù ��° ���
		//boolean result = (ch >=65) && (ch <=90);
		
		//�� ��° ���
		boolean result = (ch >= 'A') && (ch <= 'Z');
		
		System.out.println("����ڰ� �Է��� ���� �빮���Դϱ� : " + result);
		
	}
	
	public void method3() {
		
		//����ڿ��� ������ �Է¹��� �� �������� Ȯ��
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� (M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		boolean result = (gender == 'F') || (gender == 'f');
		// || �ǹ� : ~�̰ų�, �Ǵ�
		
		System.out.println("����ڰ� �����Դϱ� : " + result);
		// || : �� ���� ���� �� �ϳ��� true�� �ִٸ� || ������ ������� ���������� true
		//      �� ���� ���� ���  false�� ��� || ������ ������� false
	}
	
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����Ͻ÷��� y�� �Է� : ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = (ch == 'y') || (ch == 'Y');
		
		System.out.println("����ڰ� �Է��� ���� y �Ǵ� Y �Դϱ� : " + result);
	}
	
	/*
	 *  && : �ΰ��� ������ ��� true���� ������� true�� (AND == ~�̰�, ~�׸���, ~�̸鼭, �Ӹ��ƴ϶�)
	 * 
	 *  true && true   => true
	 *  true && false  => false
	 *  false && true  => false
	 *  false && false => false
	 *  
	 *  ** && �����ڸ� �������� ���� ����� false�� ��� ���� ������ ���� �������� ����!! **
	 *  
	 *  || : �ΰ��� ������ �ϳ��� true��� ������� true (OR == �Ǵ�, ~�̰ų�)
	 *  
	 *  true || true   => true
	 *  true || false  => true
	 *  false || true  => true
	 *  false || false => false
	 *  
	 *  ** || �����ڸ� �������� ���� ����� true�� ��� ���� ������ ���� �������� ����!! **
	 */
	
	public void method5() {
		int num = 10;
		boolean result1 = (num < 5) && (++num > 0);
		
		System.out.println("result : " + result1);
		System.out.println("&&���� ���� num : " + num);     // ���� ����� false�̱� ������ �� ���� ����� ������� �ʴ´�.
		
		int num2 = 10;
		boolean result2 = (num2 < 20) || (++num2 > 0);
			
		System.out.println("||���� ���� num2 : " + num2);  // ���� ����� true�̱� ������ �� ���� ����� ������� �ʴ´�.
		
		int num3 = 10;
		boolean result3 = true || (++num3 > 0);   //dead code(���� ����� �� ���� �ڵ�)
		
		
		
	}
}
