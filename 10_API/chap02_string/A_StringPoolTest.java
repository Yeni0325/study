package com.kh.chap02_string.controller;

public class A_StringPoolTest {

	public void method1() {
		
		//1. �����ڸ� ���� ���ڿ� ����
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		//�������� ObjectŬ������ �ִ� toStringŬ������ ����Ǹ鼭 �̻��� �ּҰ��� ��µǾ�� �ϴµ�,
		//String Ŭ������ toString�޼ҵ尡 �̹� �������̵� �Ǿ�����! (���� ����ִ� ���ڿ��� ��ȯ�ϵ���)
		
		System.out.println(str1 == str2); //false (�ּҰ� �񱳶�)
		
		System.out.println(str1.equals(str2));
		//String Ŭ������ equals�޼ҵ�� �̹� �������̵� �Ǿ�����!! (�ּҰ� �񱳰� �ƴ� ���� ��� ���ڿ��� ��)
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//StringŬ������ hashCode�޼ҵ尡 �̹� �������̵� �Ǿ�����!!(�ּҰ��� �ƴ� ���� ��� ���ڿ��� ������ hashcode�� ����)
		
		//���� �ּҰ��� ���ؼ� �˰� �ʹٸ� System.indentityHashCode(���۷���)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
	
	public void method2() {
		
		String str = new String("hello");
		//2. ���ڿ��� ���ͷ������� ����
		String str1 = "hello";
		String str2 = "hello";
		//���ͷ� ���� ���� �� ���� �״�� ��µǱ� ������ ���ڰ� ���ٰ� ������ �� ������
		//�� ģ���� ������� heap������ �ö󰡼� str1, str2������ �ּҰ��� ������
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//���� ��� ���ڿ��� ������ hashcode�� ����� ������ ������ �ּҰ� ���
		
		System.out.println(str1 == str2);
		//true => str1 �ּҰ��� str2 �ּҰ��� �����ϴ�
		
		//���� �ּҰ��� ��ġ�ϴ��� ��¥ �ּҰ� ���
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str));
		//new��� Ű���带 ���� ������ str�� �ּҰ��� �ٸ�
		
		//���ͷ� ���� �� Heap���� �ȿ� �ִ� String pool(���Ǯ)������ �ö󰡰� �ȴ�. 
		//String pool(���Ǯ) ������ Ư¡ : ������ ���ڿ��� ������ �� ����
		
		System.out.println("=======");
		String str3 = "hi";
		System.out.println(System.identityHashCode(str3));
		
		//String�� '�Һ�Ŭ����' ��. => ���� ������ �ʴ� Ŭ������.
		//�� ������ �����ϳ�, �� �ڸ����� �����Ǵ� ������ �ƴ�!
		str3 = "bye";
		System.out.println(System.identityHashCode(str3)); // �ƿ� ���ο� �ּҰ��� �ο��ް� �ȴ�.
		
		// hi�� bye�� �ٲ�� ���� �ƴ϶� String pool(���Ǯ) ������  bye�� ���� �����Ǹ鼭 ���ο� �ּҰ��� �ο��ȴ�.
		// => �� �ڸ����� �����Ǵ� ���� �ƴ� ���� �� �Ź� ���ο� ���� �����ϰ� �Ǵ� �Һ�Ŭ������ Ư¡!
		//�� ���� �����ϴ� hi��� ���ͷ��ڽ��� �������� �ʴ� �����̱� ������ '�������÷���'�� �ڵ������� ����������!
		
		str3 = "hello";
		System.out.println(System.identityHashCode(str3));
	}
	
	
	
	
}
