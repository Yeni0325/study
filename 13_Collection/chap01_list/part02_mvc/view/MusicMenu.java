package com.kh.chap01_list.part02_mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01_list.part01_basic.model.vo.Music;
import com.kh.chap01_list.part02_mvc.controller.MusicController;

// 화면을 담당하는 클래스 (출력문, 입력문)
// 메뉴에서 사용자의 요청(메소드호출)을 Controller쪽으로 전달한다.
public class MusicMenu {
	
	private MusicController mc = new MusicController();
	//MusicController클래스 전역변수로 생성
	
	private Scanner sc = new Scanner(System.in);
	//스캐너클래스 전역변수로 생성
	
	
	/**
	 * 메인화면 : 프로그램 실행 시 처음보여지는 화면
	 */
	public void mainmenu() { 
		
		while(true) { //사용자가 종료하겠다는 의사를 밝힐때까지 메뉴가 계속 보여지게
			
			System.out.println("\n=== Welcome 별밤 ===");
			System.out.println("1. 새로운 곡 추가");
			System.out.println("2. 곡 전체 조회");
			System.out.println("3. 특정 곡 삭제");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			//.메소드호출() 이아니고 그냥 메소드호출()을 할 경우 해당클래스 안에 있는 메소드를 호출한다.
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
			case 0 : System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
					 return;
			default : System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요."); 
				    
			}
		}	
	}
	
	
	
	/**
	 * 1.새로운 곡 추가하는 서브화면
	 */
	public void insertMusic() {
		
		System.out.println("\n== 새로운 곡 추가 ==");
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		System.out.print("가수 입력 : ");
		String artist = sc.nextLine();
		
		// 곡 추가 요청 보내기! (사용자가 입력한 곡명, 가수명 같이 넘기면서!)
		// 즉, Controller 메소드 호출
		mc.insertMusic(title, artist); // => 요청한다
		System.out.println("성공적으로 곡이 추가되었습니다.");
		
	}
	
	/**
	 * 2. 곡 전체를 조회하는 서브화면
	 */
	public void selectMusic() {
		
		System.out.println("\n=== 전체 곡 리스트 ===");
		
		//전체 곡 조회요청! (Controller메소드 호출)
		ArrayList<Music> list = mc.selectMusic();
		
		if(list.isEmpty()) {// list가 비어있으면 true, 비어있지않으면 false반환
			System.out.println("현재 존재하는 곡이 없습니다.");
		} else { // 리스트에 뭐라도 담겨있을 경우
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}
	
	/**
	 * 3. 특정 곡을 삭제하는 서브화면
	 */
	public void deleteMusic() {
		
		System.out.println("\n=== 특정 곡 삭제 ===");
		
		System.out.print("삭제하고자 하는 곡 명 : ");
		String title = sc.nextLine();
		
		//삭제 요청 보내기! (Controller메소드 호출) 사용자가 입력한 값을 전달하면서
		int result = mc.deleteMusic(title);
		
		if(result > 0) { //result가 1인 경우
			System.out.println("성공적으로 삭제되었습니다.");
		} else {//result가 0인 경우
			System.out.println("삭제할 곡을 찾지 못했습니다.");
		}
	}
	
	
	/**
	 * 4. 특정 곡을 검색시켜주는 서브화면
	 */
	public void searchMusic() {
		
		System.out.println("\n=== 특정 곡 검색 ===");
		
		System.out.print("검색할 곡 명 (키워드입력 가능) : ");
		String keyword = sc.nextLine();
		
		ArrayList<Music> searchList = mc.searchMusic(keyword);
		
		System.out.println("\n=== 검색 결과 ===");
		if(searchList.isEmpty()) { //텅 비어있을 경우 =>검색결과가 없음
			System.out.println("검색된 결과가 없습니다.");
		}else {//검색된게 담겨있음
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
