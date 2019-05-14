package java16;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		//¼ø¼­°¡Áß¿ä
		ArrayList list = new ArrayList();
		list.add("±èµ¥ÀÌ");
		list.add("±è»çÀü");
		list.add("±è±¸Á¶");
		list.add("±èÀÚ·á");
		System.out.println(list);
		int size = list.size();
		list.remove(1);
		System.out.println(list);
		list.set(1, "±èÃæ¼º");
		System.out.println(list);
		for (int i = 1; i < list.size(); i++) {
			System.out.println(i*100 + ": " + list.get(i));
		}
		//list.remove(0);
		//System.out.println(list);
		//list.remove(1);
		//System.out.println(list);
		//list.remove("Á¤½ºÅ°");
		//System.out.println(list);
		
		
		
	}

}
