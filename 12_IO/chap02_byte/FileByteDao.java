package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//dao(Data Access Object) : 데이터에 직접적으로 연결

public class FileByteDao {
	
	/*
	 * "바이트 기반 스트림" 가지고 데이터 입출력해보기!!
	 * 
	 * - 바이트 스트림 : 데이터를 1바이트 단위로 전송하는 통로(좁은 통로.. 1바이트면 한글은 깨짐)
	 * - 기반 스트림 : 외부매체와 직접적으로 연결되는 통로
	 * 
	 * 
	 * XXXInputStream : XXX매체로부터 데이터를 입력받는 통로 (외부매체로부터 데이터를 읽어오겠다)
	 * XXXOuputStream : XXX매체로 데이터를 출력하는 통로 (외부매체로 데이터를 내보내겠다)
	 * 
	 */
	
	//프로그램(자바코드, 메모리) --> 외부매체 (파일) (출력 : 프로그램 상의 데이터를 파일로 내보내기, 즉 파일로 저장)
	public void fileSave() {
		
		//FileOutputStream : 파일과 직접적으로 연결해서 1바이트 단위로 데이터를 출력하는 스트림
		
		//1. 스트림 생성 (통로 만들기)
		//2. 스트림으로 데이터를 출력 (메소드 활용)
		//3. 다 사용한 후 스트림 반납
		
		FileOutputStream fout = null;
		try {
			//1. FileOutputStream 객체 생성 => 해당 파일과의 연결통로 생성
			/*
			 * true 미 작성시 => 해당 파일이 존재할 경우 기존의 데이터가 덮어씌워진다(기본값이 false)
			 * true 작성 시 => 해당 파일이 존재할 경우 기존의 데이터에 이어서 작성된다
			 */
			fout = new FileOutputStream("a_byte.txt"/*, true*/); // => '( )' 안에는 어떤 파일과 연결할건지 작성 
			//FileOutputStream 객체 생성 시 해당 파일이 존재하지 않는다면 파일을 새로 만들어주고 해당 파일과의 연결통로를 생성해준다
			
			//2. 파일에 데이터를 출력하고자 할 때 write 메소드 사용
			//   숫자를 출력하던 문자를 출력하던 실상 파일에 기록되는건 문자로 기록된다.(아스키 코드표 참고)
			//   숫자(0~127)
			fout.write(97);   // 97에 해당하는 'a'문자가 저장 => int와 char는 자동형변환이 가능하기 때문에
			fout.write('b');  //           'b'문자가 저장
			//fout.write('강');  // 2바이트짜리 한글을 1바이트에 전달하게될 경우 깨져서 저장된다 => 바이트스트림으로는 제한이 있음
			
			byte[] arr = {99, 100, 101}; 
			fout.write(arr);   // 0번 인덱스부터 마지막인덱스까지 순차적으로 데이터가 출력이 된다.
			                   // 해당 숫자에 해당하는 문자가 저장 (cde)
			
			//write(byte[] b, int off, int len) : byte배열의 off인덱스부터 len 갯수만큼 출력
			fout.write(arr, 1, 2);  // de 문자가 저장
			
			//3. 스트림 다 이용했으면 반납하기! (반드시!)
			// fout.close(); //위에서 write() 메소드 실행 시 IOException이 발생할 경우 => 해당 catch블럭을 실행하고 try~catch문을 빠져나가기 때문에 반납하는 코드는 실행X
			                 //중간에 어떤 예외가 발생하던 무조건 실행시키고자 하는 구문이 존재한다면 마지막에 'finally'블럭 안에 작성해준다.
			
		} catch (FileNotFoundException e) {//존재하지 않는 경로를 제시 시 발생할 수 있음
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //이 안에 작성된 코드는 어떤 예외가 발생하던간에 마지막에 무조건 실행하고 빠져나갈거임!
			
			
			try {
				//3. 스트림 다 이용했으면 반납하기! (반드시!)
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//프로그램(자바코드, 메모리) <-- 외부매체 (파일) (입력 : 파일로부터 데이터 가져오기)
	public void fileRead() {
		
		//FileInputStream : 파일로부터 데이터를 1바이트 단뒤로 입력받는 스트림
		
		//1. 스트림생성 (통로 만들기)
		//2. 스트림 통해서 입력받아옴 (메소드 활용)
		//3. 사용이 끝난 스트림 반납
		
		FileInputStream fin = null;
		try {
			
			//1. FileInputStream 객체 생성 => 해당 파일과 연결통로 만들어짐
			fin = new FileInputStream("a_byte.txt"); //정말 해당 파일이 존재하지 않을경우 무조건 FileNotFoundException 발생
			
			//2. 파일로부터 데이터를 읽어들이고자 할 때 read 메소드 사용
			//   1byte단위로 하나씩 읽어옴 => 무조건 int값(정수값)으로 반환
			
			// 실제로 파일에 얼마만큼의 데이터가 있는지 모를경우? => 반복문 활용 가능
			/*
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			
			System.out.println(fin.read()); // 파일의 끝을 만나는 순간 '-1'을 받아온다.
			System.out.println(fin.read());
			*/
			
			/* 반복문 수행시 매번 read() 메소드가 두번씩 실행되기 때문에 드문드문 읽어들여진다 => 잘못됨
			while(fin.read() != -1) { //읽어들인 값이 -1이 아닐 경우에만 반복적으로 실행되도록
				System.out.println(fin.read());
			}
			*/
			
			// read()호출은 반복문 수행 시 매번 한번씩 실행되도록
			// 해결방법1. 우선 무한반복을 돌려놓고 매번 조건검사를 실행하는 방법
			/*
			while(true) {
				int value = fin.read();
				if(value == -1) {
					break;
				}
				System.out.println(value);
			}
			*/
			
			//해결방법2. 권장방법
			int value = 0;
			while((value = fin.read()) != -1) { //읽어들인 값이 -1이 아닐 경우에만 반복적으로 실행되도록
				System.out.println((char)value);
			}
			
			
			
			
		} catch (FileNotFoundException e) { //파일이 존재하지 않으면 예외 발생
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{

			try {
				//3. 다 사용한 스트림 반납
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
