package java16;

import java.util.ArrayList;

public class ListTest2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("����");
		list.add("�Ϻ�");
		list.add("�ʸ���");
		list.add("ĳ����");
		list.add("�̱�");
		int size = list.size();
		System.out.println("������� ������ : " + list);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
}

