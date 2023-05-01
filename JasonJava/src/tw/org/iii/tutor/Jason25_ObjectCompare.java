package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Jason25_ObjectCompare {

	public static void main(String[] args) {
		String str1 = "Brad";
		String str2 = "Brad";
		System.out.println(str1.equals(str2));	
		
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		//為改寫的情況下與'＝＝'相同
		//Bike類中沒有對equals()方法進行重寫，
		//因此equals()方法預設是使用 == 比較物件的引用，
		//而不是比較物件的內容
		System.out.println(b1.equals(b2));
		Bike b3 = b2;
		System.out.println(b2.equals(b3));
		System.out.println(b2 == b3);
	}

}
