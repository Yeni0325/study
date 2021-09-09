package com.kh.chap02_tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientProgram {
	
	//클라이언트용 프로그램
	public static void main(String[] args) {
		
		// 현재 내가 연결하고자하는 서버의 IP주소가 필요 => 내 pc의 ip주소
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null; //입력용 보조스트림
		PrintWriter pw = null; //출력용 보조스트림
		
		Socket socket = null;
		
		// 요청하고자 하는 서버 IP : 192.168.35.79
		// 포트번호 : 3000
		
		int port = 3000;
		String serverIP; //요청하고자 하는 서버 선언
		
		try {
			serverIP = "192.168.35.79";
			
			// 1) 서버에 연결 요청 보내는 구문 (요청하고자 하는 서버의 IP주소와 지정된 포트번호를 제시하면서 소켓 객체 생성)
			socket = new Socket(serverIP, port); 
			// 현재 해당서버가 구동중이라면 연결요청이 보내지고 그 순간 서버에서는 수락하게 된다.
			// serverIP에는 현재 내가 연결요청하고자하는 IP번호가, port에는 연결요청하고자 하는 포트번호가 담겨져 있음
			// 만약 서버가 구동중이 아니거나, 내가 IP주소와 포트번호를 잘못 제시했을 경우 => 통신실패 => null값이 socket에 담김
			
			if(socket != null) { // 서버와 잘 연결됐을경우
				
				System.out.println("서버와 연결 성공!!");
				
				//서버와 연결에 성공했기 때문에 데이터를 입출력하고자 한다면 소켓을 가지고 스트림을 만들어줘야 한다.
				// 2) 서버와 입출력하는 기반스트림 생성
				// 3) 보조스트림을 통해서 성능 개선
				
				// 입력용 스트림 (서버로부터 전달된 데이터를 한줄 단위로 읽어들이는 입력용 스트림)
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//1. socket.getInputStream() : 서버로부터 값을 읽어들이는 입력용스트림이 만들어지는 메소드로 서버로부터 값을 입력받기 위한 바이트스트림
				//2. InputStreamReader() : 바이트스트림을 문자스트림으로 바꿔줄 수 있는 보조스트림 생성, 보조스트림 생성 시 기반스트림을 전달하면서 생성!!
				//3. BufferedReader() : 한 줄 단위로 입력할 수 있는 문자보조스트림 생성(BufferedReader()객체 생성 시 new InputStreamReader()객체의 속도를 향상시킴)
				
				// 출력용 스트림 (서버에게 값을 한줄단위로 전달할 수 있는 출력용 스트림)
				pw = new PrintWriter(socket.getOutputStream());
				//1. socket.getOutputStream() : 클라이언트에 값을 출력받기 위한 바이트스트림 연결
				//2. PrintWriter() : 데이터 출력할 때 print(), println() 메소드를 가지고 있는 2바이트를 출력받을 수 있는 보조스트림
				//                   println()메소드 호출 시 전달할 데이터를 전달하면 해당 데이터의 개행처리를 해줌으로써 한줄 단위로 출력 가능!
				//                   한 문장 출력 후 자동으로 줄바꿈까지 해주는 보조스트림임
				//                   출력 시 BufferedWriter()를 활용할 경우 출력할데이터만 출력이 되고, 개행을 넣고자할때면 매번 newLine을 이용해야한다.
				
				while(true) {
					
					//먼저 클라이언트가 내보낼 수 있게끔 출력 먼저!
					//서버에게 보낼 내용 입력받아서 출력
					// 4) 스트림 통해 출력
					System.out.print("서버에게 보낼 내용 : ");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage);
					// pw.println() : pw라는 printWriter객체를 한줄단위로 메소드를 출력하고 줄바꿈까지 들어가게끔 하는 print()라는 출력용메소드를 활용해 클라이언트에게 출력
					pw.flush(); // 작성안하면 데이터 전달자체가 안됨
					//현재 스트림(통로)에 있는 데이터를 강제로 내보내는 메소드 (close메소드 호출되면 자동으로 flush실행)
					
					//서버에서 보낸데이터를 입력
					// 5) 스트림 통해서 입력
					String message = br.readLine();
					//br.readLine() : 입력용 스트림에 전달된 데이터가 있을 경우 한줄로 읽어들임
					System.out.println("서버로부터 전달받은 메세지 : " + message);
					
				}
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				// 6) 통신 종료
				pw.close(); //출력용스트림 반납
				br.close(); //입력용스트림 반납
				
				//스트림을 다 쓰면 반납하는 것 처럼 ServerSocket객체도 마무리 시 서버를 닫아줘야한다.
				socket.close(); //서버와 연결된 소켓객체 닫음
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 테스트 시 무조건 서버부터 먼저 연결이 되야한다!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
