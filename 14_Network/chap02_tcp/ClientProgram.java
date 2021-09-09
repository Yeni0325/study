package com.kh.chap02_tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientProgram {
	
	//Ŭ���̾�Ʈ�� ���α׷�
	public static void main(String[] args) {
		
		// ���� ���� �����ϰ����ϴ� ������ IP�ּҰ� �ʿ� => �� pc�� ip�ּ�
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null; //�Է¿� ������Ʈ��
		PrintWriter pw = null; //��¿� ������Ʈ��
		
		Socket socket = null;
		
		// ��û�ϰ��� �ϴ� ���� IP : 192.168.35.79
		// ��Ʈ��ȣ : 3000
		
		int port = 3000;
		String serverIP; //��û�ϰ��� �ϴ� ���� ����
		
		try {
			serverIP = "192.168.35.79";
			
			// 1) ������ ���� ��û ������ ���� (��û�ϰ��� �ϴ� ������ IP�ּҿ� ������ ��Ʈ��ȣ�� �����ϸ鼭 ���� ��ü ����)
			socket = new Socket(serverIP, port); 
			// ���� �ش缭���� �������̶�� �����û�� �������� �� ���� ���������� �����ϰ� �ȴ�.
			// serverIP���� ���� ���� �����û�ϰ����ϴ� IP��ȣ��, port���� �����û�ϰ��� �ϴ� ��Ʈ��ȣ�� ����� ����
			// ���� ������ �������� �ƴϰų�, ���� IP�ּҿ� ��Ʈ��ȣ�� �߸� �������� ��� => ��Ž��� => null���� socket�� ���
			
			if(socket != null) { // ������ �� ����������
				
				System.out.println("������ ���� ����!!");
				
				//������ ���ῡ �����߱� ������ �����͸� ������ϰ��� �Ѵٸ� ������ ������ ��Ʈ���� �������� �Ѵ�.
				// 2) ������ ������ϴ� ��ݽ�Ʈ�� ����
				// 3) ������Ʈ���� ���ؼ� ���� ����
				
				// �Է¿� ��Ʈ�� (�����κ��� ���޵� �����͸� ���� ������ �о���̴� �Է¿� ��Ʈ��)
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//1. socket.getInputStream() : �����κ��� ���� �о���̴� �Է¿뽺Ʈ���� ��������� �޼ҵ�� �����κ��� ���� �Է¹ޱ� ���� ����Ʈ��Ʈ��
				//2. InputStreamReader() : ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �ٲ��� �� �ִ� ������Ʈ�� ����, ������Ʈ�� ���� �� ��ݽ�Ʈ���� �����ϸ鼭 ����!!
				//3. BufferedReader() : �� �� ������ �Է��� �� �ִ� ���ں�����Ʈ�� ����(BufferedReader()��ü ���� �� new InputStreamReader()��ü�� �ӵ��� ����Ŵ)
				
				// ��¿� ��Ʈ�� (�������� ���� ���ٴ����� ������ �� �ִ� ��¿� ��Ʈ��)
				pw = new PrintWriter(socket.getOutputStream());
				//1. socket.getOutputStream() : Ŭ���̾�Ʈ�� ���� ��¹ޱ� ���� ����Ʈ��Ʈ�� ����
				//2. PrintWriter() : ������ ����� �� print(), println() �޼ҵ带 ������ �ִ� 2����Ʈ�� ��¹��� �� �ִ� ������Ʈ��
				//                   println()�޼ҵ� ȣ�� �� ������ �����͸� �����ϸ� �ش� �������� ����ó���� �������ν� ���� ������ ��� ����!
				//                   �� ���� ��� �� �ڵ����� �ٹٲޱ��� ���ִ� ������Ʈ����
				//                   ��� �� BufferedWriter()�� Ȱ���� ��� ����ҵ����͸� ����� �ǰ�, ������ �ְ����Ҷ��� �Ź� newLine�� �̿��ؾ��Ѵ�.
				
				while(true) {
					
					//���� Ŭ���̾�Ʈ�� ������ �� �ְԲ� ��� ����!
					//�������� ���� ���� �Է¹޾Ƽ� ���
					// 4) ��Ʈ�� ���� ���
					System.out.print("�������� ���� ���� : ");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage);
					// pw.println() : pw��� printWriter��ü�� ���ٴ����� �޼ҵ带 ����ϰ� �ٹٲޱ��� ���Բ� �ϴ� print()��� ��¿�޼ҵ带 Ȱ���� Ŭ���̾�Ʈ���� ���
					pw.flush(); // �ۼ����ϸ� ������ ������ü�� �ȵ�
					//���� ��Ʈ��(���)�� �ִ� �����͸� ������ �������� �޼ҵ� (close�޼ҵ� ȣ��Ǹ� �ڵ����� flush����)
					
					//�������� ���������͸� �Է�
					// 5) ��Ʈ�� ���ؼ� �Է�
					String message = br.readLine();
					//br.readLine() : �Է¿� ��Ʈ���� ���޵� �����Ͱ� ���� ��� ���ٷ� �о����
					System.out.println("�����κ��� ���޹��� �޼��� : " + message);
					
				}
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				// 6) ��� ����
				pw.close(); //��¿뽺Ʈ�� �ݳ�
				br.close(); //�Է¿뽺Ʈ�� �ݳ�
				
				//��Ʈ���� �� ���� �ݳ��ϴ� �� ó�� ServerSocket��ü�� ������ �� ������ �ݾ�����Ѵ�.
				socket.close(); //������ ����� ���ϰ�ü ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// �׽�Ʈ �� ������ �������� ���� ������ �Ǿ��Ѵ�!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
