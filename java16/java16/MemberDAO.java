package java16;

import java.util.ArrayList;

public class MemberDAO {
	
	public ArrayList selectAll() {
		MemberDTO d1 = new MemberDTO("aaa", "123", "abc");
		MemberDTO d2 = new MemberDTO("bbb", "456", "def");
		MemberDTO d3 = new MemberDTO("ccc", "789", "ghi");
		
		//dto를 3개를 만들어서 list로 묶으세요.
		//그 리스트를 리턴
		ArrayList list = new ArrayList();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		
		return list;
	}
}
