package java18;

import java.util.ArrayList;

public class ListTest2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("나는 스트링"); 
		//String(자식, 작다) -> Object(부, 크다)
		//자동형변환, 업캐스팅
		list.add(100);
		System.out.println(list);
		String name = (String)list.get(0);
	}

}
