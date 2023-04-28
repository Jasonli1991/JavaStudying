package tw.org.iii.tutor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Jason66_TCPsend {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getByName("10.0.104.190"), 9957);
            OutputStream oout = socket.getOutputStream();
            OutputStreamWriter ow = new OutputStreamWriter(oout);
            BufferedWriter bw = new BufferedWriter(ow);
            bw.write("Hello, World!");
            bw.flush();
            bw.close();
            socket.close();
            System.out.println("Send OK");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}