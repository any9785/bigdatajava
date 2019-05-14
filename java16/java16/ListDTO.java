package java16;

import java.util.ArrayList;

public class ListDTO {

	public static void main(String[] args) {
		BbsDTO b1 = new BbsDTO("100", "java", "fun java", "fun");
		BbsDTO b2 = new BbsDTO("200", "jsp", "fun jsp", "fun");
		BbsDTO b3 = new BbsDTO("300", "spring", "fun spring", "fun");
		BbsDTO b4 = new BbsDTO("400", "android", "fun android", "fun");
		
		ArrayList list = new ArrayList();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		System.out.println(list);
		System.out.println(list.get(0));
		BbsDTO dto = (BbsDTO) list.get(0);
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		System.out.println(dto.getEtc());
		System.out.println(list.get(3));
			
	}

}
