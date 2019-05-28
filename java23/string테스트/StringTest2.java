package string�׽�Ʈ;

import java.util.Iterator;

public class StringTest2 {
	public static void main(String[] args) {
		String s1 = "I am a java programmer";
		String s2 = "I am a python programmer";
		String s3 = "2011511";
		System.out.println(s1.toString());
		System.out.println(s1.equals(s2)); //�����ϰ� �ִ� ���� ��
		System.out.println(s1 == s2); //��ü�� ���ִ� ���� ��
		System.out.println(s1.length());
		System.out.println(s1.charAt(7));
		System.out.println(s3.charAt(0));
		StringBuffer buffer = new StringBuffer("hello");
		System.out.println(buffer.charAt(0));
		System.out.println(s1.substring(1));
		System.out.println(s1.substring(1, 5)); //1,2,3,4 ������
		
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
		System.out.println(s7.lastIndexOf("/")); //������ /�����´�
		System.out.println(s7.substring(s7.lastIndexOf("/")));
		
		System.out.println(s6.toUpperCase()); //�빮��
		System.out.println(s6.toLowerCase()); //�ҹ���
		String s66 = s6.replace("Good", "best");
		System.out.println(s66);
		char[] result6 = s6.toCharArray();
		for (char c : result6) {
			System.out.println(c);
		}
		String s8 = "   hello!! win !!   ";
		System.out.println(s8.trim()); //��������
		
		System.out.println(s8.concat("final")); //�ڿ� �̾�ٿ���
		System.out.println(s8.contains("hello")); //�����ϰ������� true
		String s9 = "wineer class";
		System.out.println(s9.startsWith("winner"));
		System.out.println(s9.endsWith("class"));
		String s10 = "hera@naver.com";
		System.out.println(s10.endsWith("class"));
		if(s10.endsWith("com")) {
			System.out.println("����ȸ��ñ���.");
		}else
			System.out.println("����ȸ�簡 �ƴϱ���.");
	}
}
