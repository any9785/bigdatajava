package java16;

import java.util.ArrayList;

public class ListTest3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("�ڼ���");
		list.add("������");
		list.add("������");
		list.add("�谳��");
		int size = list.size();
		System.out.println(list); 
		list.remove(1);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + "��: " + list.get(i));
		}
	}
}
