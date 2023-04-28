package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Jason51 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file1.txt");
			int c;
			
			byte[] buf = new byte[3];
			int len;
			while ((len = fin.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
