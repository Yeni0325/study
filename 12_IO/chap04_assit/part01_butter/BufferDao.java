package com.kh.chap04_assist.part01_buffer.model.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDao {
	
	/*
	 * ������Ʈ�� : ��ݽ�Ʈ������ �����ߴ� ������ ���� ��� �����ִ� ��Ʈ��
	 *          ��ݽ�Ʈ������ �������� �ʴ� �߰����� �޼ҵ� ���� / ������ ���� �ӵ� ��� ��Ų�ٰų� ���
	 *    >> �ܺ� ��ü�� ���������� ����Ǵ� ��Ʈ���� �ƴ�!
	 *       �ܵ� ��� �Ұ� (�ݵ�� ��� ��Ʈ���� �Բ� ���)
	 */
	
	
	//���α׷�(�ڹ��ڵ�, �޸�) --> �ܺθ�ü (����) (��� : ���α׷� ���� �����͸� ���Ϸ� ��������, �� ���Ϸ� ����)
	public void fileSave() {
		
		//FileWriter : ���ϰ� ���������� �����ؼ� 2byte ������ �����͸� ����� �� �ִ� ��Ʈ��
		//BufferedWriter : ���۶�� ������ �������ִ� ������Ʈ�� (�ӵ� ��� ����)
		
		//1. ��ݽ�Ʈ�� ���� ����
		//FileWriter fw = new FileWriter("c_buffer.txt");
		//2. ������Ʈ�� ����
		//   ������Ʈ�� ���� �� ��ݽ�Ʈ�� ��ü�� �����ϸ鼭 ����(� ��ݽ�Ʈ���� ����ų����)
		//BufferedWriter bw = new BufferedWriter(fw);
		
		//���� �� ���� ���ٷ� �ۼ�
		/*
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			
			//wrtie �޼ҵ� �̿��ؼ� ������ ���
			bw.write("�ȳ��ϼ���\n");
			bw.write("�ݰ����ϴ�.");
			bw.newLine(); // �ٹٲ��� �־��ִ� �޼ҵ� => BufferedWriter�� ��� ����!
			bw.write("����������");
			//���۶�� ������ ��� �׾Ƴ��ٰ� �ѹ��� ������� => �ӵ� ��� ����.
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// try~with~resource �������� �ڿ� �ݳ����� �� �����ϰ� �۾��� �� ����
		// jdk7���� �̻���� ��밡��
		/*
		 * try(try�������� ����� ��Ʈ����ü ���� ����){ // �˾Ƽ� try �� ������ �ش� ��Ʈ�� �ݳ����� ����
		 * 
		 * } catch(����Ŭ���� e){
		 * 
		 * }
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))){
			bw.write("�ȳ��ϼ���\n");
			bw.write("�ݰ����ϴ�.");
			bw.newLine(); // �ٹٲ��� �־��ִ� �޼ҵ� => BufferedWriter�� ��� ����!
			bw.write("����������");
			
		} catch (IOException e) {
			e.printStackTrace();
		} //�ڿ� �ݳ� ���� �Ƚᵵ��! �ڵ����� �ݳ����� ���ٰ���
		
		
	}
	
	
	
}
