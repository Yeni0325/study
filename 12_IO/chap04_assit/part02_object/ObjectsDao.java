package com.kh.chap04_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectsDao {
	
	//프로그램(자바코드, 메모리) --> 외부매체 (파일) (출력 : 프로그램 상의 데이터를 파일로 내보내기, 즉 파일로 저장)
	public void fileSave() {
		
		Phone[] arr = new Phone[3];
		arr[0] = new Phone("갤럭시", 1200000);
		arr[1] = new Phone("아이폰", 1300000);
		arr[2] = new Phone("플립", 1500000);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_phones.txt"))){
			
			for(int i=0; i<arr.length; i++) {
				
				oos.writeObject(arr[i]);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//프로그램(자바코드, 메모리) <-- 외부매체 (파일) (입력 : 파일로부터 데이터 가져오기)
	public void fileRead() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_phones.txt"))){
			
			//객체 배열을 생성했지만 입력해올때는 배열과 상관이 없다.
			//이전에 read메소드는 입력시 파일의 끝을 만나는 순간 '-1'출력
			//readLine메소드는 파일의 끝을 만나는순간 'null'을 출력
			//몇 개의 데이터가 있는지 모르기 때문에 반복문을 활용해야한다.
			
			/*
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			
			System.out.println(ois.readObject()); //파일의 끝을 만나는 순간 EOFException => End of Exception 예외발생
			*/
			//EOFExcepiton의 부모는 IOException이기 때문에  IOException구문이 낚아채져서 어떤 부분이 예외가 발생했는지 추척해서 알려줌
			
			while(true) {
				System.out.println(ois.readObject());
			}
			//어떤 값을 돌려준다면 해당 값으로 조건을 작성할 수 있지만 위는 값을 돌려주지 않고 EOFException 예외를 발생했기 때문에
			//무한반복을 돌려놓고 언젠가 파일의 끝을 만나는 순간 EOFException catch블럭을 만나게 되고 파일을 빠져나가게 된다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("파일을 다 읽어들였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("프로그램이 종료됩니다.");
	}
	
	
	

}
