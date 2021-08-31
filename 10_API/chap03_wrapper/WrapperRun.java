package com.kh.chap03_wrapper.run;

public class WrapperRun {

	public static void main(String[] args) {
		
		/*
		 * * Wrapper 클래스 (자바에서 제공하는 Wrapper클래스가 아닌, 몇가지 클래스를 통틀어 Wrapper클래스라고 부름)
		 *   => 기본자료형을 객체로 포장해줄 수 있는 클래스가 래퍼클래스 라고한다(Wrapper 클래스)
		 *   
		 *   기본자료형        <------->    Wrapper클래스
		 *   boolean                 Boolean
		 *   char                   *Character
		 *   byte                      Byte
		 *   short                    Short
		 *    int                   *Integer
		 *    long                    Long
		 *   float                    Float
		 *   double                   Double
		 *   
		 *   클래스화 시켰기 때문에 메소드호출 가능하다!
		 *   
		 *   => 기본자료형을 객체로 취급해야하는경우
		 *     - 메소드 호출해야될때
		 *     - 메소드의 매개변수로 기본자료형이 아닌 객체타입만이 요구될때
		 *     - 다형성을 적용시키고자 할때
		 */
		
		
		//Boxing : 기본자료형을 Wrapper클래스 자료형으로 변환시키는 것
		int num1 = 10;
		int num2 = 15;
		
		//System.out.println(num1.equals(num2));
		
		//방법1. 객체 생성 구문을 통한 방법
		Integer i1 = new Integer(num1);  // num1 -> i1
 		Integer i2 = new Integer(num2);  // num2 -> i2
 		
 		System.out.println(i1);
 		System.out.println(i2);
 		
 		System.out.println(i1 == i2);  //박스에 담긴 주소값의 동등비교
 		
 		//객체화 시키면 메소드 호출 가능
 		System.out.println(i1.equals(i2));
 		System.out.println(i1.compareTo(i2));   // => compareTo() : Integer타입끼리 앞과 뒤의 값을 비교해서 앞의 값이 더 크면 1반환, 뒤숫자가 더 크면 -1 반환, 일치하면 0을 반환하는 메소드!
 		
 		//방법2. 객체 생성따위 하지 않고 바로 대입하는 방법(AutoBoxing)
 		Integer i3 = num1; //자동형변환을 통해 int타입인 num1이 Integer로 변환된다.
 		System.out.println(i3);
 		
 		//방법2가 훨씬 간단한데 왜 방법1이 존재할까?
 		//=> 객체생성을 통해서 반드시 변환해야되는 경우 => 숫자만 존재하는 문자열이 존재, 문자열을 Integer타입으로 바꾸고자 할때는 방법2가 불가하다 => 방법2의 경우 왼쪽 , 오른쪽이 동일한 자료형일 경우만 가능하다!
 		//Integer i4 = "123";
 		Integer i4 = new Integer("123"); // "123" -> 123
 		System.out.println(i4); //숫자 123이 출력된다.
 		
 		
 		//UnBoxing : Wrapper 클래스 자료형 => 기본자료형
 		
 		//방법1. 해당 그 Wrapper클래스에서 제공하는 xxxValue() 메소드를 통해
 		int num3 = i3.intValue(); // i3 => num3    10
 		int num4 = i4.intValue(); // i4 => num4    123
 		
 		//방법2. 메소드따위 사용하지 않고 바로 대입하는 방법(AutoUnBoxing)
 		int num5 = i1;
 		
 		System.out.println("===========");
 		
 		//Wrapper클래스를 잘 알아야하는 이유
 		
 		//기본자료형    <---->  String
 		String str1 = "10";
 		String str2 = "15.3";
 		
 		System.out.println(str1 + str2); //문자열로 작업된다! 1015.3
 		
 		//1. String --> 기본자료형
 		//    "10"  -->   10
 		//   "15.3" -->  15.3
 		// 해당 Wrapper클래스.parseXXX() 사용   => 파싱한다
 		int i = Integer.parseInt(str1);
 		double d = Double.parseDouble(str2);
 		
 		System.out.println(i + d);
 		System.out.println("===========");
 		//2. 기본자료형 --> String
 		//     10   -->  "10"
 		//    15.3  --> "15.3"
 		
 		String strI = String.valueOf(i);
 		String strD = String.valueOf(d);
 		System.out.println(strI+strD);
 		
	}

}
