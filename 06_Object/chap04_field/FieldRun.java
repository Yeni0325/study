package com.kh.chap04_field.run;

import com.kh.chap04_field.model.vo.FieldTest1;
import com.kh.chap04_field.model.vo.FieldTest2;
import com.kh.chap04_field.model.vo.FieldTest3;

public class FieldRun {

	public static void main(String[] args) {
		
		// --- FieldTest1 ---
		
		/*
		FieldTest1 f1 = new FieldTest1();
		
		f1.test(5);
        */
		
		// --- FieldTest2 ---
		/*
		FieldTest2 f2 = new FieldTest2();
		
		//public : ��𼭵� ���ٰ���(�ٸ���Ű���ӿ��� �ұ��ϰ�)
		System.out.println(f2.pub);
		
		//protected : ���� ��Ű�� �� ���� ����, �ٸ� ��Ű����� ��ӱ����� ���� ����!
		//System.out.println(f2.pro);
		
		//default : ���� ��Ű�������� ���� ����
		//System.out.println(f2.def);
		
		//private : �ش� Ŭ���������� ���� ����
		//System.out.println(f2.pri);
		 */
		
		// ---- FieldTest3 ---
		
		//static�� ��Ű�� ���� ���� ������ ������ ������ �� �����Ƿ� �տ� 'Ŭ������'�� �ۼ��ؾ��Ѵ�!!
		System.out.println(FieldTest3.sta);
		System.out.println(FieldTest2.sta);
		
		FieldTest3.sta = "������"; 
		// ���� static�� �پ��� ���� ��𼭵� �� �� �ְ�, ������ ����!
		
		System.out.println(FieldTest3.sta);
		
		System.out.println(FieldTest3.STA_FIN);
		//FieldTest3.STA_FIN = "������"  //����� ����Ʊ� ������ ������ �Ұ�
		
		System.out.println(Math.PI);
		
		
		
	}

}
