package com.kh.variable;

public class C_Printf {
	
	public void printfTest() {
		
		//System.out.printf("����ϰ����ϴ� ����(����), ����ϰ����ϴ� ��, ��, ...");
		//����ϰ����ϴ� ������ ������ ���Ŀ� ���缭 ���(�ٹٲ�x)�� ����. ��, ���ٶ��� (����) �ȉ�!!
		
		/*
		 * ���˾ȿ��� ���� �� �ִ� Ű����
		 * %d : ����
		 * %c : ����
		 * %s : ���ڿ� (���ڵ� ����)
		 * %f : �Ǽ�
		 */
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		// "10 20"
		System.out.println(iNum1 + " " + iNum2);
		System.out.printf("%d %d", iNum1,iNum2);
	}

}
