package com.kh.chap02_objectArray.run;

import java.util.Scanner;

import com.kh.chap02_objectArray.model.vo.Phone;

public class ObjectArrayRun {

	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		//for loop��
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		Phone[] phones = new Phone[3];
		/*
		System.out.println(phones);   
		System.out.println(phones[0]);  //null
		phones[0].setName("������");      //NullPointerException   
		*/
		
		phones[0] = new Phone();
		phones[1] = new Phone("���̻�", "���", 1300000, "11pro");
		phones[2] = new Phone("���ϼ�", "����", 1200000, "s20");
		
		//���߿� phones[0]�� ���� ���ʹٸ�?
		phones[0].setName("������");
		phones[0].setBrand("����");
		phones[0].setPrice(1000000);
		phones[0].setSeries("1");
		
		int total = 0;
		for(int i=0;i<phones.length;i++) {
			System.out.println(phones[i].information());
			total += phones[i].getPrice();
		}
		
		System.out.println("�� ���� : " + total + "��");
		System.out.println("��հ� : " + total / phones.length + "��");
		
		
		
		// ����ڿ��� �����ϰ����ϴ� �ڵ������� �Է¹޾� �ش� �ڵ����� ã�� �Ŀ� �� ������ �˷��ֵ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ��� �ϴ� �ڵ��� �Է� : ");
		String buy = sc.nextLine();
		
		for(int i=0;i<phones.length;i++) {
			if(phones[i].getName().equals(buy)) {
				System.out.println("����� �����ϰ��� �ϴ� �ڵ����� ���� " + phones[i].getPrice() + "�� �Դϴ�.");
			}
		}
		
		
		
	}

}
