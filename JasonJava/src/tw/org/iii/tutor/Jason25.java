package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Jason25 {

	public static void main(String[] args) {
		String str1 = "Brad";
		String str2 = "Brad";
		System.out.println(str1.equals(str2));	
		
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		//為改寫的情況下與'＝＝'相同
		System.out.println(b1.equals(b2));
		Bike b3 = b2;
		System.out.println(b2.equals(b3));
		System.out.println(b2 == b3);
	}

}
