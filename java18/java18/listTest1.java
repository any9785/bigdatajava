package java18;

import java.util.HashMap;

public class listTest1 {
	public static void main(String[] args) {
		HashMap list = new HashMap();
		Member m1 = new Member("ABC", "Content1", "김아무개",  "010");
		Member m2 = new Member("DEF", "Content2", "박아무개",  "015");
		Member m3 = new Member("GHI", "Content3", "이아무개",  "019");
		list.put(100, m1);
		list.put(200,m2);
		list.put(300,m3);
	
		System.out.println(list);
	}
}
