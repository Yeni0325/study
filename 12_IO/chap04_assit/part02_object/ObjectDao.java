package com.kh.chap04_assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

//��ü ��ü�� ��°�� ���/�Է��ϱ�
public class ObjectDao {
	
	//���α׷�(�ڹ��ڵ�, �޸�) --> �ܺθ�ü (����) (��� : ���α׷� ���� �����͸� ���Ϸ� ��������, �� ���Ϸ� ����)
	public void fileSave() {
		
		//����� ������ (Phone ��ü)
		Phone ph = new Phone("������", 1300000);
		
		//Phone��ü ��ü�� ��°�� ����ϰ��� �Ҷ��� ��ݽ�Ʈ�������δ� �Ұ��ϴ�.������ ��ü������ ������� �� �ִ� ������Ʈ���� �ʿ��ϴ�.
		//��ü������ ������� �� �ִ� ������Ʈ���� ObjectOutputStream, ObjectInputStream�� ����
		
		// FileOutputStream : ���ϰ� ���������� �����ؼ� 1byte ������ �����͸� ����� �� �ִ� ��Ʈ��
		// ObjectOutputStream : ��ü ������ ����� �� �ֵ��� ������ �ִ� ������Ʈ��(ObjectWriter�� ����x)
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d_phone.txt"))){
			
			oos.writeObject(ph);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//���α׷�(�ڹ��ڵ�, �޸�) <-- �ܺθ�ü (����) (�Է� : ���Ϸκ��� ������ ��������)
	public void fileRead() {
		
		// FileIutputStream : ���ϰ� ���������� �����ؼ� 1byte ������ �����͸� �Է¹��� �� �ִ� ��Ʈ��
		// ObjectIutputStream : ��ü ������ �Է¹��� �� �ְ� ������ �ִ� ������Ʈ��(ObjectReader�� ����x)
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_phone.txt"))){
			
			Phone ph = (Phone)ois.readObject();
			System.out.println(ph);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
