package tw.org.iii.tutor;

public class Jason13_for {

	public static void main(String[] args) {
//		for (int i = 0 ; i < 10; i++) {
//			System.out.println(i);
//		}
		
//		for (int i = 0 ; i < 10;) {
//			System.out.println(i++);
//		}
		
//		int i = 0;
//		for (printJason(); i < 10; printLine()) {
//			System.out.println(i++);
//		}
//	}
//	
//	static void printJason() {
//		System.out.println("Jason");
//	}
//	static void printLine() {
//		System.out.println("-----");
//	}
	
		int i = 0;
		for (printJason(); i < 10; printLine()) {
			System.out.println(i++);
		}
	}
	
	static void printJason() {
		int lottery = (int)(Math.random()*49+1);
		System.out.println("Jason" + lottery);
	}
	static void printLine() {
		System.out.println("-----");
	}
	
	}
