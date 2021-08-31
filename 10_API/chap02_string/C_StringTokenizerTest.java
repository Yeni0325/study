package com.kh.chap02_string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizerTest {

	public void method() {
		
		String str = "JAVA,Oracle,JDBC,HTML,CSS,Spring";
		
		//�����ڸ� �������� �ؼ� ���ڿ��� �и���Ű�� ���
		
		//���1. �и��� ���ڿ����� String[] �迭�� �������� ����� �Ҷ�
		//      StringŬ������ �����ϴ� split �޼ҵ� �̿�
		//      ���ڿ�.split(������) : String[]   => ���� �ɰ��� ���ڿ����� String[]�迭�� ��ȯ�ȴ�
		
		String[] arr = str.split(",");
		//String[]�� ��ȯ�Ǳ� ������ ������ �ڷ����� String[] arr�� �������Ѵ�.
		
		System.out.println("�迭�� ���� : " + arr.length);
		
		/*
		for(int i=0; i<arr.length; i++) {
			System.out.println(i + "��° �ε��� : " + arr[i]);
		}
		*/
		//for-loop���� ���ԵǸ� i���� Ȱ�밡���ϴ�
		
		//for-each��(���� for��) : �迭�� 0�� �ε������� �������ε������� ���������� �����ϰ��� �� �� ���!
		for(String s : arr) { // s = arr[0] => s = arr[1] => ...
			System.out.println(s);
		}
		
		//for-each���� for-loop���� �ٸ��� �ε����� Ȱ���ϴ� ����� �ټ� �����ϴ�.
		// �� �Ʒ��� ���� ������� �����ϱ���!
		/*
		 * int i = 0;
		 * for(String s : arr) {
		 *  System.out.println(i++ + "��° �ε��� : " + s);
		 * }
		 */
		
		
		//���2. �и��� ���ڿ����� ���� ��ū���ν� �����ϰ��� �� ��
		//      java.util.StringTokenizer Ŭ������ �̿��ϴ� ���
		//      StringTokenizer stn = new StringTokenizer(�и���Ű�����ϴ¹��ڿ�, ������);
		StringTokenizer stn = new StringTokenizer(str, ",");
		
		System.out.println("�и��� ���ڿ��� ���� : " + stn.countTokens());
		//�迭�� ��� ������ �и��� ���ڿ��� �������� ���� ��� ������ �ε����� ������ �� �־�����, ���⼭�� �ε������ ������ ����x
		// ���� ���������� �������� ����!
		
		/*
		System.out.println(stn.nextToken());  //=> ù��°�� �޼ҵ� ȣ�� �� ù����� ������
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		*/
		
		//=> stn�̶�� �������κ��� �ϳ��� ���������� �̾ƿ´�!
		// �迭�� ��� �ε������� �̾ƿ� ��� �Ҹ���� �ʰ� �迭�� ��� ����������, nextToken�� ��� '��ȸ��'!!
		
		
		//System.out.println(stn.countTokens());
		// stn�������� �ƿ� �̾Ƽ� �������Ƿ� �� �̰��� ����� ������ ����Ұ�� 0�� ��µȴ�.
		//0�� ���� ��Ȳ���� nextToken�� �����Ұ�� 'NoSuchElementException'���� �߻� => �� �̻� ��Ұ� ����.
		
		//���� ����� ������ 100�����, ���� 6���� ����� �̾ƿ°�ó�� �ݺ��ϱ�� ��ƴ�!
		
		/* �߸��ȹ��(�ݺ����� 3���� ����)
		for(int i=0; i<stn.countTokens(); i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
		//i=0  ,  i < 6 => true ��� => JAVA
		//i=1  ,  i < 5 => true ��� => Oracle (JAVA�� �������Ա� ������ stn.countTokens�� 5�� �ȴ�)
		//i=2  ,  i < 4 => true ��� => JDBC   (Oracle�� �������Ա� ������ stn.countTokens�� 4�� �ȴ�)
		//i=3  ,  i < 3 => false ��� => �ݺ��� ����!
		
		//�ݺ����� ������ 6���� �����̾��ٸ� ������ �̾ƿ� �� ������ stn.countToken�� ���ڰ� ���� �پ��� ������ 
		//��� ��ū�� ��µ��� �ʴ´�.
		
		//�ذ���1.(����� ������ 100�����)
		/*
		int count = stn.countTokens(); // count = 6
		
		for(int i=0; i<count; i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
		
		//�ذ���2.(��ū�� ������ 100�����)
		while(stn.hasMoreTokens()/*�ݺ��� ����� ����*/) { // stn.hasMoreTokens() => ������ ��ū�� ���������� true, ������ false���!
			System.out.println(stn.nextToken());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
