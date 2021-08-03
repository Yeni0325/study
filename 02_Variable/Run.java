package com.kh.run;

import com.kh.variable.A_Variable;
import com.kh.variable.B_KeyboardInput;
import com.kh.variable.C_Printf;
import com.kh.variable.D_Cast;

public class Run {

	public static void main(String[] args) {
		
		A_Variable a = new A_Variable();
		// a.printVariable();
		
		//a.declareVariable();
		
		B_KeyboardInput b = new B_KeyboardInput();
		
		//b.inputTest1();
		
		//b.inputTest2();
		
		//b.inputTest3();
		
		//b.inputTest4();
		
		//b.charAtTest();
		
		C_Printf c = new C_Printf();
		
		//c.printfTest();
		
		D_Cast d = new D_Cast();
		
		//d.autoCasting();
		d.forceCasting();

	}
}
