package tw.org.iii.tutor;

public class Jason34 {

	public static void main(String[] args) {
		

	}

}

interface Jason341 {
	void m1();
}

interface Jason342 {
	void m2();
}

//extends可以有多個父介面
interface Jason343 extends Jason341, Jason342 {
	void m3();
}
class Jason344 implements Jason343 {

	@Override
	public void m1() {
	}

	@Override
	public void m3() {
	}

	@Override
	public void m2() {
	}
	
}
