package tw.org.iii.tutor;

import java.util.Scanner;

/**
 * @author chihchungli
 *
 */
public class Jason02_scannerCount {

	public static void main(String[] args) {
		// INPUT => 10 + 3 = 13;
		Scanner scanner = new Scanner(System.in);
		System.out.print("x = ");
		int x = scanner.nextInt();
		System.out.print("y = ");
		int y = scanner.nextInt();
		int r1 = x + y;
		int r2 = x - y;
		int r3 = x * y;
		int r4 = x / y;
		int mod = x % y;
		System.out.printf("%d + %d = %d\n", x, y, r1);
		System.out.printf("%d - %d = %d\n", x, y, r2);
		System.out.printf("%d x %d = %d\n", x, y, r3);
		System.out.printf("%d / %d = %d ......%d", x, y, r4, mod);
	}

}
