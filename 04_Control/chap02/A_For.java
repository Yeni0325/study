package com.kh.chap02.loop;

import java.util.Scanner;

public class A_For {
	/*
	 * <�ݺ���>
	 * ���α׷� �帧�� �����ϴ� ��� �� �ϳ�
	 * � �����ڵ带 �ݺ������� ���������
	 * 
	 * ũ�� �� ������ ���� (for��, while��(do-while��) )
	 * 
	 * 
	 * * for��
	 * 
	 *  for(�ʱ��; ���ǽ�; ������) { //�ݺ� Ƚ���� �����ϱ� ���� �����ϴ� �͵�
	 *      �ݺ������� �����Ű�����ϴ� ����;
	 *  }
	 *  
	 *   - �ʱ�� : �ݺ����� ����� �� "ó���� �� �ѹ��� ����Ǵ� ����"
	 *           (���� �ݺ��� �ȿ��� ���� ������ ���� �� �ʱ�ȭ�ϴ� ����)
	 *           
	 *   - ���ǽ� : "�ݺ����� ����� ����"�� �ۼ��ϴ� ����
	 *            ���ǽ��� true�� ��� �ش� ������ ����
	 *            ���ǽ��� false�� �Ǵ� ���� ���� �ݺ��� ���߰� ��������
	 *            (���� �ʱ�Ŀ� ���õ� ������ ������ ���ǽ��� �ۼ���)
	 *   
	 *   - ������ : �ݺ����� �����ϴ� ���� ���� ������Ű�� ����
	 *            (���� �ʱ�Ŀ� ���õ� ������ ������ ���������� (++, --)�� �����)
	 *            
	 *   * for���� ������ ����
	 *   �ʱ�� --> ���ǽ� �˻� --> true�� ��� ���౸�� ���� --> ������
	 *       --> ���ǽ� �˻� --> true�� ��� ���౸�� ���� --> ������
	 *       -------- �� ������ ��� �ݺ� --------
	 *       --> ���ǽ� �˻� --> false�� ��� ���౸�� ����x ==> �ݺ��� ��������
	 *       
	 *       
	 * * �˾Ƶ� ��
	 *   for�� �ȿ� �ʱ��, ���ǽ�, ������ ���� ���� �����ϱ� �� (��, ;�� �ݵ�� �ʼ�)
	 */
	
	public void method1() {
		
		// "�ȳ��ϼ���"�� 5�� �ݺ��ؼ� ����ϱ�
		for(int i=1; i<=5 ;i++) { // i���� 1�������� 5���� �Ź� 1�� �����ϴµ��� �ݺ� ���� (1, 2, 3, 4, 5 => 5ȸ)
			System.out.println("�ȳ��ϼ���");
		}
		
		for(int i=0; i<=4 ; i++) { // 0, 1, 2, 3, 4
			System.out.println("�ݰ����ϴ�.");
		}
		
		for(int i=11; i<=15; i++) { // i���� 11�������� 15���� �Ź� 1�� �����ϴµ��� �ݺ� ����(11, 12, 13, 14, 15 => 5ȸ) 
			System.out.println("����������");
		}
		
		for(int i=1; i<=9 ;i+=2) { // i���� 1�������� 9���� �Ź� 2�� �����ϴµ��� �ݺ� ����(1, 3, 5, 7, 9 => 5ȸ)
			System.out.println("Hello");
		}
		
	}	
	
