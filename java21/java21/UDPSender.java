package java21;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender {
	public static void main(String[] args) throws Exception {
		//네트워크 통신은 소켓이 있어야 함.
		DatagramSocket socket = new DatagramSocket();
		//소켓으로 패킷을 전송한다.
		String str = "I an a java programmer";
		byte[] data = str.getBytes();
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		DatagramPacket packet = new DatagramPacket(data, data.length,ip,7000);
		
		socket.send(packet);
		socket.close();

	}
}
