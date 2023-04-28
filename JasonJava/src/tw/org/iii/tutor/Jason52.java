package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Jason52 {

	public static void main(String[] args) {
		try {
			File source = new File("dir1/file1.txt");
			FileInputStream fin = new FileInputStream(source);
			int c;
			
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			System.out.println(new String(buf));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
