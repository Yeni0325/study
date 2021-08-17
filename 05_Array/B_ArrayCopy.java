package com.kh.array;

import java.util.Arrays;
//import java.lang.*;       =>       �˰Ը𸣰� ���ԵǾ�����

public class B_ArrayCopy {
	
	//�迭 ����
	public void method1() {
		
		int[] origin = {1, 2, 3, 4, 5};
		
		System.out.println("=== ���� �迭 ��� ===");
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.println();
		
		//�ܼ��ϰ� origin�� �ٽ� ���Խ�Ų copy �迭 ����
		int[] copy = origin;
		System.out.println("=== ���纻 �迭 ��� ===");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println();
		
		copy[2] = 99;
		System.out.println("----------- ���纻 �迭 �� ���� �� -------------");
		System.out.println("=== ���� �迭 ��� ===");
		for(int i=0;i<origin.length;i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println("\n=== ���纻 �迭 ��� ===");
		for(int i=0;i<copy.length;i++) {
			System.out.print(copy[i] + " ");
		}
		
		//copy���� ������ ������ �ص� �������� ����Ǿ�����
		//��? origin�� copy�� ���� ���� �����ϰ� �ֱ� ����(��, ���� �ּҰ�)
		System.out.println("\norigin�ּҰ� : " + origin.hashCode());
		System.out.println("copy�ּҰ� : " + copy.hashCode());
		
		// => ���� ���� : �ּҰ��� ����
		
	}
	
	//���� ������ ������ �ذ��ϱ� ���ؼ� ��������
	
	public void method2() {
		
		//���1.for���� Ȱ���� ���
		//  ���ο� �迭�� �ƽθ� ������ �� �ݺ����� Ȱ���ؼ� �����迭�� ������ ������ ���� �迭�� ����
		int[] origin = {1, 2, 3, 4, 5};
		
		//int[] copy = origin; // �������� : �ּҰ� ����
		int[] copy = new int[5];
		/*
		 * copy[0] = origin[0];
		 * copy[1] = origin[1];
		 * ...
		 * copy[4] = origin[4];
		 */
		
		for(int i=0; i<copy.length ; i++) {
			copy[i] = origin[i];
			
		}
		
		copy[2] = 99;
		System.out.println("--- copy ���� �� ---");
		System.out.println("=== ���� �迭 ��� ===");
		for(int i=0; i<origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println("\n=== ���纻 �迭 ��� ===");
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
	
		System.out.println("\norigin�ּҰ� : " + origin.hashCode());
		System.out.println("copy�ּҰ� : " + copy.hashCode());
		
		
		
	}
	
	public void method3() {
		
		//���2. ���ο� �迭 ���� �� System Ŭ���������� arraycopy() �޼ҵ带 �̿��� ����
		
		int[] origin = {1, 2, 3, 4, 5}; //�����迭
		int[] copy = new int[10]; //���纻�迭 (�˳��ϰ� ũ�� ���� )  // 0~9�ε������� 0�� ����ִ� ����!
		
		// System.arraycopy(�����迭��, ��������� �����迭�� �ε���, ���纻�迭��, ���纻�迭�� ����� �����ε���, ������ ����);
		/*
		 * 1. � �迭�� �����Ұ���(�����迭��) ����
		 * 2. ���� ������ ���� �迭�� �ε��� ����
		 * 3. ���纻�迭�� ����
		 * 4. ��� �ε������� �����ε����� �����Ұ��� ����
		 * 5. �����ε������� ��� �����Ұ��� ���� ����
		 */
		
		System.arraycopy(origin, 1, copy, 3, 3);
		
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\norigin�ּҰ� : " + origin.hashCode());
		System.out.println("copy�ּҰ� : " + origin.hashCode());
		//�ּҰ��� �ٸ�(���� ����)
		// => ���� �ٸ� �迭�� �����ϰ� ����
		// => ��, �迭 ������ ���ο��� ������ ���� ����
	}
	
	public void method4() {
		//���3. Arrays Ŭ�������� �����ϴ� copyOf() �޼ҵ� ���
		//   ���ο� �迭�� �������� �ʾƵ� ���������� �˾Ƽ� �迭�� �������!
		
		int[] origin = {1, 2, 3, 4, 5};
		// ���纻 �迭 = Arrays.copyOf(�����迭��, �����ұ���);
		int[] copy = Arrays.copyOf(origin,10);
		
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		/*
		 * Array.copyOf �޼ҵ�
		 * => ���� ������ ���� ��ŭ ���纻 �迭�� ũ�Ⱑ �Ҵ��� �ȴ�.
		 * => ��, ���� ������ ���̰� �����迭�� ũ�⺸�� Ŭ ���, ������ �迭������ �� ���� �� �� �������� 0���� ä��!!
		 * =>     ���� ������ ���̰� �����迭�� ũ�⺸�� ���� ���, ������ �迭�� �ִ� �� �� ���� ������ ���̸�ŭ ����!
		 */
		
		System.out.println("\norigin �ּҰ� : " + origin.hashCode());
		System.out.println("copy �ּҰ� : " + copy.hashCode());
	}
	
	public void method5() {
		//�����迭�� �Ȱ��� ������ ������ ���
		
		//���4. clone() �޼ҵ� �̿��� ����
		//      �ε��� ���� �Ұ�, ũ�� ���� ������ ����
		int[] origin = {1,2,3,4,5};
		
		//���纻 �迭 = �����迭.clone();
		int[] copy = origin.clone();
		
		for(int i=0; i<copy.length ;i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\norigin �ּҰ� : " + origin.hashCode());
		System.out.println("copy �ּҰ� : " + copy.hashCode());
	}
	
	/*
	 * [����]
	 * java.lang.Math
	 * java.lang.String               => java.lang�� ���־��̴� �޼ҵ�� import�� �� �ʿ䰡 ����
	 * java.lang.System
	 * 
	 * java.util.Scanner
	 * java.util.Arrays               => java.lang �̿��� ��Ű���� �ִ� Ŭ������ �� ���� ������ import�ؾߵ�!!
	 */
	
}
