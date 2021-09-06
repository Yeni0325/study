package com.kh.chap02_abstractAndInterface.part02_basic.model.vo;
//                                   '�����ϴ�'
public class Mother extends Person implements Basic{
	
	// * Ŭ������ Ŭ�������� ���߻���� �Ұ��������� �������̽��� ���߻���� �������Ѿ��� �����ϴ�!!
	
	private String babyBirth; // ������ ź�� : ��� | �Ծ� | ����
	
	//�⺻ ������
	public Mother() {
		
	}
	
	//�Ű����� ������
	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
	}
	
	//setter / getter
	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}
	
	public String getBabyBirth() {
		return babyBirth;
	}
	
	//toString
	@Override
	public String toString() {
		return "Mother [" + super.toString() + ", babyBirth : " + babyBirth + "]";
	}

	@Override
	public void eat() {
		// ������� ���� �����Կ� 10 ����
		super.setWeight(super.getWeight() + 10);  // ������ ���� �����Ұǵ� , ������ �����Կ� + 10������ ��
		// ������� �ǰ����� 10 ����
		super.setHealth(super.getHealth() - 10); // �ǰ����� �����Ұǵ�, ������ �ǰ����� -10 ������ ��
	}

	@Override
	public void sleep() {
		// ���ڸ� �ǰ��� 20����
		super.setHealth(super.getHealth() + 20); // �ǰ����� �����Ұǵ� , ������ �ǰ����� +20 ������ ��
	}
	
	

}
