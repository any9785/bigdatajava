package java16;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		//�������߿�
		ArrayList list = new ArrayList();
		list.add("�赥��");
		list.add("�����");
		list.add("�豸��");
		list.add("���ڷ�");
		System.out.println(list);
		int size = list.size();
		list.remove(1);
		System.out.println(list);
		list.set(1, "���漺");
		System.out.println(list);
		for (int i = 1; i < list.size(); i++) {
			System.out.println(i*100 + ": " + list.get(i));
		}
		//list.remove(0);
		//System.out.println(list);
		//list.remove(1);
		//System.out.println(list);
		//list.remove("����Ű");
		//System.out.println(list);
		
		
		
	}

}
