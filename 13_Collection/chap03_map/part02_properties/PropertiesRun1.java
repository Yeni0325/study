package com.kh.chap03_map.part02_properties.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

//���
public class PropertiesRun1 {

	public static void main(String[] args) {
		
		// Properties : Map�迭�� �÷���. ���� ���� ���� �� key+value ��Ʈ�� �����ؾ��Ѵ�.
		// HashMap���� ������ : Properties���� key���� String, value���� String���� ����!
		
		Properties prop = new Properties();
		
		/*
		// Map �迭�̱� ������ HashMap�� ������ put()�޼ҵ带 �̿��ؼ� key + value ��Ʈ ��Ⱑ �����ϴ�.
		prop.put("������", new Snack("���ڸ�", 1500));
		prop.put("�����", new Snack("§��", 700));
		
		System.out.println(prop);
		
		// Map �迭�̱� ������ get()�޼ҵ带 ���� key���� �����ϸ� value���� �����ش�.
		System.out.println(prop.get("������"));
		
		// ������ Properties�� ����ϴ� ���� �ַ� Properties�� ��� �͵��� ���Ϸ� ��� �Ǵ� �Է¹޾� �� �� �����!
		// ��, Properties���� �����ϴ� store(), load() �޼ҵ带 ����ϱ� ���ؼ� 
		
		//���� prop���� key������ String�迭, value������ Snack�迭�� ����� �ִ�. 
		
		try {
			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			// Properies.store(����Ͽ� ���������� �����Ұ���, ������ ����� ���� ���ڿ�) : store�� �����ϴ� �޼ҵ��̱� ������ �� 
			// ������ ������� ��� ���� ��� ���ܰ� �߻����� �𸣱� ������ "����ó��"�� ��������� �Ѵ�.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
		// �� ClassCastException ���� �߻� : ���������� Store() ���� �� Properties�� ����ִ� key+value ��Ʈ�� String���� ����ȯ�ؼ� ����ϰ� �Ǵµ�, SnackŬ������  StringŬ������ ����ȯ�� �� ���� ������ �߻��ϴ� ����
		
		// Properties key+value��Ʈ�� �߰��� ��
		// 1. setProperty(String key, String value) => key���� String, value���� String������ ����� �� ��
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		//Map�� Ư¡�� value���� �ߺ��ǵ� ���������, key���� �ߺ��Ǵ� ���� value���� ��������� �� Ȯ�� ����!, ���� ���� ���� �ȵǴ� �� Ȯ�� ����!
		
		
		// 2. getProperty(String key) : String => key���� �����ϸ� �׿� �ش��ϴ� value���� ��ȯ���ִ� �޼ҵ�
		System.out.println(prop.getProperty("List"));
		System.out.println(prop.getProperty("�����")); //�������� �ʴ� key���� �����ϸ� null���� ��ȯ���ش�.
		
		try {
			//3. store(OutputStream os, String comments) : Properties�� ����ִ� key-value ������ ���Ϸ� ���(���������� �� String���� ��ȯ)
			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			
			//4. storeToXML(OutputStream os, String comments)
			prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
