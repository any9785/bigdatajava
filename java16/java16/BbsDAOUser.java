package java16;

import java.util.ArrayList;

public class BbsDAOUser {
	public static void main(String[] args) {
		BbsDAO dao = new BbsDAO();
		ArrayList list = dao.selectAll();
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
		BbsDTO dto = (BbsDTO) list.get(i);
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		System.out.println(dto.getEtc());
		System.out.println();
		
		}
	}
}
