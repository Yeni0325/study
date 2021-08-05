package com.kh.operator;

public class F_Compound {

	/*
	 * * ���� ���� ������
	 *   ��������ڿ� ���Կ����ڰ� ���յǾ��ִ� ����
	 *   ����ó�� �ӵ��� �������Ƿ� ����ϴ°� ������!!
	 * 	 	
	 *   += -= *= /= %=
	 * 	
	 * 	 a = a + 3;      =>    a += 3;  (3�� a�� ���� �����ϴ� ���� �ƴ�, a�� 3�� ���ϰ� �� ����� a�� ����)
	 * 	 a = a - 3;      =>    a -= 3;  (3���� a�� ���� ����, �� ����� a���� ����)
	 *   a = a * 3;      =>    a *= 3;  (3���� a�� ���� ���ϰ�, �� ����� a���� ����) 
	 *   a = a / 3;      =>    a /= 3;  (3���� a�� ���� ������, �� ����� a���� ����)
	 *   a = a % 3;      =>    a %= 3;  (3���� a�� ���� �������� ���� a���� ����)
	 *   
	 */
	
	public void method1() {
		int num = 12;
		
		System.out.println("���� num : " + num);
		
		num = num + 3; 
		//�������� ������� ������ ȣ���� ���� �׳� ������ ���!
		System.out.println("3 ������Ų num : " + num);
		
		num += 3;  // num = num + 3
		System.out.println("�� 3 ������Ų num : " + num);
		
		num -= 5;  // num = num - 5
		System.out.println("5 ���ҽ�Ų num : " + num);
		
		num *= 6; // num = num * 6
		System.out.println("6�� ������Ų num : " + num);
		
		num /= 2; // num = num / 2
		System.out.println("2�� ���ҽ�Ų num : " + num);
		
		num %= 4; // num = num % 4
		System.out.println("num�� 4�� ������ ���� ������ ���� num : " + num);
		
		
		String str = "Hello";
		//str = str + "World";    //"HelloWorld"   =>  ���ڿ��� + �� �����ϴ�!
		str += "World";           //���� ���մ��Կ����ڵ� ���ڿ��� +�� �����ϴ�!
		System.out.println(str);
	
	}
}
