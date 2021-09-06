package com.kh.chap04_assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

//객체 자체를 통째로 출력/입력하기
public class ObjectDao {
	
	//프로그램(자바코드, 메모리) --> 외부매체 (파일) (출력 : 프로그램 상의 데이터를 파일로 내보내기, 즉 파일로 저장)
	public void fileSave() {
		
		//출력할 데이터 (Phone 객체)
		Phone ph = new Phone("아이폰", 1300000);
		
		//Phone객체 자체를 통째로 출력하고자 할때는 기반스트림만으로는 불가하다.무조건 객체단위로 출력해줄 수 있는 보조스트림이 필요하다.
		//객체단위로 입출력할 수 있는 보조스트림은 ObjectOutputStream, ObjectInputStream만 존재
		
		// FileOutputStream : 파일과 직접적으로 연결해서 1byte 단위로 데이터를 출력할 수 있는 스트림
		// ObjectOutputStream : 객체 단위로 출력할 수 있도록 도움을 주는 보조스트림(ObjectWriter는 존재x)
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d_phone.txt"))){
			
			oos.writeObject(ph);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//프로그램(자바코드, 메모리) <-- 외부매체 (파일) (입력 : 파일로부터 데이터 가져오기)
	public void fileRead() {
		
		// FileIutputStream : 파일과 직접적으로 연결해서 1byte 단위로 데이터를 입력받을 수 있는 스트림
		// ObjectIutputStream : 객체 단위로 입력받을 수 있게 도움을 주는 보조스트림(ObjectReader는 존재x)
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_phone.txt"))){
			
			Phone ph = (Phone)ois.readObject();
			System.out.println(ph);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
