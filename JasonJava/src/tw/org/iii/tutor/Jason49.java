package tw.org.iii.tutor;

import java.io.File;

public class Jason49 {

	public static void main(String[] args) {
		File dir1 = new File("dir1");
		if (dir1.exists() && dir1.isDirectory()) {
			File[] files = dir1.listFiles();
			for (File file: files) {
				String fname = file.getName();
				long size = file.length();
				String type = file.isDirectory()?"dir":"file";
				System.out.println(fname+":"+size+":"+type);
			}
		}
			
	}

}
