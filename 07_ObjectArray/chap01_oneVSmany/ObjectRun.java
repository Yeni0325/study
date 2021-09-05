package com.kh.chap01_oneVSmany.run;

import java.util.Scanner;

import com.kh.chap01_oneVSmany.model.vo.Book;

public class ObjectRun {

	public static void main(String[] args) {
		
		
		//방법 1. 기본생성자로 생성 후 setter 메소드를 이용해 값 초기화
		/*
		Book bk = new Book();
		bk.setTitle("자바의 정석");
		bk.setAuthor("강보람");
		bk.setPrice(10000);
		bk.setPublisher("kh");
		*/
		
		//방법2. 매개변수 생성자를 통해 생성과 동시에 값 초기화
		//Book bk = new Book("자바의 정석", "강보람", 10000, "kh");
		
		//[응용] 사용자에게 입력받은 값을 통해 생성과 동시에 값 초기화
		
		Scanner sc = new Scanner(System.in);
		/*
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		Book bk = new Book(title, author, price, publisher);
		System.out.println(bk.information());
		*/
		
		//              ↑이전 내용 복습
		
		//세 개의 Book 객체를 관리해야한다면??
		Book bk1 = null;
		Book bk2 = null;
		Book bk3 = null;
		
		// 세 도서에 대한 정보를 반복적으로 사용자에게 입력받은 후, 각 객체 생성과 동시에 초기화
		
		for(int i=0; i<3 ; i++) { // i=0, i=1, i=2
			
			System.out.println((i+1) + "번째 도서 정보 입력");
			System.out.print("도서명 : ");
			String title = sc.nextLine();
			
			System.out.print("저자명 : ");
			String author = sc.nextLine();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			
			//매 번 조건검사 후 각각의 객체를 생성해야됨
			if(i==0) {
				bk1 = new Book(title, author, price, publisher);
			} else if(i==1){
				bk2 = new Book(title, author, price, publisher);
			}else {
				bk3 = new Book(title, author, price, publisher);
			}
		}
		//객체 생성 끝
		
		//전체 도서 정보들 조회하기 => 일일히 각 객체의 출력문 작성 (반복문 활용x)
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		System.out.println(bk3.information());
		
		//도서 제목으로 검색하는 서비스
		System.out.print("검색할 책 제목 : ");
		String search = sc.nextLine();
		
		if(bk1.getTitle().equals(search)) {
			System.out.println(bk1.information());
		}
		
		if(bk2.getTitle().equals(search)) {
			System.out.println(bk2.information());
		}
		
		if(bk3.getTitle().equals(search)) {
			System.out.println(bk3.information());
		}
	}
	//위 내용을 if - else if문으로 하지 않는 이유 :
	// 동일한 도서명을 가진 책이 존재할 수 있는데 if - else if 문으로 할 경우 3개의 if문 중 하나만 true일 경우 나머지 책 이름을
	// 출력하지 않고 빠져나오는 상황이 발생할 수 있다. 따라서 이런 상황에서는 각각의 if문을 만들어주는것이 바람직!
	

}
