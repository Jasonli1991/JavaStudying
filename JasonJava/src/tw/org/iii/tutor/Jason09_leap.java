package tw.org.iii.tutor;

public class Jason09_leap {

	public static void main(String[] args) {
		int year = 2023;
		if ((year / 4) != 0) {	
			System.out.println("平年");
		}else {
			if (year / 4 == 0 & year / 100 != 0) {
				System.out.println("閏年");
			}
		}
	}

}
