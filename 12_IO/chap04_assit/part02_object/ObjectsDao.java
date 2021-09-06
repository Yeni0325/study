package com.kh.chap04_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectsDao {
	
	//���α׷�(�ڹ��ڵ�, �޸�) --> �ܺθ�ü (����) (��� : ���α׷� ���� �����͸� ���Ϸ� ��������, �� ���Ϸ� ����)
	public void fileSave() {
		
		Phone[] arr = new Phone[3];
		arr[0] = new Phone("������", 1200000);
		arr[1] = new Phone("������", 1300000);
		arr[2] = new Phone("�ø�", 1500000);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_phones.txt"))){
			
			for(int i=0; i<arr.length; i++) {
				
				oos.writeObject(arr[i]);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//���α׷�(�ڹ��ڵ�, �޸�) <-- �ܺθ�ü (����) (�Է� : ���Ϸκ��� ������ ��������)
	public void fileRead() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_phones.txt"))){
			
			//��ü �迭�� ���������� �Է��ؿö��� �迭�� ����� ����.
			//������ read�޼ҵ�� �Է½� ������ ���� ������ ���� '-1'���
			//readLine�޼ҵ�� ������ ���� �����¼��� 'null'�� ���
			//�� ���� �����Ͱ� �ִ��� �𸣱� ������ �ݺ����� Ȱ���ؾ��Ѵ�.
			
			/*
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			
			System.out.println(ois.readObject()); //������ ���� ������ ���� EOFException => End of Exception ���ܹ߻�
			*/
			//EOFExcepiton�� �θ�� IOException�̱� ������  IOException������ ����ä���� � �κ��� ���ܰ� �߻��ߴ��� ��ô�ؼ� �˷���
			
			while(true) {
				System.out.println(ois.readObject());
			}
			//� ���� �����شٸ� �ش� ������ ������ �ۼ��� �� ������ ���� ���� �������� �ʰ� EOFException ���ܸ� �߻��߱� ������
			//���ѹݺ��� �������� ������ ������ ���� ������ ���� EOFException catch���� ������ �ǰ� ������ ���������� �ȴ�.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("������ �� �о�鿴���ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("���α׷��� ����˴ϴ�.");
	}
	
	
	

}
