package com.kh.array;

public class A_Array {
	
	//���� : �ϳ��� ������ �ϳ��� ���� ���� �� ����
	//�迭 : �ϳ��� ������ �������� ���� ���� �� �ִ� ����
	//     "���� �ڷ����� ��"���θ� ���� �� ����
	//     ��Ȯ�� ������ڸ� �迭�� �� �ε��� �ڸ��� ���� ���� ���(�ε����� 0���� ����!!)
	
	public void method1() {
		// * �迭�� �� ������
		
		// ������� �͸��� �̿��ϰ� �Ǹ� => �뷮�� �����͵��� �����ϰ��� �� �� ������ ������ ���� ���� ����
		/*
		int num1 = 0;
		int num2 = 1;
		int num3 = 2;
		int num4 = 3;
		int num5 = 4;
		*/
		
		//����ϰ��� �Ҷ��� => ������ ����ؾߵ� (�ݺ��� Ȱ�� �Ұ�)
		/*
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		*/
		
		
		// �� �հ踦 ���� ����
		// int sum = num1 + num2 + num3 + num4 + num5;
		
	
		
		/*
		 * 1. �迭 ���� (�������� ������ ������ �迭�� ����ڴ�!)
		 *    �ڷ��� �迭��[];
		 *    �ڷ���[] �迭��;
		 */
		//int a; //���� ����
		
		//int arr[];
		//int[] arr;
		
		/*
		 * 2. �迭 �Ҵ� (�� �迭�� ��� ������ �����Ҳ��� ũ�������ϴ� ����, �� ������ŭ�� ���� �������)
		 *    �迭�� = new �ڷ���[�迭ũ��];
		 */
		
		//arr = new int[5];
		
		// **** �迭 ����� ���ÿ� �Ҵ�(�迭 ����� ���ÿ� ũ�� ����)
		
		int[] arr = new int[5];
		
		/*
		 * 3. �� ���� 
		 *    �迭��[�ε���] = ��;
		 */
		/*
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 4;
		*/
		
		// �迭�� ���� : �ݺ��� Ȱ�� ����!!
		for(int i=0; i<5; i++) {
			arr[i] = i;
		}
		/*
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		*/
		
		for(int i=0;i<5;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(arr); // ���� arr�̶�� �ڽ����� "�ּҰ�"�̶�°� ������� => �̻��� ���� ���
		
	}
	
	
	public void method2() {
		
		int i = 10;
		
		int[] iArr = new int[5]; // new �� ����ؼ� ������ �κ��� �׻� Heap������ ����ȴ�.
		// �� stack������ ����
		
		System.out.println(iArr);
		
		
		
		
		
		
		
		
	}
}
