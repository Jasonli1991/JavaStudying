package tw.org.iii.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class Jason71 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.iii.org.tw/assets/images/information-news/image005.jpg");
			HttpURLConnection conn = 
				(HttpURLConnection)url.openConnection();
			conn.connect();
			BufferedInputStream bin = 
				new BufferedInputStream(conn.getInputStream());
			FileOutputStream fout = new FileOutputStream("dir2/iii.jpg");
			
			byte[] buf = new byte[4*1024]; int len;
			while ( (len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			fout.flush();
			fout.close();
			bin.close();
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
