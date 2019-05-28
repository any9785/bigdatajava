package string테스트;

import java.util.Iterator;

public class StringTest2 {
	public static void main(String[] args) {
		String s1 = "I am a java programmer";
		String s2 = "I am a python programmer";
		String s3 = "2011511";
		System.out.println(s1.toString());
		System.out.println(s1.equals(s2)); //참조하고 있는 값을 비교
		System.out.println(s1 == s2); //객체에 들어가있는 값을 비교
		System.out.println(s1.length());
		System.out.println(s1.charAt(7));
		System.out.println(s3.charAt(0));
		StringBuffer buffer = new StringBuffer("hello");
		System.out.println(buffer.charAt(0));
		System.out.println(s1.substring(1));
		System.out.println(s1.substring(1, 5)); //1,2,3,4 가져옴
		
		System.out.println("------------");
		String[] result = s1.split("");
		System.out.println(result.toString());
		for (String s : result) {
			System.out.println(s);
		}
		String s5 = "Hi, Good Morning!";
		String[] result2 = s5.split(" ");
		System.out.println(result2.length);
		for (String s : result2) {
			System.out.println(s);
		}
		System.out.println("---------------");
		String[] result3 = s5.split(",");
		System.out.println(result3.length);
		for (String s : result3) {
			System.out.println(s);
		}
		String s6 = "Hi, Good Morning!";
		String[] result4 = s6.split("[.]");
		System.out.println(result4.length);
		for (String s : result4) {
			System.out.println(s);
		}
		System.out.println(s6.indexOf("Good"));
		
		String s7 = "http://www.naver.com/member/index.jsp";
		System.out.println(s7.lastIndexOf("/")); //마지막 /가져온다
		System.out.println(s7.substring(s7.lastIndexOf("/")));
		
		System.out.println(s6.toUpperCase()); //대문자
		System.out.println(s6.toLowerCase()); //소문자
		String s66 = s6.replace("Good", "best");
		System.out.println(s66);
		char[] result6 = s6.toCharArray();
		for (char c : result6) {
			System.out.println(c);
		}
		String s8 = "   hello!! win !!   ";
		System.out.println(s8.trim()); //공백제거
		
		System.out.println(s8.concat("final")); //뒤에 이어붙여줌
		System.out.println(s8.contains("hello")); //포함하고있으면 true
		String s9 = "wineer class";
		System.out.println(s9.startsWith("winner"));
		System.out.println(s9.endsWith("class"));
		String s10 = "hera@naver.com";
		System.out.println(s10.endsWith("class"));
		if(s10.endsWith("com")) {
			System.out.println("닷컴회사시군요.");
		}else
			System.out.println("닷컴회사가 아니군요.");
	}
}
