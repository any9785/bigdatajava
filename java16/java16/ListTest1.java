package java16;

import java.util.ArrayList;

public class ListTest1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("���α׷���");
		list.add("DB������");
		list.add("������Ʈ�Ŵ���");
		list.add("�����ڳ��̳�");
		int size = list.size();
		System.out.println(list);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
}
