package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Jason64_DUPreceive {

	public static void main(String[] args) {
		byte[] buf = new byte[1024]; 
		try (DatagramSocket soket = new DatagramSocket(8888)){
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			soket.receive(packet);
			
			String urip = packet.getAddress().getHostAddress();
			byte[] data = packet.getData();
			int len = packet.getLength();
			String mesg = new String(data, 0, len);
			
			System.out.println(urip + ":" + mesg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
