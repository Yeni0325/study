package com.kh.chap02_abstractAndInterface.part02_basic.run;

import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Baby;
import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Basic;
import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Mother;
import com.kh.chap02_abstractAndInterface.part02_basic.model.vo.Person;

public class BasicRun {

	public static void main(String[] args) {
		
		//Person p = new Person();
		
		/* �������̽� ���� ��
		Person mom = new Mother("�����", 50, 70, "���");
		//�θ� Ÿ�� ���۷����� �ڽ� ��ü ���� (������ ����)
		Person baby = new Baby("���Ʊ�", 3.5, 70);
		//�θ� Ÿ�� ���۷����� �ڽ� ��ü ���� (������ ����)
		
		System.out.println(mom);
		System.out.println(baby);
		
		mom.eat(); //������+10 �ǰ��� -10
		baby.eat();//������ +3 �ǰ��� +1
		
		mom.sleep(); //�ǰ��� +20
		baby.sleep(); //�ǰ��� +3
		System.out.println("============= ������ ==============");
		System.out.println(mom);
		System.out.println(baby);
		*/
		
		//==========================================================
		//�������̽� ���� �� 
		
		//Basic b = new Basic();
		//�������̽��� ������ ����ʵ�� �߻�޼ҵ�ۿ� �ۼ��� ���ϱ� ������ �Ϻ��ϰ� �̿ϼ��� ���´�!!
		//   => ���� �翬�� ��ü ���� �Ұ�!! but, ���۷��� ������ �����ϴ� ���� �����ϴ�!
		
		Basic mom = new Mother("�����", 50, 70, "���");
		//�θ� Ÿ�� ���۷����� �ڽ� ��ü �޾��ִ� �� ����(������ ����)
		Basic baby = new Baby("���Ʊ�", 3.5, 70);
		//�θ� Ÿ�� ���۷����� �ڽ� ��ü �޾��ִ� �� ����(������ ����)
		
		System.out.println(mom);
		System.out.println(baby);
		
		mom.eat();
		baby.eat();
		
		mom.sleep();
		baby.sleep();
		
		System.out.println(mom);
		System.out.println(baby);
		
		/*
		 * Ŭ�������� Ŭ������ ��ӹ��� �� :  Ŭ���� extends Ŭ���� (Ŭ������ Ŭ�������� ����� ���߻�� �Ұ�! ���ϻ�Ӹ� ����)
		 *                     : ȭ��ǥ "�Ǽ�"
		 *                     
		 * Ŭ�������� �������̽��� ������ �� : Ŭ���� implements �������̽�, �������̽�, .. (Ŭ������ �������̽����� ����� ���߻�� ����!)
		 *                       : ȭ��ǥ "����"
		 *                       
		 * �������̽����� �������̽��� ��� : �������̽� extends �������̽�, �������̽�, .. (���߻�� ����) 
		 *                       : ȭ��ǥ "�Ǽ�"
		 * 
		 * ȭ��ǥ�� "�Ǽ�"�� ��� => extends
		 * ȭ��ǥ�� "����"�� ��� => implements
		 * 
		 * * �߻�Ŭ������ �������̽��� ������
		 *          |             �߻�Ŭ����                         |            �������̽�                          
		 * =======================================================================
		 *  ��Ӱ���     |             ���ϻ��                             |             ���߻��                            
		 * -----------------------------------------------------------------------
		 *  Ű����         |             extends           |          implements
		 * -----------------------------------------------------------------------
		 * �߻�޼ҵ�     |       �߻�޼ҵ� 0�� �̻�                          |       ��� �޼ҵ尡 �߻�޼ҵ�
		 * ǥ����/����   |       ��������� abstract ���            |     ���������� abstract (��������)
 		 * ------------------------------------------------------------------------
		 * �Ϲݸ޼ҵ�      |             O                |               X
		 * �ۼ� ���� ���� |                              |
		 * ------------------------------------------------------------------------
		 *    �ʵ�        |         �Ϲ��ʵ� ���� �� ����                  | ����ʵ常 ���� �� ����(���������� public static final)
		 *    
		 *    
		 *   extends �Ϲ�Ŭ����  ---> extends �߻�Ŭ����  ---> implements �������̽�
		 *   ------------------------------------------------------------->
		 *                         �������� �� £���� (�Ծ��� �� ����)
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}

}
