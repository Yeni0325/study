package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.mode.vo.Desktop;
import com.kh.chap01_poly.part02_electronic.mode.vo.NoteBook;
import com.kh.chap01_poly.part02_electronic.mode.vo.Tablet;

//������ ��������� ���� ����
public class ElectronicShop1 {
	
	//��� ���ڻ󰡿� �ִ� ����
	
	//������ ��ǰ�� ��ǰ��ü�� �޾Ƽ� ������ ������ �ʿ���
	
	//�ʵ��
	//Ư�� ��ü ��ü�� �����ϴ� �ʵ嵵 ����
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	//������ ��ǰ�� ������ ���� ���� �ڸ����� ������ ����
	//Ư�� Ŭ������ �ִ� �ʵ�� Ŭ������ ������ ��ü�����ϴ� ���� �ش� Ŭ������ �ش��ϴ� �ʵ常ŭ�� �ڸ��� �޸𸮻� �����ȴ�!!
	
	//�����ں�
	
	
	
	//�޼ҵ��
	public void insert(Desktop d) {  //Desktop d = new Desktop(~~~~);
		desk = d;
	}
	
	public void insert(NoteBook n) { //NoteBook n = new NoteBook(~~~~~);
		note = n;
	}
	
	public void insert(Tablet t) { //Tablet t = new Tablet(~~~~~~~);
		tab = t;
	}
	
	// ���� 3���� �޼ҵ�� '�����ε�'�� ����� ������!!
	
	public Desktop selectDesktop() {
		return desk;
	}
	
	public NoteBook selectNoteBook() {
		return note;
	}
	
	public Tablet selectTablet() {
		return tab;
	}
	
	
	
	
	
	
	
}
