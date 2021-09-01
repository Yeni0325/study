package com.kh.exception.run;

import java.io.IOException;

import com.kh.exception.controller.A_UnCheckedException;
import com.kh.exception.controller.B_CheckedException;

public class ExceptionRun {

	public static void main(String[] args) throws IOException {
		
		/*
		 * * ���� ����
		 * - �ý��ۿ��� : ��ǻ���� ���۵����� ���� �߻��ϴ� ���� => �ҽ��ڵ�� �ذ�ȵ� => �ɰ��� ���� (jvm���� ����)
		 * - �����Ͽ��� : �ҽ��ڵ� ������ ������ ���� �� �߻��ϴ� ���� (�����Ű�� ��) => �����ٷ� ���ʿ� ������ �˷��� => �������� �Ǽ�
		 * - ��Ÿ�ӿ��� : �ڵ������ ������ ���µ� ���α׷� ���� �߿� �߻��ϴ� ���� => ������� �Ǽ��� �� �ְ� ������ ���������� ��츦 ����� ó�����س��� �� ����
		 * 
		 * - �� ���� : ���������ε� �������� �������� ���� ���� ������ ������ ���α׷� �ǵ��� ���� �ʴ� ��
		 * 
		 * �ý��� ������ ������ �����Ͽ���, ��Ÿ�ӿ���, �������� ���� ���� �� �ɰ��� �͵��� ������ �۾�
		 * �̷� �͵��� "����"��� �Ѵ� => Exception
		 * 
		 * "����"�� "�߻�"���� ��쿡 ���ؼ� "ó��"�ϴ� ����� => "����ó��"��� ��!!
		 * 
		 * * ����ó���� �ϴ� ����
		 * - ����ó���� ���� �ʰ� �״�� ���ܰ� �߻��Ǵ°�� ���α׷��� ������������ ����� �� ����
		 * 
		 * * ����ó�� ��� (���ܰ� �߻����� ��)
		 * 1. try ~ catch���� �̿� (try~with~resource)
		 * 2. throws�� �̿� (���ѱ�� == �����Ѵ�)
		 * 3. 
		 */
		
		A_UnCheckedException a = new A_UnCheckedException();
		//a.method1();
		//a.method2();
		//a.method3();
		
		B_CheckedException b = new B_CheckedException();
		b.method1();
		
		
	}

}
