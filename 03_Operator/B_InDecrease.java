package com.kh.operator;

public class B_InDecrease {
	
	/*
	 * * ���������� (���� ������)
	 *  ++ : ������ ��� ���� 1 ���������ִ� ������
	 *       ex) ++����, ����++
	 *           ������������/ �� ���������� 
	 *  
	 *  -- : ������ ��� ���� - ���ҽ����ִ� ������
	 *       ex) --����, ����--
	 *       
	 *       (����������)���� : ��������    => "������" ��ó��
	 *       ����(����������) : ��������   => ��ó�� "������"
	 */
	
	public void method1() {
		
		// ���������׽�Ʈ
		int num1 = 10;
		System.out.println("���� ���� ���� �� num1�� �� : " + num1);  //num1 = 10���
		System.out.println("1ȸ ���� �� ��� : " + ++num1);        //num1 = 11���
		System.out.println("2ȸ ���� �� ��� : " + ++num1);        //num1 = 12���
		System.out.println("3ȸ ���� �� ��� : " + ++num1);        //num1 = 13���  
		System.out.println("���� num1�� �� : " + num1);          // 13�� ���
		
		System.out.println("========================");
		
		// ���������׽�Ʈ
		int num2 = 10;
		System.out.println("���� ���� ���� �� num2�� �� : " + num2);   //num2 = 10���
		System.out.println("1ȸ ���� �� ��� : " + num2++);        // 10��� �� => num2=11�� ����
		System.out.println("2ȸ ���� �� ��� : " + num2++);        // 11��� �� => num2=12�� ����
		System.out.println("3ȸ ���� �� ��� : " + num2++);        // 12��� �� => num2=13�� ���� 
		System.out.println("���� num2�� �� : " + num2);          // 13�� ���
	}
	
	public void method2() {
		int a = 10;
		int b = ++a; // a=11, b=11
		
		System.out.printf("a : %d, b : %d\n", a, b);
		
		int c = 10;
		int d = c++; // d=10, c=11
		
		System.out.printf("c : %d, d : %d\n", c, d);
		
		int num = 20;
		System.out.println("���� num : " + num);      // num = 20
		System.out.println("++num��? : " + ++num);   // num = 21
		System.out.println("num++��? : " +  num++);  // num = 21(22)
		System.out.println("--num��? : " + --num);   // num = 21
		System.out.println("num--��? : " + num--);   // num = 21(20)
		System.out.println("���� num : " + num);      // num = 20
	}
	
	public void method3() {
		int num1 = 20;
		int result1 = ++num1 * 3; // num1 = 21, result1 = 63
		
		System.out.printf("num1 : %d, result1 : %d\n", num1, result1);
		
		int num2 = 20;
		int result2 = num2++ *3; // num2 = 21, result2 = 60
		
		System.out.printf("num2 : %d, result2 : %d\n", num2, result2);
	}
	
	public void method4() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);               //a=10(11)   => 10���
		System.out.println(++a + b++);         //a=12 b=20(21) => 32��� 
		System.out.println(a++ + --b + --c);   //a=12(13) b=20 c=29 => 61
		
		System.out.printf("a : %d, b : %d, c : %d", a, b, c);
		
	}

}
