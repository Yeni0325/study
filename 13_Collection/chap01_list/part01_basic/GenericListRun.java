package com.kh.chap01_list.part01_basic.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_basic.model.vo.Music;

public class GenericListRun {
	
	public static void main(String[] args) {
		
		// ���׸����� ������ ���뵵 �����ϴ�.
		
		// <Music>�� ���׸� ���� �� => E == Music
		ArrayList<Music> list = new ArrayList<Music>();
	
		list.add(new Music("Good bye", "��ȿ��"));
		list.add(new Music("�� ��", "�����"));
		//list.add("��");
	
		System.out.println(list);
		
		//���� �ε��� ������ �߰�
		list.add(1, new Music("������ ��� �뷡", "���̽�"));
	
		System.out.println(list);
		
		//x�� �ε��� ����
		list.set(0, new Music("���� �޴�", "��������"));
		System.out.println(list);
		
		//list
		List<Music> sub = list.subList(0, 2);
		
		//�÷����� �ڿ��� ��°�� �߰���Ű��
		list.addAll(sub);
		System.out.println(list);
		
		//�ش� �ε����� ��ü ��ġ ��ȯ
		Music m = list.get(0); //���׸� ������ Music���� �߱� ������ MuicŸ������ ��ȯ�� ���ش�.
		System.out.println(m);
		
		System.out.println(list.get(1).getTitle());
		// ���׸� ������  Music���� �߱� ������ ������ ����ȯ ������ ��ġ�� �ʾƵ� �ȴ�!
		
		//for-each��
		for(Music o : list) { //���׸� ������  Music���� �߱� ������ ObjectŸ���� �ƴ� MusicŸ���� ������ ���� ���� �� �ִ�!
			System.out.println(o);
		}
		
		/*
		 * * ���׷�<>�� ����ϴ� ����
		 * 1. ��õ� Ÿ���� ��ü�� �����ϵ��� ������ �� �� ����
		 * 2. �÷��ǿ� ����� ��ü�� ������ ����� �� �Ź� ����ȯ�ϴ� ������ ���ֱ� ����
		 */
	}
}
