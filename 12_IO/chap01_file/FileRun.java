package com.kh.chap01_file.run;

import java.io.File;
import java.io.IOException;

public class FileRun {

	public static void main(String[] args) {
		
		// 간단하게 파일(file)이 만들어지는 과정
		// java.io.File 클래스를 이용해서 
		
		// test.txt라는 파일을 만들어보자
		// 우선, 경로지정은 하지 않고 만들어보자
		
		//1.경로지정을 딱히 하지 않은 상태로 파일 생성 => 현재 project 폴더에 파일 생성 => 작업탐색기 
		try {
			//객체 생성
			File f1 = new File("test.txt"); //매개변수로 어떤 파일을 만들고 싶은지 제시
			f1.createNewFile(); //메소드까지 실행해야만 실제 파일이 만들어짐!!
			
		//2. 존재하는 폴더에 파일 생성 => 해당 경로까지 지정하면 됨(존재하지 않는 폴더 작성x)	
			File f2 = new File("D:\\test.txt"); //존재하지 않는 경로 제시 시 IOException 발생
			f2.createNewFile();
			
			//File f3 = new File("D:\\temp\\test.txt"); //존재하지 않은 폴더를 제시했을 때 찾지 못하면서 IOException 발생
			//f3.createNewFile();
		
	    //3. 폴더 먼저 만들고 파일까지 만들어지게 하기
			File tempFolder = new File("D:\\temp");
			tempFolder.mkdir(); // 폴더가 만들어지게하는 메소드
			
			File f3 = new File("D:\\temp\\test.txt");
			f3.createNewFile();
			
			System.out.println(f1.exists()); // f1.exists() => 파일이 존재하면 true, 존재하지 않으면 false를 반환하는 메소드
			System.out.println(new File("ttt.txt").exists()); // => 파일생성은 createNewFile까지 함께 호출해줘야하기 때문에 해당 파일은 존재하지 않는다. => false출력
			
			System.out.println(f1.isFile()); // f1.isFile() => 파일이 맞으면 true, 파일이 아니면 false를 반환하는 메소드
			System.out.println(tempFolder.isFile());
			
			//--------------------------------------------------
			
			File folder = new File("parent");//별도로 경로지정을 안했기 때문에 현재 project폴더에서 생성
			folder.mkdir();
			
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("절대경로 : " + file.getAbsolutePath());
			System.out.println("파일용량 : " + file.length());
			System.out.println("상위폴더 : " + file.getParent());
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램을 종료합니다.");
		
		
	}
	
	//메모리영역은 휘발성이기 때문에 프로그램이 종료되면 싹 다 사라짐 => 따라서 내가 어떤 데이터를 영구적으로 보관하고자 한다면 외부매체에 저장해야한다!
	
	//외부매체로 부터 데이터를 입력하거나, 출력하는 방법
	
	/*
	 * 프로그램 상의 데이터를 외부매체로 출력한다거나 또는 외부매체로부터 입력을 받아올꺼임!!
	 * 반드시 그 외부매체와 직접적인 통로를 먼저 만들어야한다. => 그 통로를 바로 '스트림'이라고 한다.
	 * 
	 * * 스트림(통로)의 특징 (데이터를 주고받을 수 있는 통로)
	 * - 단방향 : 입력이면 입력 / 출력이면 출력만 가능!
	 *          => 입력과 출력을 동시다발적으로 하고자 한다면? => 입력용스트림/출력용스트림 따로 열어야됨!
	 * - 선입선출(FIFO) : 통로가 파이프 같은 개념이기 때문에 먼저 보낸 값이 먼저 나옴!! 
	 * - 시간지연(delay)라는 문제가 생길 수 있음 ! => 앞쪽에 있는 데이터가 나가야 뒤쪽에 있는 데이터가 나갈 수 있기 때문)
	 * 
	 * 
	 * * 스트림의 구분
	 * 1. 통로의 사이즈 (1byte짜리 / 2byte짜리)
	 *  - 바이트 스트림 : 1byte짜리만 왔다 갔다 할 수 있을 정도의 사이즈(좁은통로) => 입력용스트림(InputStream) / 출력용스트림(OutputStream)
	 *  - 문자 스트림 : 2byte짜리도 왔다 갔다 할 수 있을 정도의 사이즈(넓은 통로)  => 입력용스트림(Reader) / 출력용스트림(Writter)	
	 *  	
	 * 2. 외부매체와 직접연결 유무
	 *  - 기반 스트림 : 외부 매체외 직접적으로 연결되는 통로(필수적으로 존재해야함, 성능이 다소 약함)
	 *  - 보조 스트림 : 말 그대로 보조 역할만 하는 통로(속도를 빠르게 한다거나, 그외에 유용한 기능들을 제공하는..)
	 *              보조스트림은 단독 사용 불가!, 기반스트림은 반드시 기본적으로 있어야한다!
	 */


}
