package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Jason55 {

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			FileOutputStream fout = new FileOutputStream("dir2/Jason.aif");
			FileInputStream fin = new FileInputStream("dir1/五月.aif");
			int b;
			while((b = fin.read()) != -1) {
				fout.write(b);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("finish" + (System.currentTimeMillis()-start));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
