package java16;

import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		Vector datalist = new Vector();
		datalist.add("hello");
		datalist.add(100);
		datalist.add(11.22);
		datalist.add(true);
		datalist.add('a');
		
		System.out.println(datalist.size() + "개");
		
		System.out.println(datalist); //toString() override 재정의
		datalist.remove(0);
		System.out.println(datalist.size() + "개");
		System.out.println(datalist);
	}

}
