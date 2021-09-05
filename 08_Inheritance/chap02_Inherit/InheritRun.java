package com.kh.chap02_inherit.run;

import com.kh.chap02_inherit.mode.vo.Airplane;
import com.kh.chap02_inherit.mode.vo.Car;
import com.kh.chap02_inherit.mode.vo.Ship;

public class InheritRun {

	public static void main(String[] args) {
	
		
		Car c = new Car("��Ʋ��", 12.5, "����", 4);
		
		Ship s = new Ship("���ù�", 3, "�", 1);
		
		Airplane a = new Airplane("�����", 0.01, "��Ʈ��", 10, 4);
		
		System.out.println(c.information());
		System.out.println(s.information());
		System.out.println(a.information());
		
		c.howToMove();
		s.howToMove();
		a.howToMove();
		
		/*
		 * * ����� ����
		 * - ���� ���� ���� �ڵ�� ���ο� Ŭ���� �ۼ� ����
		 * - �ڵ带 ���������� �����ϱ� ������ �ڵ��� �߰��� ������ ����(���α׷��� ���꼺�� ���������� ũ�� �⿩)
		 * 
		 * * ����� Ư¡
		 * - Ŭ�������� ��ӿ� �־�� ���߻���� �Ұ�(���ϻ�Ӹ� ����! ��, �θ�� �ϳ���)
		 * - �θ�Ŭ������ ���ǵǾ��ִ� protected�ʵ�� �ڽ�Ŭ�������� ���� ���� ����
		 * - �ڽİ�ü�� �θ�Ŭ������ �ִ� �޼ҵ带 ��ġ ����ó�� ȣ�� ����
		 * - �θ�Ŭ������ �ִ� �޼ҵ尡 ������ �ȵ�� �ڽ�Ŭ�������� �������̵� ����!(�޼ҵ� ������)
		 * - ��õǾ����� ������ ��� Ŭ����(�ڹٿ��� �����ϴ� Ŭ����, ���� ���� Ŭ����)�� Object��� Ŭ������ �ļ��̴�!!
		 *   => ��, ObjectŬ������ �ִ� �޼ҵ带 ������� ȣ�� ����!
		 *   => �Ӹ� �ƴ϶� �������̵��� ���ؼ� �����ǵ� �����ϴ�! 
		 * 
		 */
		
		System.out.println(c.hashCode());
		System.out.println(c.equals(s));
		
		System.out.println(c/*.toString()*/);
		System.out.println(c.toString());
		//'c'�� ����Ұ��, c.toString()�� ����ϴ� �Ͱ� ����. ObjectŬ������ �ִ� �޼ҵ尡 �˰Ը𸣰� ��µȰͰ� ����!
		
	}

}
