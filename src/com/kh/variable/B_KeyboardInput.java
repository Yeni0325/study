package com.kh.variable;

import java.util.Scanner;

// ����ڰ� Ű����� �Է��� ���� �޾Ƶ��̴� Scanner �ǽ�
public class B_KeyboardInput {

	public void inputTest1() {
		
		/*
		 * Ű����� ���� �Է��ϴ� ���
		 * Scanner �� ����Ѵ�!
		 * (�� java.util.Scanner Ŭ������ �̿��ϴ� ���̴�!)
		 * Scanner Ŭ���� ������ �޼ҵ带 ȣ���Ͽ� �Է¹޴°�.
		 */
		
		// ��ĳ�� Ŭ������ ��ü ����
		Scanner sc = new Scanner(System.in);
		// System.in �� �Է¹��� ���� ����Ʈ ������ �޾Ƶ��̰ڴٴ� �ǹ�
		// ��� �ÿ��� System.out �̶�� ������ �����!
		
		System.out.print("�ƹ��ų� �Է��غ����� : ");
		String amuguna = sc.nextLine();
		
		System.out.println("�Է¹��� ���� : " + amuguna);
	}
}





