package com.kh.chap01_list.part02_mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01_list.part01_basic.model.vo.Music;
import com.kh.chap01_list.part02_mvc.controller.MusicController;

// ȭ���� ����ϴ� Ŭ���� (��¹�, �Է¹�)
// �޴����� ������� ��û(�޼ҵ�ȣ��)�� Controller������ �����Ѵ�.
public class MusicMenu {
	
	private MusicController mc = new MusicController();
	//MusicControllerŬ���� ���������� ����
	
	private Scanner sc = new Scanner(System.in);
	//��ĳ��Ŭ���� ���������� ����
	
	
	/**
	 * ����ȭ�� : ���α׷� ���� �� ó���������� ȭ��
	 */
	public void mainmenu() { 
		
		while(true) { //����ڰ� �����ϰڴٴ� �ǻ縦 ���������� �޴��� ��� ��������
			
			System.out.println("\n=== Welcome ���� ===");
			System.out.println("1. ���ο� �� �߰�");
			System.out.println("2. �� ��ü ��ȸ");
			System.out.println("3. Ư�� �� ����");
			System.out.println("4. Ư�� �� �˻�");
			System.out.println("5. Ư�� �� ����");
			System.out.println("0. ���α׷� ����");
			
			System.out.print(">> �޴� ���� : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			//.�޼ҵ�ȣ��() �̾ƴϰ� �׳� �޼ҵ�ȣ��()�� �� ��� �ش�Ŭ���� �ȿ� �ִ� �޼ҵ带 ȣ���Ѵ�.
			switch(menu) {
			case 1 : insertMusic();
					 break;
			case 2 : selectMusic();
				     break;
			case 3 : deleteMusic();
			         break;
			case 4 : searchMusic();
			    	 break;
			case 5 :
			    	 break;
			case 0 : System.out.println("���α׷��� �����մϴ�. �̿����ּż� �����մϴ�.");
					 return;
			default : System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �������ּ���."); 
				    
			}
		}	
	}
	
	
	
	/**
	 * 1.���ο� �� �߰��ϴ� ����ȭ��
	 */
	public void insertMusic() {
		
		System.out.println("\n== ���ο� �� �߰� ==");
		System.out.print("���� �Է� : ");
		String title = sc.nextLine();
		System.out.print("���� �Է� : ");
		String artist = sc.nextLine();
		
		// �� �߰� ��û ������! (����ڰ� �Է��� ���, ������ ���� �ѱ�鼭!)
		// ��, Controller �޼ҵ� ȣ��
		mc.insertMusic(title, artist); // => ��û�Ѵ�
		System.out.println("���������� ���� �߰��Ǿ����ϴ�.");
		
	}
	
	/**
	 * 2. �� ��ü�� ��ȸ�ϴ� ����ȭ��
	 */
	public void selectMusic() {
		
		System.out.println("\n=== ��ü �� ����Ʈ ===");
		
		//��ü �� ��ȸ��û! (Controller�޼ҵ� ȣ��)
		ArrayList<Music> list = mc.selectMusic();
		
		if(list.isEmpty()) {// list�� ��������� true, ������������� false��ȯ
			System.out.println("���� �����ϴ� ���� �����ϴ�.");
		} else { // ����Ʈ�� ���� ������� ���
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}
	
	/**
	 * 3. Ư�� ���� �����ϴ� ����ȭ��
	 */
	public void deleteMusic() {
		
		System.out.println("\n=== Ư�� �� ���� ===");
		
		System.out.print("�����ϰ��� �ϴ� �� �� : ");
		String title = sc.nextLine();
		
		//���� ��û ������! (Controller�޼ҵ� ȣ��) ����ڰ� �Է��� ���� �����ϸ鼭
		int result = mc.deleteMusic(title);
		
		if(result > 0) { //result�� 1�� ���
			System.out.println("���������� �����Ǿ����ϴ�.");
		} else {//result�� 0�� ���
			System.out.println("������ ���� ã�� ���߽��ϴ�.");
		}
	}
	
	
	/**
	 * 4. Ư�� ���� �˻������ִ� ����ȭ��
	 */
	public void searchMusic() {
		
		System.out.println("\n=== Ư�� �� �˻� ===");
		
		System.out.print("�˻��� �� �� (Ű�����Է� ����) : ");
		String keyword = sc.nextLine();
		
		ArrayList<Music> searchList = mc.searchMusic(keyword);
		
		System.out.println("\n=== �˻� ��� ===");
		if(searchList.isEmpty()) { //�� ������� ��� =>�˻������ ����
			System.out.println("�˻��� ����� �����ϴ�.");
		}else {//�˻��Ȱ� �������
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
