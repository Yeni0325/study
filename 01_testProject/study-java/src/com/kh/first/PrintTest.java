package com.kh.first;

public class PrintTest {
	
	//��¹� �ǽ�
	public static void main(String[] args) {
		
		System.out.println("println�� �ٹٲ�");
		
		System.out.print("print��  �ٹٲ�X\n"); //���ڿ�(����)�� ���� �׳� �ֵ���ǥ�� ���´�.
		
		System.out.print(1234 + "\n"); // ������ ��� �׳� �����ش�.
		
		System.out.print('A' + "\n"); // ������ ��� Ȭ����ǥ�� ���´�.
		
		//�ٹٲ��� �ϰ� ������ print���� ����ϴ� ����?
		System.out.print("�ٹٲ��� �ϰ� �;�\n");
		System.out.print("�ٹٲ� ������!\n");    // '\n' ���๮�ڷ�, �ٹٲ� ȿ���� �ش�.
		
		// ����+����, ����+���ڿ�, ����+���ڿ��� ���� ���� �ٸ� ���¸� �ٿ��� ��Ÿ���ִ� ��ȣ�� '+'
		
		System.out.print("Hi\nEveryone!!\n"); //���๮�ڴ� ���� �߰��� �ƹ������� ���� �� �ִ�.

		System.out.print("\\n"); // \n ��ü�ε� \�� �ϳ� �� �ٿ��شٸ� ����� �����ϴ�.
	}

}
