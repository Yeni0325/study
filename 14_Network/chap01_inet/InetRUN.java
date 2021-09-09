package com.kh.chap01_inet.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetRUN {

	public static void main(String[] args) {
		
		/*
		 * * ��Ʈ��ũ (Network) : �������� ��ǻ�͵��� ����Ǿ��ִ� ��Ÿ� ������
		 *                     => �̷� ��Ʈ��ũ�� ���� ���ΰ��� ������ ��ȯ ����!
		 *                     
		 * * IP �ּ� : ��Ʈ��ũ �� �� ��ǻ�͵��� �ĺ����� �� �ִ� ��ȣ (��ǻ���� �ֹι�ȣ)
		 *           cmdâ���� ipconfig��� �ۼ��ϸ� Ȯ�ΰ��� (IPv4�ּ�)
		 *           
		 * * ������ Ŭ���̾�Ʈ
		 * > ���� : Ŭ���̾�Ʈ(��)���� ���񽺸� �������ִ� ���α׷� (Ŭ���̾�Ʈ�� ��û�� ó���ؼ� �������ִ�)
		 * > Ŭ���̾�Ʈ : ������ ��û�ϴ� ��ǻ�� (���񽺸� �����޴� ��)
		 * 
		 * - ������ ��û�ϱ� ���ؼ��� �� ��û�ϰ��� �ϴ� ������ IP�ּ�, ��Ʈ��ȣ�� �˾ƾߵ�!
		 * - 
		 */
		
		// InetAddress : ��Ʈ��ũ ����(ip�ּ� ����)�� Ȯ���� �� �ִ� Ŭ����
		
		try {
			InetAddress localhost = InetAddress.getLocalHost(); //�� pc(����ȣ��Ʈ)�� ���� ������ ��ȯ
			//InetAddress.getLocalHost() : LocalHoast => �� pc�� ����Ŵ ��, ��pc�� ��Ʈ��ũ ������ Ȯ���� �� �ִ� Ŭ����
			
			System.out.println(localhost); // �� pc�� + / + �� IP �ּ�
			
			System.out.println("�� PC�� : " + localhost.getHostName()); // ȣ��Ʈ(����)�� �̸� ��ȯ
			System.out.println("�� IP�ּ� : " + localhost.getHostAddress()); // ȣ��Ʈ(����)�� ip�ּ� ��ȯ
			
			System.out.println("================================");
			
			// ���� �˰� �ִ� �������� ���ؼ� �� �������õ� ���� ���
			InetAddress googleHost = InetAddress.getByName("www.google.com"); // InetAddress.getByname() : ������ ���� ���ؼ� �ش� ȣ��Ʈ�� ���� ���� ��ȯ�ϴ� �޼ҵ�
			
			System.out.println("���� ������ : " + googleHost.getHostName());
			System.out.println("���� IP�ּ� : " + googleHost.getHostAddress());
			
			System.out.println("================================");
			
			// �������� ���ؼ� �������õ� �͵��� �迭�� ���� �� ����
			InetAddress[] naverHost = InetAddress.getAllByName("www.naver.com"); // InetAddress.getAllByName() : ������ ���� ���ؼ� �ش� ȣ��Ʈ�� ���� ������ "�迭"�� ��ȯ�ϴ� �޼ҵ�
			
			System.out.println("���̹� ȣ��Ʈ ���� : " + naverHost.length);
			for(InetAddress n:naverHost) {
				System.out.println("���̹� ������ : " + n.getHostName());
				System.out.println("���̹� IP�ּ� : " + n.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		/*
		 * * ���籸������ ������ ������
		 *   Ŭ���̾�Ʈ�� �� ������ ��û���� �� ����! => ������ ���ƿ�!
		 *   
		 * - ��û�� ���信 ���ؼ� ���α׷��� ���ư� ("���"�Ѵٰ� ǥ��)
		 * - �������� ��Ź�� : HTTP �������� ���
		 * 
		 * * �ڹٸ��� ������ ������ Ŭ���̾�Ʈ���� ������ ��� �غ���!
		 *   �̶� �����͸� ������ϰ��� �Ѵٸ� ������ Ŭ���̾�Ʈ���� ��Ʈ��(�������)�� �ʿ���!
		 *   
		 * * ���� : ���μ������� ����� ���! (������ Ŭ���̾�Ʈ�� ��Ʈ���� �����ϱ� ���� ��)
		 *        ������ ���� �����ؾ� ���̿� ��θ� ���� �� �ִ�.
		 * 
		 * * ���� ���α׷��� (TCP��� / UDP���)
		 * - TCP��� : ������ ���ۼӵ��� ����! �����Ͱ� ��Ȯ�ϰ� ���������� ���� ������! (�ŷڼ��� �䱸�Ǵ� ���α׷� : http, �̸���, ...)
		 * - UDP��� : ������ ���ۼӵ��� ����! �ŷڼ� ���� �����Ͱ� ���޵� �� ����! (�����͸� �����ӵ��� �����ϰ��� �ϴ� ���α׷� : �ǽð������󼭺�)
		 * 
		 */
		
		/*
		 * TCP ���� ���α׷��� : Ŭ���̾�Ʈ�� �������� 1:1 ���� ���
		 *                 ������ ���� ����Ǿ� Ŭ���̾�Ʈ�� ��û�� ��ٷ��� �Ѵ�. �������� ������ 2���� �ִµ�, ServerSocket�� Client Socket. ���������� ServerSocket�� �����Ǿ�� �ϰ�, 
		 *                 �� ��, ServerSocket�� �����ϰ� ��Ʈ��ȣ�� ���� ��Ʈ�� ����ΰ� ������ ������Ų��. ������ ������Ų ���¿��� Ŭ���̾�Ʈ �ʿ��� ServerSocket�� �����û�� ������ �ȴ�.
		 *                 ������������ �������� �� Ŭ���̾�Ʈ�� ������ �� ���� "������"�� �����Ѵ�. �׷��ٰ� �����û�� ������ ���� ServerSocket ��ü�� ������ accept()��� �޼ҵ带 ���� ������ �����ϰ� �ȴ�.
		 *                 �� ������, �������� Ŭ���̾�Ʈ�� ����ϱ� ���� Client Socket�� ������ �ǰ�, Ŭ���̾�Ʈ�� socket��ü�� ����. �ᱹ, �������� �ִ� Client Socket�� Ŭ���̾�Ʈ�� �ִ� Socket�� 
		 *                 ����� �ϰ� �ȴ�.
		 * 
		 */
		
		
		
		
	}

}
