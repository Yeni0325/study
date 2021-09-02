package com.kh.chap04_assist.part01_buffer.model.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDao {
	
	/*
	 * 보조스트림 : 기반스트림으로 부족했던 성능을 보다 향상 시켜주는 스트림
	 *          기반스트림에서 제공하지 않는 추가적인 메소드 제공 / 데이터 전송 속도 향상 시킨다거나 등등
	 *    >> 외부 매체와 직접적으로 연결되는 스트림은 아님!
	 *       단독 사용 불가 (반드시 기반 스트림과 함께 사용)
	 */
	
	
	//프로그램(자바코드, 메모리) --> 외부매체 (파일) (출력 : 프로그램 상의 데이터를 파일로 내보내기, 즉 파일로 저장)
	public void fileSave() {
		
		//FileWriter : 파일과 직접적으로 연결해서 2byte 단위로 데이터를 출력할 수 있는 스트림
		//BufferedWriter : 버퍼라는 공간을 제공해주는 보조스트림 (속도 향상에 도움)
		
		//1. 기반스트림 먼저 생성
		//FileWriter fw = new FileWriter("c_buffer.txt");
		//2. 보조스트림 생성
		//   보조스트림 생성 시 기반스트림 객체를 전달하면서 생성(어떤 기반스트림을 향상시킬건지)
		//BufferedWriter bw = new BufferedWriter(fw);
		
		//위의 두 줄을 한줄로 작성
		/*
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			
			//wrtie 메소드 이용해서 데이터 출력
			bw.write("안녕하세요\n");
			bw.write("반갑습니다.");
			bw.newLine(); // 줄바꿈을 넣어주는 메소드 => BufferedWriter라서 사용 가능!
			bw.write("저리가세요");
			//버퍼라는 공간에 계속 쌓아놨다가 한번에 출력해줌 => 속도 향상에 좋다.
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// try~with~resource 구문으로 자원 반납까지 더 간단하게 작업할 수 있음
		// jdk7버전 이상부터 사용가능
		/*
		 * try(try블럭내에서 사용할 스트림객체 생성 구문){ // 알아서 try 다 끝나면 해당 스트림 반납까지 해줌
		 * 
		 * } catch(예외클래스 e){
		 * 
		 * }
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))){
			bw.write("안녕하세요\n");
			bw.write("반갑습니다.");
			bw.newLine(); // 줄바꿈을 넣어주는 메소드 => BufferedWriter라서 사용 가능!
			bw.write("저리가세요");
			
		} catch (IOException e) {
			e.printStackTrace();
		} //자원 반납 구문 안써도됨! 자동으로 반납까지 해줄거임
		
		
	}
	
	
	
}
