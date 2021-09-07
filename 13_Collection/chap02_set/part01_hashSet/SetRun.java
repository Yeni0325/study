package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		
		//Object에 equals() => 두 객체의 "주소값"을 비교해서 일치하면 true/일치하지 않으면 false반환
		//Object에 hashCode() => 해당 객체의 "주소값"을 가지고 10진수의 형태로 만들어서 반환
		
		//다수의 객체를 보관할 수 있는 컬렉션의 한 종류
		HashSet<String> hs1 = new HashSet<>();
		//hs1이라는 공간 생성
		
		//ArrayList도 HashSet도 새로운 값을 추가하려면 add()메소드를 사용하는데
		//공통적인 Collection 부모를 가지고 있으면서 add()로 오버라이딩 되었기 때문!
		hs1.add("반갑습니다.");
		hs1.add(new String("반갑습니다."));
		hs1.add(new String("여러분"));
		hs1.add(new String("안녕하세요"));
		hs1.add(new String("여러분"));
		
		//String에 hashCode()메소드는 오버라이딩 되어있음! => "실제 담긴 문자열"을 가지고 10진수의 형태로 만들어서 반환
		//String에 equals()메소드는 오버라이딩 되어있음! => "실제 담긴 문자열"을 가지고 비교해서 일치하면 true / 일치하지 않으면 false 반환
		
		System.out.println(hs1); // 저장 순서 유지 안됨!(인덱스 개념X) 중복된 데이터(동일객체) 보관 불가능
		
		//===============================================================================
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("공유", 43, 100));
		hs2.add(new Student("김말똥", 26, 40));
		hs2.add(new Student("홍길동", 24, 20));
		hs2.add(new Student("공유", 43, 100));
		
		System.out.println(hs2); // 저장 순서 유지 안됨 / 중복제거x => 왜? 동일객체로 판단이 안되고 있어서!
		
		// HashSet 이라는 공간에 객체가 추가될때마다 동일객체인지 비교!
		// 동일객체 : 각 객체마다 hashCode()메소드 호출 결과가 일치하고, equals()메소드로 비교시 true일 경우
		
		/*
		System.out.println(new Student("공유", 43, 100).hashCode());
		System.out.println(new Student("공유", 43, 100).hashCode());
		System.out.println(new Student("공유", 43, 100).equals(new Student("공유", 43, 100)));
		*/
		
		//hs2.get(1); => set은 인덱스의 개념도 없고 get 메소드 자체가 정의 되어 있지 않음!(한 객체만 뽑아올 수 없음) 
		
		//HashSet에 담긴 모든 객체들에 순차적으로 접근 가능
		//하나만을 뽑을 순 없음
		//1. for문 사용 가능! (단, 인덱스 개념이 없기 때문에 for-each문으로만 가능!)
		for(Student s : hs2) { //Student s 타입으로 받아줄 경우 hs2는 object로 반환되기 때문에 typemismatch가 발생
			System.out.println(s);
		}
		
		System.out.println("=========================================");
		
		//2. ArrayList에 옮겨 담은 후 해당 ArrayList를 반복문 돌려가며 접근하는 방법 
		//2-1. ArrayList에 담는 첫번째 방법 : ArryList 생성 후 addAll() 메소드 이용해서 통째로 추가하기
		ArrayList<Student> list = new ArrayList<>();
		list.addAll(hs2); 
		//addAll은 컬렉션 타입 작성이 가능하고, List와 Set은 Collection을 공통 부모로 삼고 있기 때문에 HashSet인 hs2를 담아줄 수 있다.
		
		//2-2. ArryList에 담는 두 번째 방법 : ArrayList 생성과 동시에 통째로 추가하기
		ArrayList<Student> list2 = new ArrayList<>(hs2); //ArryList에 HashSet객체인 hs2를 매개변수생성자로 바로 담기
		
		//ArryList에 담는 순간 인덱스 제시가 가능하기 때문에 for-loop활용 가능!
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		
		System.out.println("=========================================");
		
		//3. Iterator 반복자를 이용해서 순차적으로 접근하는 방법
		// Collection위에 Iterable부모가 존재
		// 차곡차곡 담을 수 있는 반복자
		Iterator<Student> it = hs2.iterator(); // iterator 타입으로 반환되기 때문에 Iterator타입인 it라는 공간에 담아준다
		//hs2에 담겨있는 객체들을 Iterator(반복자)에 차곡차곡 담는 과정
		//hs2에 담겨있는 객체들이 사라지는게 아닌 Iterator공간에 복사되는 개념!
		//다만, Iterator에서 하나하나 가져올때는 뽑아오는 개념이기 때문에 it공간에서 사라진다.
		
		while(it.hasNext()) {//iterator.hasNext() : it라는 공간에 뽑을게 남아있으면 true, 없으면 false반환하는 메소드
			Student s = /*(Student)*/it.next(); //iterator.next() : iterator공간에 값을 하나씩 뽑아오는 메소드
			System.out.println(s);
		}
		//StringTokenizer와 비슷한 개념!
		
		//it.next(); 
		//더 이상 뽑을 값이 없는데 뽑으려고 할 때 'NoSuchElementException' 에러 발생
		
		
	}

}
