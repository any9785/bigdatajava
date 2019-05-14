package java18;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("나는 스트링");
		list.add("100");
		//int <--> Integer 자동변환
		//int --> Integer --> Object
		//  (boxing)    (upcasting)
		//int --> Integer (auto-boxing)
		//int <-- Interger )auto-unboxing)
		int num = (int)list.get(1);
		list.add("11.22");
		list.add(true);
		MemberDTO dto = new MemberDTO("java", "java", "java", "java");
		list.add(dto);
		list.remove(3);
		System.out.println(list);
	}
}
