package com.kh.exception.run;

import java.io.IOException;

import com.kh.exception.controller.A_UnCheckedException;
import com.kh.exception.controller.B_CheckedException;

public class ExceptionRun {

	public static void main(String[] args) throws IOException {
		
		/*
		 * * 에러 종류
		 * - 시스템에러 : 컴퓨터의 오작동으로 인해 발생하는 에러 => 소스코드로 해결안됨 => 심각한 에러 (jvm에러 포함)
		 * - 컴파일에러 : 소스코드 문법상 오류가 있을 때 발생하는 에러 (실행시키기 전) => 빨간줄로 애초에 오류를 알려줌 => 개발자의 실수
		 * - 런타임에러 : 코드상으로 문제가 없는데 프로그램 실행 중에 발생하는 에러 => 사용자의 실수일 수 있고 개발자 예측가능한 경우를 제대로 처리안해놨을 수 있음
		 * 
		 * - 논리 에러 : 문법적으로도 문제없고 실행했을 때도 굳이 문제는 없지만 프로그램 의도상 맞지 않는 것
		 * 
		 * 시스템 에러를 제외한 컴파일에러, 런타임에러, 논리에러와 같은 비교적 덜 심각한 것들을 가지고 작업
		 * 이런 것들을 "예외"라고 한다 => Exception
		 * 
		 * "예외"가 "발생"했을 경우에 대해서 "처리"하는 방법을 => "예외처리"라고 함!!
		 * 
		 * * 예외처리를 하는 목적
		 * - 예외처리를 하지 않고 그대로 예외가 발생되는경우 프로그램이 비정상적으로 종료될 수 있음
		 * 
		 * * 예외처리 방법 (예외가 발생했을 때)
		 * 1. try ~ catch문을 이용 (try~with~resource)
		 * 2. throws를 이용 (떠넘기기 == 위임한다)
		 * 3. 
		 */
		
		A_UnCheckedException a = new A_UnCheckedException();
		//a.method1();
		//a.method2();
		//a.method3();
		
		B_CheckedException b = new B_CheckedException();
		b.method1();
		
		
	}

}
