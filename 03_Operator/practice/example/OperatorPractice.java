package com.kh.practice.example;
import java.util.Scanner;


public class OperatorPractice {
	
	
	//�ǽ�����1
	public void practice1() {
		
		System.out.println("=== �ǽ�����1 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		System.out.println(num > 0 ? "�����" : "����� �ƴϴ�");
	}
	
	//�ǽ�����2
	public void practice2() {
		
		System.out.println("=== �ǽ�����2 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
			
		System.out.println( (num > 0 ? "�����" : (num == 0 ? "0�̴�" : "������ ") ) ) ;		
	}
	
	//�ǽ�����3
	public void practice3() {
		
		System.out.println("=== �ǽ�����3 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		System.out.println(num % 2 == 0 ? "¦����" : "Ȧ����");
	}
	
	//�ǽ�����4
	public void practice4() {
		
		System.out.println("=== �ǽ�����4 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο� �� : ");
		int people = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("���� ���� : ");
		int candy = sc.nextInt();
		
		System.out.println("1�δ� ���� ���� : " + (candy / people) );
		System.out.println("���� ���� ���� : " + (candy % people) );		
	}
	
	//�ǽ�����5
	public void practice5() {
		
		System.out.println("=== �ǽ�����5 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("�г�(���ڸ�) : ");
		int grade = sc.nextInt();
		
		System.out.print("��(���ڸ�) : ");
		int cla = sc.nextInt();
		
		System.out.print("��ȣ(���ڸ�) : ");
		int number = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("����(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("����(�Ҽ��� �Ʒ� ��° �ڸ�����) : ");
		double test = sc.nextDouble();
				
		String student = (gender == 'M') ? "���л�" : "���л�";
		
		
		//x�г� xx�� x�� xxx x�л��� ������ xx.xx�̴�.
		System.out.printf("%d�г� %d�� %d�� %s %s�� ������ %.2f�̴�.", grade, cla, number, name, student, test);	
	}
	
	//�ǽ�����6
	public void practice6() {
		
		System.out.println("=== �ǽ�����6 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		System.out.println(age <= 13 ? "���" : age <= 19 ? "û�ҳ�" : "����" );
	}
	
	//�ǽ�����7
	public void practice7() {
		
		System.out.println("=== �ǽ�����7 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int a = sc.nextInt();
		
		System.out.print("���� : ");
		int b = sc.nextInt();
		
		System.out.print("���� : ");
		int c = sc.nextInt();
		
		double d = (a + b + c) / 3.0;
		
		System.out.println("�հ� : " + (a + b + c) );
		System.out.println("��� : " + d);
		System.out.println( a>=40 && b>=40 && c>=40 & d>=60? "�հ�" : "���հ�" );
	}
	
	//�ǽ�����8
	public void practice8() {
		
		System.out.println("=== �ǽ�����8 ===");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ֹι�ȣ�� �Է��ϼ���(-����) : ");
		//char ch = sc.nextLine().charAt(7);
		String str = sc.nextLine(); //940325-2341536;
		
		char gender = str.charAt(7);
		
		System.out.println(gender == '1'|| gender == '3' ? "����" : "����");
	}
	
}
