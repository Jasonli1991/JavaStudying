package tw.org.iii.tutor;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class Jason62 {

	public static void main(String[] args) {
		try {
			InetAddress[] ips = InetAddress.getAllByName("www.google.com");
			for (InetAddress ip : ips)
			System.out.println(ip.getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
