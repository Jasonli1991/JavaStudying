package tw.org.iii.tutor;

public class Jason72_Thread {

	public static void main(String[] args) {
		Jason721 obj1 = new Jason721("A");
		Jason721 obj2 = new Jason721("B");
		Jason722 obj3 = new Jason722("C");
		//彈性較大
		Thread t1 = new Thread(obj3);
//		obj1.run(); obj2.run();
//		System.out.println("main");
//		//交給cpu開始排程，並非馬上執行，且start只能執行一次，但是物件尚在
		obj1.start(); obj2.start(); t1.start();
		System.out.println("main");
	}

}
class Jason721 extends Thread {
	String name;
	Jason721(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(name + "." + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

//不是Thread
class Jason722 implements Runnable {
	String name;
	Jason722(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(name + "." + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}