package com.kh.operator;
import java.util.Scanner;

public class G_Triple {
	
	/*
	 * * ���� ������ (�׸� 3���� ������ �������ִ� ������)
	 * 
	 *  [ǥ����]
	 *  ���ǽ� ? ���ǽ��� ���� ��� ������ ����� : ���ǽ��� ������ ��� ������ �����
	 *  
	 *  �̶�, ���ǽ��� �ݵ�� true �Ǵ� false�� �������� �ۼ��ؾߵ�!
	 *  �ַ� ��, �������ڸ� ���� �ۼ��ϰԵȴ�. 
	 */
	
	public void method1() {
		//�Է¹��� �������� ������� �ƴ��� �Ǻ��� �� ��� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է� : ");
		int num = sc.nextInt();
		
		
		//1-1
		String result = num > 0 ? "����̴�." : "����� �ƴϴ�.";
		
		//XX�� XXXX.
		System.out.println(num + "�� " + result);
		
		
		//1-2
		System.out.println(num + "�� " + (num <=0 ? "����� �ƴϴ�." : "����̴�."));	
	}
	
	public void method2() {
		//�Է¹��� �������� ¦������ Ȧ������ �Ǻ��� �� ��� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է� : ");
		int num = sc.nextInt();
		
		//String result = num % 2 == 0 ? "¦���̴�." : "Ȧ���̴�."; 
		String result = num % 2 ==1 ? "Ȧ���̴�." : "¦���̴�.";
		
		System.out.println(num + "�� " + result);
			
	}
	
	public void method3() {
		//����ڿ��� �����ǻ翩�� �Է¹��� �� �Ǻ��ؼ� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����Ͻ÷��� y�� �Է����ּ��� : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch == 'y' || ch == 'Y') ? "���α׷��� �����մϴ�." : "��������ϰڽ��ϴ�.";
		    //  �� ����ڰ� �Է��� ���� y�ų� Y�� ���
		System.out.println(result);
	}

	public void method4() {
		//�Է¹��� ���� ���� ���� �ҹ������� �ƴ��� �Ǻ��� �� ��� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է� : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch >= 'a' && ch <= 'z') ? "�ҹ����̴�." : "�ҹ��ڰ��ƴϴ�.";
		System.out.println(result);
	}
	
	//��ø ���׿�����
	public void method5() {
		//����ڰ� �Է��� �������� 
		//�������, ��������, 0������ ��Ȯ�ϰ� �Ǻ��� �� ��� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է� : ");
		int num = sc.nextInt();
		
		//String result = (num > 0 ? "����̴�." : (num < 0 ? "�����̴�." : "0�̴�."));
		String result = (num > 0 ? "����̴�." : (num == 0 ? "0�̴�." : "�����̴�."));
		
		System.out.println(result);
	}
	
	public void method6() {
		// ����ڿ��� �ΰ��� ������ �Է¹ް�
		// + �Ǵ� -�� �Է¹޾Ƽ� �׿� �´� �������� ������ֱ�
		// ��, + �Ǵ� - ���� �ٸ����ڸ� �Է����� ��� "�߸� �Է��߽��ϴ�" ���
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�ι�° ���� : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("������ �Է�(+ �Ǵ� -) : ");
		char op = sc.nextLine().charAt(0);
		
		String result = (op == '+' ? (num1 + num2 + "") : (op == '-' ? (num1 - num2 + "") : "�߸��Է��߽��ϴ�.") );
		System.out.println("��� : " + result);
		
	}
	
}
