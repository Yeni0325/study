package com.kh.chap01_beforeVSafter.before.run;

import com.kh.chap01_beforeVSafter.before.model.vo.Desktop;
import com.kh.chap01_beforeVSafter.before.model.vo.SmartPhone;
import com.kh.chap01_beforeVSafter.before.model.vo.Tv;

public class BeforeRun {

	public static void main(String[] args) {

		//Desktop��ü ����
		//brand, pCode, pName, price, allInOne
		Desktop d = new Desktop("�Ｚ", "d-01", "¯¯", 2000000, true);
		
		//TV��ü ����
		//brand, pCode, pName, price, inch
		Tv t = new Tv("����", "t-01", "�̳�����Ƽ��", 3500000, 65);
		
		//SmartPhone��ü ����
		//brand, pCode, pName, price, mobileAgency
		SmartPhone s = new SmartPhone("����", "s-01", "���̻�", 1300000, "KT");
		
		System.out.println(d.information());
		System.out.println(t.information());
		System.out.println(s.information());
		/*
		 * �� Ŭ������ �������� �ʵ�� �޼ҵ���� ������
		 * �̷� �ߺ��� �ڵ���� �Ź� �����ʿ� ���� ���� �θ�Ŭ������ �ѹ� �����صθ� �ߺ��� �ڵ���� ���� �� �ִ�.
		 * => ������ ���� �������� ��û�� ������ �� ������ ã�Ƽ� ������ �ʿ� ���� 
		 *    �ѹ��� �����ص� �θ�Ŭ������ �����ϸ� ��ü������ �ݿ��ȴ�.
		 *    
		 * �� Ŭ������ ���������� ������ �ִ� ��
		 * => brand, pCode, pName, price �ʵ��, setter/getter�޼ҵ�, information�޼ҵ�
		 * ==> ProductŬ������ �̸� �����غ���!!
		 */
		
		
		
		
		
	}

}
