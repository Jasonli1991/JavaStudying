package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Jason54 {

	public static void main(String[] args) {	
		try {
			FileReader reader = new FileReader("dir1/file1.txt");
			int c;
			while((c = reader.read()) != -1) {
				System.out.print((char)c);
			}
			reader.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
