package com.kh.chap03_class.run;
import com.kh.chap03_class.model.vo.Person;
import com.kh.chap03_class.model.vo.Product;

public class ClassRun {
	
	public static void main(String[] args) {
		
		Person a = new Person();
		System.out.println("===== 매개변수 생성자 연습 ======");
		Person kim = new Person("ye325", "0325", "김예은");
		
		Person park = new Person("뭘봐@gmail.com", "010-7777-7777");
		
		System.out.println(kim.information());
		System.out.println(park.information());
		
		System.out.println("=============================");
		
		a.setId("yeeun0325");
		a.setPwd("1234");
		a.setName("김예은");
		a.setAge(28);
		a.setGender('F');
		a.setPhone("010-9977-9422");
		a.setEmail("yeeun032%@naver.com");
		
		System.out.println(a.getId());
		System.out.println(a.getPwd());
		System.out.println(a.getName());
		System.out.println(a.getAge());
		System.out.println(a.getGender());
		System.out.println(a.getPhone());
		System.out.println(a.getEmail());
		
		//////////////////////////////////////
		
		
		// * 첫번째 방법 : 매개변수 생성자로 생성과 동시에 값 초기화
		Product p1 = new Product("갤럭시", 1200000, "삼성");
		System.out.println(p1.information());
		
		Product abc = new Product("하하하", 100, "아무거나브랜드", "홍길동");
		System.out.println(abc.information());
		
		//실습예제
		System.out.println("=== 실습예제 ===");
		
		// * 두번째 방법 : 기본생성자 생성 후 setter 이용해서 값 초기화
		p1.setpName("갤럭시");
		p1.setPrice(1200000);
		p1.setBrand("삼성");
		
		Product p2 = new Product("아이폰", 130000, "애플");
		
		p2.setpName("아이폰");
		p2.setPrice(1300000);
		p2.setBrand("애플");
		
		// pName : xxx, Price : xxx, brand : xxx 형식으로 출력
		
		//System.out.println("pName : " + p1.getpName() + ", Price : " + p1.getPrice() + ", brand : " + p1.getBrand());
		//System.out.println("pName : " + p2.getpName() + ", Price : " + p2.getPrice() + ", brand : " + p2.getBrand());
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		
		System.out.println("===");
		System.out.println(a.information());
	}
}
