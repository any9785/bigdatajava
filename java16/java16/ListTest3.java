package java16;

import java.util.ArrayList;

public class ListTest3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("¹Ú¼ÒÁ¤");
		list.add("±èÁ¤¹Î");
		list.add("¼ÒÁöÇö");
		list.add("±è°³³ä");
		int size = list.size();
		System.out.println(list); 
		list.remove(1);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + "µî: " + list.get(i));
		}
	}
}
