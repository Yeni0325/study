package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.mode.vo.Electronic;

//다형성 적용했을 때의 예시
public class ElectronicShop2 {
	
	//용산 전자상가에 있는 가계
	
	//필드부
	private Electronic[] elec = new Electronic[3];
	private int count = 0;
	//부모타입 배열로 모든 자식 객체 다루기
	
	
	public void insert(Electronic any) {
		elec[count++] = any;
	}
	
	public Electronic select(int index) {
		return elec[index];
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
