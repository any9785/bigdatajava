package java16;

import java.util.ArrayList;

public class MemberDAOUser {
	public static void main(String[] args) {
		//맴버리스트를 리턴받아 전체출력
		MemberDAO dao = new MemberDAO();
		ArrayList list = dao.selectAll();
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = (MemberDTO) list.get(i);
			System.out.println(dto.getId());
			System.out.println(dto.getPw());
			System.out.println(dto.getContent());
			System.out.println();
		}
	}
}
