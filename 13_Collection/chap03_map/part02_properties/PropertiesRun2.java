package com.kh.chap03_map.part02_properties.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun2 {
	
	
	//�Է�
	public static void main(String[] args) {
		
		Properties prop = new Properties(); //�������!
		
		try {
			//5. load(InputStream is)
			//prop.load(new FileInputStream("test.properties"));
			
			//6. loadFromXML(InputStream is)
			prop.loadFromXML(new FileInputStream("test.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		
		/*
		 * * .properties������ ����ϴ� ���
		 *    ���α׷��� �ʿ��� �⺻ ȯ�漳�� (������ ip�ּ�, dbms���..)������ ������ ����Ҳ���!!
		 * 	  => ��� ���ڿ��̱� ������ �����ڰ� �ƴ� �Ϲ��� �����ڰ� �ش� ������ �ľ��ؼ� �����ϱ� ����!
		 * 
		 * * .xml ������ Ư¡
		 *    ���α׷��� ���鰣�� �־ ȣȯ�� ����!
		 *    
		 */
		
		
		
	}

}
