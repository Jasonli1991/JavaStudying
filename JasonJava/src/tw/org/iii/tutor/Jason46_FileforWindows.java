package tw.org.iii.tutor;

import java.io.File;

public class Jason46_FileforWindows {

	public static void main(String[] args) {
		File file1 = new File("/Library/text");
		if (file1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
