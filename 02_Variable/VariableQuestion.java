package com.kh.variable;

public class VariableQuestion {
	public static void main (String[] args) {
		
		//�ǽ�����1
		
		System.out.println("===�ǽ�����1===");
		
		String name = "ȫ�浿";
		String gender = "��";
		int age = 20;
		int height = 165;
		
		System.out.println("�̸��� �Է��ϼ��� : " + name );
		System.out.println("������ �Է��ϼ���(��/��) : " + gender);
		System.out.println("���̸� �Է��ϼ��� : " + age);
		System.out.println("Ű�� �Է��ϼ���(cm) : " + height);
		System.out.println("Ű" + height + "cm�� " + age + "�� " + gender + "��" + name + "�� �ݰ����ϴ�^^\n");
		
		//�ǽ�����2
		
		System.out.println("===�ǽ�����2===");
		
		int a = 17;
		int b = 3;
		
		System.out.println("ù ��° ���� : " + a);
		System.out.println("�� ��° ���� : " + b);
		System.out.println("���ϱ� ��� : " + (a+b) );
		System.out.println("���� ��� : " + (a-b) );
		System.out.println("���ϱ� ��� : " + (a*b) );
		System.out.println("������ ��� : " + (a/b) + "\n" );
		
		//�ǽ�����3
		
		System.out.println("===�ǽ�����3===");
		
		double wi = 21.2;
		double he = 7.3;
		
		System.out.println("���� : " + wi);
		System.out.println("���� : " + he);
		System.out.println("���� : " + (wi * he) );
		System.out.println("�ѷ� : " + (wi + he)*2 + "\n" );
		
		//�ǽ�����4
		
		System.out.println("===�ǽ�����4===");
		
		String word = "travel";
		
		System.out.println("���ڿ��� �Է��ϼ��� : " + word);
		System.out.println("ù ��° ���� : " + word.substring(0,1) );
		System.out.println("�� ��° ���� : " +  word.substring(1,2) );
		System.out.println("�� ��° ���� : " +  word.substring(2,3) );
	}

}
