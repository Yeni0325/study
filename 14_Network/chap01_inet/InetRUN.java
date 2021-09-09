package com.kh.chap01_inet.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetRUN {

	public static void main(String[] args) {
		
		/*
		 * * 네트워크 (Network) : 여러대의 컴퓨터들이 연결되어있는 통신망 같은거
		 *                     => 이런 네트워크를 통해 서로간의 데이터 교환 가능!
		 *                     
		 * * IP 주소 : 네트워크 상에 각 컴퓨터들을 식별해줄 수 있는 번호 (컴퓨터의 주민번호)
		 *           cmd창에서 ipconfig라고 작성하면 확인가능 (IPv4주소)
		 *           
		 * * 서버와 클라이언트
		 * > 서버 : 클라이언트(고객)에게 서비스를 제공해주는 프로그램 (클라이언트의 요청을 처리해서 응답해주는)
		 * > 클라이언트 : 서버에 요청하는 컴퓨터 (서비스를 제공받는 고객)
		 * 
		 * - 서버에 요청하기 위해서는 그 요청하고자 하는 서버의 IP주소, 포트번호를 알아야됨!
		 * - 
		 */
		
		// InetAddress : 네트워크 정보(ip주소 관련)를 확인할 수 있는 클래스
		
		try {
			InetAddress localhost = InetAddress.getLocalHost(); //내 pc(지역호스트)에 대한 정보를 반환
			//InetAddress.getLocalHost() : LocalHoast => 내 pc를 가리킴 즉, 내pc의 네트워크 정보를 확인할 수 있는 클래스
			
			System.out.println(localhost); // 내 pc명 + / + 내 IP 주소
			
			System.out.println("내 PC명 : " + localhost.getHostName()); // 호스트(주인)의 이름 반환
			System.out.println("내 IP주소 : " + localhost.getHostAddress()); // 호스트(주인)의 ip주소 반환
			
			System.out.println("================================");
			
			// 내가 알고 있는 도메인을 통해서 그 서버관련된 정보 얻기
			InetAddress googleHost = InetAddress.getByName("www.google.com"); // InetAddress.getByname() : 도메인 명을 통해서 해당 호스트에 대한 정보 반환하는 메소드
			
			System.out.println("구글 서버명 : " + googleHost.getHostName());
			System.out.println("구글 IP주소 : " + googleHost.getHostAddress());
			
			System.out.println("================================");
			
			// 도메인을 통해서 서버관련된 것들을 배열로 받을 수 있음
			InetAddress[] naverHost = InetAddress.getAllByName("www.naver.com"); // InetAddress.getAllByName() : 도메인 명을 통해서 해당 호스트에 대한 정보를 "배열"로 반환하는 메소드
			
			System.out.println("네이버 호스트 갯수 : " + naverHost.length);
			for(InetAddress n:naverHost) {
				System.out.println("네이버 서버명 : " + n.getHostName());
				System.out.println("네이버 IP주소 : " + n.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		/*
		 * * 현재구동중인 서버가 있으면
		 *   클라이언트는 그 서버로 요청보낼 수 있음! => 응답결과 돌아옴!
		 *   
		 * - 요청과 응답에 의해서 프로그램은 돌아감 ("통신"한다고 표현)
		 * - 웹에서는 통신방식 : HTTP 프로토콜 통신
		 * 
		 * * 자바만을 가지고 서버와 클라이언트간에 간단한 통신 해보기!
		 *   이때 데이터를 입출력하고자 한다면 서버와 클라이언트간에 스트림(연결통로)이 필요함!
		 *   
		 * * 소켓 : 프로세스간의 통신을 담당! (서버와 클라이언트에 스트림을 연결하기 위한 문)
		 *        소켓을 먼저 생성해야 사이에 통로를 만들 수 있다.
		 * 
		 * * 소켓 프로그래밍 (TCP방식 / UDP방식)
		 * - TCP방식 : 데이터 전송속도가 느림! 데이터가 정확하고 안정적으로 전달 가능함! (신뢰성이 요구되는 프로그램 : http, 이메일, ...)
		 * - UDP방식 : 데이터 전송속도가 빠름! 신뢰성 없는 데이터가 전달될 수 있음! (데이터를 빠른속도로 전송하고자 하는 프로그램 : 실시간동영상서비스)
		 * 
		 */
		
		/*
		 * TCP 소켓 프로그래밍 : 클라이언트와 서버간의 1:1 소켓 통신
		 *                 서버가 먼저 실행되어 클라이언트의 요청을 기다려야 한다. 서버에는 소켓이 2개가 있는데, ServerSocket과 Client Socket. 서버측에서 ServerSocket이 구동되어야 하고, 
		 *                 그 때, ServerSocket을 생성하고 포트번호를 통해 포트를 열어두고 서버를 구동시킨다. 서버를 구동시킨 상태에서 클라이언트 쪽에서 ServerSocket에 연결요청을 보내게 된다.
		 *                 서버측에서는 구동중일 때 클라이언트가 접속할 때 까지 "대기상태"를 유지한다. 그러다가 연결요청이 들어오는 순간 ServerSocket 객체를 가지고 accept()라는 메소드를 통해 연결을 수락하게 된다.
		 *                 그 때부터, 서버측에 클라이언트와 통신하기 위한 Client Socket이 생성이 되고, 클라이언트도 socket객체가 존재. 결국, 서버측에 있는 Client Socket과 클라이언트에 있는 Socket이 
		 *                 통신을 하게 된다.
		 * 
		 */
		
		
		
		
	}

}
