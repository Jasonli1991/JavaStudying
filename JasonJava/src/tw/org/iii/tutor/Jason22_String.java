package tw.org.iii.tutor;

public class Jason22_String {

	public static void main(String[] args) {
		//雙引號即為物件不需new
		String s1 = "Jason";
		System.out.println(s1);
		System.out.println("Jason".charAt(0));
		
		String s2 = new String();
		byte[] b1 = {97, 98 ,99 ,100};
		String s3 = new String(b1);
		System.out.println(s2);
		//輸出對應的ASCII碼
		System.out.println(s3);
	}

}
