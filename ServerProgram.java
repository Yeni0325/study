package com.kh.chap02_tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {
	
	/*
	 * * TCP(Transmission Control Protocol)
	 * - 서버, 클라이언트 간의 1:1 소켓 통신
	 * - 데이터를 교환하기에 앞서서 서버, 클라이언트 연결되어있어야됨!(서버가 먼저 실행되어 클라이언트의 요청 기다릴꺼임)
	 * - 신뢰성 있는 데이터 전달 가능
	 * 
	 * 
	 * * Socket
	 * - 데이터를 주고받기 위해선 스트림이 필요한데 그 스트림을 만들려면 소켓이라는 문이 필요
	 * - 프로세스간의 통신을 담당
	 * - Input / OutputStream을 가지고 있음 (이 스트림을 통해 입출력이 이루어짐)
	 * - 바이트스트림만 존재(reader, writer와 같은 문자스트림 존재x)
	 * 
	 * * SeverSocek
	 * - 포트와 연결(Bind)되어 외부의 연결 요청을 기다리다가 연결요청이 들어오면 수락해줄 용도
	 *   수락(accept()메소드) => 통신할 수 있는 Socket 생성
	 * 
	 */
	
	
	//서버용 프로그램
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null; // 입력용 보조 스트림
		PrintWriter pw = null; // 한줄 단위로 출력할 수 있는 보조스트림
		
		// 1) 포트 번호 지정 (서버측에서 몇 번 포트로 통로를 열건지)
		int port = 3000;
		
		ServerSocket server = null;

		try {
			// 2) ServerSocket 객체 생성 시 포트 결합(Bind) (ServerSocket은 클라이언트의 연결요청을 받아줄 용도의 소켓, 오직 연결요청을 받아주는 용도의 소켓)
			// 외부에서 접근 요청을 받아주기 위해선 ServerSocek이 먼저 생성해야한다.
			server = new ServerSocket(port); // ServerSocket생성
			//스트림이 다 쓰면 반납하는것처럼 ServerSocket객체도 다 쓰면 close해줘야 한다.
			//따라서 finally블럭 안에 반납구문을 작성해야하기 때문에 try-catch문 밖에서 null값으로 선언 먼저 해야한다.
			
			// 3) 클라이언트로부터 연결요청이 있을때까지 대기상태
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			
			// 4) 연결 요청이 오면 요청 수락 후 해당 클라이언트와 통신할 수 있는 서버측 소켓 객체 생성
			Socket socket = server.accept(); // .accept() : 연결요청이 오면 수락해주는 메소드
			                                 // socket == 클라이언트와 통신할 수 있는 소켓 객체
			System.out.println(socket.getInetAddress().getHostAddress() + "가 연결을 요청함..."); 
			// soket.getInetAddress()메소드 : 소켓객체로부터 InerAddress() 객체를 얻어낼 수 있음  => InetAddress.getHostAddress() : 클라이언트의 ip주소를 알아내는 메소드
			
			// 5) 클라이언트와 입출력 기반스트림 생성 (바이트 스트림으로밖에 안됨..)
			// 6) 보조스트림 통한 성능 개선 (바이트스트림이기 때문에 1바이트밖에 못받아서)
			
			// 입력용 스트림 (클라이언트로부터 전달된 값을 한줄단위로 읽어들이기 위한 입력용 스트림)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			//1. socket.getInputStream() : 클라이언트와 연결된 입력용스트림이 만들어지는 메소드로 클라이언트로부터 값을 입력받기 위한 바이트스트림
			//2. InputStreamReader() : 바이트스트림을 문자스트림으로 바꿔줄 수 있는 보조스트림 생성, 보조스트림 생성 시 기반스트림을 전달하면서 생성!!
			//3. BufferedReader() : 한 줄 단위로 입력할 수 있는 문자보조스트림 생성(BufferedReader()객체 생성 시 new InputStreamReader()객체의 속도를 향상시킴)
			
			// 출력용 스트림(클라이언트에게 값을 한줄단위로 전달할 수 있는 출력용 스트림)
			pw = new PrintWriter(socket.getOutputStream());
			//1. socket.getOutputStream() : 클라이언트에 값을 출력받기 위한 바이트스트림 연결
			//2. PrintWriter() : 데이터 출력할 때 print(), println() 메소드를 가지고 있는 2바이트를 출력받을 수 있는 보조스트림
			//                   println()메소드 호출 시 전달할 데이터를 전달하면 해당 데이터의 개행처리를 해줌으로써 한줄 단위로 출력 가능!
			//                   한 문장 출력 후 자동으로 줄바꿈까지 해주는 보조스트림임
			//                   출력 시 BufferedWriter()를 활용할 경우 출력할데이터만 출력이 되고, 개행을 넣고자할때면 매번 newLine을 이용해야한다.
			
			//채팅처럼 입출력 무한반복
			while(true) {
				// 7) 스트림을 통해서 읽고 쓰기
				// 클라이언트로부터 전달된 메세지가 있을 경우 서버측에서 읽어들여보자 (입력)
				String message = br.readLine();
				//br.readLine() : 입력용 스트림에 전달된 데이터가 있을 경우 한줄로 읽어들임
				System.out.println("클라이언트로부터 전달받은 메세지 : " + message);
				
				// 반대로 클라이언트에게 데이터 전달! (출력)
				// 사용자에게 입력받은 값 전달
				System.out.print("클라이언트에게 보낼 내용 : ");
				String sendMessage = sc.nextLine();
				
				pw.println(sendMessage); 
				// pw.println() : pw라는 printWriter객체를 한줄단위로 메소드를 출력하고 줄바꿈까지 들어가게끔 하는 print()라는 출력용메소드를 활용해 클라이언트에게 출력
				pw.flush();  // 작성안하면 데이터 전달자체가 안됨
				//현재 스트림(통로)에 있는 데이터를 강제로 내보내는 메소드 (close메소드 호출되면 자동으로 flush실행)
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				// 8) 통신 종료
				pw.close(); //출력용스트림 반납
				br.close();//입력용스트림 반납
				
				server.close(); //서버 닫음
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	
	}

}
