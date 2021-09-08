package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part01_basic.model.vo.Music;

// 사용자의 요청 처리해주는 클래스
public class MusicController {
	
	private ArrayList<Music> list = new ArrayList<>();
	{ //초기화 블럭 : ↑위에 필드가 생성될 때 함께 생성됨
		list.add(new Music("Good Bye", "박효신"));
		list.add(new Music("술이 달다", "에픽하이"));
		list.add(new Music("밥이 달다", "강보람"));
	}//=>생성자도 아니고, 메소드도 아닌 경우 "{}" 안에 작성 가능하다.
	
	//필드는 어느 시점에 메모리 영역에 올라갈까?
	//해당 MusicController객체가 생성되는 시점에 list와 2개의 Music객체가 메모리 영역에 올라간다.
	//     ㄴ MusicMenu클래스에 private MusicController mc = new MusicController()가 실행되는 시점
	
	//클래스 영역내에 곧바로 쓸 수 있는건 필드부, 생성자부, 메소드부다.
	//필드자리에는 변수를 선언한다거나, 선언과 동시에 초기화한다거나, 선언과 동시에 생성하는 구문만 작성 가능하다.
	//추가적으로 실행시키고자 하는 코드는 클래스 영역 내에 곧바로 작성 불가!
	
	public void insertMusic(String title, String artist) {
		
		list.add(new Music(title, artist));
		
	}
	
	public ArrayList<Music> selectMusic() {
		return list;
	}
	
	public int deleteMusic(String title) {
		
		int result = 0; 
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) { //list.get(i).equals(title)라고 할 경우, Music객체가 통째로 가져와진다.
				list.remove(i);
				result = 1;
				break;
			}
		}
		
		//result = 0 (삭제할 곡 못 찾음) | 1 (성공적으로 삭제)
		return result;
	}
	
	public ArrayList<Music> searchMusic(String keyword) {
		
		//return값은 하나만 가능하기 때문에 , 객체배열 혹은 ArryList로 return값을 반환해줘야 한다.
		//다만, 몇개의 값이 반환될지는 모르기 때문에 ArryList로 return해줘야한다.
		
		ArrayList<Music> searchList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(keyword)) {
				searchList.add(list.get(i));
			}
		}
		//searchList => 텅 비어있을 수 있음 | 검색된 Music 객체들이 담겨있을 수 있음
		return searchList;
	}
	
	
	
	
	
}

	