package com.kh.chap01_poly.part01_basic.model.vo;

public class Child1 extends Parent {
	
	//�ʵ��
	private int z;

	//�����ں�
	public Child1() {
		//super();�����Ǿ� ����
		//�θ� Ŭ������ �⺻�����ڸ� �������� ����
		// ���� �⺻�����ڸ� �׻� �ݵ�� �����ؾ� �ϴ� ������ �� ���⿡ ���� => ���� �ش� Ŭ������ ��ӱ����� �� �� �𸣱� ������!
	}
	
	public Child1(int x, int y, int z) {
		super(x, y);  //�θ� ������ ȣ��
		this.z = z;
	}
	
	//�޼ҵ��
	public void setZ(int z) {
		this.z = z;
	}
	
	public int getZ() {
		return z;
	}
	
	public void printChild1() {
		System.out.println("�� ù��° �ڽ��̾�");
	}
	
	@Override
	public void print() {
		System.out.println("�� ù��° �ڽ��̾�");
	}
	
	
	
	
	
}
