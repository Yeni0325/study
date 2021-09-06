package com.kh.chap01_list.part01_basic.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_basic.model.vo.Music;

public class ListRun {
	
	/*
	 * * 컬렉션이란?
	 *   자료구조 개념이 내장되어 있는 클래스로 자바에서 제공하는 "자료구조"를 담당하는 "프레임워크"다.
	 *   배열의 단점을 보완한 것
	 *   
	 *   - 자료구조 : 방대한 데이터를 보다 효율적으로 관리(조회, 정렬, 추가, 수정, 삭제 등)할 수 있도록 도와주는 개념
	 *   - 프레임워크 : 이미 만들어져있는 틀(뼈대)
	 *
	 * * 배열의 단점과 컬렉션의 장점
	 * > 배열의 단점
	 *   1. 배열은 우선 크기를 지정해야됨! 한번 지정된 크기를 변경할 수 없음!
	 * 		새로운 값을 더 추가하고자 한다면 새로운 크기의 배열을 만들고 기존껄 복사하는 코드를 직접기술
	 * 		배열을 애초에 크게 만들면 메모리 낭비가 심함
	 * 
	 *   2. 배열의 중간 위치에 값을 추가하거나 삭제하는 경우 매번 값을 땡겨주는 복잡한 알고리즘을 직접 기술해야됨..
	 * 
	 *   3. 한 공간에 한 타입의 데이터들만 저장 가능하다.
	 * 
	 * > 컬렉션의 장점
	 *   1. 크기를 지정해줄 필요 없음! 만일 크기지정을 했다고 해도, 해당 크기보다 더 많은 데이터가 들어왔을 경우 알아서 크기가 늘어남!
	 *      크기의 제약이 없다.
	 * 
	 *   2. 중간에 값을 추가한다거나 삭제하는 경우 값을 땡겨주는 작업(알고리즘)을 직접 기술할 필요없음!
	 *      단지 메소드 호출만으로 알아서 내부적으로 진행될꺼임
	 * 
	 *   3. 한 공간에 여러타입의 데이터 저장 가능! (단, 객체만 저장 가능)
	 *   
	 * * 방대한 데이터들을 단지 보관만 해두고 조회만 할 경우 배열을 많이 사용
	 *   방대한 데이터들을 보관, 추가, 삭제 등등 이런 과정들이 빈번할 경우 컬렉션을 많이 사용
	 *   
	 *  
	 *  		|			   Collection               |
	 *          |                   |                   |
	 *          |       list계열            |       set계열              |          Map계열 
	 *===============================================================================                                                  
	 * 저장가능        |        데이터(value)만 담으면 됨                            |  key + 데이터(value) 세트로 담기
	 *  데이터         |                                       |
	 *-------------------------------------------------------------------------------                                       
	 * 순서유지여부  |         O         |         X         |             X
	 *          |    (index개념 있음)  |                   |   
	 *-------------------------------------------------------------------------------                                                  
	 *중복값 허용여부 |         O         |         X         |    데이터(value)가 중복이 되도
	 *          |                   |                   |      key값이 종복안되면 허용됨
	 */

	public static void main(String[] args) {

		// 별도로 제네릭 설정을 하지 않으면 <Object>   =>  E == Object
		ArrayList list = new ArrayList(3); // 크기 지정할수도 있고 안할수도 있음! (지정안할경우 내부적으로 크기는 10으로 설정)
		//ArrayList 컬렉션 생성 => 내부적으로 배열과 비슷한 공간이 생성된다.
		
		System.out.println(list); // 안에 아무것도 없음(비워있는 상태)
		
		//E => Element : 리스트에 담길 데이터들 (요소)
		
		// 1. add(E e) : 리스트공간 끝에 전달된 데이터를 추가시켜주는 메소드 *
		list.add(new Music("Good Bye", "박효신"));
		list.add(new Music("이 밤", "양다일"));
		list.add(new Music("잊혀지다", "정키"));
		list.add("끝");
		
		//지정된 크기보다 더 많이 넣어도 오류 안남 => 장점1 : 크기의 제약 없음
		//다양한 타입의 데이터 담을 수 있음           => 장점3 : 여러타입 보관 가능
		
		System.out.println(list); // list의 특징 : 순서유지하면서 담김(0번 인덱스부터 차곡차곡)
		
		// 2. add(int index, E e) : 직접 인덱스를 지정해서 해당 인덱스 위치에 데이터를 추가시켜주는 메소드
		list.add(1, new Music("진심이 담긴 노래", "케이시"));
		
		// 중간 위치에 데이터 추가시 복잡한 알고리즘 직접 구현 안함 => 장점2 
		System.out.println(list);
		
		// 3. remove(int index) : 해당 인덱스 위치의 데이터를 삭제시켜주는 메소드
		list.remove(1);
		System.out.println(list);
		
		// 4. set(int index, E e) : 해당 인덱스 위치에 데이터를 새로 전달된 e로 수정시켜주는 메소드
		list.set(0, new Music("술이달다", "에픽하이"));
		System.out.println(list);
		
		// 5. size() : 리스트의 사이즈를 반환시켜주는 메소드 (즉, 몇개의 데이터가 담겨있는지) *
		System.out.println("리스트의 사이즈 : " + list.size());  // 배열과 비교해보자면 length 같은 느낌
		
		// 6. get(int index) : 해당 인덱스위치의 객체를 반환시켜주는 메소드 *
		Music m = (Music)list.get(0);
		String s = (String)list.get(3);
		// list.get() 메소드의 경우 Object 타입으로 반환을 하기 때문에 Object보다 작은 크기의 자료형에 담을 경우 강제형변환을 시켜줘야 한다.
		System.out.println(m);
		System.out.println(s);
		System.out.println(list.get(1));
		System.out.println(((Music)list.get(1)).getTitle());
		
		// 7. subList(int index1, int index2) : List  => 추출해서 새로운 List로 반환
		List sub = list.subList(0, 2); // 0 <=    < 2
		System.out.println(sub);      
		
		// 8. addAll(Collection c) : 컬렉션을 통채로 뒤에 추가시켜주는 메소드
		list.addAll(sub);
		System.out.println(list);
		
		// 9. isEmpty() : boolean => 현재 컬렉션이 비어있는지 묻는 메소드
		System.out.println(list.isEmpty());
		
		// 10. clear() : 싹 비워주는 메소드
		//list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
		
		
		// 반복문을 통해 순차적으로 출력
		System.out.println("=======================================================");
		// 1) for loop문
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=======================================================");
		// 2) for each문
		for(Object o:list) {// o => list.get(0); =>  0 => list.get(1);...
			              // get()메소드로 리스트를 뽑을 때 object타입으로 반환이 된다.
			System.out.println(o);
		}
		
	}

}
