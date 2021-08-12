package com.kh.chap03.branch;
import java.util.Scanner;

public class A_Break {

	/*
	 * break;   :  �ݺ��� �ȿ� ���Ǵ� �б⹮
	 *             break;�� ����Ǵ� ���� ���� �����ִ� �ݺ����� ������ ��������
	 * 
	 *  * ���ǻ��� : switch�� ���� break; �� ���� switch������ ���������� ����
	 */
	
	public void method1() {
		//������(1~100) ������ �� �߻���Ű��, �� ������ ��� (�� ������ �Ź� �ݺ��Ҳ���)
		//��, �߻��� �������� 3�� ����� ���(3���� �������� �� �������� 0�� ���) �ݺ����� �������ò���
		
		
		while(true) { //���ѹݺ� ��������
		int random =(int)(Math.random() * 100 + 1);
		
		if(random % 3 == 0) {
			break;   // �ݺ����� ������ ���������� �ϴ� ����
		}
		System.out.println("������ : " + random);
		
		}
		
		
	}
	
	//��������!!
	public void method2() {
		//����ڿ��� ���ڿ��� �Է¹޾� �ش� ���ڿ��� ���� ��� (�̰����� �Ź� �ݺ�)
		//�� , ����ڰ� �Է��� ���ڿ��� "exit"�� ��� �ݺ����� ������������
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���ڿ��� �Է����ּ��� : ");
			String str = sc.nextLine();
		
			if(str.equals("exit")) {   //���ڿ��� ���ڿ����� ����񱳴�  equals�� ����ؾ���!! => �ݺ��� ����������
				break;
			}else { //�Է°��� exit�� �ƴҰ�� => ���ڿ� ���� ���
				System.out.println("���ڿ��� ���� : " + str.length());
			}
			
		}
		System.out.println("���α׷��� �����մϴ�.");
		
		
	}
	
	public void method3() {
		//����ڿ��� ��(2~9)�� �Է¹޾� �ش� ���� ���
		//Ȥ�ö� �߸��� ���� �Է����� ��� �ٽ� ���� �Է¹޵��� ����
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("��(2~9)�� �Է����ּ��� : ");
			int dan = sc.nextInt();
			
			if(dan>=2 && dan<=9) { // �� �Է����� ��� => �ش� ���� ��� �� �ݺ����� ��������
				
				for(int i=1;i<=9;i++) {
					System.out.printf("%d x %d = %d\n", dan, i, dan*i);
				}
				break;
			
			} else { // �߸��Է����� ��� => �߸��Է������� �˸��� ���� ���
				System.out.println("�߸��Է��߽��ϴ�. �ٽ� �Է����ּ���.");
			}
			
		}
	}
	
	
	
	
}
