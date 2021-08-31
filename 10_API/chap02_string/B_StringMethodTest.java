package com.kh.chap02_string.controller;

public class B_StringMethodTest {
	
	public void method1() {
		
		String str1 = "Hello World";
		
		// �޼ҵ� (�Ű�����) : ��ȯ��
		
		//1. ���ڿ�.charAt(int index) : char
		//   ���ڿ����� ���޹��� index��ġ�� ���ڸ��� �����ؼ� ����
		char ch = str1.charAt(3);
		System.out.println("ch : " + ch);
		
		//2. ���ڿ�.concat(String str) : String
		//   �ش� ���ڿ��� ���޵� ���ڿ��� �ϳ��� ���ļ� ���ο� ���ڿ� ����
		String str2 = str1.concat("!!!");
		System.out.println("str2 : " + str2);
		
		//���ڿ��� ���ڿ��� �̾���̷��� concat�� �ƴ� '+'(��������)�� Ȱ���� ����� �����ߴ�.
		String str3 = str1 + "!!!";
		System.out.println("str3 : " + str3);
		
		//str2�� str3�� �����
		System.out.println("str2�� str3�� ��ġ�մϱ� : " + (str2 == str3));
		//str2�� str3�� �ڽ��� ��� �ּҰ��� �ٸ��� ������ false ���
		//str2�� str3�� ��� ���ڿ��� ��ġ�ϳ� ���� ����ִ� �ּҰ��� �ٸ�!!
		
		//3. ���ڿ�.equals(Object obj) : boolean
		//   ���ڿ��� ���޵� �Ǵٸ� ���ڿ��� ������ �ּҰ� �񱳰� �ƴ� ���� ���ڿ����� ������ ����� ����
		System.out.println("str2�� str3�� ��ġ�մϱ�(equals) : " + str2.equals(str3));
		
		//4. ���ڿ�.contains(CharSequence s) : boolean
		//   String�� CharSequence�� ��ӹް� ����
		
		
		//5. ���ڿ�.length() : int
		//   ���ڿ��� ���� ��ȯ
		System.out.println("str1�� ���� : " + str1.length());
		
		//6. ���ڿ�.substring(int beginIndex) : String
		//   => ���ڿ��� beginIndex ��ġ�������� �������� ���ڿ��� �����ؼ� ����
		System.out.println(str1.substring(6));
		//   ���ڿ�.substring(int beginIndex, int endIndex) : String
		//   => ���ڿ��� beginIndex ��ġ��������  endIndex -1 ������ ���ڿ��� �����ؼ� ���� 
		System.out.println(str1.substring(0,4)); // begin <=   < end
		
		//7. ���ڿ�.replace(char oldChar, char newChar) : String
		//   �ش� ���ڿ����� oldChar�� �ش��ϴ� ���ڵ��� newChar�� ��ȯ�� '�� ���ڿ�' ����
		String str4 = str1.replace('l', 'c');
		System.out.println("str1���� l�� c�� �ٲ� ���ڿ� ���� : " + str4);
		System.out.println("str1�� ����Ƴ�? : " + str1);
		
		//8. ���ڿ�.toUpperCase() : String
		//   �ش� ���ڿ��� �� �빮�ڷ� ������ �� ���ڿ� ����
		String str5 = str1.toUpperCase();
		System.out.println("str5 : " + str5);
		//   ���ڿ�.toLoserCase() : String
		//   �ش� ���ڿ��� �� �ҹ��ڷ� ������ �� ���ڿ� ����
		System.out.println(str1.toLowerCase());
		
		/*
		 * System.out.print("����Ͻðڽ��ϱ�?(y/n) : ");
		 * char ch = sc.nextLine().toUpperCase().charAt(0);    => toUpperCase�� ���ڿ� �޼ҵ�� ������ sc.nextLine.CharAt().toUpperCast�� �Ұ�
         *                 //�޼ҵ� ���̾� ȣ�� == �޼ҵ� ü�̴�
		 * => ����ڰ� �ҹ��ڸ� �Է��ص� �빮�ڷ� ��ȯ�� �� ch�� ���� ��
		 * 
		 * if(ch == 'N'){
		 *    //���α׷� ����
		 * }
		 * 
		 * 
		 */
		
		
		//9. ���ڿ�.trim() : String
		//   ���ڿ� �յڿ� ������ �����ϴ� �޼ҵ�
		String str6 = "    JA   VA     ";
		System.out.println("str6 : " + str6.trim());
		
		//10. ���ڿ�.toCharArray() : char[]
		//    ���ڿ��� �ִ� ������ ���ڵ��� char �迭�� �Űܴ�� �޼ҵ�
		char[] arr = str1.toCharArray();
		System.out.println(arr[0]);
		
		//11. static valueOf(char[] data) : String
		//    char[] �迭�� ����� �ִ� ���ڵ��� ���ڿ��� �����ִ� �޼ҵ�
		System.out.println(String.valueOf(arr));
		//static�޼ҵ�� ������ 'Ŭ������.'���� ȣ���ؾ��h��!!
	}
	
	
	
	
	
	
	
	
	
	
	
}
