package com.kh.chap02_abstractAndInterface.part01_easy.model.vo;

public abstract class Sports {
	
	//�ʵ��
	private int people;
	
	//�����ں�
	public Sports() {
		
	}
	
	public Sports(int people) {
		this.people = people;
	}
	
	//�޼ҵ��
	public void setPeople(int people) {
		this.people = people;
	}
	
	public int getPeople() {
		return people;
	}
	
	public String toString() {
		return "people : " + people;
	}
	
	//�߻�޼ҵ�(abstract) : �Ӹ��θ� �ۼ��ϰ� ����δ� �ۼ����� ���� �̿ϼ��� �޼ҵ�
	public abstract void rule(); //�ۼ� �� �޼ҵ�� ��� Ŭ�����κп� 'abstract'�� �ۼ��ؾ��Ѵ�!
	//������ �̿ϼ��� �κ��� ��ӹ޴� �ڽ�Ŭ�������� �ϼ���Ű�� �ȴ�!
	// ���?? �������̵��� ���ؼ�!
	
	//�θ�Ŭ������ �̿ϼ��� �߻�޼ҵ带 �θ�, �ڽ�Ŭ������ ���������� �������̵��� ���� �ش� �޼ҵ带 �ϼ�������� �Ѵ�. 
	//�߻�Ŭ���� : �߻�޼ҵ尡 �����ϴ� Ŭ����
}
