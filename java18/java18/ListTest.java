package java18;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("���� ��Ʈ��");
		list.add("100");
		//int <--> Integer �ڵ���ȯ
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
