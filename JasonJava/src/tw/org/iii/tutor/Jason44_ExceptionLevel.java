package tw.org.iii.tutor;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Jason44_ExceptionLevel{

	public static void main(String[] args) {
		try {
			new Jason441().m1();			
		}catch (Exception e) {}
		
//		new Jason441().m1();	
	}
}

class Jason441 {
	void m1() throws Exception {
		m2();
	}
	void m2() throws Exception {
		m3(3);			
	}
	void m3(int a) throws FontFormatException, IOException{
//		throw new Exception(); 
//		throw new RuntimeException(); 
		if (a > 0) {
			throw new FontFormatException(null); 
		}else {
			throw new FileNotFoundException(); 	
		}
		
	}
}
//子類別拋出的例外及範圍必須比父類別少及小
class Jason442 extends Jason441{
	void m3(int b) throws RuntimeException{
		
	}
}
