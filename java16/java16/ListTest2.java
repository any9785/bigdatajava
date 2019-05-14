package java16;

import java.util.ArrayList;

public class ListTest2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("유럽");
		list.add("일본");
		list.add("필리핀");
		list.add("캐나다");
		list.add("미국");
		int size = list.size();
		System.out.println("가고싶은 여행지 : " + list);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
}

