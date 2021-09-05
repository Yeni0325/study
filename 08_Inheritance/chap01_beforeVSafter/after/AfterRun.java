package com.kh.chap01_beforeVSafter.after.run;

import com.kh.chap01_beforeVSafter.after.model.vo.Desktop;
import com.kh.chap01_beforeVSafter.after.model.vo.SmartPhone;
import com.kh.chap01_beforeVSafter.after.model.vo.Tv;

public class AfterRun {

	public static void main(String[] args) {
	
		/*
		 * * ����� ����
		 * - ���� ���� ���� �ڵ�� ���ο� Ŭ���� �ۼ� ����
		 * - �ߺ��� �ڵ带 ������ �����ϱ� ������ �ڵ��� �߰��� ���濡 ���� (���α׷��� ���꼺�� ���������� ũ�� �⿩)
		 */
		
		//Desktop ��ü ����
		//brand, pCode, pName, price, allInOne
		Desktop d = new Desktop("�Ｚ", "d-01", "¯¯����ũž", 2000000, true);
		
		//Tv ��ü ����
		//brand, pCode, pName, price, inch
		Tv t = new Tv("����", "t-01", "�̳�����Ƽ��", 3500000, 70);
		
		
		//SmartPhone ��ü ����
		//brand, pCode, pName, price, mobileAgency
		SmartPhone s = new SmartPhone("����", "s-01", "������", 1500000, "KT");
		
		System.out.println(d.information());
		System.out.println(t.information());
		System.out.println(s.information());
		
		
		s.setPrice(1200000);
		s.setMobileAgency("SKT");
		System.out.println(s.information());
		
		/*
		 * * ����� Ư¡
		 * - �ڽİ�ü�� ������ �θ�Ŭ������ �ִ� �޼ҵ带 ��ġ ����ó�� ȣ�� ����
		 * - �θ�Ŭ������ �ִ� �޼ҵ带 �������̵��� ���� �ڽ�Ŭ�������� ������ ����
		 * => �������̵��� �ϴ� ���� �ڽ�Ŭ������ �ִ� �޼ҵ� �켱���� ����
		 * - Ŭ�������� ����� ���� ����� �Ұ����ϴ� (���� ��Ӹ� ����)
		 */
		
		
		
		
		
	}

}
