package com.kh.chap01_list.part02_mvc.run;

import com.kh.chap01_list.part02_mvc.view.MusicMenu;

public class MVCRun {

	public static void main(String[] args) {
		
		/*
		 * * MVC���� : �� Ŭ�������� ����(model->������, view->ȭ��, controller->��ûó��)�� �ο��ؼ� �۾�! 
		 *                                   => �������� ����!
		 * 
		 * - M(Model) : �����͸� ����ϴ� ���� (�����͵��� ������� Ŭ����, ����Ͻ� ������ ó���ϴ� Ŭ����, �����Ͱ� �����Ǿ��ִ� �����԰� �����ؼ� ������ϴ� Ŭ����)
		 * - V(View) : ȭ���� ����ϴ� ���� ��, ����ڿ��� �������� �ð����� ��� (��¹�(Print��), �Է¹�(Scanner))
		 * - C(Controller) : ����ڰ� ��û�� ������ ó���� �� �� ����� �����ִ� ���� (��¹������� �Ⱦ�����!!)
		 * 
		 * 
		 */
		
		//������� ���ุ ���ְ� ��!
		MusicMenu mm = new MusicMenu();
		mm.mainmenu();
		

	}

}
