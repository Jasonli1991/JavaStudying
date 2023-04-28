package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Jason50 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file1.txt");
			int c;
			
			while ((c = fin.read()) != -1) {
                System.out.print((char) c);
            }
			
//			do {
//                c = fin.read();
//                if (c != -1) {
//                    System.out.print((char) c);
//                }
//            } while (c != -1);
//			


//            for (int i = 0; (c = fin.read()) != -1; i++) {
//                System.out.print((char) c);
//            }
			fin.close();
			System.out.println("OK");
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//		} catch (IOException e) {
//			System.out.println(e);
//		}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
