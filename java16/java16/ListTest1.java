package java16;

import java.util.ArrayList;

public class ListTest1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("프로그래머");
		list.add("DB관리자");
		list.add("프로젝트매니저");
		list.add("웹디자너이너");
		int size = list.size();
		System.out.println(list);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
}
