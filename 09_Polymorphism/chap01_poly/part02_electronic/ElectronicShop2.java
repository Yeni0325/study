package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.mode.vo.Electronic;

//������ �������� ���� ����
public class ElectronicShop2 {
	
	//��� ���ڻ󰡿� �ִ� ����
	
	//�ʵ��
	private Electronic[] elec = new Electronic[3];
	private int count = 0;
	//�θ�Ÿ�� �迭�� ��� �ڽ� ��ü �ٷ��
	
	
	public void insert(Electronic any) {
		elec[count++] = any;
	}
	
	public Electronic select(int index) {
		return elec[index];
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
