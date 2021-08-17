package com.kh.array;

import java.util.Scanner;

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
		
		double[] dArr = new double[3];
		System.out.println(dArr);
		
		/*
		 * ���� ���ͷ����� ��ٷ� ���� �� �ִ� ������ �Ϲ� ������� �̾߱��ϰ�
		 * �ּҰ��� ��� �ִ� ������ ���� ����(���۷��� ����)��� ǥ��
		 * 
		 * �⺻�ڷ���(boolean, char, byte, short, int, long, float, double)���� ����� ����
		 * => ���� ���ͷ� ���� �ٷ� ��� ���� => �׳� �Ϲ� ����
		 * 
		 * �� �� �ڷ���(int[], double[], char[], short[], ... String, Scanner,...)���� ����� ����
		 * => �ּҰ��� ��� ���� => ���� ����(���۷��� ����)
		 */		
	}
	
	
	public void method3() {
		
		int[] iArr = new int[3]; //0 ~ 2�� �ε���
		double[] dArr = new double[4]; // 0 ~ 3�� �ε���
		// �迭 �����ϰ� ũ������(�Ҵ�)������ �� ����
		
		// �׷� ������ �ε����� �ʱ�ȭ�� �Ǿ�������? �ʱⰪ�� ���������?
		
		// iArr �迭 ���
		for(int i=0; i<=2; i++) {
			System.out.println(iArr[i]);
		}
		
		for(int i=0; i<=3; i++) {
			System.out.println(dArr[i]);
		}
		
		// �� �ε����� �ʱ�ȭ���� �ʾ������� �ұ��ϰ� ������ �������! why? 
		// heap�̶�� ������ ���� ������� ������ �� ����!!
		// => ���� ������ ������� �� JVM�� �⺻�����ζ� �ʱ�ȭ(����)�� ��������!	
	}
	
	public void method4() {
		
		int[] arr = new int[10];
		
		/*
		 * arr[0] = 1;
		 * arr[1] = 2;
		 * arr[2] = 3;
		 * arr[3] = 4;
		 * arr[4] = 5;
		 */
		
		//���Կ�  for��
		for(int i=0; i<arr.length ;i++) {
			arr[i] = i + 1;
		}
		
		//��¹� for��
		for(int i=0; i<arr.length ;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(arr); // �迭���ڷ���+@+�ּҰ���16��������
		System.out.println(arr.hashCode()); // �ּҰ��� 10��������
		System.out.println("�迭�� ���� : " + arr.length); // �迭�� ����
		
	}
	
	public void method5() {
		
		int result = 0;
		
		int[] arr = null;
		// �ּҰ��� ��� ������ �⺻���� null�̴�! ������ ����ó�� 0�� ������ �ʱ�ȭ�� �Ұ�!
		
		/*
		 * int[] arr
		 * System.out.println(arr); => ���� �߰� ũ�⸦ �������� �ʾұ� ������ ������ �߻��Ѵ� => ���� ���������� �����ϴ� ��Ȳ�̰�, 
		                                                                    ���ÿ��������� ���� ����ִ� ���·� ������ �� �ִ�.
		 */
		
		System.out.println(arr);
		//null������ �޼ҵ带 ȣ���Ѵٰų� Ư�� ��򰡿� �����ϰ��� �Ѵٸ� �׻� ������ �߻�!!
		// => NullPointerException!!
		
		//����1.
		//System.out.println(arr.hashCode());
		
		//����2.
		//System.out.println(arr.length);
		
		//����3.
		//System.out.println(arr[0]);	
		
	}
	
	public void method6() {
		
		int[] arr = new int[5];
		
		/*
		 * arr[0] = 2;
		 * arr[1] = 4;
		 * arr[2] = 6;
		 * arr[3] = 8;
		 * arr[4] = 10;
		 */
		
		//���1.
		/*
		for(int i=0; i<arr.length ; i++ ) {
			arr[i] = (i+1)*2;
		}
		
		for(int i=0; i<arr.length ; i++) {
			System.out.println("arr" + "[" + i + "] = " + arr[i]);
		}
		*/
		
		//���2.
		int value = 2;
		for(int i=0; i<arr.length ;i++) {
			arr[i] = value;
			value+=2;
		}
		
		for(int i=0; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("arr�� �ؽ��ڵ尪 : " + arr.hashCode());
		System.out.println("arr�� ���� : " + arr.length);
		
		/*
		ArrayIndexOutOfBoundsException 
		: �迭�� �������� �ε��� ���ý� �߻� (�������� ��� �ε��� ����)
		arr[5] = 12;
		arr[6] = 14;
		*/
		
		// * �迭�� ���� ū ����
		//   �ѹ� ������ �迭�� ũ��� ������ �Ұ�
		//   => �迭�� ũ�⸦ �����ϰ��� �Ѵٸ� �ٽ� �����ߵ�!
		arr = new int[7];  // => �̹� �ִ� �迭�� new int[7]�̶�� �迭�� �����ϴ� �����θ� ����!
		
		System.out.println("���� ���� arr�� �ؽ��ڵ� �� : " + arr.hashCode()); 
		System.out.println("���� ���� arr�� ���� : " + arr.length);
		// �ּҰ��� ���� ��! => ���ο� ���� �����ϰ� �ִٴ� ��!
		
		/*
		 * ������ ������ ������ �迭�� Heap������ �εս� ���ٴϴ� ���� => ��𿡵� �����Ǿ� ���� �ʴ� ���·� �ʿ���� ������! => �����ִ°� ����
		 * => java������ �����ð��� ������ "�������÷���(GC)"�� �˾Ƽ� ������!
		 * => java�� "�ڵ��޸� ����" Ư¡!! => �����ڰ� �ڵ� �ۼ����� �Ű澵 �� ����!
		 */
		
		// �迭�� ������ ������Ű���� �Ѵٸ�? => ������� ������ ��!
		arr = null; // �ƹ��͵� �������� �ʰڴ�!
		
		System.out.println(arr);
		// null.xxx() => NullPointerException �߻�
		
	}
	
	public void method7() {
		//�迭 ����, �Ҵ�, �ʱ�ȭ �� ���ÿ� �ϱ�
		
		//���1.
		int[] arr1 = new int[] {1,2,3,4};
		
		//���2.
		int[] arr2 = {1,2,3,4};
		
		System.out.println(arr1 == arr2); //false
		//������ ������ ����ִ� �ּҰ��� ���ϱ� ������ false�� ����
	}
	
	public void method8() {
		
		//1. ũ�� 10¥�� ���� �迭 ���� �� 
		int[] arr = new int[9];
		
		//2. �ݺ����� Ȱ���ؼ� 0�� �ε������� �������ε������� ���������� �����ϸ鼭 ���� �����ϴ� ���� �ۼ�
		//   �Ź� 1~100���̿� �߻��Ǵ� ������
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100 + 1);
		}
		
		
		//3. �ݺ����� Ȱ���ؼ� �ش� �迭�� 0�� �ε��� ~ ������ �ε������� ����ִ� �� ���
		// arr[x] : xx
	
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		
		
	}
	
	public void method9() {
		
		//1. ����ڿ��� �迭�� ���� �Է¹��� �� 
		//   �ش� �� ũ�⸸ŭ�� ���ڿ� �迭 ����
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�迭�� ���̸� �Է��Ͻÿ� : ");
		int size = sc.nextInt();
		
		String[] arr = new String[size];
		
		sc.nextLine();
		//2. �ݺ����� Ȱ���ؼ� �Ź� ����ڿ��� ���ϸ� �Է¹޾� �� ���� �� �ε��� �ڸ��� ����(0�� ~ �������ε���)
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("�����ϴ� ���ϸ� �Է� : ");
			arr[i] = sc.nextLine();
		}
		
		//3. �ݺ����� Ȱ���ؼ� 0~�������ε������� ��� ���� ���
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void method10() {
		
		//����ڿ��� ���ڿ� �ϳ��� �Է¹��� �� 
		//���ڿ��� ������ �ε����� �ش��ϴ� ���ڸ� �̾� char�迭�� �Ű� ���
		
		//1. ����ڿ��� ���ڿ� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ��� �Է��Ͻÿ� : ");
		String str = sc.nextLine();
		
		System.out.print("ã�����ϴ� ���� : ");
		char ch = sc.nextLine().charAt(0);
		
		//2. char�迭 �����صα� (�̶� �迭�� ũ�� == ���ڿ��� ���̸�ŭ)
		// ���ڿ� ���̸� �˾Ƴ����� ? ���ڿ�.length()
		char[] arr = new char[str.length()];
		
		//3. �ݺ��� Ȱ���ؼ� �ش� ���ڿ����� �� �ε��� �� ���ڸ� �̾� char �迭�� �� �ε����� ����
		/*
		 * arr[0] = str.charAt(0);
		 * arr[1] = str.charAt(1);
		 * arr[2] = str.charAt(2);
		 * ...
		 * arr[������] = str.charAt(������);
		 */
		
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = str.charAt(i);
		}
		
		//4. �ݺ��� Ȱ���ؼ� �ش� �迭�� 0��~������ �ε������� ��� ���� ���
		
		int count = 0; //��ġ�ϴ� ���ڰ� ������ ��� �Ź� 1�� ����
		
		for(int i=0;i<arr.length; i++) {
			System.out.println(arr[i]);
			
			if(ch==arr[i]) {
				count++;
			}
		}
		
		System.out.println("ã���� ���� ���� : " + count);
		
	}
	
	public void method11() {
		
		//1. ����ڿ��� �迭�� ���� �Է¹��� �� �ش� ũ�⸸ŭ�� �����迭 ����
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ���̸� �Է��Ͻÿ� : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
	
		//2. �ݺ�����  Ȱ���ؼ� 0~������ �ε������� �Ź� 1~100������ ������ �߻����� ����
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 100 + 1);
		}
		
		//3. �ݺ��� Ȱ���ؼ� 0~������ �ε������� ��� ���� ��°� ���ÿ�
		//   �ش� �ε����� ��� ���� ¦���� ������ �� �� ���ϱ�
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			
			if(i % 2 == 0) {
				sum += arr[i];

			}
		}
		
		
		
		//4. ������ ������ ¦������ ���� ���
		
		System.out.println("¦������ �� �� : " + sum);
	}
	
	public void remind() {
	//����
		
		
		/*�������� ������ ���α׷��� ���� ���
		int age1 =  15;
		int age2 = 23;
		int age3 = 50;
		int age4 = 34;
		int age5 = 25;
		
		for(int i=1; i<=5 ; i++) {
			//System.out.println(agei);   // agei��� �������� ã���־ �ȵ�
			//System.out.println(age + i); // age��� �������� ã���־ �ȵ�
		}
		*/
		
		
		//�迭������ ���α׷���
		
		int[] ages = new int[5];
		
		ages[0] = 15;
		ages[1] = 23;
		ages[2] = 50;
		ages[3] = 34;
		ages[4] = 25;
		
		int sum = 0;
		for(int i=0; i<ages.length; i++) {
			System.out.println(ages[i]);
			sum += ages[i];
		}
		
		
	}
	
}
