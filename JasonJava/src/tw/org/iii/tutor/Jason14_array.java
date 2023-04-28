package tw.org.iii.tutor;

public class Jason14_array {

	public static void main(String[] args) {		
		int a;
		int[] b;
		a = 1;
		b = new int[3];
		System.out.println(b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		b[0] = 123;
		b[2] = -4;
		System.out.println("-----");
		System.out.println(b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
