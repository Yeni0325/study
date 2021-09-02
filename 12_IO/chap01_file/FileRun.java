package com.kh.chap01_file.run;

import java.io.File;
import java.io.IOException;

public class FileRun {

	public static void main(String[] args) {
		
		// �����ϰ� ����(file)�� ��������� ����
		// java.io.File Ŭ������ �̿��ؼ� 
		
		// test.txt��� ������ ������
		// �켱, ��������� ���� �ʰ� ������
		
		//1.��������� ���� ���� ���� ���·� ���� ���� => ���� project ������ ���� ���� => �۾�Ž���� 
		try {
			//��ü ����
			File f1 = new File("test.txt"); //�Ű������� � ������ ����� ������ ����
			f1.createNewFile(); //�޼ҵ���� �����ؾ߸� ���� ������ �������!!
			
		//2. �����ϴ� ������ ���� ���� => �ش� ��α��� �����ϸ� ��(�������� �ʴ� ���� �ۼ�x)	
			File f2 = new File("D:\\test.txt"); //�������� �ʴ� ��� ���� �� IOException �߻�
			f2.createNewFile();
			
			//File f3 = new File("D:\\temp\\test.txt"); //�������� ���� ������ �������� �� ã�� ���ϸ鼭 IOException �߻�
			//f3.createNewFile();
		
	    //3. ���� ���� ����� ���ϱ��� ��������� �ϱ�
			File tempFolder = new File("D:\\temp");
			tempFolder.mkdir(); // ������ ����������ϴ� �޼ҵ�
			
			File f3 = new File("D:\\temp\\test.txt");
			f3.createNewFile();
			
			System.out.println(f1.exists()); // f1.exists() => ������ �����ϸ� true, �������� ������ false�� ��ȯ�ϴ� �޼ҵ�
			System.out.println(new File("ttt.txt").exists()); // => ���ϻ����� createNewFile���� �Բ� ȣ��������ϱ� ������ �ش� ������ �������� �ʴ´�. => false���
			
			System.out.println(f1.isFile()); // f1.isFile() => ������ ������ true, ������ �ƴϸ� false�� ��ȯ�ϴ� �޼ҵ�
			System.out.println(tempFolder.isFile());
			
			//--------------------------------------------------
			
			File folder = new File("parent");//������ ��������� ���߱� ������ ���� project�������� ����
			folder.mkdir();
			
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("���ϸ� : " + file.getName());
			System.out.println("������ : " + file.getAbsolutePath());
			System.out.println("���Ͽ뷮 : " + file.length());
			System.out.println("�������� : " + file.getParent());
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("���α׷��� �����մϴ�.");
		
		
	}
	
	//�޸𸮿����� �ֹ߼��̱� ������ ���α׷��� ����Ǹ� �� �� ����� => ���� ���� � �����͸� ���������� �����ϰ��� �Ѵٸ� �ܺθ�ü�� �����ؾ��Ѵ�!
	
	//�ܺθ�ü�� ���� �����͸� �Է��ϰų�, ����ϴ� ���
	
	/*
	 * ���α׷� ���� �����͸� �ܺθ�ü�� ����Ѵٰų� �Ǵ� �ܺθ�ü�κ��� �Է��� �޾ƿò���!!
	 * �ݵ�� �� �ܺθ�ü�� �������� ��θ� ���� �������Ѵ�. => �� ��θ� �ٷ� '��Ʈ��'�̶�� �Ѵ�.
	 * 
	 * * ��Ʈ��(���)�� Ư¡ (�����͸� �ְ���� �� �ִ� ���)
	 * - �ܹ��� : �Է��̸� �Է� / ����̸� ��¸� ����!
	 *          => �Է°� ����� ���ôٹ������� �ϰ��� �Ѵٸ�? => �Է¿뽺Ʈ��/��¿뽺Ʈ�� ���� ����ߵ�!
	 * - ���Լ���(FIFO) : ��ΰ� ������ ���� �����̱� ������ ���� ���� ���� ���� ����!! 
	 * - �ð�����(delay)��� ������ ���� �� ���� ! => ���ʿ� �ִ� �����Ͱ� ������ ���ʿ� �ִ� �����Ͱ� ���� �� �ֱ� ����)
	 * 
	 * 
	 * * ��Ʈ���� ����
	 * 1. ����� ������ (1byte¥�� / 2byte¥��)
	 *  - ����Ʈ ��Ʈ�� : 1byte¥���� �Դ� ���� �� �� ���� ������ ������(�������) => �Է¿뽺Ʈ��(InputStream) / ��¿뽺Ʈ��(OutputStream)
	 *  - ���� ��Ʈ�� : 2byte¥���� �Դ� ���� �� �� ���� ������ ������(���� ���)  => �Է¿뽺Ʈ��(Reader) / ��¿뽺Ʈ��(Writter)	
	 *  	
	 * 2. �ܺθ�ü�� �������� ����
	 *  - ��� ��Ʈ�� : �ܺ� ��ü�� ���������� ����Ǵ� ���(�ʼ������� �����ؾ���, ������ �ټ� ����)
	 *  - ���� ��Ʈ�� : �� �״�� ���� ���Ҹ� �ϴ� ���(�ӵ��� ������ �Ѵٰų�, �׿ܿ� ������ ��ɵ��� �����ϴ�..)
	 *              ������Ʈ���� �ܵ� ��� �Ұ�!, ��ݽ�Ʈ���� �ݵ�� �⺻������ �־���Ѵ�!
	 */


}
