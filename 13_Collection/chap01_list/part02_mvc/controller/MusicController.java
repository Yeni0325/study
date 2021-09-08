package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part01_basic.model.vo.Music;

// ������� ��û ó�����ִ� Ŭ����
public class MusicController {
	
	private ArrayList<Music> list = new ArrayList<>();
	{ //�ʱ�ȭ �� : ������ �ʵ尡 ������ �� �Բ� ������
		list.add(new Music("Good Bye", "��ȿ��"));
		list.add(new Music("���� �޴�", "��������"));
		list.add(new Music("���� �޴�", "������"));
	}//=>�����ڵ� �ƴϰ�, �޼ҵ嵵 �ƴ� ��� "{}" �ȿ� �ۼ� �����ϴ�.
	
	//�ʵ�� ��� ������ �޸� ������ �ö󰥱�?
	//�ش� MusicController��ü�� �����Ǵ� ������ list�� 2���� Music��ü�� �޸� ������ �ö󰣴�.
	//     �� MusicMenuŬ������ private MusicController mc = new MusicController()�� ����Ǵ� ����
	
	//Ŭ���� �������� ��ٷ� �� �� �ִ°� �ʵ��, �����ں�, �޼ҵ�δ�.
	//�ʵ��ڸ����� ������ �����Ѵٰų�, ����� ���ÿ� �ʱ�ȭ�Ѵٰų�, ����� ���ÿ� �����ϴ� ������ �ۼ� �����ϴ�.
	//�߰������� �����Ű���� �ϴ� �ڵ�� Ŭ���� ���� ���� ��ٷ� �ۼ� �Ұ�!
	
	public void insertMusic(String title, String artist) {
		
		list.add(new Music(title, artist));
		
	}
	
	public ArrayList<Music> selectMusic() {
		return list;
	}
	
	public int deleteMusic(String title) {
		
		int result = 0; 
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) { //list.get(i).equals(title)��� �� ���, Music��ü�� ��°�� ����������.
				list.remove(i);
				result = 1;
				break;
			}
		}
		
		//result = 0 (������ �� �� ã��) | 1 (���������� ����)
		return result;
	}
	
	public ArrayList<Music> searchMusic(String keyword) {
		
		//return���� �ϳ��� �����ϱ� ������ , ��ü�迭 Ȥ�� ArryList�� return���� ��ȯ����� �Ѵ�.
		//�ٸ�, ��� ���� ��ȯ������ �𸣱� ������ ArryList�� return������Ѵ�.
		
		ArrayList<Music> searchList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(keyword)) {
				searchList.add(list.get(i));
			}
		}
		//searchList => �� ������� �� ���� | �˻��� Music ��ü���� ������� �� ����
		return searchList;
	}
	
	
	
	
	
}

	