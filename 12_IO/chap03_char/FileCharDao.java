package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
	
	/*
	 * "문자 기반 스트림" 을 가지고 입출력 해보기!
	 * 
	 * - 문자 스트림 : 데이터를 2byte 단위로 전송하는 통로 (넓은 통로)
	 * - 기반 스트림 : 외부매체와 직접적으로 연결되는 스트림(통로)
	 * 
	 * XXXReader : 입력용 스트림
	 * XXXWriter : 출력용 스트림
	 */
	
	//프로그램(자바코드, 메모리) --> 외부매체 (파일) (출력 : 프로그램 상의 데이터를 파일로 내보내기, 즉 파일로 저장)
	public void fileSave() {
		
		// FileWriter : 파일로 데이터를 2바이트 단위로 출력할 수 있는 스트림
		FileWriter fw = null;
		
		try {
			//1. FileWriter 객체 생성
			fw = new FileWriter("b_char.txt"); //해당 파일이 없으면 새로 만들고 연결, 있으면 그냥 연결만 해줌
			
			//2. write 메소드를 이용해 데이터 출력
			//   2바이트 단위로 데이터 전송
			fw.write("와! IO 재밌다..ㅎ"); // 실제로는 해당 문자열의 문자 하나 하나씩 전송되는 개념
			fw.write(' ');
			fw.write('A');
			fw.write("\n");
			
			char[] arr = {'a', 'p', 'p', 'l', 'e'}; // 각각의 인덱스 순차적으로 출력
			fw.write(arr);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			// 3. 스트링 반납
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//프로그램(자바코드, 메모리) <-- 외부매체 (파일) (입력 : 파일로부터 데이터 가져오기)
	public void fileRead() {
		
		//FileReader : 파일로부터 데이터를 2바이트 단위로 입력받을 수 있는 스트림
		
		FileReader fr = null;
		try {
			//1. FileReader 객체 생성
			fr = new FileReader("b_char.txt");
			
			//2. read 메소드 이용해서 읽어들이자 (정수값)
			//   파일의 끝을 만나는 순간 -1 반환
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.println((char)value);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