	public void method2() {
		// 1���� 5���� ���
		
		/*
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		*/
		
		/*
		for(int i=1; i<=5 ; i++) {
			System.out.println(i);
		}
		//1
		//2
		//3
		//4
		//5
		*/
		
		// 1 2 3 4 5
		for(int i=1; i<6; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		
		
	}
	
	public void method3() {
		// 5 4 3 2 1
		for(int i=5;i>=1; i--) { // i���� 5�������� 1���� 1�� �����ϴµ��� �ݺ� ����(5,4,3,2,1 => 5ȸ)
			System.out.print(i + " ");
		}
		
	}
	
	public void method4() {
		// 1���� 10������ Ȧ������ ���
		// 1 3 5 7 9
		
		//1-1
		
		/*
		 for(int i=1;i<=9;i+=2) { // i���� 1�������� 10���� �Ź� 2�� �����Ǵµ��� �ݺ� (1, 3, 5, 7, 9 => 5ȸ)
		 
			System.out.print(i + " ");
		}
		*/
		
		//1-2
		for(int i=1; i<=10; i++) { // i���� 1�������� 10���� �Ź� 1�� �����Ǵ� ���� �ݺ�(10ȸ)
			if(i % 2 == 1) {
			System.out.print(i + " ");
			}
		}
		
	}
	
	public void method5() {
		//1 2 3 4 5 ... 10
		for(int i=0; i<=10 ;i++) { // i���� 0�������� 9���� �Ź� 1�� �����Ǵ� �ݺ�
			if(i>=1) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	public void method6() {
		// 1�������� 10������ �� �հ�
		
		// ���1. int sum = 1+2+3+4....+8+9+10;
		
		// ���2
		/* int sum = 0;
		 * sum += 1;
		 * sum += 2;
		 * sum += 3;
		 * sum += 4;
		 * ....
		 * sum += 9;
		 * sum += 10;
		 * 
		 * ��Ģ�� ã��!! sum������ �����ؼ� �ջ��ϴ°� �ݺ������� �����
		 * ��, �����ؼ� ���ϰ����ϴ� ���� 1�������� 10���� 1�� �����Ǵ°� �ľ��� �� ����!
		 */
		
		
		int sum=0;
		
		for(int i=0;i<=10;i++) {
			sum+=i;
		}
		System.out.println("1�������� 10������ �� �հ� : " + sum);
	}
	
	public void method7() {
		//1�������� ����ڰ� �Է��� �������� �� �հ�
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("1�̻��� ���� : ");
			int num = sc.nextInt();
		
			if(num>=1) { //�� �Է����� ��� => 1�������� ����ڰ� �Է��� �������� ���հ� ��� �� �ݺ��� ����������
				int sum = 0;
				for(int i=1;i<=num;i++) { // i���� 1�������� num���� �Ź� 1�� �����Ǵµ��� �ݺ� ����
					sum+=i;
			}
				
				System.out.println("1�������� " + num + "������ �� �հ� : " + sum);
				break;
			
			}else { // �߸��Է�������� => ���� ���� ��� �� �ٽ� �Է¹��� �� �ְ� ����
				System.out.println("�߸��Է��߽��ϴ�. �ٽ��Է����ּ���");
		}
		/* int sum = 0;
		 * 
		 * sum +=1;
		 * sum +=2;
		 * ...
		 * sum += num;
		 * 
		 * �����ؼ� �����ְ����ϴ� ���� 1�������� num���� 1�� ����
		 */
		
		}
	}
	public void method8() {
		// 1�������� � ������(1~10������ ������)������ �� �հ�
		
		/*
		 * java.lang.Math Ŭ�������� ����ϴ� random() �޼ҵ� ȣ���ؼ� �Ź� �ٸ� �������� �� �� ����!!
		 * 
		 * Math.random() ȣ�� ��  ==> 0.0 ~ 0.9999999������ ������ �߻�
		 *                         (0.0 <=   < 1.0)
		 */
		
		//int random = Math.random(); //double���̶� �ȵ�
		//              0.0 <=  <1.0  => 0.0 ~ 0.999999999
		
		//int random = Math.random() * 10;
		//               0.0 <=  <10.0  => 0.0 ~ 9.99999999
		
		//int random = Math.random() * 10 + 1;
        //               1.0 <=  <11.0  => 1.0 ~ 10.99999999
		
		int random = (int)(Math.random() * 10 + 1);
		//               1<=     <11    => 1~10
		
		System.out.println("1~10������ ������  : " + random);
		
		int sum = 0;
		for(int i=1; i<=random ;i++) {
			sum+=random;
		}
		System.out.println("1�������� " + random + "�������� �� : " + sum);
	}
	
	public void method9() {
		
		String str = "Hello";
		
		// �� �ε����� ���� �̾Ƽ� ���
		/*
		 * H => str.charAt(0) ���
		 * e => str.charAt(1) ���
		 * l => str.charAt(2) ���
		 * l => str.charAt(3) ���
		 * 0 => str.charAt(4) ���
		 * 
		 * 0�� �ε����������� 4�� �ε���(������ �ε���)���� �Ź� 1�� �����ϸ鼭 �ݺ� ����
		 */
		for(int i=0; i<5 ;i++) {
			System.out.println(str.charAt(i));
		}
		
	}
	
	public void method10() {
		//��������� ���ڿ� �Է¹޾Ƽ� (str������ ����)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		
		// �� �ε����� ���ڸ� �̾Ƽ� ���
		// apple �Է� : 5����
		// 01234
		
		// strawberry �Է� : 10����
		// 0123456789 
		
		// kiwi �Է� : 4����
 		// 0123
		
		// ��! ������ �ε����� �׻� ���ڿ��� ����-1 �̱���!!
		// �����ϰ��� �ϴ� �ε������� 0 ~ (���ڿ��� ����-1) ���� �Ź� 1�� ����
		
		System.out.println("���ڿ��� ���� : " + str.length());
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}
	
	public void method11() {
		//2�� ����ϱ�
		/*
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * 2 x 3 = 6
		 * ...
		 * 2 x 8 = 16
		 * 2 x 9 = 18
		 */
		
		for(int i=1; i<10 ;i++) {
			//��� 1. 
			//System.out.println("2 x " + i + " = " + (2*i));
			//��� 2
			System.out.printf("%d x %d = %d\n",2 ,i ,(2*i) );
		}
	}
	
	public void method12() {
		//����ڰ� �Է��� �ܼ� ����ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �� (2~9)�� �Է� : ");
		int dan = sc.nextInt();
		
		//����ڰ� �Է��� dan ���� ���� 2~9���� ������ Ȯ��
		if(dan>=2 && dan<=9) { // �� �Է����� ��� => �ش� �� ������ֱ�
			for(int i=1; i<=9; i++) {
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
			}
		}else { // �߸� �Է����� ��� => "�߸��Է�����"���
			System.out.println("2~9������  ���ڸ� �Է��ؾ��մϴ�. �߸��Է��ϼ̽��ϴ�.");
		}
	}
	
	public void method13() {
		// ������(2���� 9������ ������)���� ������ ����ϱ�
		// ���� + x�� ���� ���۰�, * x�� ��� ���� ���Ұ����� �ش�!
		
		int dan = (int)(Math.random() * 8 + 2);
				 // 0.0 <= <1.0
		         // 0.0 <= <8.0
		         // 2.0 <= <10.0 
		
		System.out.println("===" + dan + "�� ===");
		for(int i=1;i<=9;i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}
		
	}
	
	// ��ø for�� (���ʿ� �ִ� �ݺ����� �ٽ� �ݺ�)
	public void method14() {
				// 1 2 3 4 5
			for(int j=1;j<=3;j++) {	
				for(int i=1;i<=5;i++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
	}
	
	public void method15() {
		// ****
		// ****
		// ****
		// ****
		
		// ���� 1~4���� �ݺ�                          => �ٱ��� for��
		// �� �� ������ �� ���� 1~4���� �ݺ�    => ���� for��
		for(int i=1;i<=4;i++) {
			
			for(int j=1;j<=4;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public void method16() {
		// 1*** => i == j (1�� 1���� ��)
		// *2** => i == j (2�� 2���� ��)
		// **3* => i == j (3�� 3���� ��)
		// ***4 => i == j (4�� 4���� ��)     => ��� ���� ��ġ�� �� ���ڸ� ���! �ƴҰ�� * ���!
		
		for(int i=1;i<=4;i++) {
			
			for(int j=1;j<=4;j++) {
				
				if(i == j) {
				System.out.print(i);
				}else {
				System.out.print("*");
				}
				
			}
			
			System.out.println();
		}
		
	}
	
	public void method17() {
		// 2�ܺ��� 9�ܱ��� ���
		
		//int dan = 2;
		
		for(int dan=2;dan<=9;dan++) {
			
			System.out.println("=== " + dan + "�� ===");
			for(int i=1;i<=9;i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
			}
			System.out.println();
		}
		
	}
	
	public void method18() {
		
		for(;;) { // => �ƹ��͵� �Է����� ���� ��� ���Ѵ�� ���� �Է��Ѵ�. ���ǽ� �ڸ� ���� �� �⺻������ true!
			      
			System.out.println("�ȳ�");
		}
		
	}
			
		
}
