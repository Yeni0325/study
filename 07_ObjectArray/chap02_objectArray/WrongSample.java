package com.kh.chap02_objectArray.run;

import com.kh.chap02_objectArray.model.vo.Phone;

public class WrongSample {

	public static void main(String[] args) {
		
		Phone[] arr = new Phone[3];
		
		//--- 1�� ������ ��ġ���� ---
		arr[0] = new Phone();
		arr[1] = new Phone();
		arr[2] = new Phone();
		//---------------------
		
		//for(int i=0; i<=arr.length; i++) {
		//--- 2�� ������ ��ġ ����---
		for(int i=0; i<arr.length; i++) {
		//---------------------
			System.out.println(arr[i].getName());
		}
		
		//�߻��ϴ� ����
		//1. NullPointerException
		//i�� ������ �ε������� for�� ��ü�� �����߾�����ϳ� ���� ��ü �迭�� �� �ε����� ��� ���� null�� ���¿��� �ش� �޼ҵ带 ȣ���Ϸ��� �߱� ������
		// => ��ü �迭�� ���� �� �� �ε������� ��ü ������ �����ؾߵ�
		
		//2. ArrayIndexOutOfBoundsException
		// �������� ������ �������� �� �߻��ϴ� ���� , �ε����� ������ ����� �� �߻��ϴ� ����
		// ���ǽ����� 'i<=�迭�� ����' ��� ���õǾ��־��� ������ �迭�� ������ �ε������� ū ���� ���õǾ���.
		// ��ġ ���� => ���ǽ� ���� => i < �迭�� ����
		
		
		
		
	}

}
