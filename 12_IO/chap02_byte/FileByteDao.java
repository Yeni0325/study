package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//dao(Data Access Object) : �����Ϳ� ���������� ����

public class FileByteDao {
	
	/*
	 * "����Ʈ ��� ��Ʈ��" ������ ������ ������غ���!!
	 * 
	 * - ����Ʈ ��Ʈ�� : �����͸� 1����Ʈ ������ �����ϴ� ���(���� ���.. 1����Ʈ�� �ѱ��� ����)
	 * - ��� ��Ʈ�� : �ܺθ�ü�� ���������� ����Ǵ� ���
	 * 
	 * 
	 * XXXInputStream : XXX��ü�κ��� �����͸� �Է¹޴� ��� (�ܺθ�ü�κ��� �����͸� �о���ڴ�)
	 * XXXOuputStream : XXX��ü�� �����͸� ����ϴ� ��� (�ܺθ�ü�� �����͸� �������ڴ�)
	 * 
	 */
	
	//���α׷�(�ڹ��ڵ�, �޸�) --> �ܺθ�ü (����) (��� : ���α׷� ���� �����͸� ���Ϸ� ��������, �� ���Ϸ� ����)
	public void fileSave() {
		
		//FileOutputStream : ���ϰ� ���������� �����ؼ� 1����Ʈ ������ �����͸� ����ϴ� ��Ʈ��
		
		//1. ��Ʈ�� ���� (��� �����)
		//2. ��Ʈ������ �����͸� ��� (�޼ҵ� Ȱ��)
		//3. �� ����� �� ��Ʈ�� �ݳ�
		
		FileOutputStream fout = null;
		try {
			//1. FileOutputStream ��ü ���� => �ش� ���ϰ��� ������� ����
			/*
			 * true �� �ۼ��� => �ش� ������ ������ ��� ������ �����Ͱ� ���������(�⺻���� false)
			 * true �ۼ� �� => �ش� ������ ������ ��� ������ �����Ϳ� �̾ �ۼ��ȴ�
			 */
			fout = new FileOutputStream("a_byte.txt"/*, true*/); // => '( )' �ȿ��� � ���ϰ� �����Ұ��� �ۼ� 
			//FileOutputStream ��ü ���� �� �ش� ������ �������� �ʴ´ٸ� ������ ���� ������ְ� �ش� ���ϰ��� ������θ� �������ش�
			
			//2. ���Ͽ� �����͸� ����ϰ��� �� �� write �޼ҵ� ���
			//   ���ڸ� ����ϴ� ���ڸ� ����ϴ� �ǻ� ���Ͽ� ��ϵǴ°� ���ڷ� ��ϵȴ�.(�ƽ�Ű �ڵ�ǥ ����)
			//   ����(0~127)
			fout.write(97);   // 97�� �ش��ϴ� 'a'���ڰ� ���� => int�� char�� �ڵ�����ȯ�� �����ϱ� ������
			fout.write('b');  //           'b'���ڰ� ����
			//fout.write('��');  // 2����Ʈ¥�� �ѱ��� 1����Ʈ�� �����ϰԵ� ��� ������ ����ȴ� => ����Ʈ��Ʈ�����δ� ������ ����
			
			byte[] arr = {99, 100, 101}; 
			fout.write(arr);   // 0�� �ε������� �������ε������� ���������� �����Ͱ� ����� �ȴ�.
			                   // �ش� ���ڿ� �ش��ϴ� ���ڰ� ���� (cde)
			
			//write(byte[] b, int off, int len) : byte�迭�� off�ε������� len ������ŭ ���
			fout.write(arr, 1, 2);  // de ���ڰ� ����
			
			//3. ��Ʈ�� �� �̿������� �ݳ��ϱ�! (�ݵ��!)
			// fout.close(); //������ write() �޼ҵ� ���� �� IOException�� �߻��� ��� => �ش� catch���� �����ϰ� try~catch���� ���������� ������ �ݳ��ϴ� �ڵ�� ����X
			                 //�߰��� � ���ܰ� �߻��ϴ� ������ �����Ű���� �ϴ� ������ �����Ѵٸ� �������� 'finally'�� �ȿ� �ۼ����ش�.
			
		} catch (FileNotFoundException e) {//�������� �ʴ� ��θ� ���� �� �߻��� �� ����
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //�� �ȿ� �ۼ��� �ڵ�� � ���ܰ� �߻��ϴ����� �������� ������ �����ϰ� ������������!
			
			
			try {
				//3. ��Ʈ�� �� �̿������� �ݳ��ϱ�! (�ݵ��!)
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//���α׷�(�ڹ��ڵ�, �޸�) <-- �ܺθ�ü (����) (�Է� : ���Ϸκ��� ������ ��������)
	public void fileRead() {
		
		//FileInputStream : ���Ϸκ��� �����͸� 1����Ʈ �ܵڷ� �Է¹޴� ��Ʈ��
		
		//1. ��Ʈ������ (��� �����)
		//2. ��Ʈ�� ���ؼ� �Է¹޾ƿ� (�޼ҵ� Ȱ��)
		//3. ����� ���� ��Ʈ�� �ݳ�
		
		FileInputStream fin = null;
		try {
			
			//1. FileInputStream ��ü ���� => �ش� ���ϰ� ������� �������
			fin = new FileInputStream("a_byte.txt"); //���� �ش� ������ �������� ������� ������ FileNotFoundException �߻�
			
			//2. ���Ϸκ��� �����͸� �о���̰��� �� �� read �޼ҵ� ���
			//   1byte������ �ϳ��� �о�� => ������ int��(������)���� ��ȯ
			
			// ������ ���Ͽ� �󸶸�ŭ�� �����Ͱ� �ִ��� �𸦰��? => �ݺ��� Ȱ�� ����
			/*
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			
			System.out.println(fin.read()); // ������ ���� ������ ���� '-1'�� �޾ƿ´�.
			System.out.println(fin.read());
			*/
			
			/* �ݺ��� ����� �Ź� read() �޼ҵ尡 �ι��� ����Ǳ� ������ �幮�幮 �о�鿩���� => �߸���
			while(fin.read() != -1) { //�о���� ���� -1�� �ƴ� ��쿡�� �ݺ������� ����ǵ���
				System.out.println(fin.read());
			}
			*/
			
			// read()ȣ���� �ݺ��� ���� �� �Ź� �ѹ��� ����ǵ���
			// �ذ���1. �켱 ���ѹݺ��� �������� �Ź� ���ǰ˻縦 �����ϴ� ���
			/*
			while(true) {
				int value = fin.read();
				if(value == -1) {
					break;
				}
				System.out.println(value);
			}
			*/
			
			//�ذ���2. ������
			int value = 0;
			while((value = fin.read()) != -1) { //�о���� ���� -1�� �ƴ� ��쿡�� �ݺ������� ����ǵ���
				System.out.println((char)value);
			}
			
			
			
			
		} catch (FileNotFoundException e) { //������ �������� ������ ���� �߻�
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{

			try {
				//3. �� ����� ��Ʈ�� �ݳ�
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
