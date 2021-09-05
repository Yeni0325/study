package com.kh.chap02_objectArray.run;

import java.util.Scanner;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ArrayForEach {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30};
		
		//for each�� (���� for�� /������ for��)
		//���±��� �ʱ��, ���ǽ�, �������� ���� �ܼ��� for������ ���� for��
		//�迭 �Ǵ� �÷��ǰ� �Բ� ����
		//���� ���� �ǳ�? �迭 �Ǵ� �÷����� 0�� �ε������� ������ �ε������� ���������� ��� ������ ������ �� ���
		/*
		 * for(���������� ������ ���� ���� ���� ���� : ���������� ������ �迭 Ȥ�� �÷���) {// �ݺ� Ƚ�� == �迭 �Ǵ� �÷����� ũ��
		 *       �� ���������� ������ �迭�� 0���ε���, 1���ε����� ���� ������ ����.
		 * }
		 */
		
		//      int  int[]
		for(int value:arr) { //�������� �ݺ����� �� �� ���� arr[0]�� ��, arr[1]�� ��, arr[2]���� ������ ���� �ȴ�.
			        // arr�� ������ 10, 20, 30, ��, �������̱� ������ int �ڷ����� ������ �����ؾ� �Ѵ�.
			System.out.println(value);
		}
		
		//0�� �ε������� ������ �ε��������� ���� ���� ���� ǥ���� �� �ִ�. 
		
		Phone[] phones = new Phone[3];
		
		phones[0] = new Phone("������", "�Ｚ", 1500000, "��Ʈ20");
		phones[1] = new Phone("������", "����", 1300000, "11����");
		phones[2] = new Phone("������", "����", 900000, "����");
		
		phones[2].setSeries("1");
		
		int total=0;
		//phones�迭�� �ڷ����� Phone�̱� ������ Phone�ڷ����� ���� p�� ����!!
		for(Phone p:phones) {//�ݺ����� �������� phones�� 0��, 1��, 2�� �ε����� ���� ������ ����.
			System.out.println(p.information());
			//�ݺ����� �� ������ 0�� �ε����� ��� information
			//            2�� �ε����� ��� information�� ���� �ȴ�.
			total += p.getPrice();
			//�ݺ����� �� ������ 0,1,2�� �ε����� ��� getPice���� total�� �������� �ȴ�. 
		}
		//���������� p��� �������� �� ��ü�� �ּҰ��� ���� �ȴ�. �ּҰ��� ���� �Ǹ鼭 phones �迭�� ���� �������� �� �� �ְԵȴ�.
		
		
		System.out.println("���հ�  : " + total + "��");
		System.out.println("��հ� : " + total / phones.length + "��");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����ϰ��� �ϴ� �ڵ��� : ");
		String buy = sc.nextLine();
		
		for(Phone p:phones) {
			if(p.getName().equals(buy)) {
				System.out.println("���� : " + p.getPrice() + "��");
			}
		}
		
		
		
		
	}

}
