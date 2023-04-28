package tw.org.iii.tutor;

public class Jason30_abstract {

	public static void main(String[] args) {
		//抽象類別無法直接做出必須由子類別處理
//		Jason301 obj1 = new Jason301();
		Jason301 obj2 = new Jason302();
		Jason301 obj3 = new Jason303();
		obj2.m2();
		obj3.m2();

	}

}

abstract class Jason301 {
	Jason301(int a){
		System.out.println("Jason301()");
	}
	void m1() {System.out.println("Jason301:m1()");}
	abstract void m2();
}
class Jason302 extends Jason301{
	Jason302(){
		super(2);
		System.out.println("Jason302()");
	}
	void m2() {System.out.println("Jason302:m2()");}
}
class Jason303 extends Jason301{
	Jason303(){
		super(3);
		System.out.println("Jason302()");
	}
	void m2() {System.out.println("Jason303:m2()");}
}