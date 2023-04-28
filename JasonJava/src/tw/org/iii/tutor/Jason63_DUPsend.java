package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Jason63_DUPsend {

	public static void main(String[] args) {
		byte[] data = "ʕʘ̅͜ʘ̅ʔ ".getBytes();
		try {
			DatagramSocket soket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("10.0.104.255"), 8888);
			soket.send(packet);
			soket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
