package com.kh.chap06_method.controller;

public class OverloadingTest {
	
	// �����ε� : �� Ŭ���� ���� ���� �޼ҵ������ ������ �� �ִ� ��
	
	public void test() {
		
		
		
	}
	
	/*
	public void test() {
		
	} => ������ �Ȱ������� �Ұ�.
	*/
	
	public void test(int a) {
		//�Ȱ��� �̸��� �޼ҵ����� �Ű������� ���������� �ٸ��鼭 ������ �����ϱ� ������ �����ε��� �����ϴ�!
	}
	
	public void test(int a, String s) {
		
	}
	
	public void test(String s, int a) {
		
	}
	
	public void test(int a, int b) {
		
	}
	
	/*
	public void test(int c, int d) {
	                                   => �����ε� �� �Ű������� �̸��� �߿����� �ʴ�!	
	}
	*/
	//�Ű����� ����� ������� "�Ű������� �ڷ����� ����"�� "����"�� �ٸ��� �ۼ��Ǿ�� �Ѵ�!!
	
	public void test(String str) {
		
	}
	
	/*
	public int test(String str) {
		                           => "��ȯ��"�� �޶� �ȵ�!! ������ �Ű������� �޶���Ѵ�!!
	}
	*/
	/*
	private void test(String str) {
                                   => "����������"�� �������!!		
                                   
	}
	*/
	
	/*
	 * * ���
	 *   �����ε� : �� Ŭ���� ���� ������ �̸��� �޼ҵ��
	 *           ��, �Ű�������, ����������, ��ȯ���� �� ������
	 *           �Ű������� �ڷ����� ����, ������ �ٸ��� �ۼ��Ǿ�ߵ�!!
	 */
}
