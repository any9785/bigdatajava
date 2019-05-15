package java21;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9100);
		System.out.println("TCP 서버 소켓 시작됨..");
		System.out.println("클라이언트의 연결을 기다리는 중...");
		while(true) {
			Socket socket = server.accept();
			System.out.println("클라이언트와 연결성공.!!!");		
		}
		
	}
}