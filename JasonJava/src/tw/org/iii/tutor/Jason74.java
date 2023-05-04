package tw.org.iii.tutor;

import tw.org.iii.myclasses.BCrypt;

public class Jason74 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hwPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hwPasswd);
		
		if (BCrypt.checkpw("123456",hwPasswd)) {
			System.out.println("OK");
		} else {
			System.out.println("XX");
		}
	}

}
