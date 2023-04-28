package tw.org.iii.tutor;

public class Jason07_if {

	public static void main(String[] args) {
//		double temp = Math.random();
//		System.out.println(temp);
//		double temp2 = temp * 101;
//		System.out.println(temp2);
//		int score = (int)temp2;
		
		int score = (int)(Math.random()*101);
		System.out.println(score);
		if (score >= 60) {
			System.out.print("Pass");
		}else {
			System.out.print("Down");
		}
		
	}

}
