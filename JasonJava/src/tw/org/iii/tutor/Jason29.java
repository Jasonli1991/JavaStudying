package tw.org.iii.tutor;

public class Jason29 {

	public static void main(String[] args) {
		Brad292 obj1 = new Brad292();
		Brad291 obj2 = new Brad292();
		Brad291 obj3 = new Brad293();
		obj2.m1();
		doThing(obj3);
	}

	static void doThing(Brad291 obj) {
		obj.m1();
	}
}
class Brad291 {
	void m1() {System.out.println("Brad291:m1()");}}
class Brad292 extends Brad291 {
	void m1() {System.out.println("Brad292:m1()");}
	void m2() {System.out.println("Brad292:m2()");}
}
class Brad293 extends Brad291 {
	void m1() {System.out.println("Brad293:m1()");}
	void m2() {System.out.println("Brad293:m2()");}
}