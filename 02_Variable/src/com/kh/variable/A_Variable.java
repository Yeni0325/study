package com.kh.variable;

public class A_Variable {
	
	// �ñް� �ٹ��ð��� �ٹ��ϼ��� ���ؼ� ������ ����ؼ� ����ϴ� �޼ҵ�
	
	public void printVariable() {
		System.out.println("===== ���� ��� �� =====");
		
		System.out.println("�ñ� : 8500��");
		System.out.println("�ٹ��ð� : 6�ð�");
		System.out.println("�ٹ��ϼ� : 8��");
		
		//���� = �ñ� * �ٹ��ð�  * �ٹ��ϼ�
		// �谩�� : OOOOO�� �������� ����Ϸ���??
		System.out.println("�谩�� : " + (9450 * 6 * 8) + "��");
		System.out.println("�Ǵ��� : " + (9450 * 6 * 8) + "��");
		System.out.println("�Ǽ��� : " + (9450 * 6 * 8) + "��");
		System.out.println("������ : " + (9450 * 6 * 8) + "��");
		System.out.println("���ѳ� : " + (9450 * 6 * 8) + "��");
		
		//���� ��� �� 
		System.out.println("===== ���� ��� �� =====");
		
		int pay = 9450; // �ڹٿ��� '=' ��ȣ�� �����ϴ� ��� ���� �ƴ϶� 8500 �̶�� ���� pay��� ���ڿ� �ְڴ� ��, �����ϰڴٴ� �ǹ�!
		int time = 6;
		int day = 8;
		
		System.out.println("�谡�� : " + (pay * time * day) + "��" );
		System.out.println("��� : "  + (pay * time * day) + "��");
		System.out.println("����� : " + (pay * time * day) + "��");
		System.out.println("���� : " + (pay * time * day) + "��");
		System.out.println("�迹�� : " + (pay * time * day) + "��");
		
		/*
		 *  ������ ����ϴ� ����
		 *  1. ������ �켱������ ���� �ǹ̸� �ο��� �������� ����. (�������� ��������.)
		 *  2. �� �ѹ� ���� ����ϰ� �ʿ��� ������ ������ ���� �������� ����. (���뼺�� ��������.)
		 *  3. ���������� ���� ������ �� �ִ�.
		 */
		
	}

}
