package com.kh.chap05_constructor.run;

import com.kh.chap05_constructor.model.vo.User;

public class ConstructorRun {

	public static void main(String[] args) {
		
		//1. �⺻�����ڷ� ��ü ���� �� �ش� ��ü ���� ���
		User a = new User();
		
		System.out.println(a.information());
		//�� �ʵ忡 JVM�� �ʱⰪ�� �������!!
		
		
		//2. �Ű����� 3������ �����ڷ� ��ü ���� �� ���� ���
		User u2 = new User("user02", "pass02", "ȫ�浿");
		
		/*
		u2.setUserId("user02");
		u2.setUserPwd("pass02");
		u2.setUserName("ȫ�浿");
		*/
		
		System.out.println(u2.information());
		u2.setUserName("ȫ����"); // �ʵ� �ϳ��� ������ ��쵵 �����ű� ������ setter�޼ҵ� �ʼ�!!
		
		//3. �Ű����� 5��¥�� �����ڷ� ��ü ���� �� ���� ���
		User u3 = new User("user03", "pass03", "�踻��", 23, '��');
		System.out.println(u3.information());
	}

}
