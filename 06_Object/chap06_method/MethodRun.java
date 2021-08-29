package com.kh.chap06_method.run;
import java.util.Scanner;

import com.kh.chap06_method.controller.NonStaticMethod;
import com.kh.chap06_method.controller.OverloadingTest;
import com.kh.chap06_method.controller.StaticMethod;

public class MethodRun {

	public static void main(String[] args) {
		
		//---------NonStaticMetod-----------
		NonStaticMethod test = new NonStaticMethod();
		
		// 1. �Ű����� ���� ��ȯ�� ���� �޼ҵ� ȣ��
		test.method1();
		
		//2. �Ű����� ���� ��ȯ�� �ִ� �޼ҵ� ȣ��
		//test.method2();
		/*
		String str = test.method2();
		System.out.println(str);
		=> �� �� ���� ����� �� Ȱ���� �����̸� �� ������� �ϴ°��� �´�.
		*/
		
		System.out.println(test.method2());
		// �� ��� �� ������ Ȱ�� ���� ��¸� �� ��� ���� ���� ���ٷ� ȣ�⵵ �����ϴ�!
		
		//3. �Ű����� �ְ� ��ȯ���� ����  �޼ҵ� ȣ��
		test.method3(10, 0);
		//int a = test.method3(10, 20);
		//��ȯ���� ���� �޼ҵ��̱� ������ ���� ���� ������� ������ �����ϴ� ���� �Ұ����ϴ�.
		
		//4. �Ű������� �ְ� ��ȯ���� �ִ� �޼ҵ� ȣ��
		char ch = test.method4("pineapple", 3);
		System.out.println(ch);
		//System.out.println(test.method4("pineapple", 3));
		// �� ��� �� ������ Ȱ�� ���� ��¸� �� ��� ���� ���� �� �ٷ� ȣ�� ����!
		
		//����1.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		System.out.println("��� : " + test.method5(str, num));
		
		System.out.println();
		System.out.println();
		System.out.println("===StaticMethod===");
		//------------StaticMethod--------------
		StaticMethod test2 = new StaticMethod();
		
		//1.
		StaticMethod.method1();
		
		//2.
		System.out.println(StaticMethod.method2());
		
		//3. 
		StaticMethod.method3("ȫ�浿");
		
		//4. 
		System.out.println(StaticMethod.method4("apple", "apple"));
		
		System.out.println();
		System.out.println();
		System.out.println("===OverloadingTEST===");
		//------------OverloadingTest--------------
		OverloadingTest ot = new OverloadingTest();
		ot.test();
		ot.test(20);
		ot.test(10, "������");
		ot.test("������", 20);
		ot.test(10,20);
		
		//�����ε��� ��ǥ���� �� => ��¹� print()
		System.out.print(10);
		System.out.print("����");
		System.out.print(0.0);
		//System.out.println
	}

}
