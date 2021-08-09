package com.kh.chap01.condition;
import java.util.Scanner;

public class B_Switch {
	
	/*
	 * * switch���� if���� �����ϰ� ���ǹ���!
	 * 
	 *   �ٸ�, if������ "������"�̶��?
	 *   1. if���� ���ǽ��� �����Ӱ� �������!
	 *      switch���� ����񱳷� �ۿ� ������� ����!
	 *   2. �����ұ����� �����ϰ� �ڵ����� ���������� ����!! (���� break;�� �ۼ��ؾߵ�)
	 *   
	 *   
	 *   
	 *   [ǥ����]
	 *   switch(�������� ������� �����) {
	 *   case ��1 : ��ġ�� ��� �����ڵ�1; break;
	 *   case ��2 : ��ġ�� ��� �����ڵ�2; break;
	 *   ...
	 *   default : ���� ����� ��� ��ġ���� ���� ��� ������ �ڵ�;(if���� else����)
	 *   }
	 */
	
	public void method1() {
		
		/*
		 * ������ �Է¹޾�
		 * 1�� ��� "�������Դϴ�."
		 * 2�� ��� "�Ķ����Դϴ�."
		 * 3�� ��� "�ʷϻ��Դϴ�."
		 * �߸��Է�������� "�߸��Է��ϼ̽��ϴ�."
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		
		//if���ǹ� ���
		
		/*
		if(num == 1) {
		 
			System.out.println("�������Դϴ�.");
		} else if(num == 2) {
			System.out.println("�Ķ����Դϴ�.");
		} else if(num == 3) {
			System.out.println("�ʷϻ��Դϴ�.");
		} else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		*/
		
		//Switch�� ���
		
		switch(num) {
		case 1 : 
			System.out.println("�������Դϴ�."); 
			break;
		case 2 : 
			System.out.println("�Ķ����Դϴ�."); 
			break;
		case 3 : 
			System.out.println("�ʷϻ��Դϴ�."); 
			break;
		default : 
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}	
	}
	
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����ϰ����ϴ� ����(���,�ٳ���,������) �Է� : ");
		String fruit = sc.nextLine();
		
		int price = 0;
		
		switch(fruit) {
		case "���" :                         //��� ��� �Է��� ��� ���� �߻� => fruit ������ ���ڿ��̱� ������ �ڷ����� ��ġ���Ѿ���
			price = 1000;
			break;
		case "�ٳ���" :
			price = 2000;
			break;
		case "������" : 
			price = 3000;
			break;
		default :
			System.out.println("�߸��Է��߽��ϴ�.");
		return;
		}
		
		// xx�� ������ xxxx���Դϴ�.
		System.out.println(fruit + "�� ������ " + price + "���Դϴ�.");
	}
	
	//break���� �Ƚᵵ �Ǵ� ���̽�
	public void method3() {
		
		// ��޺� ����
		// 1 : ��������, �۾������, �б��ȯ
		// 2 : �۾������, �б��ȯ
		// 3 : �б����
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���(����) : ");
		int level = sc.nextInt();
		
		switch(level) {
		case 1 :
			System.out.println("�� �������� �־�");
		case 2 :
			System.out.println("�� �۾������ �־�");
		case 3 :
			System.out.println("�� �б���� �־�");
		}
	}
	
	//break���� �Ƚᵵ �Ǵ� ���̽�2
	public void method4() {
		//���� �Է¹޾� �ش� ���� ������ ��¥ ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�� ~ 12������ �� �ϳ��� �Է�(������) : ");
		int month = sc.nextInt();
		
		//1, 3, 5, 7, 8, 10, 12    => 31��
		//4, 6, 9, 11              => 30��
		//2                        => 28�� �Ǵ� 29��
		
		switch(month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : 
			System.out.println("�Է��Ͻ� ���� 31�ϱ����Դϴ�."); break;
		case 4 :
		case 6 :
		case 9 :
		case 11 : 
			System.out.println("�Է��Ͻ� ���� 30�ϱ����Դϴ�."); break;
		case 2 : 
			System.out.println("�Է��Ͻ� ���� 28�� �Ǵ� 29�ϱ����Դϴ�."); break;
		default : 
			System.out.println("�ݵ�� 1��~12�������� �Է��ؾ� �˴ϴ�.");
		}
		
	}
}
