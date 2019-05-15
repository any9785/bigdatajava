package java21;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSToIp {
	public static void main(String[] args) {
		String dns = "mgr.kgitbank.com";
		//String dns = "www.naver.com";
		InetAddress address;
		try {
			address = InetAddress.getByName(dns);
			System.out.println(address);
			System.out.println("ip주소: " + address.getHostAddress()); //ip호출
		} catch (UnknownHostException e) {
			System.out.println("도메인 네임이 존재하지 않습니다.");
			System.out.println("올바른 도메인 네임을 입력해주세요.");
		}
	}
}
