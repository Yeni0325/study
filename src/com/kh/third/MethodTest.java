package com.kh.third;

public class MethodTest {
	
	public static void main(String[] args) {
		
		System.out.println("�ȳ�");
		/*testPrintA();
		testPrintB();
		testPrintC();
		*/
		testPrintA();
		
		// �� ���� ����� ���������� ��� � �޼ҵ带 ȣ���ϴ��Ŀ� ���� ����� �޶��� �� �ִ�.
		// �̷������� �޼ҵ带 ��ɺ��� ���� �ʿ��� �� ���� ȣ���ϸ� �ȴ�.
	}
	
	public static void testPrintA() {
		System.out.println("A �޼ҵ� ������!!");
		
		testPrintB();
	}
	
	public static void testPrintB() {
		System.out.println("B �޼ҵ� ������!!");
		
		testPrintC();
	}
	
	public static void testPrintC() {
		System.out.println("C �޼ҵ� ������!!");
		
		//testPrintA(); ���Ѵ�� ���ư��� ������ ������ �߻��Ѵ�.
	}

}
