package com.kh.chap04_field.run;

import com.kh.chap04_field.model.vo.FieldTest1;
import com.kh.chap04_field.model.vo.FieldTest2;
import com.kh.chap04_field.model.vo.FieldTest3;

public class FieldRun {

	public static void main(String[] args) {
		
		// --- FieldTest1 ---
		
		/*
		FieldTest1 f1 = new FieldTest1();
		
		f1.test(5);
        */
		
		// --- FieldTest2 ---
		/*
		FieldTest2 f2 = new FieldTest2();
		
		//public : 어디서든 접근가능(다른패키지임에도 불구하고)
		System.out.println(f2.pub);
		
		//protected : 같은 패키지 내 접근 가능, 다른 패키지라면 상속구조만 접근 가능!
		//System.out.println(f2.pro);
		
		//default : 같은 패키지에서만 접근 가능
		//System.out.println(f2.def);
		
		//private : 해당 클래스에서만 접근 가능
		//System.out.println(f2.pri);
		 */
		
		// ---- FieldTest3 ---
		
		//static은 패키지 영역 내에 동일한 변수가 존재할 수 있으므로 앞에 '클래스명'을 작성해야한다!!
		System.out.println(FieldTest3.sta);
		System.out.println(FieldTest2.sta);
		
		FieldTest3.sta = "ㅋㅋㅋ"; 
		// 단지 static만 붙었을 때는 어디서든 쓸 수 있고, 변경이 가능!
		
		System.out.println(FieldTest3.sta);
		
		System.out.println(FieldTest3.STA_FIN);
		//FieldTest3.STA_FIN = "ㅎㅎㅎ"  //상수로 선언됐기 때문에 변경이 불가
		
		System.out.println(Math.PI);
		
		
		
	}

}
