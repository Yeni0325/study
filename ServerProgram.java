package com.kh.chap02_tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {
	
	/*
	 * * TCP(Transmission Control Protocol)
	 * - ����, Ŭ���̾�Ʈ ���� 1:1 ���� ���
	 * - �����͸� ��ȯ�ϱ⿡ �ռ��� ����, Ŭ���̾�Ʈ ����Ǿ��־�ߵ�!(������ ���� ����Ǿ� Ŭ���̾�Ʈ�� ��û ��ٸ�����)
	 * - �ŷڼ� �ִ� ������ ���� ����
	 * 
	 * 
	 * * Socket
	 * - �����͸� �ְ�ޱ� ���ؼ� ��Ʈ���� �ʿ��ѵ� �� ��Ʈ���� ������� �����̶�� ���� �ʿ�
	 * - ���μ������� ����� ���
	 * - Input / OutputStream�� ������ ���� (�� ��Ʈ���� ���� ������� �̷����)
	 * - ����Ʈ��Ʈ���� ����(reader, writer�� ���� ���ڽ�Ʈ�� ����x)
	 * 
	 * * SeverSocek
	 * - ��Ʈ�� ����(Bind)�Ǿ� �ܺ��� ���� ��û�� ��ٸ��ٰ� �����û�� ������ �������� �뵵
	 *   ����(accept()�޼ҵ�) => ����� �� �ִ� Socket ����
	 * 
	 */
	
	
	//������ ���α׷�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null; // �Է¿� ���� ��Ʈ��
		PrintWriter pw = null; // ���� ������ ����� �� �ִ� ������Ʈ��
		
		// 1) ��Ʈ ��ȣ ���� (���������� �� �� ��Ʈ�� ��θ� ������)
		int port = 3000;
		
		ServerSocket server = null;

		try {
			// 2) ServerSocket ��ü ���� �� ��Ʈ ����(Bind) (ServerSocket�� Ŭ���̾�Ʈ�� �����û�� �޾��� �뵵�� ����, ���� �����û�� �޾��ִ� �뵵�� ����)
			// �ܺο��� ���� ��û�� �޾��ֱ� ���ؼ� ServerSocek�� ���� �����ؾ��Ѵ�.
			server = new ServerSocket(port); // ServerSocket����
			//��Ʈ���� �� ���� �ݳ��ϴ°�ó�� ServerSocket��ü�� �� ���� close����� �Ѵ�.
			//���� finally�� �ȿ� �ݳ������� �ۼ��ؾ��ϱ� ������ try-catch�� �ۿ��� null������ ���� ���� �ؾ��Ѵ�.
			
			// 3) Ŭ���̾�Ʈ�κ��� �����û�� ���������� ������
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �ֽ��ϴ�...");
			
			// 4) ���� ��û�� ���� ��û ���� �� �ش� Ŭ���̾�Ʈ�� ����� �� �ִ� ������ ���� ��ü ����
			Socket socket = server.accept(); // .accept() : �����û�� ���� �������ִ� �޼ҵ�
			                                 // socket == Ŭ���̾�Ʈ�� ����� �� �ִ� ���� ��ü
			System.out.println(socket.getInetAddress().getHostAddress() + "�� ������ ��û��..."); 
			// soket.getInetAddress()�޼ҵ� : ���ϰ�ü�κ��� InerAddress() ��ü�� �� �� ����  => InetAddress.getHostAddress() : Ŭ���̾�Ʈ�� ip�ּҸ� �˾Ƴ��� �޼ҵ�
			
			// 5) Ŭ���̾�Ʈ�� ����� ��ݽ�Ʈ�� ���� (����Ʈ ��Ʈ�����ιۿ� �ȵ�..)
			// 6) ������Ʈ�� ���� ���� ���� (����Ʈ��Ʈ���̱� ������ 1����Ʈ�ۿ� ���޾Ƽ�)
			
			// �Է¿� ��Ʈ�� (Ŭ���̾�Ʈ�κ��� ���޵� ���� ���ٴ����� �о���̱� ���� �Է¿� ��Ʈ��)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			//1. socket.getInputStream() : Ŭ���̾�Ʈ�� ����� �Է¿뽺Ʈ���� ��������� �޼ҵ�� Ŭ���̾�Ʈ�κ��� ���� �Է¹ޱ� ���� ����Ʈ��Ʈ��
			//2. InputStreamReader() : ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �ٲ��� �� �ִ� ������Ʈ�� ����, ������Ʈ�� ���� �� ��ݽ�Ʈ���� �����ϸ鼭 ����!!
			//3. BufferedReader() : �� �� ������ �Է��� �� �ִ� ���ں�����Ʈ�� ����(BufferedReader()��ü ���� �� new InputStreamReader()��ü�� �ӵ��� ����Ŵ)
			
			// ��¿� ��Ʈ��(Ŭ���̾�Ʈ���� ���� ���ٴ����� ������ �� �ִ� ��¿� ��Ʈ��)
			pw = new PrintWriter(socket.getOutputStream());
			//1. socket.getOutputStream() : Ŭ���̾�Ʈ�� ���� ��¹ޱ� ���� ����Ʈ��Ʈ�� ����
			//2. PrintWriter() : ������ ����� �� print(), println() �޼ҵ带 ������ �ִ� 2����Ʈ�� ��¹��� �� �ִ� ������Ʈ��
			//                   println()�޼ҵ� ȣ�� �� ������ �����͸� �����ϸ� �ش� �������� ����ó���� �������ν� ���� ������ ��� ����!
			//                   �� ���� ��� �� �ڵ����� �ٹٲޱ��� ���ִ� ������Ʈ����
			//                   ��� �� BufferedWriter()�� Ȱ���� ��� ����ҵ����͸� ����� �ǰ�, ������ �ְ����Ҷ��� �Ź� newLine�� �̿��ؾ��Ѵ�.
			
			//ä��ó�� ����� ���ѹݺ�
			while(true) {
				// 7) ��Ʈ���� ���ؼ� �а� ����
				// Ŭ���̾�Ʈ�κ��� ���޵� �޼����� ���� ��� ���������� �о�鿩���� (�Է�)
				String message = br.readLine();
				//br.readLine() : �Է¿� ��Ʈ���� ���޵� �����Ͱ� ���� ��� ���ٷ� �о����
				System.out.println("Ŭ���̾�Ʈ�κ��� ���޹��� �޼��� : " + message);
				
				// �ݴ�� Ŭ���̾�Ʈ���� ������ ����! (���)
				// ����ڿ��� �Է¹��� �� ����
				System.out.print("Ŭ���̾�Ʈ���� ���� ���� : ");
				String sendMessage = sc.nextLine();
				
				pw.println(sendMessage); 
				// pw.println() : pw��� printWriter��ü�� ���ٴ����� �޼ҵ带 ����ϰ� �ٹٲޱ��� ���Բ� �ϴ� print()��� ��¿�޼ҵ带 Ȱ���� Ŭ���̾�Ʈ���� ���
				pw.flush();  // �ۼ����ϸ� ������ ������ü�� �ȵ�
				//���� ��Ʈ��(���)�� �ִ� �����͸� ������ �������� �޼ҵ� (close�޼ҵ� ȣ��Ǹ� �ڵ����� flush����)
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				// 8) ��� ����
				pw.close(); //��¿뽺Ʈ�� �ݳ�
				br.close();//�Է¿뽺Ʈ�� �ݳ�
				
				server.close(); //���� ����
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	
	}

}
