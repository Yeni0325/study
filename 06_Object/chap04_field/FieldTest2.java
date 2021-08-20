package com.kh.chap04_field.model.vo;


//�ʵ���� ���������ڸ� �׽�Ʈ �غ��� ���� Ŭ����
public class FieldTest2 {
	
	/*
	 * * �ʵ忡�� ��밡���� ���������� 4����
	 * 
	 * - public : ��𼭵�(������Ű��, �ٸ���Ű�� ���) ���� ����
	 * 
	 * - protected : ���� ��Ű�� ���� ����, �ٸ� ��Ű���� ��� ��ӱ���(�θ��ڽİ��� ����)������ ���� ����
	 *                                          ��ӱ����� �ƴϸ� ������ �Ұ���!
	 * 
	 * - default : ���� ��Ű���� ���� ����, �ٸ� ��Ű���� ��� ������ ������ �Ұ���!
	 * 
	 * - private : ���� �ش� Ŭ���������� ������ ����!
	 * 
	 * ���������� �Ʒ��� ���������� ������ �� �ִ� ������ ������
	 */
	
	public String pub = "public";
	protected String pro = "protected";
	String def = "default";                   //default�� ���������ڸ� �����ؾ���!
	private String pri = "private";
	
	public static String sta = "static_FieldTest2";
}
