package com.kh.chap01_list.part01_basic.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_basic.model.vo.Music;

public class GenericListRun {
	
	public static void main(String[] args) {
		
		// 제네릭으로 다형성 적용도 가능하다.
		
		// <Music>로 제네릭 설정 함 => E == Music
		ArrayList<Music> list = new ArrayList<Music>();
	
		list.add(new Music("Good bye", "박효신"));
		list.add(new Music("이 밤", "양다일"));
		//list.add("끝");
	
		System.out.println(list);
		
		//직접 인덱스 제시후 추가
		list.add(1, new Music("진심이 담김 노래", "케이시"));
	
		System.out.println(list);
		
		//x번 인덱스 수정
		list.set(0, new Music("술이 달다", "에픽하이"));
		System.out.println(list);
		
		//list
		List<Music> sub = list.subList(0, 2);
		
		//컬렉션을 뒤에서 통째로 추가시키기
		list.addAll(sub);
		System.out.println(list);
		
		//해당 인덱스의 객체 위치 반환
		Music m = list.get(0); //제네릭 설정을 Music으로 했기 떄문에 Muic타입으로 반환을 해준다.
		System.out.println(m);
		
		System.out.println(list.get(1).getTitle());
		// 제네릭 설정을  Music으로 했기 때문에 별도의 형변환 과정을 거치지 않아도 된다!
		
		//for-each문
		for(Music o : list) { //제네릭 설정을  Music으로 했기 때문에 Object타입이 아닌 Music타입의 변수에 값을 담을 수 있다!
			System.out.println(o);
		}
		
		/*
		 * * 제네렉<>을 사용하는 이유
		 * 1. 명시된 타입의 객체만 저장하도록 제한을 둘 수 있음
		 * 2. 컬렉션에 저장된 객체를 꺼내서 사용할 때 매번 형변환하는 절차를 없애기 위해
		 */
	}
}
