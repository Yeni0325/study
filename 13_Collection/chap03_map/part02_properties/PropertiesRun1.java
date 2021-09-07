package com.kh.chap03_map.part02_properties.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

//출력
public class PropertiesRun1 {

	public static void main(String[] args) {
		
		// Properties : Map계열의 컬렉션. 따라서 값을 담을 때 key+value 세트로 저장해야한다.
		// HashMap과의 차이점 : Properties에는 key값도 String, value값도 String으로 담음!
		
		Properties prop = new Properties();
		
		/*
		// Map 계열이기 때문에 HashMap과 동일한 put()메소드를 이용해서 key + value 세트 담기가 가능하다.
		prop.put("다이제", new Snack("초코맛", 1500));
		prop.put("새우깡", new Snack("짠맛", 700));
		
		System.out.println(prop);
		
		// Map 계열이기 때문에 get()메소드를 통해 key값을 제시하면 value값을 돌려준다.
		System.out.println(prop.get("다이제"));
		
		// 하지만 Properties를 사용하는 경우는 주로 Properties에 담긴 것들을 파일로 출력 또는 입력받아 올 때 사용함!
		// 즉, Properties에서 제공하는 store(), load() 메소드를 사용하기 위해서 
		
		//현재 prop에는 key값으로 String계열, value값으로 Snack계열이 담겨져 있다. 
		
		try {
			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			// Properies.store(어떤파일에 직접적으로 연결할건지, 파일의 제목과 같은 문자열) : store는 저장하는 메소드이기 때문에 출 
			// 파일의 입출력의 경우 언제 어디서 예외가 발생할지 모르기 때문에 "예외처리"를 진행해줘야 한다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
		// ↑ ClassCastException 예외 발생 : 내부적으로 Store() 실행 시 Properties에 담겨있는 key+value 세트를 String으로 형변환해서 출력하게 되는데, Snack클래스를  String클래스로 형변환할 수 없기 때문에 발생하는 예외
		
		// Properties key+value세트로 추가할 때
		// 1. setProperty(String key, String value) => key값도 String, value값도 String값으로 담고자 할 때
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		//Map의 특징인 value값은 중복되도 상관없지만, key값이 중복되는 순간 value값이 덮어씌워지는 것 확인 가능!, 저장 순서 유지 안되는 것 확인 가능!
		
		
		// 2. getProperty(String key) : String => key값을 전달하면 그에 해당하는 value값을 반환해주는 메소드
		System.out.println(prop.getProperty("List"));
		System.out.println(prop.getProperty("새우깡")); //존재하지 않는 key값을 제시하면 null값을 반환해준다.
		
		try {
			//3. store(OutputStream os, String comments) : Properties에 담겨있는 key-value 값들을 파일로 출력(내부적으로 다 String으로 변환)
			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			
			//4. storeToXML(OutputStream os, String comments)
			prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
