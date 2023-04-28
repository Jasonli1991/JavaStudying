package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Jason61 {
	public static void main(String[] args) {
		Jason613 obj = new Jason613();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/brad"));
			oout.writeObject(obj);
			oout.flush(); oout.close();
			System.out.println("----");
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/brad"));
			oin.readObject();
			oin.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}


class Jason611 {
	Jason611(){System.out.println("Jason611()");}
}
class Jason612 extends Jason611 {
	Jason612(){System.out.println("Jason612()");}
}
class Jason613 extends Jason612 {
	Jason613(){System.out.println("Jason613()");}
}