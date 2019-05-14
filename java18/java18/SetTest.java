package java18;

import java.util.HashSet;

public class SetTest {
	public static void main(String[] args) {
		HashSet bag = new HashSet();
		bag.add("ÈŞÁö");
		bag.add("ÈŞ´ëÆù");
		bag.add("Áö°©");
		System.out.println("³» °¡¹æ¼ÓÀÇ ¹°°Ç °³¼ö: " + bag.size() + "°³");
		System.out.println(bag);
		bag.add("Áö°©");
		System.out.println(bag);
		
	}
}	
