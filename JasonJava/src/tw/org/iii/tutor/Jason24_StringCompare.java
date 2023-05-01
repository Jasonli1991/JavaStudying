package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Jason24_StringCompare {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = s1.concat("Chao");
		String s3 = s1.replace("a", "A");
		
//		字串產生後，內容不會被改變，直到被cpu回收
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println("------");
		
		
		
		int a = 10, b = 3;
		System.out.println(a == b);
		String str1 = "Brad";
		String str2 = "Brad";
		System.out.println(str1 == str2);
		String str3 = new String("Brad");
		String str4 = new String("Brad");
		//記憶體位置不同
		System.out.println(str3 == str4);
		System.out.println(str1 == str3);
		System.out.println(str1);
		
		System.out.println("----");
		
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1 == b2);
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1);
		
		
				
	}

}
