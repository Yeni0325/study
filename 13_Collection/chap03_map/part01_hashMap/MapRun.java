package com.kh.chap03_map.part01_hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		
		//순서 유지 불가, 키 값 중복 불가(value는 중복 가능)
		HashMap<String, Snack> hm = new HashMap<>(); // key == String  / value == Snack
		//<key, value> 타입 작성
		
		//계층구조를 보면
		//List계열, Set 계열의 클래스들은 Collection을 구현한 클래스다.
		// => 객체를 추가하고자 할 때 공통적으로 add메소드 이용!
		
		//Map계열은 Collection을 구현한 클래스가 아님!
		// => 추가하고자 할 때 put 메소드 이용 (이때 key + value 세트로 담아야함!)
		
		//1. put(K key , V value) : 컬렉션에 key value 세트로 추가시켜주는 메소드
		hm.put("다이제", new Snack("초코맛", 1500));
		hm.put("칸초", new Snack("단맛", 600));
		hm.put("새우깡", new Snack("짠맛", 500));
		
		hm.put("포테이토칩", new Snack("짠맛", 500));
		
		System.out.println(hm); // {키=밸류, 키=밸류, ...}
		// 저장되는 순서 유지 안됨! value값이 중복되도 key값이 중복안되면 잘 저장된다!
		
		hm.put("새우깡", new Snack("매운맛", 700));
		System.out.println(hm);
		//동일한 키값으로 다시 추가하는 경우 value값이 덮어씌워진다! (value는 중복가능)
		
		//2. get(Object key) : V => 컬렉션에서 해당 Key값을 가지는 value값을 반환시켜주는 메소드
		Snack s = /*(Snack)*/hm.get("다이제"); // => Object 타입을 Snack 타입에 담으려고 하면 typemismatch 에러 발생
		System.out.println(s);
		
		//3. size() : 컬렉션에 담겨있는 객체들의 갯수 반환
		System.out.println("몇 개 : " + hm.size());
		
		//4. replace(K key, V value) => 컬렉션에서 해당 key 값을 찾아서 다시 전달한 value값으로 수정시켜주는 메소드
		hm.replace("포테이토칩", new Snack("겁나 짠맛", 1000));
		System.out.println(hm);
		
		//5. remove(Object key) => 컬렉션에서 해당 key값을 찾아서 key-value 세트를 삭제시켜주는 메솓,
		hm.remove("포테이토칩");
		System.out.println(hm);
		
		System.out.println("=================================================");
		//map 공간에 담긴 모든 key값과 value값을 다 출력하고자 할 때
		//for each문 안됨!
		/*
		for( :hm) {
		
		}
		*/
		
		//ArrayList로도 안됨!
		//ArrayList list = new ArrayList(hm);
		
		//Iterator 반복자를 이용!
		//Iterator it = hm.iterator(); //곧바로 iterator() 호출 못함! 왜? iterator()는 List계열 또는 Set계열에서만 쓸 수 있는 메소드!
		
		//Map을 Set으로 바꿔주는 메소드 제공!(2개)
		//Map => Set계열 => Iterator
		
		//방법1. keySet()메소드 이용하는 방법
		// 1) keySet()메소드를 호출 하는 순간 hm(hashMap)에 담긴 key값들만 set계열 컬렉션(키들의 집합 형태)에 담긴다
		Set<String> KeySet = hm.keySet();
		
		// 2) set계열은 iterator() 메소드 활용이 가능하기 때문에 iterator()를 통해 옮겨담기
		//    다만 set계열 컬렉션은 keyset을 통해 키값만 담겼으므로 iterator() 메소드 안에도 key값만 담겨있다.
		//    keySet.iterator() : Iterator
		Iterator<String> itKey = KeySet.iterator();
		
		// 3) 반복문을 통해서 뽑기
		while(itKey.hasNext()) {
			 String key = /*(String)*/itKey.next();
			 //get()메소드를 활용해 해당 key값에 해당하는 value값을 가져올 수 있음
			 Snack value = /*(Snack)*/hm.get(key);
			 System.out.println(key + "=" + value);
		}
		
		System.out.println("=================================================");
		
		//방법2. entrySet()메소드 이용하는 방법
		// 1) entrySet()메소드 호출 순간, Set계열의 공간이 생성 => hm(hashMap)에 담긴 key+value세트가 Entry(k+v)
		//    즉, Entry에 감싸져서 Set계열로 넘어온다.
		Set<Entry<String, Snack>> entrySet = hm.entrySet(); //key+value 세트의 집합
		
		// 2) iterator()메소드 호출을 통해 set공간에 담긴 entry타입의 key+value값이 넘어온다
		//    entrySet.iterator() : Iterator
		Iterator<Entry<String, Snack>> itEntry = entrySet.iterator();
		
		// 3) 반복문을 통해서 뽑기
		while(itEntry.hasNext()) {
			Entry<String, Snack> entry = /*(Entry)*/itEntry.next(); 
			// itEntry.next()는 key+value 세트인 Entry타입이 뽑혀져 나온다.
			
			String key = /*(String)*/entry.getKey(); //Entry.getKey() : Entry에서 제공하는 메소드로, key값을 뽑아오는 메소드
			Snack value = /*(Snack)*/entry.getValue(); //Entry.getValue() : value값을 뽑아오는 메소드
			System.out.println(key + "=" + value);
		}
		
		
		
	}

}
