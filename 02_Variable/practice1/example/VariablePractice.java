package com.kh.practice1.example;

import java.util.Scanner;

public class VariablePractice {
	
	//�ǽ�����1
	public void method1() {
		System.out.println("===�ǽ�����1===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("������ �Է��ϼ���(��/��) : ");
		char gender = sc.nextLine().charAt(0);
				
		System.out.print("Ű�� �Է��ϼ���(cm) : ");
		double height = sc.nextDouble();
		
		//Ű xxx.x�� xx�� x�� xxx�� �ݰ����ϴ�^^
		System.out.println("Ű " + height + "�� " + age + "�� " + gender + "�� " + name + "�� �ݰ����ϴ�^^");
	}
	
	//�ǽ�����2
	public void method2() {
		System.out.println("===�ǽ�����2===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ������ �Է��ϼ��� : ");
		int a = sc.nextInt();
		
		System.out.print("�� ��° ������ �Է��ϼ��� : ");
		int b = sc.nextInt();
		
		System.out.println("���ϱ� ��� : " + (a+b) );
		System.out.println("���� ��� : " + (a-b) );
		System.out.println("���ϱ� ��� : " + (a*b) );
		System.out.println("������ �� ��� : " + (a/b) );
	}
	
	//�ǽ�����3
	public void method3() {
		System.out.println("===�ǽ�����3===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		double dNum1 = sc.nextDouble();
		
		System.out.print("���� : ");
		double dNum2 = sc.nextDouble();
		
		System.out.println("���� : " + (dNum1 * dNum2) );
		System.out.println("�ѷ� : " + ((dNum1+dNum2)*2) );
	}
	
	//�ǽ�����4
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		
		String str = sc.nextLine();
		
		System.out.println("ù ��° ���� : " + str.charAt(0));
		System.out.println("�� ��° ���� : " + str.charAt(1));
		System.out.println("�� ��° ���� : " + str.charAt(2));
	}
}
