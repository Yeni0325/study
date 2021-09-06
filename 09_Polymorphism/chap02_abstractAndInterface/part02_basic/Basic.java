package com.kh.chap02_abstractAndInterface.part02_basic.model.vo;

public interface Basic {
	//�������̽��� Ŭ������ �� �������� , �׳� �������̽��� ����Ѱ�!

	//�߻�Ŭ����(abstract class) : �Ϲ��ʵ� �ۼ����� + �Ϲݸ޼ҵ� �ۼ����� + [�߻�޼ҵ� �ۼ�����]
	//�������̽�(interface)      : [Only ����ʵ�] + �߻�޼ҵ�
	
	//private int a; => �������̽��� ���� ����ʵ常 �����ϱ� ������ �����߻�
	public static final int NUM = 10;
	//�������̽������� �ʵ�� ������ ����ʵ���!!
	
	//���� ������ ������ ����ʵ��̱� ������ 'public static final'�κ��� ������ �����ϴ�!
	/*public static final*/ int NUM2 = 20;
			
	/*
	public void test() {
	                          => �������̽��� �Ϲݸ޼ҵ� �ۼ� �Ұ�	
	}
	*/
	
	//�������̽��� �޼ҵ�� ������ �߻�޼ҵ���!!
	public abstract void eat();
	public abstract void sleep();
	
	//���� ������ ������ �߻�޼ҵ��̱� ������ 
	/*
	 * [public abstract] void eat();      => 'public abstract'���� ����!!
	 * [public abstract] void sleep();
	 */
	
	//�������̽��� �����ϴ� ���� '����ʵ�' '�߻�޼ҵ�' �ΰ��� �ۼ��� �����ϱ� ������ ������ �������̵��ؾ��ϴ� �޼ҵ� �ۿ� ����!!!!
	// => �Ϲ����� �߻�Ŭ�������� �������� ����!
	
	
	
	
	
	
}
