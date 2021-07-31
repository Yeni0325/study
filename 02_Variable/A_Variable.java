package com.kh.variable;

public class A_Variable {

	// �ñް� �ٹ��ð��� �ٹ��ϼ��� ���ؼ� ������ ����ؼ� ����ϴ� �޼ҵ�
	public void printVariable() {
		
		System.out.println("===== ���� ��� �� =====");
		
		System.out.println("�ñ� : 9450��");
		System.out.println("�ٹ��ð� : 6�ð�");
		System.out.println("�ٹ��ϼ� : 8��");
		
		// ���� = �ñ� X �ٹ��ð�  X �ٹ��ϼ�
		// �谩�� : OOOOO�� �������� ����ϰ�ʹ�!
		System.out.println("�谩�� : " + (9450 * 6 * 8) + "��");
		System.out.println("�Ǵ��� : " + (9450 * 6 * 8) + "��");
		System.out.println("�Ǽ��� : " + (9450 * 6 * 8) + "��");
		System.out.println("������ : " + (9450 * 6 * 8) + "��");
		System.out.println("���ѳ� : " + (94500 * 6 * 8) + "��"); // �ڹٿ��� ������ * ��ȣ�� ��Ÿ����.
		
		// ���� ��� ��
		System.out.println("===== ���� ��� �� =====");
		
		int pay = 9450; // �ڹٿ��� = ��ȣ�� �����ϴٶ�� ���� �ƴ϶� 8500 �̶�� ���� pay ��� ���ڿ� �ְڴ� ��, �����ϰڴ� ��� �ǹ�!
		int time = 6;
		int day = 8;
		
		System.out.println("�谡�� : " + (pay * time * day) + "��");
		System.out.println("��� : " + (pay * time * day) + "��");
		System.out.println("����� : " + (pay * time * day) + "��");
		System.out.println("���� : " + (pay * time * day) + "��");
		System.out.println("�迹�� : " + (pay * time * day) + "��");
		
		/*
		 * ������ ����ϴ� ����
		 * 1. ������ �켱������ ���� �ǹ̸� �ο��� �������� ����. (�������� ��������.)
		 * 2. �� �ѹ� ���� ����ϰ� �ʿ��� ������ ������ ���� �������� ����. (���뼺�� ��������.)
		 * 3. ���������� ���� ������ �� �ִ�.
		 */
	}
	
	// ������ ����
	public void declareVariable() {
		
		/*
		 * ������ ����
		 * ���� ����ϱ� ���� ������ �޸� ������ Ȯ��, �Ҵ��Ѵ�. => ��, ���� �����ϱ� ���� ���ڸ� ����ڴ�!!
		 * 
		 * [ǥ����] �ڷ��� �����̸�;
		 * 
		 * �ڷ��� : ������ ũ�� �� ��� �� �������ִ� �κ�
		 * �����̸� : ������ �̸��� �ٿ��ִ� �κ� (�ǹ̺ο�!)
		 * 
		 * ���� ���� �� ��������
		 * 1. �����̸��� �ҹ��ڷ� ���� / ��, ��Ÿ�� ǥ����� ��ų��! / ������ �Ұ�!
		 * 2. ���� ���� �� ({}) ������ ������ ���������� ���� �Ұ� => ��, �ߺ��� �Ұ����ϴ�!
		 * 3. �ش� ���� �� ({}) ���� ����� ������ �� ���� �ȿ����� ��� ����
		 * 	=> �ٸ� �޼ҵ忡���� ����� �Ұ��ϴ�!
		 */
		
		
		// ----- �ڷ����� ���� ���� -----
		// 1. ���� (���� = true / false)
		boolean isTrue;
		boolean isFalse = true; // 1byte, ��������� ���ÿ� ���� ����(=), �� ����
		System.out.println("isFalse�� ���ο� ���� ���� �� : " + isFalse);
		
		isTrue = 1 + 3 < 1; // false
		
		isTrue = true;  // 3 + 1 > 1 => 4�� 1���� Ů�ϱ�? ���Դϴ�! (true)
		isFalse = false; // 4 + 2 < 1 => 6���� 1�� Ů�ϱ�? �����Դϴ�! (false)

		// 2. ������
		// 2_1. ������ (�Ҽ��� X)
		byte bNum; // 1byte (-128 ~ 127)
		bNum = -128;
		
		short sNum = 1000; // 2byte
		
		int iNum = 10000; // 4byte, �������� �⺻ �ڷ���
		
		long lNum = 100000; // 8byte
		
		// 2_2. �Ǽ��� (�Ҽ��� O)
		float fNum = 0.0f; // 4byte => �Ҽ��� 7�ڸ����� ǥ�� ����
						   // float�� ��� double�� ���� �����ϱ� ���� �� �ڿ� f �� �ٿ��ش�.
		
		double dNum = 0; // 8byte => �Ҽ��� 15�ڸ����� ǥ�� ����, �Ǽ����� �⺻ �ڷ���
		
		// 3. ������
		// 3_1. ����
		char ch = 'a'; // 2byte
		char kim;
		kim = '��';
		
		// 3_2. ���ڿ�
		String str; // ������
		str = "abc";
		
		// ���� �� ������ Ȯ���غ���!
		System.out.println(isTrue);
		System.out.println("isFalse�� ���ο� ���� ���� �� : " + isFalse);
		System.out.println(bNum);
		// System.out.println(-128);
		
		// �����̸� : �� �� ���·� ����ϰ�ʹ�!!
		System.out.println("sNum : " + sNum);
		System.out.println("iNum : " + iNum);
		System.out.println("lNum : " + lNum);
		System.out.println("fNum : " + fNum);
		System.out.println("dNum : " + dNum);
		System.out.println("ch : " + ch);
		System.out.println("kim : " + kim);
		System.out.println("str : " + str);
		
		
		// ����� ����!
		// [ǥ����] final �ڷ��� ����̸�;
		final int AGE; // ����̸��� ��� �빮�ڷ� ���´�!
		AGE = 10; // �ʱ�ȭ
		
		System.out.println("AGE : " + AGE);
		
		// AGE = 11; // ����� ���� ������ �Ұ��ϴ�!!

		System.out.println("AGE : " + AGE);
		
		// ��ǥ���� ����� �� : 3.14 (����, ������)
		System.out.println("���� : " + Math.PI);
	}
	
}










